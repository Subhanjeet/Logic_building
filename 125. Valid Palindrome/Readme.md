# 125. Valid Palindrome

**Difficulty:** Easy

## Problem

Given a string `s`. Return true if it is a palindrome, considering only alphanumeric characters and ignoring case.

## Examples

```
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome
```

```
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome
```

```
Input: s = " "
Output: true
Explanation: after removing non-alphanumeric characters, s is empty string, considered a palindrome
```

## Constraints

- 1 ≤ s.length ≤ 2 * 10^5
- s consists only of printable ascii characters

## Approach

two pointer from both ends. skip characters that arent alphanumeric by moving pointer forward/backward. compare lowercase version of chars at both pointers, if mismatch return false. keep going till pointers meet.

Time: O(n)
Space: O(1)