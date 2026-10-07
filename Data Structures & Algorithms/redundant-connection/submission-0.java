class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        //build adj
        for(int i = 1; i < edges.length+1; i++){
            adj.put(i, new ArrayList());}

        //Start iterating and adding edges while
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
            int[] visited = new int[edges.length+1];
            if(!dfs(a, -1, adj, visited)){
                return edge; 
            }
        }

        return new int[0];

    }

    public boolean dfs(int node, int parent, HashMap<Integer, List<Integer>> adj, int[] visited){
        if(visited[node] == 1){return false;}
        if(visited[node] == 2){return true;}

        visited[node] = 1;

        List<Integer> neigh = adj.get(node);
        for(int i : neigh){
            if(i == parent){
                continue;
            }

            if(!dfs(i, node, adj, visited)){
                return false; 
            }
        }


        visited[node] = 2;
        return true;

    }
}
