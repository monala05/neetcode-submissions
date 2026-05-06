class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int fresh = 0;

        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int cur = grid[i][j];
                if(cur == 1){fresh++;}
                if(cur == 2){
                    q.add(new int[]{i, j});
                }

            }
        }
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int layer = q.size();
            boolean rotted = false;
            for(int i = 0; i < layer; i++){
                int[] cur = q.poll();
                int row = cur[0];
                int col = cur[1];

                for(int[] dir: directions){
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length){
                        if(grid[r][c] == 1){
                            fresh--;
                            grid[r][c] = 2;
                            q.add(new int[]{r,c});
                            rotted = true;
                        }
                    }
                }
            }
                    if(rotted)time++;
        }
        
        if(fresh != 0){
            return -1;
        }else{
            return time;
        }
    }
}
