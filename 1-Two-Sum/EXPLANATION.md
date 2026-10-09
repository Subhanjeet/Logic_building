# 1. Two Sum

Difficulty: Easy

## Problem
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order.

## Examples
```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```

```
Input: nums = [3,2,4], target = 6
Output: [1,2]
```

```
Input: nums = [3,3], target = 6
Output: [0,1]
```

## Constraints
- 2 ≤ nums.length ≤ 10^4
- -10^9 ≤ nums[i] ≤ 10^9
- -10^9 ≤ target ≤ 10^9
- Exactly one valid answer exists.

## Approach
brute force nested loops. outer loop selects first element nums[i], inner loop checks all subsequent elements nums[j]. if nums[i] + nums[j] equals target, return their indices [i, j]. simple baseline approach checking every pair.

Time: O(n²)
Space: O(1)
Difficulty: 🟢 Easy
Pattern: Array / Brute Force
LeetCode: [LeetCode Problem](https://leetcode.com/problems/two-sum/)

## Full Code
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}
```

✅ Your code is correct and passes. It's a standard brute-force solution using nested loops to test every possible pair in the array until the matching sum is found.

## Code Explanation

### Step 1: Outer Loop for First Element
```java
for(int i=0; i<nums.length; i++){
```
Iterates through index `i` from 0 to `nums.length - 1`, selecting the first number of candidate pair `nums[i]`.

### Step 2: Inner Loop for Second Element
```java
for(int j=i+1; j<nums.length; j++){
```
Starts from `i + 1` to avoid pairing an element with itself or re-checking previously tested pairs.

### Step 3: Pair Sum Check and Return
```java
if(nums[i] + nums[j] == target){
    return new int[]{i,j};
}
```
Checks if `nums[i] + nums[j] == target`. When true, immediately constructs and returns the index array `[i, j]`.

## Logic
This approach evaluates every distinct pair of indices `(i, j)` where `i < j`. 
Why it works: By exhaustively testing all combinations, it is guaranteed to locate the unique pair that sums up to `target`.
Pattern to recognize: When looking for a combination of elements meeting a condition in small arrays or baseline solutions, a nested loop checks all pairs.

## Dry Run
Input: nums = [2, 7, 11, 15], target = 9

| Step | i | nums[i] | j | nums[j] | Sum (nums[i] + nums[j]) | Action | Result |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 0 | 2 | 1 | 7 | 2 + 7 = 9 | Match found! Return [0, 1] | [0, 1] |

Final output: [0, 1] ✅

## Complexity

### Time Complexity
O(n²)
The outer loop runs up to n times and the inner loop runs on average n/2 times, performing n*(n-1)/2 comparisons in the worst case.

### Space Complexity
O(1)
Performs all operations using constant extra space without allocating auxiliary dynamic data structures.
