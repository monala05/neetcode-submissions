class Solution {
    public int leastInterval(char[] tasks, int n) {
        //what do we need we a way to count each occurance
        // a wayu to keep track of tasks that cant be completed yet
        // a way to keep the current most frequent task

        HashMap<Character, Integer> hashy = new HashMap<>();
        //get counts
        for(int i = 0; i < tasks.length; i++){
            hashy.put(tasks[i], hashy.getOrDefault(tasks[i], 0) + 1);   
        }

        PriorityQueue<Integer> heap  = new PriorityQueue<Integer>(Collections.reverseOrder());

        
        //populate heap of tasks with the amount of every task
        for(int i: hashy.values()){
            heap.offer(i);
        }   
        int time = 0;

        //this is where we have the elements that need a cooldown. We hold The amounnt left of that element,the time when cooldown ends
        Queue<int[]> q = new LinkedList();

        //We are now going to get a running count of tasks while our Q or Heap have values
        while(!q.isEmpty() || !heap.isEmpty()){
            time++;

            if(!heap.isEmpty()){
                int cur = heap.poll() - 1;

                if(cur > 0){
                    q.add(new int[]{cur, time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                heap.offer(q.poll()[0]);
            }

        }


        return time;
    }
}