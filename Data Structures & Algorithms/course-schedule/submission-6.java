class Solution {
    int[] state;
    HashMap<Integer, List<Integer>> hashy;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        hashy = new HashMap();

        //States = 0 - unvisited, 1 visiting, 2 processed.
        state = new int[numCourses];
        //Fill out hashmap with empty lists to avoid nulls
        for(int i = 0; i < numCourses; i++){
            hashy.put(i, new ArrayList());
        }
        
        //Build adj list
        for(int i = 0; i < prerequisites.length; i++){
            int[] cur = prerequisites[i];
            int course = cur[0];
            int pre = cur[1];
            hashy.get(course).add(pre);
        }

        //Do a dfs for all courses, at each course we iterate to see if it has a cycle, return false if we detect a cycle
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i)){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int course){
        if(state[course] == 1){return false;}
        if(state[course] == 2){return true;}
        state[course] = 1;

        List<Integer> preReqs = hashy.get(course);

        for(int pre: preReqs){
            if(!dfs(pre)){
                return false;
            }
        }

        state[course] =2;

        return true;
    }
}
