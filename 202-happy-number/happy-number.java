class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> scan = new HashSet<>();
        while(n != 1){
            if(scan.contains(n)){
                return false;
            }
            scan.add(n);
            int sum = 0;
            while(n>0){
                int digit = n%10;
                sum = sum + (digit*digit);
                n /= 10;
            }
            n = sum;
        }
        return true;
    }
}