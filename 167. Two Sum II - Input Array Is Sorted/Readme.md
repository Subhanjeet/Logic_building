# 167. Two Sum II - Input Array Is Sorted

**Difficulty:** Medium

## Problem

Given a 1-indexed array of integers `numbers` sorted in non-decreasing order, find two numbers such that they add up to a specific `target`. Return the indices of the two numbers, `[index1, index2]`, added by one, as an integer array of length 2. Use only constant extra space.

## Examples

```
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: numbers[0] + numbers[1] = 2 + 7 = 9
```

```
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: numbers[0] + numbers[2] = 2 + 4 = 6
```

```
Input: numbers = [-1,0], target = -1
Output: [1,2]
```

## Constraints

- 2 ≤ numbers.length ≤ 3 * 10^4
- -1000 ≤ numbers[i] ≤ 1000
- numbers sorted in non-decreasing order
- exactly one solution exists

## Approach

array already sorted so use two pointer instead of hashmap to keep space constant. one pointer at start one at end. if sum too small move left pointer up, if too big move right pointer down, if equal return both indices plus 1.

Time: O(n)
Space: O(1)