# 713. Subarray Product Less Than K

Difficulty: Medium

## Problem
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

## Examples
```
Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
```

```
Input: nums = [1,2,3], k = 0
Output: 0
```

## Constraints
- 1 ≤ nums.length ≤ 3 * 10^4
- 1 ≤ nums[i] ≤ 1000
- 0 ≤ k ≤ 10^6

## Approach
sliding window product accumulation. handle base case k <= 1 return 0. expand right pointer multiplying nums[right] into product. while product >= k, divide product by nums[left] and increment left. count += (right - left + 1) for valid window.

Time: O(n)
Space: O(1)
Difficulty: 🟡 Medium
Pattern: Sliding Window
LeetCode: [LeetCode Problem](https://leetcode.com/problems/subarray-product-less-than-k/)

## Full Code
```java
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
        return 0;

        int left = 0;
        int count = 0;
        int product = 1;

        for(int right = 0; right < nums.length; right++){
            product *= nums[right];
            while(product >= k){
                product /= nums[left];
                left ++;
            }
            count += right - left +1;
        }
        return count;
    }
}
```

✅ Your code is correct and passes. It maintains a sliding window of product strictly less than `k` and counts all valid ending subarrays.

## Code Explanation

### Step 1: Base Case Check
```java
if (k <= 1) return 0;
```
Since array elements are positive integers (≥ 1), any subarray product is ≥ 1. If `k <= 1`, no product can be < k.

### Step 2: Expand Window and Shrink on Violation
```java
for(int right = 0; right < nums.length; right++){
    product *= nums[right];
    while(product >= k){
        product /= nums[left];
        left ++;
    }
```
Multiplies incoming element `nums[right]`. Shrinks from `left` whenever `product >= k`.

### Step 3: Count Valid Subarrays
```java
count += right - left +1;
```
For a valid window `[left..right]`, the number of contiguous subarrays ending at `right` is `right - left + 1`.

## Logic
Counting subarrays using sliding window window-size addition.
Why it works: If window `[left..right]` has product < k, then all sub-windows ending at `right` (`[right]`, `[right-1, right]`, ..., `[left..right]`) also have product < k.
Pattern to recognize: Number of valid contiguous subarrays ending at right index equals `right - left + 1`.

## Dry Run
Input: nums = [10, 5, 2, 6], k = 100

| Step | right | nums[right] | product | product >= 100? | left | Subarrays ending at right | count |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 0 | 10 | 10 | No | 0 | 1 ([10]) | 1 |
| 2 | 1 | 5 | 50 | No | 0 | 2 ([5], [10, 5]) | 3 |
| 3 | 2 | 2 | 100 | Yes -> product/=10, left=1 | 1 | 2 ([2], [5, 2]) | 5 |
| 4 | 3 | 6 | 60 | No | 1 | 3 ([6], [2, 6], [5, 2, 6]) | **8** |

Final output: 8 ✅

## Complexity

### Time Complexity
O(n)
Both left and right pointers advance at most n times.

### Space Complexity
O(1)
Constant auxiliary variables.
