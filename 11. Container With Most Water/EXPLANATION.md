# 11. Container With Most Water

Difficulty: Medium

## Problem
Given n non-negative integers height where each represents a point at coordinate (i, height[i]), find two lines that together with the x-axis form a container holding the max water.

## Examples
```
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The max area is between index 1 (height 8) and index 8 (height 7), width 7 * height 7 = 49.
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
two pointers from opposite ends. left starts at 0, right at n-1. calculate area = min(height[left], height[right]) * (right - left). greedily move pointer with smaller height inward because width shrinks, so only taller lines can yield larger area.

Time: O(n)
Space: O(1)
Difficulty: 🟡 Medium
Pattern: Two Pointers (Greedy Shrinking)
LeetCode: [LeetCode Problem](https://leetcode.com/problems/container-with-most-water/)

## Full Code
```java
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int maxArea = 0;
        while(left < right){
            int width = right - left;
            int currentHeight = Math.min(height[left],height[right]);
            int area = (currentHeight * width);
            maxArea = Math.max(maxArea, area);
            if(height[left] < height[right]){
                left ++;
            }else{
                right --;
            }
        }
            return maxArea;
    }
}
```

✅ Your code is correct and passes. It employs a two-pointer greedy strategy starting at extreme boundaries and advancing the shorter bar inward.

## Code Explanation

### Step 1: Initialize Two Pointers at Array Boundaries
```java
int left = 0;
int right = n-1;
int maxArea = 0;
```
Sets `left` at start and `right` at end to maximize initial width.

### Step 2: Calculate Area and Update Max
```java
int width = right - left;
int currentHeight = Math.min(height[left],height[right]);
int area = (currentHeight * width);
maxArea = Math.max(maxArea, area);
```
Calculates current container capacity bounded by shorter vertical line.

### Step 3: Greedily Move Shorter Bar Inward
```java
if(height[left] < height[right]){
    left ++;
}else{
    right --;
}
```
Moving the taller bar would decrease width without increasing height. Therefore, moving the shorter bar is the only candidate that could yield a larger area.

## Logic
The water trapped is bounded by the shorter line: `Area = min(h[l], h[r]) * (r - l)`.
Why it works: Since width decreases at every step, keeping the shorter line cannot produce any larger area with any inner pointer. Eliminating the shorter line proves globally optimal.
Pattern to recognize: Maximizing an interval-based metric with opposing boundaries points to a two-pointer inward search.

## Dry Run
Input: height = [1, 8, 6, 2, 5, 4, 8, 3, 7]

| Step | left | right | height[left] | height[right] | width | currentHeight | area | maxArea | Action |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 0 | 8 | 1 | 7 | 8 | 1 | 8 | 8 | left++ |
| 2 | 1 | 8 | 8 | 7 | 7 | 7 | 49 | 49 | right-- |
| 3 | 1 | 7 | 8 | 3 | 6 | 3 | 18 | 49 | right-- |
| 4 | 1 | 6 | 8 | 8 | 5 | 8 | 40 | 49 | right-- |
| 5 | 1 | 5 | 8 | 4 | 4 | 4 | 16 | 49 | right-- |
| 6 | 1 | 4 | 8 | 5 | 3 | 5 | 15 | 49 | right-- |
| 7 | 1 | 3 | 8 | 2 | 2 | 2 | 4 | 49 | right-- |
| 8 | 1 | 2 | 8 | 6 | 1 | 6 | 6 | 49 | right-- |

Final output: 49 ✅

## Complexity

### Time Complexity
O(n)
The while loop executes at most n steps since `right - left` decreases by 1 each iteration.

### Space Complexity
O(1)
Only uses primitive variables for pointers and area tracking.
