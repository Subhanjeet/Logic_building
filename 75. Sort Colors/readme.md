# 75. Sort Colors

**Difficulty:** Medium

## Problem

Given an array `nums` with `n` objects colored red, white, or blue, represented by integers 0, 1, and 2. Sort them in-place so that objects of the same color are adjacent, in the order red, white, blue. Must solve without using library sort function.

## Examples

```
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

```
Input: nums = [2,0,1]
Output: [0,1,2]
```

## Constraints

- n == nums.length
- 1 ≤ n ≤ 300
- nums[i] is 0, 1, or 2

## Approach

dutch national flag algorithm. three pointers, low mid high. low tracks boundary for 0s, high tracks boundary for 2s, mid scans through. if nums[mid] is 0 swap with low and move both low and mid forward. if 2 swap with high and move high back, dont move mid since swapped value unchecked. if 1 just move mid forward. one pass sorts everything.

Time: O(n)
Space: O(1)