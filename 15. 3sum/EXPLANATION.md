# 15. 3Sum

Difficulty: Medium

## Problem
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. The solution set must not contain duplicate triplets.

## Examples
```
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
```

```
Input: nums = [0,1,1]
Output: []
```

```
Input: nums = [0,0,0]
Output: [[0,0,0]]
```

## Constraints
- 3 ≤ nums.length ≤ 3000
- -10^5 ≤ nums[i] ≤ 10^5

## Approach
sort array first. iterate through i from 0 to n-3. skip duplicate nums[i]. use two pointers l = i+1 and r = n-1 to find pairs where nums[l] + nums[r] == -nums[i]. when found, add triplet, advance both pointers, and skip duplicates for l and r.

Time: O(n²)
Space: O(1)
Difficulty: 🟡 Medium
Pattern: Two Pointers / Sorting
LeetCode: [LeetCode Problem](https://leetcode.com/problems/3sum/)

## Full Code
```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i = 0 ; i < n-2 ; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i+1;
            int r = n-1;
            int sum = -1 * nums[i];
            while(l < r){
                int s = nums[l] + nums[r];
                if(s == sum){
                        res.add(Arrays.asList(nums[i] , nums[l] , nums[r]));
                        l++;
                        r--;
                        while( l < r && nums[l] == nums[l-1]){
                            l++;
                        }
                        while( l < r && nums[r] == nums[r+1]){
                            r--;
                        }
                }
                else if( s < sum){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return res;
    }
}
```

✅ Your code is correct and passes. Sorting allows using two pointers to reduce 3Sum to 2Sum while gracefully bypassing duplicate triplets.

## Code Explanation

### Step 1: Sort Array and Skip Duplicate Anchors
```java
Arrays.sort(nums);
for(int i = 0 ; i < n-2 ; i++){
    if(i > 0 && nums[i] == nums[i-1]) continue;
```
Sorting brings identical values together. `if(i > 0 && nums[i] == nums[i-1])` prevents duplicate triplets rooted at the same first value.

### Step 2: Two-Pointer Pair Search
```java
int l = i+1, r = n-1, sum = -1 * nums[i];
while(l < r){
    int s = nums[l] + nums[r];
```
Fixes first element `nums[i]` and searches for pair `nums[l] + nums[r] == -nums[i]`.

### Step 3: Record Triplet and Skip Duplicate Pair Values
```java
if(s == sum){
    res.add(Arrays.asList(nums[i] , nums[l] , nums[r]));
    l++; r--;
    while(l < r && nums[l] == nums[l-1]) l++;
    while(l < r && nums[r] == nums[r+1]) r--;
}
```
When pair matches, adds triplet and skips adjacent duplicate elements for both `l` and `r`.

## Logic
Converting 3Sum into sorted 2Sum problems.
Why it works: Sorting allows directional pointer movement (`l++` increases sum, `r--` decreases sum). Skipping duplicates guarantees unique output triplets.
Pattern to recognize: Multi-variable target sum problems on arrays benefit from sorting + multi-pointer scanning.

## Dry Run
Input: nums = [-1, 0, 1, 2, -1, -4] -> Sorted: [-4, -1, -1, 0, 1, 2]

| Step | i | nums[i] | Target Pair Sum | l | r | nums[l]+nums[r] | Action | Result List |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 0 | -4 | 4 | 1 (-1) | 5 (2) | 1 < 4 | l++ -> no match | [] |
| 2 | 1 | -1 | 1 | 2 (-1) | 5 (2) | 1 == 1 | Found! l=3, r=4 | [[-1, -1, 2]] |
| 3 | 1 | -1 | 1 | 3 (0) | 4 (1) | 1 == 1 | Found! l=4, r=3 | [[-1, -1, 2], [-1, 0, 1]] |
| 4 | 2 | -1 | - | - | - | - | Skip duplicate nums[i] | [[-1, -1, 2], [-1, 0, 1]] |

Final output: [[-1, -1, 2], [-1, 0, 1]] ✅

## Complexity

### Time Complexity
O(n²)
Sorting takes O(n log n). Outer loop runs n times and inner two-pointer search runs O(n), totaling O(n²).

### Space Complexity
O(1) auxiliary space (excluding space required for sorting and output list).
