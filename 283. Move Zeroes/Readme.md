# Move Zeroes

**Difficulty:** Easy

## Problem

Given an integer array `nums`. Move all 0's to the end of it while maintaining the relative order of the non-zero elements. Must be done in-place without making a copy of the array.

## Examples

```
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
```

```
Input: nums = [0]
Output: [0]
```

## Constraints

- 1 ≤ nums.length ≤ 10^4
- -2^31 ≤ nums[i] ≤ 2^31 - 1

## Approach

two pointer. one pointer tracks position to place next non-zero element, other scans through array. whenever non-zero found swap it into position and move that pointer forward. keeps relative order since we only shift non-zero elements ahead, zeros naturally get pushed to end.

Time: O(n)
Space: O(1)