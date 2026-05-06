class Solution {
        private Map<Integer, List<Integer>> preMap = new HashMap<>();
        private Set<Integer> visiting = new HashSet<>();
        private Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Adjacency 
        for(int[] pairs: prerequisites){
            int course = pairs[0];
            int pre = pairs[1];
            preMap.computeIfAbsent(course, k -> new ArrayList<>()).add(pre);
        }

        // course are non inclusive so if 3 course the numbers go from 0 - 2
        for(int course = 0; course < numCourses; course++){
            if(!dfs(course)) return false;
        }

        return true;
    }

    public boolean dfs(int course){
        if(visiting.contains(course)){
            return false;
        }

        if(visited.contains(course)){
            return true;
        }


        visiting.add(course);
        List<Integer> prereqs = preMap.getOrDefault(course, new ArrayList<>());
        for (int prereq : prereqs) {
            if (!dfs(prereq)) return false;
        }


        //We finished processing this node/class
        visiting.remove(course);
        visited.add(course);
        return true;

    }
}
