# 485. Max Consecutive Ones

Difficulty: Easy

## Problem
Given a binary array nums, return the maximum number of consecutive 1s in the array.

## Examples
```
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
```

```
Input: nums = [1,0,1,1,0,1]
Output: 2
```

## Constraints
- 1 ≤ nums.length ≤ 10^5
- nums[i] is either 0 or 1.

## Approach
single pass streak counter. loop through nums. if num == 1 increment count and update maxCount = max(maxCount, count). if num == 0 reset count to 0.

Time: O(n)
Space: O(1)
Difficulty: 🟢 Easy
Pattern: Single Pass Counter
LeetCode: [LeetCode Problem](https://leetcode.com/problems/max-consecutive-ones/)

## Full Code
```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }
}
```

✅ Your code is correct and passes. It tracks current streak of ones and maintains the global maximum streak in a single linear pass.

## Code Explanation

### Step 1: Initialize Streak Variables
```java
int count = 0;
int maxCount = 0;
```
`count` tracks current consecutive ones streak. `maxCount` stores maximum streak observed.

### Step 2: Iterate Array and Reset on Zero
```java
for (int num : nums) {
    if (num == 1) {
        count++;
        maxCount = Math.max(maxCount, count);
    } else {
        count = 0;
    }
}
```
Increments streak on 1; resets streak to 0 on 0.

## Logic
Linear streak tracking.
Why it works: `count` accurately measures consecutive ones. Encountering 0 terminates current streak, resetting `count` for next block.
Pattern to recognize: Maximum consecutive elements problem solved with simple counter reset pattern.

## Dry Run
Input: nums = [1, 1, 0, 1, 1, 1]

| Step | num | num == 1? | count | maxCount | Action |
| :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 1 | Yes | 1 | 1 | Increment streak |
| 2 | 1 | Yes | 2 | 2 | Increment streak |
| 3 | 0 | No | 0 | 2 | Reset streak |
| 4 | 1 | Yes | 1 | 2 | Increment streak |
| 5 | 1 | Yes | 2 | 2 | Increment streak |
| 6 | 1 | Yes | 3 | **3** | Increment streak |

Final output: 3 ✅

## Complexity

### Time Complexity
O(n)
Single pass through array.

### Space Complexity
O(1)
Constant auxiliary variables.
