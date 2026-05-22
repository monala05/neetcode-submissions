class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i: piles){
            max = Math.max(i, max);
        }

        int l = 1; 
        int r = max + 1;

        while(l < r){
            int k = (l + r)/2;

            if(works(piles, k, h)){
                r = k;
            }else{
                l = k + 1;
            }
        }

        return r;
    }

    public boolean works(int[] piles, int k, int h){
        int hours = 0;

        for(int p: piles){
            hours += (p + k - 1) / k;
        }

        return hours <= h;
    }
}
