class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<int[]>();

       for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j});
                }
            }
       }

        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i = 0; i < 4; i++){
                int[] newDir = {cur[0] + dir[i][0], cur[1]+ dir[i][1]};
                if (newDir[0] < 0 || newDir[0] >= grid.length || newDir[1] < 0 || newDir[1] >= grid[0].length){
                    continue;
                }

                if(grid[newDir[0]][newDir[1]] != Integer.MAX_VALUE){
                    continue;
                }

                q.add(new int[]{newDir[0], newDir[1]});
                grid[newDir[0]][newDir[1]] = grid[cur[0]][cur[1]] + 1;
            }
        }
    }
}