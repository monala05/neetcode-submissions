class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] ans = new int[cost.length + 1];
        ans[0] = 0;
        ans[1] = 0;

        for(int i = 2; i <= cost.length; i++){
            int cur = Math.min((ans[i-1] + cost[i-1]), ans[i-2] + cost[i-2]);
            ans[i] = cur;
        }

        return ans[ans.length - 1];
    }
}
