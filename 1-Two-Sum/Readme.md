# Two Sum

**Difficulty:** Easy

## Problem

Given an array of integers `arr[]` and a target value `target`. Find indices (or elements) of two numbers such that they add up to `target`.

## Examples

```
Input: arr[] = [2, 7, 11, 15], target = 9
Output: [0, 1]
Explanation: arr[0] + arr[1] = 2 + 7 = 9
```

```
Input: arr[] = [3, 2, 4], target = 6
Output: [1, 2]
Explanation: arr[1] + arr[2] = 2 + 4 = 6
```

```
Input: arr[] = [3, 3], target = 6
Output: [0, 1]
Explanation: arr[0] + arr[1] = 3 + 3 = 6
```

## Constraints

- 2 ≤ arr.size() ≤ 10^4
- exactly one valid answer exists

## Approach

use hashmap. loop through array, for each element check if (target - element) already in map. if yes return indices. if no store element with its index in map. one pass, no nested loop needed.

Time: O(n)
Space: O(n)

