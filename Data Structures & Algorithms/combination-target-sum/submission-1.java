class Solution {
    List<List<Integer>> ans = new ArrayList();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        bt(nums,target, new ArrayList(), 0);
        return ans;    
    }

    public void bt(int[] nums, int target, List<Integer> cur, int i){
        //base case is our goal we want the sum of our array to sum to target
        if(i >= nums.length || target <= 0){
            if(target == 0){
                ans.add(new ArrayList(cur));
            }
            return;
        }

        //decision space is our numbers array. we dont have to iterate because we are 
        //considering one at a time we dont have to consider every element in the array at all times.
        //this we lead to many more calls.
            cur.add(nums[i]);
            //what is our constraint? how do we make a new choice
            //our constraint is target. We cant go over. We keep adding untill 
            //we are at or above target
            // we chose to keep adding the same number untill we hit base
            bt(nums, target - nums[i], cur, i);
            //now we backtrack and remove from cur
            cur.remove(cur.size() - 1);

            //do we have to make another call
            //yes we have to consider the next element
            bt(nums, target, cur, i +1);
    }
}
