class KthLargest {
    
    PriorityQueue<Integer> heap;
    int k; 

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue(Collections.reverseOrder());
        this.k = k;
        for(int n: nums){
            heap.offer(n);
        }
    }
    
    public int add(int val) {
        List<Integer> poped = new ArrayList();
        heap.add(val);
        int index = k;
        int result = -1;
        while(index > 0){
            index--;
            int cur = heap.poll();
            if(index == 0){
                result = cur;
            }
            poped.add(cur);
        }

        for(int i: poped){
            heap.offer(i);
        }

        return result;
    }
}
