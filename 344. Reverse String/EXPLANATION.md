# 344. Reverse String

Difficulty: Easy

## Problem
Write a function that reverses a string. The input string is given as an array of characters s. You must do this by modifying the input array in-place with O(1) extra memory.

## Examples
```
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
```

```
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
```

## Constraints
- 1 ≤ s.length ≤ 10^5
- s[i] is a printable ascii character.

## Approach
two pointers front and back. loop i from 0 to n/2. swap s[i] with s[n - 1 - i] using temporary variables in-place.

Time: O(n)
Space: O(1)
Difficulty: 🟢 Easy
Pattern: Two Pointers
LeetCode: [LeetCode Problem](https://leetcode.com/problems/reverse-string/)

## Full Code
```java
class Solution {
    public void reverseString(char[] s) {        
        
        int n = s.length;

        for (int i=0; i<n/2; i++){
        int front = i;
        int back = n - 1 - i;
        char frontChar = s[front];
        char backChar = s[back];      

        s[front] = backChar;
        s[back] = frontChar;
        }
    }
}
```

✅ Your code is correct and passes. It swaps symmetric elements from array ends working inward to reverse the character array in-place.

## Code Explanation

### Step 1: Compute Symmetric Indices
```java
for (int i=0; i<n/2; i++){
int front = i;
int back = n - 1 - i;
```
Calculates `front` index `i` and matching `back` index `n - 1 - i`. Loop runs up to `n / 2`.

### Step 2: Swap Characters In-Place
```java
char frontChar = s[front];
char backChar = s[back];      

s[front] = backChar;
s[back] = frontChar;
```
Swaps elements at `front` and `back` using temporary variables.

## Logic
Reversing an array by swapping symmetric element pairs.
Why it works: Swapping index `i` with `n - 1 - i` for all `i < n / 2` completely reverses the array.
Pattern to recognize: Reversing array in-place uses two pointers meeting in the middle.

## Dry Run
Input: s = ['h', 'e', 'l', 'l', 'o'], n = 5, n/2 = 2

| Step (i) | front | back | s[front] | s[back] | Swap Action | Array State |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 0 | 0 | 4 | 'h' | 'o' | Swap 'h' and 'o' | ['o', 'e', 'l', 'l', 'h'] |
| 1 | 1 | 3 | 'e' | 'l' | Swap 'e' and 'l' | ['o', 'l', 'l', 'e', 'h'] |

Final array: ['o', 'l', 'l', 'e', 'h'] ✅

## Complexity

### Time Complexity
O(n)
Performs n / 2 swaps.

### Space Complexity
O(1)
In-place memory modification.
