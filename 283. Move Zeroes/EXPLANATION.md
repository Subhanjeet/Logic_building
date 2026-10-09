# 283. Move Zeroes

Difficulty: Easy

## Problem
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements in-place.

## Examples
```
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
```

```
Input: nums = [0]
Output: [0]
```

## Constraints
- 1 ≤ nums.length ≤ 10^4
- -2^31 ≤ nums[i] ≤ 2^31 - 1

## Approach
two pointers left placement pointer and right scanner pointer. right iterates through array. whenever nums[right] != 0, swap nums[left] with nums[right] and increment left. all non-zero elements shift to front in relative order, zeros pushed to back.

Time: O(n)
Space: O(1)
Difficulty: 🟢 Easy
Pattern: Two Pointers (In-place Partition)
LeetCode: [LeetCode Problem](https://leetcode.com/problems/move-zeroes/)

## Full Code
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        for(int right = 0; right < n; right++){
            if( nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left ++;
            }
        }
    }
}
```

✅ Your code is correct and passes. Swapping non-zero elements to `left` maintains relative ordering while pushing zeros to the right.

## Code Explanation

### Step 1: Set Placement Pointer
```java
int left = 0;
```
`left` points to position where next non-zero element should be placed.

### Step 2: Iterate Scanner Pointer and Swap Non-Zeros
```java
for(int right = 0; right < n; right++){
    if( nums[right] != 0){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left ++;
    }
}
```
`right` scans array. When non-zero found, swaps it with element at `left` and advances `left`.

## Logic
Partitioning array into non-zero prefix and zero suffix.
Why it works: Swapping ensures non-zero elements are moved into `left` in their original order without overwriting.
Pattern to recognize: Re-arranging elements meeting a boolean condition in-place suggests read/write pointer swaps.

## Dry Run
Input: nums = [0, 1, 0, 3, 12]

| Step | right | nums[right] | nums[right] != 0? | Swap Target | left | Array State |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| Init | - | - | - | - | 0 | [0, 1, 0, 3, 12] |
| 1 | 0 | 0 | No | - | 0 | [0, 1, 0, 3, 12] |
| 2 | 1 | 1 | Yes | Swap nums[0], nums[1] | 1 | [1, 0, 0, 3, 12] |
| 3 | 2 | 0 | No | - | 1 | [1, 0, 0, 3, 12] |
| 4 | 3 | 3 | Yes | Swap nums[1], nums[3] | 2 | [1, 3, 0, 0, 12] |
| 5 | 4 | 12 | Yes | Swap nums[2], nums[4] | 3 | [1, 3, 12, 0, 0] |

Final array: [1, 3, 12, 0, 0] ✅

## Complexity

### Time Complexity
O(n)
Single pass through array of length n.

### Space Complexity
O(1)
Performs swaps in-place using constant auxiliary memory.
