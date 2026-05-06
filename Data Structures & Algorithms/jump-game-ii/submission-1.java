class Solution {

        // The idea here is to keep a range of how far we can go at any index
        //If we reach the end of the range, we updated the amount of jumps. 
        //We always try to go as far as possible so we have to keep track during our current range
        //How far we can go, when we hit the end of the range we update to the fartherst so far

    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for(int i = 0; i < nums.length - 1; i++){
            farthest = Math.max(farthest, nums[i] + i);

            if(i == currentEnd){
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}
