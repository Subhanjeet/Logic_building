class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int i=0; i<n; i++){
            int current = nums[i];
            if(freq.containsKey(current)){
                freq.put(current, freq.get(current) +1);
            }else{
                freq.put(current, 1);
            }
            if(freq.get(current)> n/2)
            return current;
        }
        return -1;
    }
}