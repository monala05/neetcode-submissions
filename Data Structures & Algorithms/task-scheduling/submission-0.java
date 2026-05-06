class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hashy = new HashMap();
        PriorityQueue<Integer> heap = new PriorityQueue(Collections.reverseOrder());

        for(int i = 0; i < tasks.length; i++){
            hashy.put(tasks[i], hashy.getOrDefault(tasks[i], 0) + 1);
        }
        
        for(char car : hashy.keySet()){
            heap.offer(hashy.get(car));
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();

        while(!heap.isEmpty() || !q.isEmpty()){
            time++;
            
            if(heap.isEmpty()){
                time = q.peek()[1];
            }else{
                int cur = heap.poll() - 1;
                
                if(cur > 0){
                    q.add(new int[]{cur, time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                heap.add(q.poll()[0]);
            }
        }

        return time;

    }
}
