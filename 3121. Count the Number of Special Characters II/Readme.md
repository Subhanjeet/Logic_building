# Count the Number of Special Characters II

**Difficulty:** Medium

## Problem

Given a string `word`. A letter is considered special if it appears both in lowercase and uppercase in `word`, and every lowercase occurrence of that letter comes before every uppercase occurrence. Return the count of special letters in `word`.

## Examples

```
Input: word = "aaAbcBC"
Output: 3
Explanation: a, b, c all appear lowercase before their uppercase, all special
```

```
Input: word = "abc"
Output: 0
Explanation: no uppercase letters present
```

```
Input: word = "abBACad"
Output: 1
Explanation: a has lowercase after uppercase so not special, b is not, c not, only a... check each letter carefully, only valid ones count
```

## Constraints

- 1 ≤ word.length ≤ 2 * 10^5
- word consists of lowercase and uppercase English letters only

## Approach

track for each letter the last index where it appears lowercase and first index where it appears uppercase. if both exist and last lowercase index is less than first uppercase index, letter is special. use two arrays of size 26 to store this info in one pass, then count at the end.

Time: O(n)
Space: O(1) since fixed size 26 array