# 75. Sort Colors

Difficulty: Medium

## Problem
Given an array nums with n objects colored red, white, or blue, represented by integers 0, 1, and 2. Sort them in-place so that objects of the same color are adjacent, in the order red, white, blue. Must solve without using library sort function.

## Examples
```
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

```
Input: nums = [2,0,1]
Output: [0,1,2]
```

## Constraints
- n == nums.length
- 1 ≤ n ≤ 300
- nums[i] is 0, 1, or 2

## Approach
dutch national flag algorithm. three pointers, low mid high. low tracks boundary for 0s, high tracks boundary for 2s, mid scans through. if nums[mid] is 0 swap with low and move both low and mid forward. if 2 swap with high and move high back, dont move mid since swapped value unchecked. if 1 just move mid forward. one pass sorts everything.

Time: O(n)
Space: O(1)
Difficulty: 🟡 Medium
Pattern: Three Pointers (Dutch National Flag)
LeetCode: [LeetCode Problem](https://leetcode.com/problems/sort-colors/)

## Full Code
```java
class Solution {
    public void sortColors(int[] nums) {
       int n = nums.length;
       int first = 0;
       int middle = 0;
       int last = n-1;
       while(middle <= last){
        switch(nums[middle]){
            case 0:
                int temp = nums[first];
                nums[first] = nums[middle];
                nums[middle] = temp;
                first ++;
                middle ++;
                break;

            case 1:
                middle ++;
                break;

            case 2:
                temp = nums[middle];
                nums[middle] = nums[last];
                nums[last] = temp;
                last --;
                break; 
        }
       }
    }
}
```

✅ Your code is correct and passes. It's the Dutch National Flag algorithm — a single pass that partitions the array into 0s, 1s, and 2s in place. Note that in the case 2 branch you deliberately do not advance middle, which is the crucial subtlety of this algorithm.

## Code Explanation

### Step 1: Set Up Three Pointers
```java
int first = 0; int middle = 0; int last = n - 1;
```
Three pointers divide the array into four regions:
- `[0, first)` — the sorted 0s (confirmed).
- `[first, middle)` — the sorted 1s (confirmed).
- `[middle, last]` — the unprocessed region.
- `(last, n-1]` — the sorted 2s (confirmed).
`middle` is the scanner that walks through the unprocessed region.

### Step 2: Loop Until the Unprocessed Region Empties
```java
while (middle <= last) {
```
We keep going while there are unprocessed elements. Once `middle` passes `last`, everything has been classified.

### Step 3: Handle Each Color
**Case 0 — swap to the front:**
```java
case 0: int temp = nums[first]; nums[first] = nums[middle]; nums[middle] = temp; first++; middle++; break;
```
A 0 belongs at the front. We swap it with the element at `first` (the boundary of the 0-region) and grow that region. Both pointers advance: `first++` because the 0-region grew, and `middle++` because the element now at `middle` is a confirmed 1.

**Case 1 — just move on:**
```java
case 1: middle++; break;
```
A 1 is already in the right middle region, so we simply advance `middle`.

**Case 2 — swap to the back:**
```java
case 2: temp = nums[middle]; nums[middle] = nums[last]; nums[last] = temp; last--; break;
```
A 2 belongs at the back. Swap it with the element at `last` and shrink the 2-region from the right.
The key subtlety: after swapping in case 2, we do not advance `middle`. The element we just swapped into `nums[middle]` came from the unprocessed region, so we haven't examined it yet — we must re-check it on the next iteration.

## Logic
This is a partitioning problem: arrange 0s, then 1s, then 2s. The Dutch National Flag algorithm solves it in a single pass by maintaining three regions with three pointers.
`first` marks where the next 0 should go (front).
`last` marks where the next 2 should go (back).
`middle` scans unclassified elements.
When we see a 0, swap it to the front; a 2, swap it to the back; a 1, leave it and move on. Everything converges so that, in one pass, all 0s, 1s, and 2s are in place.

Why it works: the invariants — "everything left of first is 0," "everything between first and middle is 1," "everything right of last is 2" — are maintained on every iteration. Because a 2 is swapped in from the unprocessed zone, we re-inspect that spot rather than skipping it, ensuring nothing is misclassified.

Pattern to recognize: "sort an array of a few fixed values," "partition into groups," or "move all X to one side" points to a partition / three-pointer approach. The tell is a small, known set of categories and an in-place requirement.

## Dry Run
Input: nums = [2, 0, 2, 1, 1, 0] (indices 0–5)

| Step | middle | first | last | nums[middle] | Action | Array after |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 0 | 0 | 5 | 2 | swap with last(5); last-- → 4 | [0, 0, 2, 1, 1, 2] |
| 2 | 0 | 0 | 4 | 0 | swap with first(0); first=1, middle=1 | [0, 0, 2, 1, 1, 2] |
| 3 | 1 | 1 | 4 | 0 | swap with first(1); first=2, middle=2 | [0, 0, 2, 1, 1, 2] |
| 4 | 2 | 2 | 4 | 2 | swap with last(4); last-- → 3 | [0, 0, 1, 1, 2, 2] |
| 5 | 2 | 2 | 3 | 1 | middle++ → 3 | [0, 0, 1, 1, 2, 2] |
| 6 | 3 | 2 | 3 | 1 | middle++ → 4 | [0, 0, 1, 1, 2, 2] |
| 7 | 4 | 2 | 3 | - | middle > last → stop | [0, 0, 1, 1, 2, 2] |

Step 1 shows the case 2 subtlety clearly: after swapping the 2 to the back, middle stays at 0 to re-inspect the 0 that got swapped in (handled at step 2).

Final array: [0, 0, 1, 1, 2, 2] ✅

## Complexity

### Time Complexity
O(n)
The while loop runs while middle <= last. Every iteration either advances middle (case 0, case 1) or shrinks last (case 2). Since middle only ever moves right and last only ever moves left, the total number of iterations is bounded by n.

### Space Complexity
O(1)
The algorithm sorts entirely in place. Only three integer pointers (first, middle, last) and one temporary variable (temp) are used.
