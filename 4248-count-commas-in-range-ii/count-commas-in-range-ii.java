class Solution {
    public long countCommas(long n) {
        long result = 0;
        for(long i=1000; i<=n; i *= 1000){
            if(i > 999){
                result += n - i +1;
            }
        }
        return result;
    }
}