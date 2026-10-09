# 167. Two Sum II - Input Array Is Sorted

Difficulty: Medium

## Problem
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Return 1-based indices [index1, index2].

## Examples
```
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2. We return [1, 2].
```

```
Input: numbers = [2,3,4], target = 6
Output: [1,3]
```

```
Input: numbers = [-1,0], target = -1
Output: [1,2]
```

## Constraints
- 2 ≤ numbers.length ≤ 3 * 10^4
- -1000 ≤ numbers[i] ≤ 1000
- numbers is sorted in non-decreasing order.
- -1000 ≤ target ≤ 1000
- Exactly one solution exists.

## Approach
two pointers from opposite ends. left = 0, right = n-1. if numbers[left] + numbers[right] == target return 1-based indices [left+1, right+1]. if sum > target decrement right, if sum < target increment left.

Time: O(n)
Space: O(1)
Difficulty: 🟡 Medium
Pattern: Two Pointers
LeetCode: [LeetCode Problem](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

## Full Code
```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n-1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left +1,right +1};
            }
            if(sum > target){
                right --;
            }else{
                left ++;
            }
        }
        return new int[]{-1,-1};
    }
}
```

✅ Your code is correct and passes. Taking advantage of the pre-sorted input array gives an optimal single-pass two-pointer solution.

## Code Explanation

### Step 1: Set Up Boundary Pointers
```java
int left = 0;
int right = n-1;
```
Places `left` at start (smallest element) and `right` at end (largest element).

### Step 2: Compare Sum with Target
```java
int sum = numbers[left] + numbers[right];
if(sum == target){
    return new int[]{left +1,right +1};
}
```
Calculates pair sum and returns 1-indexed output array when equal to `target`.

### Step 3: Directional Pointer Movements
```java
if(sum > target){ right --; }
else{ left ++; }
```
If sum is too large, decrementing `right` lowers sum. If sum is too small, incrementing `left` raises sum.

## Logic
Exploiting sorted property to decide pointer adjustments.
Why it works: Sorted order guarantees that increasing `left` increases sum while decreasing `right` decreases sum, covering all pair combinations linearly.
Pattern to recognize: Searching for target pair sum in sorted array dictates a two-pointer approach.

## Dry Run
Input: numbers = [2, 7, 11, 15], target = 9

| Step | left | numbers[left] | right | numbers[right] | sum | sum vs target | Action |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 0 | 2 | 3 | 15 | 17 | 17 > 9 | right-- |
| 2 | 0 | 2 | 2 | 11 | 13 | 13 > 9 | right-- |
| 3 | 0 | 2 | 1 | 7 | 9 | **9 == 9** | Return [1, 2] |

Final output: [1, 2] ✅

## Complexity

### Time Complexity
O(n)
Single pass since pointers move towards each other by 1 step per iteration.

### Space Complexity
O(1)
Constant auxiliary space used.
