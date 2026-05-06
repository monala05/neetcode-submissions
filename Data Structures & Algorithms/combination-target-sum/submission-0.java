class Solution {
    List<List<Integer>> ans = new ArrayList();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> cur = new ArrayList();
        dfs(nums, 0, target, cur);
        return ans;
    }

    public void dfs(int[] nums, int i, int target, List<Integer> cur) {
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        
        if (target < 0 || i >= nums.length) {
            return;
        }
        
        // Include the current number
        cur.add(nums[i]);
        dfs(nums, i, target - nums[i], cur);
        
        // Backtrack
        cur.remove(cur.size() - 1);
        
        // Move to the next index
        dfs(nums, i + 1, target, cur);
        }
}
