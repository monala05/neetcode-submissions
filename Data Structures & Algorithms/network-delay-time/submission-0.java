class Solution {
    public int networkDelayTime(int[][] times, int n, int k) { 
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] distance = new int[n + 1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        HashMap<Integer, List<int[]>> adj = new HashMap<>();

        for(int i = 0; i < n; i++){
            adj.put(i + 1, new ArrayList());
        }

        for(int[] cur: times){
            adj.get(cur[0]).add(new int[]{cur[1], cur[2]});
        }

        //add first item to the priority queue 
        minHeap.add(new int[]{k, 0});
        distance[k] = 0;

        while(minHeap.size() != 0){
            int[] cur = minHeap.poll();
            int node = cur[0];
            List<int[]> neighboors = adj.get(node); 

            if(visited[node] == false){
                for(int[] nei: neighboors){
                    int newDistance = distance[node] + nei[1];
                    if(newDistance < distance[nei[0]]){
                        distance[nei[0]] = newDistance;
                        minHeap.add(new int[]{nei[0], newDistance});
                    }
                }
            }

            visited[node] = true;
        }   

        int ans = 0;
        for(int i = 1; i < distance.length; i++){
            ans = Math.max(distance[i], ans);
        }

        return ans = ans != Integer.MAX_VALUE ? ans : -1;
    }
}
