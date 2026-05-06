class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int max = 0;
        for(int i = 0; i < piles.length; i++){
            max = Math.max(piles[i], max);
        }

        int l = 1, r = max;
        int res = max;

        while(l <= r){
            int mid = (l + r)/2;

            int sum = 0;

            for(int i = 0; i < piles.length; i++){
                int p = piles[i];
                sum += Math.ceil((double) p/mid);
            }
            
            if(sum <= h){
                res = mid;
                r = mid -1;
            }else{
                l = mid + 1;
            }
        }
        
        return res;
    }
}
