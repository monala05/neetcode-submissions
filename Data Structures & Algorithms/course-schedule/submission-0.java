class Solution {
    // Map each course to its prerequisites
    //Adjacency list
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    // Store all courses along the current DFS path
    //This is to avoid cycles
    private Set<Integer> visiting = new HashSet<>();
    // Track courses that have been fully processed
    private Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //build adjacency list
        for(int[] pairs: prerequisites){
            int course = pairs[0];
            int pre = pairs[1];
            //build adj list. Course is key, values are prereqs
            preMap.computeIfAbsent(course, k -> new ArrayList<>()).add(pre);
        }

        //run a dfs on each course

        for(int course = 0; course < numCourses; course++){
            if(!dfs(course)) return false;
        }

        return true;
    }

    public boolean dfs(int crs){
        if(visiting.contains(crs)){
            return false;
        }

        if(visited.contains(crs)){
            return true;
        }

        visiting.add(crs);
        List<Integer> prereqs = preMap.getOrDefault(crs, new ArrayList<>());


        for (int prereq : prereqs) {
            if (!dfs(prereq)) return false;
        }

        visiting.remove(crs);
        visited.add(crs);
        return true;

    }
}
