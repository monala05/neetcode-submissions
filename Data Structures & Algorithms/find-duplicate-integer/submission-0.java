class Solution {
    public int findDuplicate(int[] nums) {
        int[] buckets = new int[nums.length + 1];

        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            buckets[cur]++;
        }
        int ans =-1;

        for(int i = 0; i < buckets.length; i++){
            if(buckets[i] > 1){
                ans = i;
            }
        }

        return ans;
    }
}
