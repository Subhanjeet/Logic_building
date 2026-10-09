# 1004. Max Consecutive Ones III

Difficulty: Medium

## Problem
Given a binary array nums and an integer k, return the maximum number of consecutive 1s in the array if you can flip at most k 0s.

## Examples
```
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1] - numbers were flipped from index 5 to 10.
```

```
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
```

## Constraints
- 1 ≤ nums.length ≤ 10^5
- nums[i] is either 0 or 1
- 0 ≤ k ≤ nums.length

## Approach
sliding window algorithm. expand right pointer while counting zeros in window. when zeros > k, shrink window from left by advancing left pointer and decrementing zero count when a 0 leaves window. track max window size at each step.

Time: O(n)
Space: O(1)
Difficulty: 🟡 Medium
Pattern: Sliding Window
LeetCode: [LeetCode Problem](https://leetcode.com/problems/max-consecutive-ones-iii/)

## Full Code
```java
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeros = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }

            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
```

✅ Your code is correct and passes. It uses a dynamic sliding window where `right` expands the window and `left` shrinks it whenever the number of zeros exceeds `k`.

## Code Explanation

### Step 1: Initialize Sliding Window State
```java
int left = 0;
int zeros = 0;
int maxLength = 0;
```
`left` tracks the window start, `zeros` counts zeros currently inside the window, and `maxLength` tracks the max valid size found.

### Step 2: Expand Window with Right Pointer
```java
for (int right = 0; right < nums.length; right++) {
    if (nums[right] == 0) {
        zeros++;
    }
```
Advances `right` pointer across array. Increments `zeros` count whenever `nums[right] == 0`.

### Step 3: Shrink Window if Zeros Exceed K
```java
while (zeros > k) {
    if (nums[left] == 0) {
        zeros--;
    }
    left++;
}
```
If `zeros > k`, window is invalid. Decrements `zeros` if `nums[left] == 0` and increments `left` until `zeros <= k`.

### Step 4: Update Max Window Length
```java
maxLength = Math.max(maxLength, right - left + 1);
```
Measures current valid window length `right - left + 1` and updates `maxLength`.

## Logic
This problem reduces to finding the longest subarray containing at most `k` zeros.
Why it works: The sliding window maintains a valid subarray of 1s (with at most k flipped 0s). Both pointers move only forward, ensuring linear scan.
Pattern to recognize: "longest contiguous subarray with at most K invalid elements" indicates a dynamic sliding window approach.

## Dry Run
Input: nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0], k = 2

| Step | right | nums[right] | zeros | zeros > k? | left | Window [left..right] | maxLength |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 0 | 1 | 0 | No | 0 | [1] | 1 |
| 2 | 1 | 1 | 0 | No | 0 | [1, 1] | 2 |
| 3 | 2 | 1 | 0 | No | 0 | [1, 1, 1] | 3 |
| 4 | 3 | 0 | 1 | No | 0 | [1, 1, 1, 0] | 4 |
| 5 | 4 | 0 | 2 | No | 0 | [1, 1, 1, 0, 0] | 5 |
| 6 | 5 | 0 | 3 | Yes -> left moves to 4, zeros=2 | 4 | [0, 0] | 5 |
| 7 | 6 | 1 | 2 | No | 4 | [0, 0, 1] | 5 |
| 8 | 7 | 1 | 2 | No | 4 | [0, 0, 1, 1] | 5 |
| 9 | 8 | 1 | 2 | No | 4 | [0, 0, 1, 1, 1] | 5 |
| 10 | 9 | 1 | 2 | No | 4 | [0, 0, 1, 1, 1, 1] | 6 |
| 11 | 10 | 0 | 3 | Yes -> left moves to 5, zeros=2 | 5 | [0, 1, 1, 1, 1, 0] | 6 |

Final output: 6 ✅

## Complexity

### Time Complexity
O(n)
Each element is visited at most twice: once by `right` and once by `left`.

### Space Complexity
O(1)
Uses a constant amount of auxiliary memory for pointers and counters.
