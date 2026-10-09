# 2570. Merge Two 2D Arrays by Summing Values

Difficulty: Easy

## Problem
You are given two 2D integer arrays nums1 and nums2 sorted in ascending order by id. Merge the two arrays into a single sorted 2D array by summing values of matching ids.

## Examples
```
Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
Output: [[1,6],[2,3],[3,2],[4,6]]
Explanation: 
- id = 1: val1 = 2, val2 = 4 -> [1, 6]
- id = 2: val1 = 3 -> [2, 3]
- id = 3: val2 = 2 -> [3, 2]
- id = 4: val1 = 5, val2 = 1 -> [4, 6]
```

```
Input: nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
Output: [[1,3],[2,4],[3,6],[4,3],[5,5]]
```

## Constraints
- 1 ≤ nums1.length, nums2.length ≤ 200
- nums1[i].length == nums2[j].length == 2
- 1 ≤ id_i, val_i ≤ 1000
- Sorted in ascending order by id.

## Approach
two pointers merge phase. pointers i and j iterate through nums1 and nums2. if id in nums1 < id in nums2, append nums1[i] and i++. if id in nums2 < id in nums1, append nums2[j] and j++. if ids equal, sum values append [id, val1+val2] and advance both. append remaining elements.

Time: O(n + m)
Space: O(n + m)
Difficulty: 🟢 Easy
Pattern: Two Pointers / Merge Sort Merge Phase
LeetCode: [LeetCode Problem](https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/)

## Full Code
```java
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int i=0;
        int j=0;
        ArrayList <int[]> result = new ArrayList<>();

        while(i<n && j<m){
            if(nums1[i][0] < nums2[j][0]){
                result.add(nums1[i]);
                i++;
            }else if(nums2[j][0] < nums1[i][0]){
                result.add(nums2[j]);
                j++;
            }else{
                result.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            }
        }

        while(i<n){
            result.add(nums1[i]);
            i++;
        }
        while(j<m){
            result.add(nums2[j]);
            j++;
        }

        return result.toArray(new int[0][]);
    }
}
```

✅ Your code is correct and passes. It merges two pre-sorted lists by ID in linear time using a classic two-pointer merge algorithm.

## Code Explanation

### Step 1: Initialize Two Pointers and Result List
```java
int i=0, j=0;
ArrayList <int[]> result = new ArrayList<>();
```
`i` tracks position in `nums1`, `j` in `nums2`.

### Step 2: Merge Matching or Smallest IDs
```java
while(i<n && j<m){
    if(nums1[i][0] < nums2[j][0]){ result.add(nums1[i]); i++; }
    else if(nums2[j][0] < nums1[i][0]){ result.add(nums2[j]); j++; }
    else { result.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]}); i++; j++; }
}
```
Compares IDs at current pointers and adds smaller ID or combined sum when equal.

### Step 3: Append Remaining Tail Elements
```java
while(i<n){ result.add(nums1[i]); i++; }
while(j<m){ result.add(nums2[j]); j++; }
```
Appends leftover elements from either array.

## Logic
Merge process of Merge Sort adapted for key-value pair aggregation.
Why it works: Since input arrays are sorted by ID, comparing head elements guarantees building the result in sorted order.
Pattern to recognize: Merging two pre-sorted arrays by key points to a two-pointer single-pass merge.

## Dry Run
Input: nums1 = [[1, 2], [2, 3], [4, 5]], nums2 = [[1, 4], [3, 2], [4, 1]]

| Step | i (nums1[i]) | j (nums2[j]) | ID Compare | Action | Added Pair |
| :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | [1, 2] | [1, 4] | 1 == 1 | Sum values | [1, 6] |
| 2 | [2, 3] | [3, 2] | 2 < 3 | Add nums1[1] | [2, 3] |
| 3 | [4, 5] | [3, 2] | 4 > 3 | Add nums2[1] | [3, 2] |
| 4 | [4, 5] | [4, 1] | 4 == 4 | Sum values | [4, 6] |

Final output: [[1, 6], [2, 3], [3, 2], [4, 6]] ✅

## Complexity

### Time Complexity
O(n + m)
Processes each element in `nums1` and `nums2` exactly once.

### Space Complexity
O(n + m)
Result list stores merged elements.
