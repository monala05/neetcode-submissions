class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hash = new HashMap();

        for(int i = 0; i < tasks.length; i++){
            hash.put(tasks[i], hash.getOrDefault(tasks[i], 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue(Collections.reverseOrder());
        for(int val: hash.values()){
            heap.offer(val);
        }

        Queue<int[]> q = new LinkedList();
        int time = 0;

        while(!q.isEmpty() || !heap.isEmpty()){
            time++;

            if(heap.isEmpty()){
                time = q.peek()[1];
            }else{
                int cnt = heap.poll() - 1;

                if(cnt > 0){
                    q.add(new int[]{cnt, time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                heap.offer(q.poll()[0]);
            }
        }

        return time;
    }
}
