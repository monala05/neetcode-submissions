class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;


    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(max.size() == 0 || num < max.peek()){
            max.offer(num);
        }else{
            min.offer(num);
        }

        //now we balance the heaps.

        if(max.size() > min.size() + 1){
            min.offer(max.poll());
        }

        if(min.size() > max.size()){
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        if(max.size() == min.size()){
            return (max.peek() + min.peek()) / 2.00;
        }else{
            return max.peek();
        }
    }
}
