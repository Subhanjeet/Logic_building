# Digit Frequency Score

**Difficulty:** Easy

## Problem

You are given an integer `n`. The score of `n` is defined as the sum of `d * freq(d)` over all distinct digits `d`, where `freq(d)` denotes the number of times digit `d` appears in `n`. Return the score of `n`.

## Examples

```
Input: n = 122
Output: 5
Explanation: digit 1 appears 1 time, contributes 1*1 = 1. digit 2 appears 2 times, contributes 2*2 = 4. total = 5
```

```
Input: n = 101
Output: 2
Explanation: digit 0 appears 1 time, contributes 0. digit 1 appears 2 times, contributes 1*2 = 2. total = 2
```

## Constraints

- 1 ≤ n ≤ 10^9

## Approach

pull digits one at a time using mod and divide by 10. keep count of each digit in an array of size 10. after processing all digits loop through the count array and add d * count[d] to answer.

Time: O(log n)
Space: O(1)