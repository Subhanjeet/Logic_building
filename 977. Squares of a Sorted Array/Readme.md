# Squares of a Sorted Array

**Difficulty:** Easy

## Problem

Given an integer array `nums` sorted in non-decreasing order. Return an array of the squares of each number, also sorted in non-decreasing order.

## Examples

```
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: squared = [16,1,0,9,100], sorted = [0,1,9,16,100]
```

```
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
```

## Constraints

- 1 ≤ nums.length ≤ 10^4
- -10^4 ≤ nums[i] ≤ 10^4
- nums sorted in non-decreasing order

## Approach

two pointer from both ends. since negatives square to positive, biggest square always at one of the two ends. compare abs value at left and right pointer, put bigger square at end of result array, move that pointer inward, fill result from back to front.

Time: O(n)
Space: O(n) for result array