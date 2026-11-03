class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int max = maxNum(nums);
        int count = 0;

        for(int i=0; i<n; i++){
            if(nums[i] == max) continue;

            if(nums[i] < max){
                count += nums[i] - max;
            }
        }
        return Math.abs(count);
    }
    
    //helper function
    public int maxNum(int[] nums){
        int max = nums[0];
        for(int num : nums){
            max = Math.max(max,num);
        }
        return max;
    }
}