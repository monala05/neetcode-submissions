class Solution {
    int target;
    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;

        return dfs(nums, 0 , 0);
    }

    public int dfs(int[] nums, int index, int sum){
        if(index >= nums.length){
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }

        return  dfs(nums, index + 1, sum - nums[index]) 
        + dfs(nums, index + 1, sum + nums[index]);
    }
}
