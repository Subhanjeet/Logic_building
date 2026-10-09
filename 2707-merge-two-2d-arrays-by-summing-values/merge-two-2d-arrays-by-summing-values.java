class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int i=0;
        int j=0;
        ArrayList <int[]> result = new ArrayList<>();

        while(i<n && j<m){
            if(nums1[i][0] < nums2[j][0]){
                result.add(nums1[i]);
                i++;
            }else if(nums2[j][0] < nums1[i][0]){
                result.add(nums2[j]);
                j++;
            }else{
                result.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            }
        }

        while(i<n){
            result.add(nums1[i]);
            i++;
        }
        while(j<m){
            result.add(nums2[j]);
            j++;
        }

        return result.toArray(new int[0][]);
    }
}