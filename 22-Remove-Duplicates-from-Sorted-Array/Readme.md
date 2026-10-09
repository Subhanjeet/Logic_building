# Remove Duplicates from Sorted Array

**Difficulty:** Easy

## Problem

Given an integer array `nums` sorted in non-decreasing order. Remove the duplicates in-place such that each unique element appears only once. Return the number of unique elements `k`. The first `k` elements of `nums` should hold the final result.

## Examples

```
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: 2 unique elements, first 2 slots hold them.
```

```
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: 5 unique elements, first 5 slots hold them.
```

## Constraints

- 1 ≤ nums.length ≤ 3 * 10^4
- -100 ≤ nums[i] ≤ 100
- nums sorted in non-decreasing order

## Approach

two pointer. one pointer tracks position to place next unique element, other scans through array. since array sorted, duplicates always next to each other so just compare current with last placed one, if different move it to next slot.

Time: O(n)
Space: O(1)