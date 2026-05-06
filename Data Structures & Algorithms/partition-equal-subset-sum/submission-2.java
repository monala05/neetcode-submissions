class Solution {
    public boolean canPartition(int[] nums) {
        //Generating subsets is N^2 i believe
        // DP we can generate this in n*t where t is half of the target
       

        int target = 0;
        for(int i = 0; i < nums.length; i++){
            target+= nums[i];
        }

        if(target % 2 != 0){return false;}
        target /= 2;

        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        //each rows 0 has to be true
        for(int i = 0; i <= nums.length; i++){
            dp[i][0] = true;
        }

        //fill 2d array, so the idea is that each row represents
        //adding a new number for first row is 1 in the example
        //It should looke like [true, true, false false false false]
        //We then copy over and add our new value
        for(int i = 1; i <= nums.length; i++){
            int num = nums[i - 1];
            for(int j = 1; j <= target; j++){
                if(j < num){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                }
            }
        }

        return dp[nums.length][target];
    
    }
}
