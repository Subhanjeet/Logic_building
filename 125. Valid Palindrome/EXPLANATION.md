# 125. Valid Palindrome

Difficulty: Easy

## Problem
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers. Given a string s, return true if it is a palindrome, or false otherwise.

## Examples
```
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
```

```
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
```

```
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters, which reads same forward and backward.
```

## Constraints
- 1 ≤ s.length ≤ 2 * 10^5
- s consists only of printable ASCII characters.

## Approach
two pointers from ends. skip non-alphanumeric characters using Character.isLetterOrDigit. compare lowercase versions of valid characters. if mismatch return false. if pointers meet return true. in-place comparison without string building.

Time: O(n)
Space: O(1)
Difficulty: 🟢 Easy
Pattern: Two Pointers
LeetCode: [LeetCode Problem](https://leetcode.com/problems/valid-palindrome/)

## Full Code
```java
class Solution {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
```

✅ Your code is correct and passes. It uses two pointers traversing inward, bypassing invalid characters and comparing normalized characters in O(1) extra space.

## Code Explanation

### Step 1: Set Up Pointers
```java
int left = 0;
int right = s.length() - 1;
```
Positions `left` at index 0 and `right` at last character index.

### Step 2: Skip Non-Alphanumeric Characters
```java
if (!Character.isLetterOrDigit(s.charAt(left))) { left++; continue; }
if (!Character.isLetterOrDigit(s.charAt(right))) { right--; continue; }
```
Bypasses spaces, punctuation, and special symbols on both ends.

### Step 3: Compare Normalized Characters
```java
if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
    return false;
}
left++; right--;
```
Converts characters to lowercase and verifies symmetry. If any pair differs, returns `false`.

## Logic
Palindromes are symmetric around their center.
Why it works: By skipping non-alphanumeric characters on-the-fly and comparing case-insensitive matches, we check string symmetry directly without allocating new string objects.
Pattern to recognize: Checking string symmetry with character filtering favors two-pointer inward scan.

## Dry Run
Input: s = "A man, a plan, a canal: Panama"

| Step | left | s[left] | right | s[right] | Action | Match? |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 0 | 'A' | 29 | 'a' | 'a' == 'a' | Yes -> left=1, right=28 |
| 2 | 1 | ' ' | 28 | 'm' | Skip left space | left=2 |
| 3 | 2 | 'm' | 28 | 'm' | 'm' == 'm' | Yes -> left=3, right=27 |
| 4 | 3 | 'a' | 27 | 'a' | 'a' == 'a' | Yes -> left=4, right=26 |

... continues symmetrically until pointers cross.

Final output: true ✅

## Complexity

### Time Complexity
O(n)
Single pass through string `s` of length n.

### Space Complexity
O(1)
Checks characters in-place without extra string allocation.
