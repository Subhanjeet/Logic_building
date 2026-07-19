# 344. Reverse String

**Difficulty:** Easy

## Problem

Write a function that reverses a string. The input string is given as an array of characters `s`. Must modify the input array in-place with O(1) extra memory.

## Examples

```
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
```

```
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
```

## Constraints

- 1 ≤ s.length ≤ 10^5
- s[i] is a printable ascii character

## Approach

two pointer from both ends, swap characters and move pointers toward center till they meet or cross.

Time: O(n)
Space: O(1)