class Solution {
    public int rob(int[] nums) {
        if(nums.length <= 2){
            if(nums.length == 1){
                return nums[0];
            }else{
                return Math.max(nums[0], nums[1]);
            }
        }

        int[] build = new int[nums.length];
        build[0] = nums[0];
        build[1] = Math.max(nums[0], nums[1]);


        for(int i = 2; i < nums.length; i++){
            // we either skip the current by choosing everything up to this point
            // or we skip the last one by chosing everything up to i-2;
            build[i] = Math.max(build[i-1],(build[i-2] + nums[i]));
        }   


        return build[build.length -1];
    }
}
