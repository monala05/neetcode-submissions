class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        this.maxHeap = new PriorityQueue(Collections.reverseOrder());
        this.minHeap = new PriorityQueue();
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == 0 || num < maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }

        // we need to balance this things
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        }

        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (minHeap.peek() + maxHeap.peek()) / 2.00;
        }else{
            return maxHeap.peek();
        }
    }
}
