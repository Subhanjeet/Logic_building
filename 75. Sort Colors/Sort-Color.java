class Solution {
    public void sortColors(int[] nums) {
       int n = nums.length;
       int first = 0;
       int middle = 0;
       int last = n-1;
       while(middle <= last){
        switch(nums[middle]){
            case 0:
                int temp = nums[first];
                nums[first] = nums[middle];
                nums[middle] = temp;
                first ++;
                middle ++;
                break;

            case 1:
                middle ++;
                break;

            case 2:
                temp = nums[middle];
                nums[middle] = nums[last];
                nums[last] = temp;
                last --;
                break; 
        }
       }
    }
}