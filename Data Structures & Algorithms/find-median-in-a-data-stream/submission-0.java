class MedianFinder {
    //Keeps smaller half of elements;
    PriorityQueue<Integer> maxHeap;

    //Keeps larger half of elemnts;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        this.maxHeap = new PriorityQueue(Collections.reverseOrder());
        this.minHeap = new PriorityQueue();
    }
    
    public void addNum(int num) {
     if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            // Move the root of maxHeap to minHeap
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            // Move the root of minHeap to maxHeap
            maxHeap.add(minHeap.poll());
        }

    }
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }else{
            return maxHeap.peek();
        }
    }
}
