class Solution {
    public boolean checkDivisibility(int n) {
        int original = n;
        int ans1 = 0;
        int ans2 = 1;
        int sum = 0;
        for(int i=n; i>0; i/=10){
            int digit = i % 10;
            ans1 += digit;
            ans2 *= digit;
        }
        sum = ans1 + ans2;
        if(0 == n % sum){
            return true;
        }else{
            return false;
        }
    }
}