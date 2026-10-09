# 11. Container With Most Water

**Difficulty:** Medium

## Problem

Given an integer array `height` of length n. There are n vertical lines drawn such that the two endpoints of line i are (i, 0) and (i, height[i]). Find two lines that together with the x-axis form a container that holds the most water. Return the maximum amount of water a container can store.

## Examples

```
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: lines at index 1 and 8 (heights 8 and 7) form container of width 7, area = 7*7 = 49
```

```
Input: height = [1,1]
Output: 1
```

## Constraints

- n == height.length
- 2 ≤ n ≤ 10^5
- 0 ≤ height[i] ≤ 10^4

## Approach

two pointer from both ends. area = min(height[left], height[right]) * (right - left). track max area seen. move pointer with smaller height inward since that one is limiting factor, moving the taller one can only decrease width without helping height. keep going till pointers meet.

Time: O(n)
Space: O(1)