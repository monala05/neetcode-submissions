class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i: piles){max = Math.max(i, max);}
        
        int l = 1;
        int r = max + 1;
        while(l <   r){
            int k = (l + r)/2;
            if(valid(piles, h, k)){
               r = k;
            }else{
                l = k+1;
            }
        }

        return l;
    }

    public boolean valid(int[] piles, int h, int k){
        double sum = 0;
        for(int i: piles){
            sum += Math.ceil((double) i / k);
        }

        return sum <= h;
    }
}
