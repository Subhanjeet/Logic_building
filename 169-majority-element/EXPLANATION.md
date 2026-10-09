# 169. Majority Element

Difficulty: Easy

## Problem
Given an array nums of size n, return the majority element. The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

## Examples
```
Input: nums = [3,2,3]
Output: 3
```

```
Input: nums = [2,2,1,1,1,2,2]
Output: 2
```

## Constraints
- n == nums.length
- 1 ≤ n ≤ 5 * 10^4
- -10^9 ≤ nums[i] ≤ 10^9

## Approach
hashmap frequency counting. iterate through array, store element frequencies in hashmap. as soon as any element count exceeds n/2, return it immediately.

Time: O(n)
Space: O(n)
Difficulty: 🟢 Easy
Pattern: Hash Map / Counting
LeetCode: [LeetCode Problem](https://leetcode.com/problems/majority-element/)

## Full Code
```java
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int i=0; i<n; i++){
            int current = nums[i];
            if(freq.containsKey(current)){
                freq.put(current, freq.get(current) +1);
            }else{
                freq.put(current, 1);
            }
            if(freq.get(current)> n/2)
            return current;
        }
        return -1;
    }
}
```

✅ Your code is correct and passes. It records element occurrences in a HashMap and short-circuits as soon as majority threshold `n / 2` is crossed.

## Code Explanation

### Step 1: Initialize Frequency HashMap
```java
HashMap<Integer,Integer> freq = new HashMap<>();
```
Creates HashMap to track `element -> frequency` mapping.

### Step 2: Track Frequency During Array Scan
```java
for(int i=0; i<n; i++){
    int current = nums[i];
    if(freq.containsKey(current)){
        freq.put(current, freq.get(current) +1);
    }else{
        freq.put(current, 1);
    }
```
Updates element frequency in HashMap.

### Step 3: Short-Circuit Check
```java
if(freq.get(current)> n/2)
    return current;
```
Checks if current element count exceeds `n / 2`. Returns immediately when true.

## Logic
Counting element frequencies to identify majority element.
Why it works: The majority element appears > n/2 times. Tracking exact counts guarantees finding it.
Pattern to recognize: Frequency counting problem easily solved with HashMap lookup.

## Dry Run
Input: nums = [2, 2, 1, 1, 1, 2, 2], n = 7, threshold = 3

| Step | i | current | Map State | Count | Exceeds 3? | Action |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 0 | 2 | {2: 1} | 1 | No | Continue |
| 2 | 1 | 2 | {2: 2} | 2 | No | Continue |
| 3 | 2 | 1 | {2: 2, 1: 1} | 1 | No | Continue |
| 4 | 3 | 1 | {2: 2, 1: 2} | 2 | No | Continue |
| 5 | 4 | 1 | {2: 2, 1: 3} | 3 | No | Continue |
| 6 | 5 | 2 | {2: 3, 1: 3} | 3 | No | Continue |
| 7 | 6 | 2 | {2: 4, 1: 3} | 4 | **Yes** | Return 2 |

Final output: 2 ✅

## Complexity

### Time Complexity
O(n)
Single pass through array with O(1) average time per HashMap put/get.

### Space Complexity
O(n)
HashMap stores up to n unique elements in worst case.
