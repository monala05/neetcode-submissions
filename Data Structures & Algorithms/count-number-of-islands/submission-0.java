class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    ans++;
                    helper(grid, row, col);
                }
            }
        }

        return ans;
    }

    public void helper(char[][] grid, int row, int col) {
        // Check if out of bounds or water ('0') is encountered
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        // Mark the current land as visited
        grid[row][col] = '0';

        // Explore the four directions
        helper(grid, row + 1, col); // down
        helper(grid, row - 1, col); // up
        helper(grid, row, col + 1); // right
        helper(grid, row, col - 1); // left
    }
}