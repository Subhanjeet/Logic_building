# 680. Valid Palindrome II

Difficulty: Easy

## Problem
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

## Examples
```
Input: s = "aba"
Output: true
```

```
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
```

```
Input: s = "abc"
Output: false
```

## Constraints
- 1 ≤ s.length ≤ 10^5
- s consists of lowercase English letters.

## Approach
two pointers left and right from ends. while left < right, if s[left] == s[right] advance left++ and right--. on first mismatch s[left] != s[right], check if substring s[left+1..right] OR s[left..right-1] is a palindrome using helper function. return true if either is valid.

Time: O(n)
Space: O(1)
Difficulty: 🟢 Easy
Pattern: Two Pointers (One Deletion Branching)
LeetCode: [LeetCode Problem](https://leetcode.com/problems/valid-palindrome-ii/)

## Full Code
```java
class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return isPalindromes(s, left +1, right) || isPalindromes(s, left, right -1); 
            }
            left ++;
            right --;
        }
        return true;
    }

    private boolean isPalindromes(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```

✅ Your code is correct and passes. On encountering the first character mismatch, it branches to test if deleting either the left or right character yields a valid palindrome.

## Code Explanation

### Step 1: Two Pointers Scan
```java
int left = 0, right = s.length() - 1;
while(left < right){
    if(s.charAt(left) != s.charAt(right)){
```
Scans inward from string boundaries.

### Step 2: Branch on Mismatch
```java
return isPalindromes(s, left +1, right) || isPalindromes(s, left, right -1);
```
On mismatch, tries skipping `s[left]` (`left + 1..right`) OR skipping `s[right]` (`left..right - 1`).

### Step 3: Helper Strict Palindrome Check
```java
private boolean isPalindromes(String s, int left, int right){
    while(left < right){
        if(s.charAt(left) != s.charAt(right)) return false;
        left++; right--;
    }
    return true;
}
```
Verifies if remaining substring is strictly a palindrome without further deletions.

## Logic
Palindrome validation with at most one character skip tolerance.
Why it works: At most one mismatch is allowed. When a mismatch occurs at `(left, right)`, the only choices are deleting `s[left]` or `s[right]`. If either resulting segment is a palindrome, the entire string is valid.
Pattern to recognize: Palindrome checking with single error tolerance branches into two standard pointer scans.

## Dry Run
Input: s = "abca"

| Step | left | s[left] | right | s[right] | Match? | Action |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 0 | 'a' | 3 | 'a' | Yes | left=1, right=2 |
| 2 | 1 | 'b' | 2 | 'c' | No | Branch: isPalindromes("bca", 2, 2) OR isPalindromes("abc", 1, 1) -> Both return True! |

Final output: true ✅

## Complexity

### Time Complexity
O(n)
At most two linear scans of string segments.

### Space Complexity
O(1)
Constant auxiliary space.
