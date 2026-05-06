class Solution {
    public boolean canJump(int[] nums) {
        //HOW FAR CAN WE GO!

        int max = 0;

        for(int i = 0; i < nums.length; i++){
            if(max < i){
                return false;
            }
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }
}
