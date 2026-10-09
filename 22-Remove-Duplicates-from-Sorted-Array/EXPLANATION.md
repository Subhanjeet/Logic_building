# 26. Remove Duplicates from Sorted Array

Difficulty: Easy

## Problem
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Return k after placing the final result in the first k slots of nums.

## Examples
```
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
```

```
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
```

## Constraints
- 1 ≤ nums.length ≤ 3 * 10^4
- -100 ≤ nums[i] ≤ 100
- nums is sorted in non-decreasing order.

## Approach
two pointers slow and fast. slow pointer i tracks index of last unique element found. fast pointer j scans from index 1. when nums[i] != nums[j], increment i and copy nums[j] to nums[i]. return i + 1 as unique count.

Time: O(n)
Space: O(1)
Difficulty: 🟢 Easy
Pattern: Two Pointers (Slow & Fast)
LeetCode: [LeetCode Problem](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

## Full Code
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
```

✅ Your code is correct and passes. It maintains unique elements at the prefix of the array in a single linear pass.

## Code Explanation

### Step 1: Initialize Slow Pointer
```java
int i = 0;
```
`i` points to the position of the last written unique element.

### Step 2: Iterate Fast Pointer
```java
for(int j = 1; j < nums.length; j++) {
    if(nums[i] != nums[j]) {
```
`j` scans through the array. When `nums[j]` differs from current unique element `nums[i]`, a new unique value is found.

### Step 3: Copy Unique Element to Front
```java
i++;
nums[i] = nums[j];
```
Advances `i` to next write slot and copies `nums[j]` into it.

## Logic
Compacting unique values into the array prefix.
Why it works: Because `nums` is sorted, identical values are adjacent. `i` only advances when a new unique element appears.
Pattern to recognize: In-place deduplication of sorted arrays uses two pointers (read and write).

## Dry Run
Input: nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]

| Step | j | nums[j] | nums[i] | nums[i] != nums[j]? | i | Prefix Array |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| Init | - | - | 0 | - | 0 | [0] |
| 1 | 1 | 0 | 0 | No | 0 | [0] |
| 2 | 2 | 1 | 0 | Yes | 1 | [0, 1] |
| 3 | 3 | 1 | 1 | No | 1 | [0, 1] |
| 4 | 4 | 1 | 1 | No | 1 | [0, 1] |
| 5 | 5 | 2 | 1 | Yes | 2 | [0, 1, 2] |
| 6 | 6 | 2 | 2 | No | 2 | [0, 1, 2] |
| 7 | 7 | 3 | 2 | Yes | 3 | [0, 1, 2, 3] |
| 8 | 8 | 3 | 3 | No | 3 | [0, 1, 2, 3] |
| 9 | 9 | 4 | 3 | Yes | 4 | [0, 1, 2, 3, 4] |

Final output: 5 ✅

## Complexity

### Time Complexity
O(n)
Single pass through array of length n.

### Space Complexity
O(1)
Modifies input array in-place without auxiliary memory.
