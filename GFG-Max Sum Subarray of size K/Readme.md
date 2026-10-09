# Max Sum Subarray of size K

**Difficulty:** Easy | **Accuracy:** 49.6% | **Submissions:** 311K+ | **Points:** 2

## Problem

Given an array of integers `arr[]` and a number `k`. Return the maximum sum of a subarray of size `k`.

**Note:** A subarray is a contiguous part of any given array.

## Examples

```
Input: arr[] = [100, 200, 300, 400], k = 2
Output: 700
Explanation: arr2 + arr3 = 700, which is maximum.
```

```
Input: arr[] = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
Output: 39
Explanation: arr1 + arr2 + arr3 + arr4 = 39, which is maximum.
```

```
Input: arr[] = [100, 200, 300, 400], k = 1
Output: 400
Explanation: arr3 = 400, which is maximum.
```

## Constraints

- 1 ≤ arr.size() ≤ 10^6
- 0 ≤ arr[i] ≤ 10^6
- 1 ≤ k ≤ arr.size()

## Approach

use sliding window. get sum of first k elements then slide window one step at a time, add new element and remove first element of previous window. track max sum along the way.

Time: O(n)
Space: O(1)
