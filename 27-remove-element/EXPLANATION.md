# 27. Remove Element

Difficulty: Easy

## Problem
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

## Examples
```
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Function should return k = 2, with the first two elements being 2.
```

```
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Function should return k = 5, with the first five elements containing 0, 1, 3, 0, and 4.
```

## Constraints
- 0 ≤ nums.length ≤ 100
- 0 ≤ nums[i] ≤ 50
- 0 ≤ val ≤ 100

## Approach
two pointers slow write pointer and fast read pointer. fast pointer iterates through nums. if nums[fast] != val, write nums[fast] to nums[slow] and increment slow. return slow count.

Time: O(n)
Space: O(1)
Difficulty: 🟢 Easy
Pattern: Two Pointers (In-place Overwrite)
LeetCode: [LeetCode Problem](https://leetcode.com/problems/remove-element/)

## Full Code
```java
class Solution {
    public int removeElement(int[] nums, int val) {

        int slow = 0; 
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
```

✅ Your code is correct and passes. It filters out matching target values in a single linear pass in-place.

## Code Explanation

### Step 1: Initialize Write Pointer
```java
int slow = 0;
```
`slow` tracks the position where the next non-val element should be placed.

### Step 2: Iterate Read Pointer
```java
for (int fast = 0; fast < nums.length; fast++) {
    if (nums[fast] != val) {
```
`fast` inspects every element in `nums`. Checks if element is not equal to `val`.

### Step 3: Write Valid Element
```java
nums[slow] = nums[fast];
slow++;
```
Overwrites element at `slow` with valid element and advances `slow`.

## Logic
Filtering unwanted values by overwriting array prefix.
Why it works: `fast` pointer reads every element while `slow` pointer keeps track of valid element count, ensuring non-val elements are shifted forward.
Pattern to recognize: Removing elements matching target condition in-place suggests read/write two pointers.

## Dry Run
Input: nums = [3, 2, 2, 3], val = 3

| Step | fast | nums[fast] | nums[fast] != 3? | slow | Prefix Array | Action |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 0 | 3 | No | 0 | [] | Skip |
| 2 | 1 | 2 | Yes | 1 | [2] | Write nums[0]=2, slow=1 |
| 3 | 2 | 2 | Yes | 2 | [2, 2] | Write nums[1]=2, slow=2 |
| 4 | 3 | 3 | No | 2 | [2, 2] | Skip |

Final output: 2 ✅

## Complexity

### Time Complexity
O(n)
Traverses input array once.

### Space Complexity
O(1)
In-place operation without extra memory allocation.
