class Solution {
    public int search(int[] nums, int target) {
    int low = 0;
    int n = nums.length;
    int high = nums.length - 1;

    while (low <= high) {
        int guess = (low + high) / 2;

        if (nums[guess] == target) return guess;

        // Identifying Part 1 - which in this case are 4,5,6,7 from example 1
        if (nums[guess] >= nums[n - 1]) {
            if (nums[guess] < target) {
                low = guess + 1;
            } else {
                if (nums[0] > target) {
                    low = guess + 1;
                } else {
                    high = guess - 1;
                }
            }
        } 
        // Identifying Part 2 - which in this case are 0,1,2 from example 1
        else {
            if (nums[guess] > target) {
                high = guess - 1;
            } else {
                if (nums[n - 1] < target) {
                    high = guess - 1;
                } else {
                    low = guess + 1;
                }
            }
        }
    }
    return -1;
    }
}