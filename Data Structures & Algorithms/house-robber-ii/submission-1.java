class Solution {
    public int rob(int[] nums) {
        if(nums.length <=2){
            if(nums.length == 1){
                return nums[0];
            }else{
                return Math.max(nums[0], nums[1]);
            }
        }

        int[] route1 = new int[nums.length];
        route1[0] = nums[0];
        route1[1] = Math.max(nums[0],nums[1]);

        for(int i = 2; i < nums.length - 1; i++){
            route1[i] = Math.max(route1[i-1],(route1[i-2] + nums[i]));
        }

        
        int[] route2 = new int[nums.length];
        route2[1] = nums[1];
        route2[2] = Math.max(nums[1], nums[2]);

        for(int i = 3; i < nums.length; i++){
            route2[i] = Math.max(route2[i-1],(route2[i-2] + nums[i]));
        }

        int ans = -1;

        for(int i = 0; i < nums.length; i++){
            ans = Math.max(ans, Math.max(route1[i], route2[i]));
        }

        return ans;
    }
}
