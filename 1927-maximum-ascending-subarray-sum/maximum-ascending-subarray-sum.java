class Solution {
    public int maxAscendingSum(int[] nums) {
        int current = nums[0];
        int result = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[i-1]){
                current += nums[i];
            }else{
                current = nums[i];
            }
            result = Math.max(current, result);
        }
        return result;
    }
}