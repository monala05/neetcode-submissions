class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> maxes = new ArrayList();
        ArrayDeque<Integer> dq = new ArrayDeque();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){

            //This slides the window, mremoving 
            while(!dq.isEmpty() &&  dq.peekFirst() <= i - k){
                    dq.pollFirst();
            }

            //This is where we remove elements that are bigger then our max
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }

            //Now what? We have to add to our dq. There is two possibilities,
            //We either found a new max and pop everything or add a smaller element

            //This works because everything would have been poped thats not 
            //in order, if its a new max it essentially gets added to the left
            dq.offerLast(i);

            if(i >= k - 1){
                maxes.add(nums[dq.peekFirst()]);
            }

        }
        int[] ans = new int[maxes.size()];
        for(int j = 0; j < maxes.size(); j++){
            ans[j] = maxes.get(j);
        }
        return ans;
    }
}
