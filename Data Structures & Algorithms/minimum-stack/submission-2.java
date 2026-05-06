class MinStack {
    List<Integer> start;
    List<Integer> min;

    public MinStack() {
        this.start = new ArrayList();
        this.min = new ArrayList();
    }
    
    public void push(int val) {
        this.start.add(val);
        
        if(min.isEmpty()){
            this.min.add(val);
        }else{
            int cur = Math.min(val, min.get(min.size() - 1));
            min.add(cur);
        }
    }
    
    public void pop() {
        this.start.remove(this.start.size() - 1);
        min.remove(min.size() - 1);
        
    }
    
    public int top() {
        return start.get(start.size() - 1);
    }
    
    public int getMin() {

        return min.get(start.size() - 1);
    }
}
