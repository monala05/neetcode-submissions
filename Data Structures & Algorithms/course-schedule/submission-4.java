class Solution {
    HashMap <Integer, List<Integer>> adj = new HashMap();
    Set<Integer> visiting = new HashSet();
    Set<Integer> visited = new HashSet();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Build adjacency list
        for(int[] course: prerequisites){
            int crs = course[0];
            int pre = course[1];

            adj.computeIfAbsent(crs, k -> new ArrayList()).add(pre);
        }

        //run a dfs on each course and return false is we find a cycle
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i)) return false;
        }

        return true;
    }

    //Run a cycle to try to find a cycle
    public boolean dfs(int crs){
        if(visiting.contains(crs)){return false;}
        if(visited.contains(crs)){return true;}

        visiting.add(crs);

        List<Integer> preReqs = adj.getOrDefault(crs, new ArrayList());

        for(int pre: preReqs){
            if(!dfs(pre)){return false;}
        }

        visiting.remove(crs);
        visited.add(crs);
        return true;
    }   
}
