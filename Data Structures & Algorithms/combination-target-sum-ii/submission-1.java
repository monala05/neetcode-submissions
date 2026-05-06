class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        bt(candidates, target, 0, new ArrayList());
        return ans;
    }

    public void bt(int[] candidates, int target, int i, List<Integer> cur){
        if(target <= 0 || i >= candidates.length){
            if(target == 0){
                ans.add(new ArrayList(cur));
                return;
            }
            return;
        }

        // initial left sided decision dfs
        cur.add(candidates[i]);
        bt(candidates, target - candidates[i], i + 1, cur);
        

        // now we have to consider the right side, recurs and backtrack
        //This is we we apply our restriction
        
        while(i + 1 < candidates.length && candidates[i] == candidates[i + 1]){
            i++;
        }
        cur.remove(cur.size() - 1);
        bt(candidates, target, i + 1, cur);
    }
}
