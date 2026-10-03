class Solution {
    int ans = 0;    
    public int maxAreaOfIsland(int[][] grid) {
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    ans = Math.max(ans, helper(grid, i, j));
                }
            }
        }

        return ans;
    }

    public int helper(int[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0){
            return 0;
        }

        grid[row][col] = 0;

        int left = helper(grid, row -1, col);
        int up = helper(grid, row, col + 1);
        int right = helper(grid, row + 1, col);
        int down = helper(grid, row, col - 1);

        return 1 + left + up + right + down;
    }
}
