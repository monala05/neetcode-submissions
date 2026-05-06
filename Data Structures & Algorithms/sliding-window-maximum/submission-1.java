class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque();
        List<Integer> maxes = new ArrayList();

        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            //Remove left side if we are out of window range
            if(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && cur > nums[dq.peekLast()]){
                dq.pollLast();
            }

            dq.addLast(i);
            //add to max if we are at the correct window size
            if(i >= k - 1){
                maxes.add(nums[dq.peekFirst()]);
            }
        }

        int[] ans = new int[maxes.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = maxes.get(i);
        }

        return ans;
    }
}
