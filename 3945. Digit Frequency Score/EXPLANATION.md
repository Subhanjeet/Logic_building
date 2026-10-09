# 3945. Digit Frequency Score

Difficulty: Easy

## Problem
Given an integer n, extract its digits, count their frequencies, and compute the total score defined as the sum of digit * frequency[digit] for all digits 0-9.

## Examples
```
Input: n = 252
Output: 9
Explanation: Digits are 2 (freq 2) and 5 (freq 1). Score = (2 * 2) + (5 * 1) = 4 + 5 = 9.
```

```
Input: n = 100
Output: 1
Explanation: Digits are 1 (freq 1) and 0 (freq 2). Score = (1 * 1) + (0 * 2) = 1.
```

## Constraints
- 1 ≤ n ≤ 10^9

## Approach
digit extraction with modulo 10 and integer division. store digit frequencies in fixed size array freq[10]. iterate digit 0 to 9 and compute total score sum(digit * freq[digit]).

Time: O(log10 n)
Space: O(1)
Difficulty: 🟢 Easy
Pattern: Math / Frequency Counting
LeetCode: Practice Problem

## Full Code
```java
class Solution {
    public int digitFrequencyScore(int n) {
        int[] freq = new int[10];
        
        while (n > 0) {
            int digit = n % 10;
            freq[digit]++;
            n /= 10;
        }
        int score = 0;

        for (int digit = 0; digit <= 9; digit++) {
            score += digit * freq[digit];
        }
        return score;
    }
}
```

✅ Your code is correct and passes. It extracts digits using standard modulo arithmetic and sums weighted frequencies.

## Code Explanation

### Step 1: Extract Digits and Count Frequencies
```java
int[] freq = new int[10];
while (n > 0) {
    int digit = n % 10;
    freq[digit]++;
    n /= 10;
}
```
Extracts last digit using `n % 10`, increments `freq[digit]`, and drops digit with `n /= 10`.

### Step 2: Compute Weighted Frequency Score
```java
int score = 0;
for (int digit = 0; digit <= 9; digit++) {
    score += digit * freq[digit];
}
return score;
```
Calculates sum of `digit * frequency` for digits 0 through 9.

## Logic
Processing integer digits sequentially.
Why it works: Modulo 10 extracts the least significant digit, allowing frequency counting in an array of size 10.
Pattern to recognize: Extracting digits from integer uses `n % 10` and `n /= 10` loop.

## Dry Run
Input: n = 252

### Extraction Phase:
1. `digit = 252 % 10 = 2` -> `freq[2] = 1`, `n = 25`
2. `digit = 25 % 10 = 5` -> `freq[5] = 1`, `n = 2`
3. `digit = 2 % 10 = 2` -> `freq[2] = 2`, `n = 0`

### Score Calculation Phase:
`score = (2 * 2) + (5 * 1) = 4 + 5 = 9`

Final output: 9 ✅

## Complexity

### Time Complexity
O(log10 n)
Number of loop iterations equals digit count of n.

### Space Complexity
O(1)
Fixed size array of length 10.
