# 3. Longest Substring Without Repeating Characters

Difficulty: Medium

## Problem
Given a string s, find the length of the longest substring without repeating characters.

## Examples
```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```

```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
```

## Constraints
- 0 ≤ s.length ≤ 5 * 10^4
- s consists of English letters, digits, symbols and spaces.

## Approach
sliding window with hashmap. right pointer expands window. hashmap stores character last seen index. if character already in hashmap, update left = max(lastSeen + 1, left) to jump past duplicate. update map with current index and update maxLength.

Time: O(n)
Space: O(min(n, m))
Difficulty: 🟡 Medium
Pattern: Sliding Window & Hash Table
LeetCode: [LeetCode Problem](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

## Full Code
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> Index= new HashMap<>();
        int maxLength = 0;
        int left= 0;

        for (int right= 0; right< s.length(); right++) {
            char currentChar = s.charAt(right);
            if (Index.containsKey(currentChar)) {
                left = Math.max(Index.get(currentChar) +1, left);
            }
            Index.put(currentChar, right);
            maxLength = Math.max(maxLength, right-left +1);
        }
        return maxLength;      
    }
}
```

✅ Your code is correct and passes. It maintains a distinct character window using a HashMap for instant index jumps when duplicates appear.

## Code Explanation

### Step 1: Initialize HashMap and Window Pointers
```java
HashMap<Character, Integer> Index= new HashMap<>();
int maxLength = 0, left = 0;
```
`Index` tracks last seen index of characters. `left` is window start, `maxLength` tracks longest substring length.

### Step 2: Expand Window and Jump Left Pointer on Duplicate
```java
for (int right= 0; right< s.length(); right++) {
    char currentChar = s.charAt(right);
    if (Index.containsKey(currentChar)) {
        left = Math.max(Index.get(currentChar) +1, left);
    }
```
If `currentChar` is in map, moves `left` to `Index.get(currentChar) + 1` (preventing backward moves with `Math.max`).

### Step 3: Record Position and Update Max Substring Length
```java
Index.put(currentChar, right);
maxLength = Math.max(maxLength, right-left +1);
```
Updates character position in map and calculates window size `right - left + 1`.

## Logic
Dynamic sliding window with index jump on duplicate characters.
Why it works: By jumping `left` pointer immediately past duplicate character's previous index, we maintain a valid duplicate-free window without shrinking one character at a time.
Pattern to recognize: "Longest substring without duplicate elements" indicates sliding window + hash table index lookup.

## Dry Run
Input: s = "abcabcbb"

| Step | right | currentChar | Duplicate in Map? | left | Map Update | Window size | maxLength |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 0 | 'a' | No | 0 | 'a': 0 | 1 | 1 |
| 2 | 1 | 'b' | No | 0 | 'b': 1 | 2 | 2 |
| 3 | 2 | 'c' | No | 0 | 'c': 2 | 3 | **3** |
| 4 | 3 | 'a' | Yes ('a':0) | max(0+1, 0) = 1 | 'a': 3 | 3 | 3 |
| 5 | 4 | 'b' | Yes ('b':1) | max(1+1, 1) = 2 | 'b': 4 | 3 | 3 |
| 6 | 5 | 'c' | Yes ('c':2) | max(2+1, 2) = 3 | 'c': 5 | 3 | 3 |
| 7 | 6 | 'b' | Yes ('b':4) | max(4+1, 3) = 5 | 'b': 6 | 2 | 3 |
| 8 | 7 | 'b' | Yes ('b':6) | max(6+1, 5) = 7 | 'b': 7 | 1 | 3 |

Final output: 3 ✅

## Complexity

### Time Complexity
O(n)
Single pass since `right` advances from 0 to `s.length() - 1` and map lookups take O(1) average time.

### Space Complexity
O(min(n, m))
`m` is alphabet size (number of distinct characters). Map stores at most `min(n, m)` entries.
