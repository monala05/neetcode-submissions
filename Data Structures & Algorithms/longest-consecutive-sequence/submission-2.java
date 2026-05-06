class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashy = new HashSet();
        
        //add all elements to set
        for(int i = 0; i < nums.length; i++){
            hashy.add(nums[i]);
        }

        int curSum =0;
        int maxSum =0;
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];

            if(hashy.contains(cur -1) == false){
                curSum++;
                int k = cur + 1;
                while(hashy.contains(k)){
                    curSum++;
                    k++;
                }
                maxSum = Math.max(curSum, maxSum);
            }
            curSum = 0;

        }

        return maxSum;

    }
}
