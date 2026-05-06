class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    ans = Math.max(helper(grid, row, col), ans);
                }
            }
        }

        return ans;
    }

    public int helper(int[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0){
            return 0;
        }

        grid[row][col] = 0;

        return 1 + helper(grid, row + 1, col) 
        + helper(grid, row, col + 1) 
        + helper(grid, row - 1, col) 
        + helper(grid, row, col -1);
    }
}
