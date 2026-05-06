class Solution {
    List<List<Integer>> ans = new ArrayList();

    public List<List<Integer>> permute(int[] nums) {

        backTrack(nums, new boolean[nums.length], new ArrayList());
        return ans;
    }

    public void backTrack(int[] nums, boolean[] visited, List<Integer> cur){
        //goal -> we reach an array with the size of nums that has a permutation
        if(cur.size() == nums.length){
            ans.add(new ArrayList(cur));
            return;
        }
        
        
        //choice -> our pool of choices is the nums[] array. we can iterate through it and pick a num

        for(int i = 0; i < nums.length; i++){
            //Constraints
            //we have to ask if this current int has been visited before
            if(visited[i] == false){
                cur.add(nums[i]);
                visited[i] = true;
            
                //now we backtrack
                backTrack(nums, visited, cur);

                //if we reach a point with a full array we now have to remove elements
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }
    }


}
