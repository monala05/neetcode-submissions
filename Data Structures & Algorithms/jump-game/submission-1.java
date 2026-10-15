class Solution {
    public boolean canJump(int[] nums) {
        int curMax = 0;

        for(int i = 0; i < nums.length; i++){
            if(curMax < i){
                return false;
            }
            curMax = Math.max(curMax, nums[i] + i);
       
        }

        return true;
    }
}
