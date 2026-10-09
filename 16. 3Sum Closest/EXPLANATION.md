# 16. 3Sum Closest

Difficulty: Medium

## Problem
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers.

## Examples
```
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
```

```
Input: nums = [0,0,0], target = 1
Output: 0
```

## Constraints
- 3 ≤ nums.length ≤ 500
- -1000 ≤ nums[i] ≤ 1000
- -10^4 ≤ target ≤ 10^4

## Approach
sort array first. iterate through i from 0 to n-3. set left = i+1, right = n-1. calculate triplet sum. track min absolute difference Math.abs(sum - target). if sum equals target return immediately. adjust left++ if sum < target or right-- if sum > target.

Time: O(n²)
Space: O(1)
Difficulty: 🟡 Medium
Pattern: Two Pointers / Sorting
LeetCode: [LeetCode Problem](https://leetcode.com/problems/3sum-closest/)

## Full Code
```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxDiff = Integer.MAX_VALUE;
        int result = 0;

        for (int i=0; i<n-2; i++){
            int left = i+1;
            int right = n-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int differenc = Math.abs(sum - target);
                if(maxDiff > differenc){
                    maxDiff = differenc;
                    result = sum;
                }
                if(sum == target){
                    return target;
                }
                else if(sum < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
    return result;   
    }
}
```

✅ Your code is correct and passes. Sorting enables two-pointer search to minimize absolute difference from target efficiently.

## Code Explanation

### Step 1: Sort Array and Initialize Best Difference Tracking
```java
Arrays.sort(nums);
int maxDiff = Integer.MAX_VALUE;
int result = 0;
```
Sorts array and sets `maxDiff` to track closest distance to target.

### Step 2: Fix Outer Element and Use Two Pointers
```java
for (int i=0; i<n-2; i++){
    int left = i+1;
    int right = n-1;
    while(left < right){
        int sum = nums[i] + nums[left] + nums[right];
```
Fixes `nums[i]` and scans remaining pair boundaries.

### Step 3: Update Closest Sum and Adjust Pointers
```java
if(maxDiff > differenc){
    maxDiff = differenc;
    result = sum;
}
if(sum == target) return target;
else if(sum < target) left++;
else right--;
```
Updates closest result when difference is smaller. Adjusts pointers based on relation to target.

## Logic
Minimizing distance `|sum - target|` over all triplets.
Why it works: Sorted array allows deterministic pointer movements. Moving `left` increases sum toward target; moving `right` decreases sum.
Pattern to recognize: Finding closest sum among triplets points to sorted array + two-pointer pair scanning.

## Dry Run
Input: nums = [-1, 2, 1, -4], target = 1 -> Sorted: [-4, -1, 1, 2]

| Step | i (nums[i]) | left (nums[left]) | right (nums[right]) | Sum | Diff (|sum - target|) | Best Result | Action |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 0 (-4) | 1 (-1) | 3 (2) | -3 | 4 | -3 | left++ |
| 2 | 0 (-4) | 2 (1) | 3 (2) | -1 | 2 | -1 | left++ -> inner loop done |
| 3 | 1 (-1) | 2 (1) | 3 (2) | 2 | 1 | **2** | right-- |

Final output: 2 ✅

## Complexity

### Time Complexity
O(n²)
Sorting takes O(n log n). Outer loop runs n times with O(n) inner two-pointer scan.

### Space Complexity
O(1)
Auxiliary memory limited to scalar tracking variables.
