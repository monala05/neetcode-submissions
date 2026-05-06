class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> cur = new ArrayList(); 
        List<List<Integer>> ans = new ArrayList(); 

        back(nums, 0,  cur, ans);

        return ans;
    }

    public void back(int[] nums, int i, List<Integer> cur, List<List<Integer>> ans){
        if(i >= nums.length){
            ans.add(new ArrayList(cur));
            return;
        }

        cur.add(nums[i]);
        back(nums, i+1, cur, ans);
        cur.remove(cur.size() - 1);
        back(nums, i+1, cur, ans);
    }
}
