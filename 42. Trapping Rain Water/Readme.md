# 42. Trapping Rain Water

**Difficulty:** Hard

## Problem

Given `n` non-negative integers representing an elevation map where the width of each bar is 1. Compute how much water it can trap after raining.

## Examples

```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
```

```
Input: height = [4,2,0,3,2,5]
Output: 9
```

## Constraints

- n == height.length
- 1 ≤ n ≤ 2 * 10^5
- 0 ≤ height[i] ≤ 10^5

## Approach

two pointer from both ends, track maxLeft and maxRight seen so far. water trapped at any bar depends on min(maxLeft, maxRight) - height of that bar. move pointer on side with smaller max inward since thats the limiting side, update max and add trapped water at each step.

Time: O(n)
Space: O(1)