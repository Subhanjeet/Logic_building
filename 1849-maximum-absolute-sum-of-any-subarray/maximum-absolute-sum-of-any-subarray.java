class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currP = 0;
        int currN = 0;
        for(int num : nums){
            currP += num;
            maxSum = Math.max(currP,maxSum);
            if(currP < 0){
                currP = 0;
            }

            currN += num;
            minSum = Math.min(currN,minSum);
            if(currN > 0){
                currN = 0;
            }
        }
        return Math.max(maxSum,Math.abs(minSum));
    }
}