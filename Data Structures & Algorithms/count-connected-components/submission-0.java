class Solution {
    public int countComponents(int n, int[][] edges) {
        //0 = not visited, 1 = visiting, 2= visited
        int[] visited = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        int ans = 0;

 
        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // Undirected graph
        }


        //start dfs of nodes
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                ans++;
                dfs(adj, visited, i);
            }
        }   

        return ans;

    }

    public void dfs(List<List<Integer>> adj, int[] visited, int node){
        visited[node] = 1;

        for(int next: adj.get(node)){
            if(visited[next] == 0){
                dfs(adj, visited, next);
            }
        }

        visited[node] = 2;
    }
}
