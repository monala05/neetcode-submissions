class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int curSum = 1;
        int ans = 1;
        int last = nums[0];

        for(int i = 1; i < nums.length; i++){
            int dif = nums[i] - last;

            if(dif == 1){
                curSum++;
                ans = Math.max(ans, curSum);
            }else if(dif > 1 ){
                curSum = 1;
            }

            last = nums[i];
        }

        return ans;
    }
}
