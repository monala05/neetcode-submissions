class Solution {
    private Queue<int[]> q = new LinkedList();
    int fresh = 0;
    public int orangesRotting(int[][] grid) {
        int time = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
            }
        } 
        
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.remove();
                bfs(grid, cur[0], cur[1]);
            }
            time++;
        }


        return fresh == 0 ? time : -1; 
    }   

    public void bfs(int[][] grid, int row, int col){
        if(row + 1 < grid.length && grid[row + 1][col] == 1){
            grid[row + 1][col] = 2;
            fresh--;
            int[] cur = {row + 1, col};
            q.add(cur);
        }

        if(col + 1 < grid[0].length && grid[row][col + 1] == 1){
            grid[row][col + 1] = 2;
            fresh--;
            int[] cur = {row, col + 1};
            q.add(cur);

        }

        if(row - 1 >= 0 && grid[row - 1][col] == 1){
            grid[row - 1][col] = 2;
            fresh--;
            int[] cur = {row - 1, col};
            q.add(cur);
        }

        if(col - 1 >= 0 && grid[row][col - 1] == 1){
            grid[row][col - 1] = 2;
            fresh--;
            int[] cur = {row, col - 1};
            q.add(cur);
        }
    }
}
