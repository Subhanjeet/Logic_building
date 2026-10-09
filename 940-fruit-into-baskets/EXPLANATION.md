# 904. Fruit Into Baskets

Difficulty: Medium

## Problem
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the i-th tree produces. You have two baskets and each basket can only hold a single type of fruit. Return the maximum number of fruits you can pick.

## Examples
```
Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
```

```
Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
```

```
Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
```

## Constraints
- 1 ≤ fruits.length ≤ 10^5
- 0 ≤ fruits[i] < fruits.length

## Approach
sliding window with hashmap. right pointer expands window. track fruit type counts in hashmap. while map size > 2, decrement count of fruit at left pointer, remove key if 0, and advance left. update maxLen = max(maxLen, right - left + 1).

Time: O(n)
Space: O(1)
Difficulty: 🟡 Medium
Pattern: Sliding Window & Hash Map
LeetCode: [LeetCode Problem](https://leetcode.com/problems/fruit-into-baskets/)

## Full Code
```java
class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0, maxLen = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int right = 0; right < n; right++) {
            freq.put(fruits[right], freq.getOrDefault(fruits[right], 0) + 1);
            
            while (freq.size() > 2) {
                int leftFruit = fruits[left];
                freq.put(leftFruit, freq.get(leftFruit) - 1);
                if (freq.get(leftFruit) == 0)
                    freq.remove(leftFruit);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
```

✅ Your code is correct and passes. It maintains a sliding window containing at most 2 distinct fruit types using a HashMap.

## Code Explanation

### Step 1: Initialize Sliding Window and HashMap
```java
int left = 0, maxLen = 0;
Map<Integer, Integer> freq = new HashMap<>();
```
`freq` tracks distinct fruit types and their frequencies inside current window.

### Step 2: Expand Window Right Boundary
```java
for (int right = 0; right < n; right++) {
    freq.put(fruits[right], freq.getOrDefault(fruits[right], 0) + 1);
```
Adds fruit type at `right` to frequency map.

### Step 3: Shrink Window when Baskets > 2
```java
while (freq.size() > 2) {
    int leftFruit = fruits[left];
    freq.put(leftFruit, freq.get(leftFruit) - 1);
    if (freq.get(leftFruit) == 0) freq.remove(leftFruit);
    left++;
}
maxLen = Math.max(maxLen, right - left + 1);
```
Shrinks from `left` until map contains at most 2 fruit types, then updates `maxLen`.

## Logic
Finding longest subarray containing at most 2 distinct integers.
Why it works: The sliding window maintains valid state (at most 2 keys in map). Both pointers advance linearly.
Pattern to recognize: "At most K distinct elements in contiguous subarray" points directly to sliding window + frequency map.

## Dry Run
Input: fruits = [1, 2, 3, 2, 2]

| Step | right | fruits[right] | Map State | Map Size | Shrink? | left | Window Size | maxLen |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 0 | 1 | {1: 1} | 1 | No | 0 | 1 | 1 |
| 2 | 1 | 2 | {1: 1, 2: 1} | 2 | No | 0 | 2 | 2 |
| 3 | 2 | 3 | {1: 1, 2: 1, 3: 1} | 3 | Yes -> remove 1 | 1 | 2 | 2 |
| 4 | 3 | 2 | {2: 2, 3: 1} | 2 | No | 1 | 3 | 3 |
| 5 | 4 | 2 | {2: 3, 3: 1} | 2 | No | 1 | 4 | **4** |

Final output: 4 ✅

## Complexity

### Time Complexity
O(n)
Single pass through `fruits` array.

### Space Complexity
O(1)
HashMap contains at most 3 distinct keys at any point.
