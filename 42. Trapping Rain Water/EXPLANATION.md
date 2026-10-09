# 42. Trapping Rain Water

Difficulty: Hard

## Problem
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

## Examples
```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water are trapped.
```

```
Input: height = [4,2,0,3,2,5]
Output: 9
```

## Constraints
- n == height.length
- 1 ≤ n ≤ 2 * 10^4
- 0 ≤ height[i] ≤ 10^5

## Approach
prefix and suffix max arrays. compute leftMax[i] (max height from 0 to i) and rightMax[i] (max height from n-1 down to i). water trapped at index i is max(0, min(leftMax[i], rightMax[i]) - height[i]). accumulate total water.

Time: O(n)
Space: O(n)
Difficulty: 🔴 Hard
Pattern: Dynamic Programming / Prefix & Suffix Arrays
LeetCode: [LeetCode Problem](https://leetcode.com/problems/trapping-rain-water/)

## Full Code
```java
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];

        if (n < 3)
        return 0;

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int water = 0;
        for (int i = 0; i < n; i++) {
            int level = Math.min(leftMax[i], rightMax[i]);
            water += level - height[i];
        }
        return water;
    }
}
```

✅ Your code is correct and passes. It precomputes maximum left and right boundary heights for every position to compute trapped water accurately.

## Code Explanation

### Step 1: Precompute Left Max Prefix Array
```java
leftMax[0] = height[0];
for (int i = 1; i < n; i++) {
    leftMax[i] = Math.max(leftMax[i - 1], height[i]);
}
```
`leftMax[i]` stores the tallest bar from index 0 up to `i`.

### Step 2: Precompute Right Max Suffix Array
```java
rightMax[n - 1] = height[n - 1];
for (int i = n - 2; i >= 0; i--) {
    rightMax[i] = Math.max(rightMax[i + 1], height[i]);
}
```
`rightMax[i]` stores the tallest bar from index `n-1` down to `i`.

### Step 3: Compute Trapped Water Per Index
```java
for (int i = 0; i < n; i++) {
    int level = Math.min(leftMax[i], rightMax[i]);
    water += level - height[i];
}
```
Water level at index `i` is determined by the shorter of the two surrounding boundaries `min(leftMax[i], rightMax[i])`.

## Logic
Trapped water at index `i` depends on the height of the tallest bar to its left and right.
Why it works: Water fills up to `min(leftMax, rightMax)`. Subtracting `height[i]` gives the exact volume of water above bar `i`.
Pattern to recognize: Boundary-dependent calculations across array indices benefit from prefix/suffix max arrays.

## Dry Run
Input: height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]

- `leftMax` = [0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3]
- `rightMax` = [3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1]

| i | height[i] | leftMax[i] | rightMax[i] | Water Level | Trapped Water |
| :--- | :--- | :--- | :--- | :--- | :--- |
| 0 | 0 | 0 | 3 | 0 | 0 |
| 1 | 1 | 1 | 3 | 1 | 0 |
| 2 | 0 | 1 | 3 | 1 | 1 |
| 3 | 2 | 2 | 3 | 2 | 0 |
| 4 | 1 | 2 | 3 | 2 | 1 |
| 5 | 0 | 2 | 3 | 2 | 2 |
| 6 | 1 | 2 | 3 | 2 | 1 |
| 7 | 3 | 3 | 3 | 3 | 0 |
| 8 | 2 | 3 | 2 | 2 | 0 |
| 9 | 1 | 3 | 2 | 2 | 1 |
| 10 | 2 | 3 | 2 | 2 | 0 |
| 11 | 1 | 3 | 1 | 1 | 0 |

Total trapped water: 0 + 0 + 1 + 0 + 1 + 2 + 1 + 0 + 0 + 1 + 0 + 0 = 6 ✅

## Complexity

### Time Complexity
O(n)
Three sequential linear loops of length n.

### Space Complexity
O(n)
Allocates `leftMax` and `rightMax` arrays of size n.
