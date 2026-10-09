# 209. Minimum Size Subarray Sum

Difficulty: Medium

## Problem
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

## Examples
```
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
```

```
Input: target = 4, nums = [1,4,4]
Output: 1
```

```
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
```

## Constraints
- 1 ≤ target ≤ 10^9
- 1 ≤ nums.length ≤ 10^5
- 1 ≤ nums[i] ≤ 10^5

## Approach
variable sliding window. expand right pointer adding nums[right] to running sum. while sum >= target, update minLen = min(minLen, right - left + 1), subtract nums[left] from sum, and advance left pointer. return 0 if minLen unchanged.

Time: O(n)
Space: O(1)
Difficulty: 🟡 Medium
Pattern: Sliding Window
LeetCode: [LeetCode Problem](https://leetcode.com/problems/minimum-size-subarray-sum/)

## Full Code
```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
```

✅ Your code is correct and passes. It expands window with `right` and contracts with `left` while maintaining valid sum to find minimal length.

## Code Explanation

### Step 1: Initialize Window State
```java
int left = 0, sum = 0;
int minLen = Integer.MAX_VALUE;
```
Sets window left boundary `left = 0`, running sum `sum = 0`, and `minLen` to max integer value.

### Step 2: Expand Window Right Boundary
```java
for (int right = 0; right < n; right++) {
    sum += nums[right];
```
Adds current element `nums[right]` to running window sum.

### Step 3: Shrink Window to Minimize Length
```java
while (sum >= target) {
    minLen = Math.min(minLen, right - left + 1);
    sum -= nums[left];
    left++;
}
```
When sum target is met, records window length and shrinks from left until sum drops below target.

## Logic
Finding shortest contiguous subarray summing to at least target.
Why it works: Since all numbers are positive, window sum is monotonically increasing with `right` expansion and decreasing with `left` contraction.
Pattern to recognize: Minimal length subarray condition on positive array indicates dynamic sliding window.

## Dry Run
Input: target = 7, nums = [2, 3, 1, 2, 4, 3]

| Step | right | nums[right] | sum | sum >= 7? | left | Window size | minLen |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 0 | 2 | 2 | No | 0 | 1 | ∞ |
| 2 | 1 | 3 | 5 | No | 0 | 2 | ∞ |
| 3 | 2 | 1 | 6 | No | 0 | 3 | ∞ |
| 4 | 3 | 2 | 8 | Yes -> left=1, sum=6 | 1 | 4 | 4 |
| 5 | 4 | 4 | 10 | Yes -> left=2 (sum=7), left=3 (sum=6) | 3 | 3 | 3 |
| 6 | 5 | 3 | 9 | Yes -> left=4 (sum=7), left=5 (sum=3) | 5 | 2 | **2** |

Final output: 2 ✅

## Complexity

### Time Complexity
O(n)
Both left and right pointers traverse array at most once.

### Space Complexity
O(1)
Only uses primitive counters and pointers.
