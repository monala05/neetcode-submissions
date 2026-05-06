class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i < nums.length; i++){
            heap.offer(nums[i]);
        }

        int ans = -1;

        while(k != 0 && !heap.isEmpty()){
            ans = heap.poll();
            k--;
        }

        return ans;
    }
}
