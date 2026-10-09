# Max Sum Subarray of size K

Difficulty: Easy

## Problem
Given an array of integers arr[] and a number k. Return the maximum sum of a subarray of size k.

## Examples
```
Input: arr[] = [100, 200, 300, 400], k = 2
Output: 700
Explanation: arr2 + arr3 = 700, which is maximum.
```

```
Input: arr[] = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
Output: 39
Explanation: arr1 + arr2 + arr3 + arr4 = 39, which is maximum.
```

## Constraints
- 1 ≤ arr.size() ≤ 10^6
- 0 ≤ arr[i] ≤ 10^6
- 1 ≤ k ≤ arr.size()

## Approach
fixed size sliding window. compute sum of first k elements. slide window from index k to n-1 by adding incoming element arr[i] and subtracting outgoing element arr[i-k]. track max window sum.

Time: O(n)
Space: O(1)
Difficulty: 🟢 Easy
Pattern: Fixed Sliding Window
LeetCode: [GeeksforGeeks Problem](https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1)

## Full Code
```java
class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return 0;
        
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}
```

✅ Your code is correct and passes. It maintains a fixed window of size `k` and updates the window sum in O(1) time per step.

## Code Explanation

### Step 1: Pre-calculate Initial Window Sum
```java
for (int i = 0; i < k; i++) {
    windowSum += arr[i];
}
maxSum = windowSum;
```
Calculates sum of first `k` elements (indices 0 to `k-1`).

### Step 2: Slide Window across Array
```java
for (int i = k; i < n; i++) {
    windowSum += arr[i] - arr[i - k];
    maxSum = Math.max(maxSum, windowSum);
}
```
Slides window one element right by adding `arr[i]` (new element) and subtracting `arr[i - k]` (old element).

## Logic
Reusing previous window sum to compute next window sum in O(1) time.
Why it works: Adjacent windows of fixed size `k` share `k - 1` overlapping elements. Subtracting the outgoing element and adding the incoming element updates the sum instantly.
Pattern to recognize: Subarray problems with fixed window size `k` call for a fixed sliding window.

## Dry Run
Input: arr = [100, 200, 300, 400], k = 2

| Step | i | Incoming (arr[i]) | Outgoing (arr[i-k]) | windowSum | maxSum |
| :--- | :--- | :--- | :--- | :--- | :--- |
| Init | 0..1 | [100, 200] | - | 300 | 300 |
| 1 | 2 | 300 | 100 | 300 + 300 - 100 = 500 | 500 |
| 2 | 3 | 400 | 200 | 500 + 400 - 200 = 700 | **700** |

Final output: 700 ✅

## Complexity

### Time Complexity
O(n)
Single pass of length n.

### Space Complexity
O(1)
Auxiliary space is O(1).
