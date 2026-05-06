class Solution {
    public int rob(int[] nums) {
        if(nums.length <= 2){
            if(nums.length == 1){
                return nums[0];
            }else{
                return Math.max(nums[0], nums[1]);
            }
        }

        return Math.max(helper(Arrays.copyOf(nums, nums.length - 1)), helper(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int helper(int[] nums){
        int prev = 0;
        int cur = 0;

        for(int i = 0; i < nums.length; i++){
            int temp = Math.max(prev + nums[i], cur);
            prev = cur;
            cur = temp;
        }
        

        return cur;
    }
}
