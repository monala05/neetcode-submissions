class Solution {
    public int rob(int[] nums) {
        if(nums.length <= 2){
            if(nums.length == 1){
                return nums[0];
            }else{
                return Math.max(nums[0], nums[1]);
            }
        }
    

        int[] first = Arrays.copyOf(nums, nums.length - 1);
        int[] second = Arrays.copyOfRange(nums, 1, nums.length);
        int[] memoFirst = new int[first.length];
        Arrays.fill(memoFirst, -1);
        int[] secondMemo = new int[second.length];
        Arrays.fill(secondMemo, -1);
        int one = helper(first, first.length - 1, memoFirst);
        int two = helper(second, second.length - 1,  secondMemo);

        return Math.max(one, two);
    }

    public int helper(int[] nums, int i, int[] memo){
        if(i == 0){return nums[0];}
        if(i == 1){return Math.max(nums[i], nums[i-1]);}
        if(memo[i] != -1){
            return memo[i];
        }
        memo[i] = Math.max(helper(nums, i - 1, memo), helper(nums, i - 2, memo) + nums[i]);
        return memo[i];
    }

}
