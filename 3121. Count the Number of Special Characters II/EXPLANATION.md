# 3121. Count the Number of Special Characters II

Difficulty: Medium

## Problem
You are given a string word. A letter c is called special if both lowercase c and uppercase C appear in word, and every lowercase c appears BEFORE the FIRST appearance of uppercase C. Return the number of special letters in word.

## Examples
```
Input: word = "aaAbcBC"
Output: 3
Explanation: The special characters are 'a', 'b', and 'c'.
```

```
Input: word = "abc"
Output: 0
```

```
Input: word = "abBCab"
Output: 1
Explanation: Only 'b' is special ('B' appears after first 'b' and before second 'b' makes 'b' fail, but wait, 'a' fails because 'a' appears after 'A').
```

## Constraints
- 1 ≤ word.length ≤ 2 * 10^5
- word consists of lowercase and uppercase English letters.

## Approach
character scanning over 'a' to 'z'. for each character ch from 'a' to 'z', find last index of lowercase ch (lastLower) and first index of uppercase C (firstUpper). if both exist and lastLower < firstUpper, increment count.

Time: O(26 * n) = O(n)
Space: O(1)
Difficulty: 🟡 Medium
Pattern: String Scanning / Index Tracking
LeetCode: [LeetCode Problem](https://leetcode.com/problems/count-the-number-of-special-characters-ii/)

## Full Code
```java
class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        for(char ch='a'; ch<='z'; ch++) {
            int lastLower = -1;
            int firstUpper = -1;
            for(int i=0; i<word.length(); i++) {
                char current = word.charAt(i);
                if(current == ch) {
                    lastLower = i;
                }
                if(current == Character.toUpperCase(ch)) {
                    if(firstUpper == -1) {
                        firstUpper = i;
                    }
                }
            }
            if(lastLower != -1 && firstUpper != -1 && lastLower < firstUpper) {
               count++;
            }
        }
        return count;
    }
}
```

✅ Your code is correct and passes. It tracks the boundary indices of last lowercase and first uppercase for each character from 'a' to 'z'.

## Code Explanation

### Step 1: Iterate Over 26 Letters
```java
for(char ch='a'; ch<='z'; ch++) {
    int lastLower = -1, firstUpper = -1;
```
Iterates through all 26 English letters, initializing index trackers.

### Step 2: Track Index Boundaries in Single String Pass per Letter
```java
for(int i=0; i<word.length(); i++) {
    char current = word.charAt(i);
    if(current == ch) lastLower = i;
    if(current == Character.toUpperCase(ch)) {
        if(firstUpper == -1) firstUpper = i;
    }
}
```
Updates `lastLower` to latest index of `ch` and `firstUpper` to first index of uppercase `ch`.

### Step 3: Validate Special Character Condition
```java
if(lastLower != -1 && firstUpper != -1 && lastLower < firstUpper) {
   count++;
}
```
Checks if both forms exist and all lowercase instances precede the first uppercase instance (`lastLower < firstUpper`).

## Logic
Verifying index ordering constraint between lowercase and uppercase letter occurrences.
Why it works: Checking `lastLower < firstUpper` ensures that NO lowercase character appears after the first uppercase character.
Pattern to recognize: Positional ordering constraint between character classes dictates tracking boundary indices.

## Dry Run
Input: word = "aaAbcBC"

| Character `ch` | `lastLower` | `firstUpper` | Condition (`lastLower < firstUpper`) | Count |
| :--- | :--- | :--- | :--- | :--- |
| 'a' | 1 (second 'a') | 2 ('A') | 1 < 2 -> True | 1 |
| 'b' | 3 ('b') | 5 ('B') | 3 < 5 -> True | 2 |
| 'c' | 4 ('c') | 6 ('C') | 4 < 6 -> True | 3 |

Final output: 3 ✅

## Complexity

### Time Complexity
O(26 * n) = O(n)
Performs 26 passes over string of length n.

### Space Complexity
O(1)
Constant auxiliary variables.
