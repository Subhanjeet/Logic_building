class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxDiff = Integer.MAX_VALUE;
        int result = 0;

        for (int i=0; i<n-2; i++){
            int left = i+1;
            int right = n-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int differenc = Math.abs(sum - target);
                if(maxDiff > differenc){
                    maxDiff = differenc;
                    result = sum;
                }
                if(sum == target){
                    return target;
                }
                else if(sum < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
    return result;   
    }
}