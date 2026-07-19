# 3Sum

**Difficulty:** Medium

## Problem

Given an integer array `nums`. Return all triplets `[nums[i], nums[j], nums[k]]` such that i, j, k are distinct and `nums[i] + nums[j] + nums[k] == 0`. Answer must not contain duplicate triplets.

## Examples

```
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: sums to 0 with no duplicate triplets
```

```
Input: nums = [0,1,1]
Output: []
Explanation: no triplet sums to 0
```

```
Input: nums = [0,0,0]
Output: [[0,0,0]]
```

## Constraints

- 3 ≤ nums.length ≤ 3000
- -10^5 ≤ nums[i] ≤ 10^5

## Approach

sort array first. fix one element, then use two pointer on rest of array to find pairs that sum to negative of fixed element. skip duplicates at each step (fixed element and both pointers) to avoid repeated triplets in output.

Time: O(n^2)
Space: O(1) excluding output