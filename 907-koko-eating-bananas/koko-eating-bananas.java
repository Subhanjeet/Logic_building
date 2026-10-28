class Solution {
    public int minEatingSpeed(int[] piles, int h) 
    {
        int n = piles.length;
        int low = 1;
        int high = getMax(piles);
        int res = high;

            while (low <= high) 
            {
                int guess = (low + high) / 2;
                long hours = fun(piles, n, guess);
                
                if (hours > h) {
                    // too slow, need to increase eating speed of koko
                    low = guess + 1;
                } else {
                    // possible eating speed, record as result and try smaller one also
                    res = guess;
                    high = guess - 1;
                }
            }
            return res;
    }
    
    // helper function
    long fun(int[] piles, int n, int guess) {
        long hour = 0;
        for (int i=0; i<n; i++) {
            hour += piles[i] / guess;
            if (piles[i] % guess != 0) {
                hour++;
            }
        }
        return hour;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for(int pile: piles){
            max = Math.max(pile, max);
        }
        return max;
    }

}