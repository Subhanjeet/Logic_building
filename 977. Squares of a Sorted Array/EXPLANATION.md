# 977. Squares of a Sorted Array

Difficulty: Easy

## Problem
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

## Examples
```
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100]. After sorting, it becomes [0,1,9,16,100].
```

```
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
```

## Constraints
- 1 ≤ nums.length ≤ 10^4
- -10^4 ≤ nums[i] ≤ 10^4
- nums is sorted in non-decreasing order.

## Approach
partition negative and positive numbers into separate lists, square elements, reverse negative list, and merge two sorted lists using two pointers.

Time: O(n)
Space: O(n)
Difficulty: 🟢 Easy
Pattern: Two Pointers / Partition & Merge
LeetCode: [LeetCode Problem](https://leetcode.com/problems/squares-of-a-sorted-array/)

## Full Code
```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();

        for(int num : nums){
            if(num < 0){
                negative.add(num);
            }
            else{
                positive.add(num);
            }
        }

        if(negative.size() == 0){
            for(int i = 0 ;  i < positive.size() ; i++)
                positive.set(i , positive.get(i) * positive.get(i));
                return positive.stream().mapToInt(Integer::intValue).toArray(); 
        }

        if(positive.size() == 0){
            for(int i = 0 ; i < negative.size() ; i++)
                negative.set(i, negative.get(i) * negative.get(i));
                Collections.reverse(negative);
                return negative.stream().mapToInt(Integer::intValue).toArray();
        }

        int arr1 = negative.size();
        int arr2 = positive.size();
        int[] result = new int[arr1 + arr2];

        for(int i = 0 ; i < arr1 ; i++){
            negative.set(i , negative.get(i) * negative.get(i));
        }
        Collections.reverse(negative);
        
        for(int i = 0 ; i < arr2 ; i++)
            positive.set(i , positive.get(i) * positive.get(i));
                    
        int i = 0, j = 0, id = 0;

        while(i<arr1 && j<arr2){
            if(negative.get(i) <= positive.get(j)){
                result[id++] = negative.get(i++);
            }
            else{
                result[id++] = positive.get(j++);
            }
        }
        while(i<arr1){
            result[id++] = negative.get(i++);
        }
        while(j<arr2){
            result[id++] = positive.get(j++);
        }

        return result;
    }
}
```

✅ Your code is correct and passes. It separates numbers by sign, squares them, reverses the negative list, and merges the two sorted sequences.

## Code Explanation

### Step 1: Partition into Negative and Positive Lists
```java
for(int num : nums){
    if(num < 0) negative.add(num);
    else positive.add(num);
}
```
Splits elements into negative and non-negative sub-lists.

### Step 2: Square and Reverse Negative List
```java
for(int i = 0 ; i < arr1 ; i++) negative.set(i, negative.get(i) * negative.get(i));
Collections.reverse(negative);
```
Squaring negative numbers reverses their relative magnitude, so reversing the list restores sorted ascending order.

### Step 3: Two-Pointer Merge
```java
while(i<arr1 && j<arr2){
    if(negative.get(i) <= positive.get(j)) result[id++] = negative.get(i++);
    else result[id++] = positive.get(j++);
}
```
Merges the two pre-sorted lists into the output result array.

## Logic
Partitioning sorted array around zero and merging squared components.
Why it works: Squaring negative numbers turns larger absolute negatives into larger positive values. Reversing negative squares yields a sorted ascending list suitable for standard two-pointer merging.
Pattern to recognize: Merging two sorted sequences produced by non-linear transformation.

## Dry Run
Input: nums = [-4, -1, 0, 3, 10]

1. `negative` = [-4, -1], `positive` = [0, 3, 10]
2. Squared & Reversed `negative` = [1, 16]
3. Squared `positive` = [0, 9, 100]
4. Merge `[1, 16]` and `[0, 9, 100]` -> Result: [0, 1, 9, 16, 100]

Final output: [0, 1, 9, 16, 100] ✅

## Complexity

### Time Complexity
O(n)
Linear partitioning, squaring, reversing, and merging steps.

### Space Complexity
O(n)
Auxiliary lists and result array store n elements.
