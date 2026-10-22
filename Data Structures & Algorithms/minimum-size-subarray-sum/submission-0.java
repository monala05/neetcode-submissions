class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;
        int curSum = 0;
        while(r < nums.length){
            curSum+= nums[r];

            while(curSum >= target){
                ans = Math.min(ans, r + 1 - l);
                curSum -= nums[l];
                l++;
            }

            r++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}