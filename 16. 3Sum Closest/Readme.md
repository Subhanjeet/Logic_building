# 3Sum Closest

**Difficulty:** Medium

## Problem

Given an integer array `nums` and a target integer `target`. Find three integers in `nums` such that the sum is closest to `target`. Return the sum of the three integers.

## Examples

```
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: -1 + 2 + 1 = 2, closest to target 1
```

```
Input: nums = [0,0,0], target = 1
Output: 0
Explanation: 0 + 0 + 0 = 0, closest to target 1
```

## Constraints

- 3 ≤ nums.length ≤ 500
- -1000 ≤ nums[i] ≤ 1000
- -10^4 ≤ target ≤ 10^4

## Approach

sort array first. fix one element, use two pointer on rest to find pair. track closest sum found so far, compare abs diff with target at each step and update if smaller. move left pointer up if sum too small, right pointer down if sum too big.

Time: O(n^2)
Space: O(1)