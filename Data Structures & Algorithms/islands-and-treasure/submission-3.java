class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList(); 
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    q.add(new int[] {i, j});
                }
            }
        }

        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++){
                int row = cur[0] + directions[i][0];
                int col = cur[1] + directions[i][1];

                if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
                || grid[row][col] != Integer.MAX_VALUE){
                    continue;
                }

                q.add(new int[]{row, col});
                grid[row][col] = grid[cur[0]][cur[1]] + 1; 
            }
        }   
    }
}
