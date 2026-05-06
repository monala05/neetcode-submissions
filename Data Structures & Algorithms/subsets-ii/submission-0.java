class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        bt(nums, 0, new ArrayList());

        return ans;
    }

    public void bt(int[] nums, int j, List<Integer> cur){
        if(j == nums.length){
            ans.add(new ArrayList(cur));
            return;
        }

        //add and iterate normally
        cur.add(nums[j]);
        bt(nums, j + 1, cur);

        //We backtrack and remove last element
        cur.remove(cur.size() - 1);
    
        //We dont want to consider elements that
        while(j + 1 < nums.length && nums[j] == nums[j+1]){
            j++;
        }

        //consider the next element that is not a dup
        bt(nums, j+1, cur);

    }
}
