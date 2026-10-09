# 424. Longest Repeating Character Replacement

Difficulty: Medium

## Problem
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times. Return the length of the longest substring containing the same letter you can get after performing the operations.

## Examples
```
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with 'B's or vice versa.
```

```
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the middle 'A' with 'B' to form "AABBBBA". The substring "BBBB" has length 4.
```

## Constraints
- 1 ≤ s.length ≤ 10^5
- s consists of only uppercase English letters.
- 0 ≤ k ≤ s.length

## Approach
sliding window with character frequency tracking. right pointer expands window and tracks max frequency of any single character in window (maxFreq). if window size minus maxFreq > k, shrink window from left by advancing left pointer and decrementing s[left] count.

Time: O(n)
Space: O(1)
Difficulty: 🟡 Medium
Pattern: Sliding Window & Frequency Counting
LeetCode: [LeetCode Problem](https://leetcode.com/problems/longest-repeating-character-replacement/)

## Full Code
```java
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
```

✅ Your code is correct and passes. It maintains a sliding window where at most `k` character replacements are needed to make all elements in the window identical.

## Code Explanation

### Step 1: Initialize Frequency Array and Window Variables
```java
int[] freq = new int[26];
int left = 0, maxFreq = 0, maxLength = 0;
```
`freq` tracks frequency of each letter A-Z in current window. `maxFreq` tracks count of most frequent letter in window.

### Step 2: Expand Window and Update Max Frequency
```java
for (int right = 0; right < s.length(); right++) {
    freq[s.charAt(right) - 'A']++;
    maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
```
Increments character count for incoming character `s[right]` and updates `maxFreq`.

### Step 3: Shrink Invalid Window
```java
while ((right - left + 1) - maxFreq > k) {
    freq[s.charAt(left) - 'A']--;
    left++;
}
```
If non-dominant characters in window `(right - left + 1) - maxFreq` exceed allowed replacements `k`, shrinks window from `left`.

## Logic
Finding longest window where `window_size - max_frequency <= k`.
Why it works: `max_frequency` represents the number of characters we keep. All other characters in window must be flipped, which requires at most `k` operations.
Pattern to recognize: Character replacement under budget `k` calls for sliding window with max frequency tracking.

## Dry Run
Input: s = "AABABBA", k = 1

| Step | right | s[right] | maxFreq | Window Size | Replacements Needed | Valid? | left | maxLength |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 0 | 'A' | 1 | 1 | 0 | Yes | 0 | 1 |
| 2 | 1 | 'A' | 2 | 2 | 0 | Yes | 0 | 2 |
| 3 | 2 | 'B' | 2 | 3 | 1 | Yes | 0 | 3 |
| 4 | 3 | 'A' | 3 | 4 | 1 | Yes | 0 | **4** |
| 5 | 4 | 'B' | 3 | 5 | 2 > 1 | No -> left=1 | 1 | 4 |
| 6 | 5 | 'B' | 3 | 5 | 2 > 1 | No -> left=2 | 2 | 4 |
| 7 | 6 | 'A' | 3 | 5 | 2 > 1 | No -> left=3 | 3 | 4 |

Final output: 4 ✅

## Complexity

### Time Complexity
O(n)
Single sliding window pass over string `s`.

### Space Complexity
O(1)
Fixed size frequency array of 26 integers.
