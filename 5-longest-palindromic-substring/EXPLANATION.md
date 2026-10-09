# 5. Longest Palindromic Substring

Difficulty: Medium

## Problem
Given a string s, return the longest palindromic substring in s.

## Examples
```
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
```

```
Input: s = "cbbd"
Output: "bb"
```

## Constraints
- 1 ≤ s.length ≤ 1000
- s consists of only digits and English letters.

## Approach
expand around center. iterate center index i from 0 to s.length()-1. expand for odd length palindromes (expand(s, i, i)) and even length palindromes (expand(s, i, i+1)). update max length substring start and end boundaries.

Time: O(n²)
Space: O(1)
Difficulty: 🟡 Medium
Pattern: Expand Around Center
LeetCode: [LeetCode Problem](https://leetcode.com/problems/longest-palindromic-substring/)

## Full Code
```java
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i=0; i<s.length(); i++) {
            //Odd length palindrome
            int len1 = expand(s, i, i);
            //Even length palindrome
            int len2 = expand(s, i, i+1);
            //Longer palindrome
            int len = Math.max(len1, len2);
            if (len>end - start +1) {
                start = i - (len -1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end +1);
    }
    private int expand(String s, int left, int right) {
        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
```

✅ Your code is correct and passes. It expands outward from all 2n-1 possible palindrome centers to find the longest palindromic substring.

## Code Explanation

### Step 1: Base Case Check
```java
if (s == null || s.length() < 2) return s;
```
If string length is less than 2, it is already a palindrome.

### Step 2: Iterate Centers and Expand
```java
for (int i=0; i<s.length(); i++) {
    int len1 = expand(s, i, i);     // Odd center
    int len2 = expand(s, i, i+1);   // Even center
    int len = Math.max(len1, len2);
```
Tests both odd-length (single center character) and even-length (dual center characters) palindromes.

### Step 3: Update Substring Boundaries
```java
if (len>end - start +1) {
    start = i - (len -1)/2;
    end = i + len/2;
}
```
Recalculates `start` and `end` indices whenever a longer palindrome is discovered.

## Logic
Palindromes are symmetric around their center.
Why it works: There are 2n - 1 possible centers (n single characters and n-1 character pairs). Expanding outward from each center identifies all palindromes.
Pattern to recognize: Longest palindromic substring problem is efficiently solved by expanding around centers.

## Dry Run
Input: s = "babad"

| i | Center s[i] | len1 (Odd) | len2 (Even) | max len | Substring | Bounds [start, end] |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 0 | 'b' | 1 ("b") | 0 | 1 | "b" | [0, 0] |
| 1 | 'a' | 3 ("bab") | 0 | 3 | "bab" | [0, 2] |
| 2 | 'b' | 3 ("aba") | 0 | 3 | "aba" | [0, 2] |
| 3 | 'a' | 1 ("a") | 0 | 1 | "a" | [0, 2] |
| 4 | 'd' | 1 ("d") | 0 | 1 | "d" | [0, 2] |

Final output: "bab" ✅

## Complexity

### Time Complexity
O(n²)
There are 2n - 1 centers. Expanding each center takes up to O(n) time.

### Space Complexity
O(1)
Constant extra memory.
