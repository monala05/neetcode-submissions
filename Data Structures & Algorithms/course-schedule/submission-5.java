class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList());
        }

        // build adj and count the amount of dependencies a crs has
        for(int[] pre: prerequisites){
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }
        Queue<Integer> q = new LinkedList();
        //Get all courses with no dependencies
        for(int i = 0; i < numCourses; i++){ 
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        //now we do the bfs
        int finished = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            finished++;
            for(int nei: adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.add(nei);
                }
            }
        }

        return finished == numCourses;
    }
}
