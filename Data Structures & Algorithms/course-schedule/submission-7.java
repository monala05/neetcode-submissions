class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //0 unvisited - 1 visiting - 2 visited
        int[] status = new int[numCourses];
        HashMap<Integer, List<Integer>> adj = new HashMap();
        for(int i = 0; i < numCourses; i++){adj.put(i, new ArrayList());}

        for(int[] courses: prerequisites){
            int course = courses[0];
            int pre = courses[1];
            adj.get(course).add(pre);
        }

        //Iterate adj list and check for redundancies 

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, status, adj)){return false;}
        }
        return true;
    }

    public boolean dfs(int course, int[] status, HashMap<Integer, List<Integer>> adj){
        if(status[course] == 2){return true;}
        if(status[course] == 1){return false;}

        status[course] = 1;
        List<Integer> neighs = adj.get(course);

        for(int i: neighs){
            if(!dfs(i, status, adj)){
                return false;
            }
        }

        status[course] = 2;
        return true;
    }
}
