class Solution {

    int[] visited;
    List<Integer> post = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //0 - unvisited 1 - visiting - 2 visited
        visited = new int[numCourses];
        HashMap<Integer, List<Integer>> hashy = new HashMap<>();
        //Prebuild adj list
        for(int i = 0; i < numCourses; i++){hashy.put(i, new ArrayList());}
        //build adj list
        for(int[] reqs: prerequisites){hashy.get(reqs[1]).add(reqs[0]);}

        //run a dfs on all unvisited nodes
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                if(!dfs(i, hashy)){
                    return new int[0];
                }
            }
        }

        int[] ans = new int[post.size()];
        for (int i = 0; i < post.size(); i++) {
            ans[i] = post.get(post.size() - 1 - i);
        }

        return ans;
    }


    public boolean dfs(int node, HashMap<Integer, List<Integer>> hashy){
        if(visited[node] == 2){
            return true;
        }

        if(visited[node] == 1){
            return false;
        }

        visited[node] = 1;
        List<Integer> cur = hashy.get(node);
        for(int i = 0; i < cur.size(); i++){
            if(!dfs(cur.get(i), hashy)) return false;
        }
        visited[node] = 2;
        post.add(node);
        return true; 
    }
}
