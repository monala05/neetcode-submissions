class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        bt(candidates, target, 0, new ArrayList());
        return ans;
    }
    
    public void bt(int candidates[], int target, int i, List<Integer> cur){
        
        //goal is target
        if(i >= candidates.length || target <= 0){
            if(target == 0){
                ans.add(new ArrayList(cur));
            }

            return;
        }
        
        //choice is the numbers array
        cur.add(candidates[i]);
        //this part makes the left sided decision
        bt(candidates, target - candidates[i], i + 1, cur);
        //constraint is we must only put up unique combinations and we cant use the same candidate
        //dupilcate combinations can be avoided by not using dup elements
        
        //we have to bt now
        // this part makes the right sided decisions
        cur.remove(cur.size() - 1);
        //consider the next element but do NOT add dups
        while(i + 1 < candidates.length && candidates[i] == candidates[i + 1]){
            i++;
        }

        bt(candidates, target, i + 1, cur);

        
    }
}
