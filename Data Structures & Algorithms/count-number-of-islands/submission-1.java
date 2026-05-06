class Solution {
    public int numIslands(char[][] grid) {
        
        //Do a dfs anytime we find a 1
        //We mark all as 0 with a dfs increment count as we have found land
        int counts = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    counts++;
                    dfs(grid, i, j);
                }
            }
        }

        return counts;
    }

    //Do a dfs and mark found land items as '0'
    public void dfs(char[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length ||
        grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';
        
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);

    }
}
