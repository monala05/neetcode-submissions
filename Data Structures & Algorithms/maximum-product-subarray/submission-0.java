class Solution {
    public int maxProduct(int[] nums) {
        int[] dpMin = new int[nums.length];
        int[] dpMax = new int[nums.length];

        //base case
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];
        int ans = nums[0];

        for(int i = 1; i < nums.length; i++){
            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i-1] * nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(nums[i], Math.min(dpMax[i-1] * nums[i], dpMin[i - 1] * nums[i]));
            ans = Math.max(dpMax[i], ans);
        }

        return ans;
    }
}
