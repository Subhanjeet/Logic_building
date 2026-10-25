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
    long fun(int[] piles, int n, int speed) {
        long h = 0;
        for (int i=0; i<n; i++) {
            h += piles[i] / speed;
            if (piles[i] % speed != 0) {
                h++;
            }
        }
        return h;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

}