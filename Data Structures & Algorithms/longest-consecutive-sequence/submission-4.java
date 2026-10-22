class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashy = new HashSet<>();
        for(int i = 0; i < nums.length; i++){hashy.add(nums[i]);}
        int ans = 0;
        
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            if(!hashy.contains(cur - 1)){
                int run = 0;
                while(hashy.contains(cur)){
                    run++;
                    cur++;
                }

                ans = Math.max(run, ans);
            }
        }


        return ans;
    }
}