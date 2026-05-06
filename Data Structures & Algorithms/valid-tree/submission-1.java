class Solution {
    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) return false; // quick check
        //Create and adj list to represent a node and its edges
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        //Create a visited array to detect cycles and if a node is an island
        boolean[] visited = new boolean[n];

        //build adj list
        for(int[] edge : edges){
            int v = edge[0];
            int z = edge[1];

            adj.get(v).add(z);
            adj.get(z).add(v);
        }

        //do a bfs to iterate and search for redundancies / islands
        //Create a q to do the bfs
        Queue<Integer> q = new LinkedList();
        q.add(0);

        while(!q.isEmpty()){
            //iterate in levels
            int cur = q.remove();
            if(visited[cur]){
                return false;
            }
            visited[cur] = true;


            for (int neighbor : adj.get(cur)) {
                if (!visited[neighbor]) {
                    q.add(neighbor);
                }
            }

            }

            for(boolean b: visited){
                if(!b){
                    return false;
                }
            }

            return true;
        }

}


