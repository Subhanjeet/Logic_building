import java.util.HashMap;

class Solution {
    public int[] findErrorNums(int[] nums) {

        int n = nums.length;
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) +1);
        }

        for (int i=1; i<=n; i++) {

            if (map.getOrDefault(i, 0) == 2){
                result[0] = i;
            }
            if (map.getOrDefault(i, 0) == 0){
                result[1] = i;
            }
        }
        return result;
    }
}