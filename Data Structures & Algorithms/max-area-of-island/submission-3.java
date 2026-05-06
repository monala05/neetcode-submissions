class Solution {
    int ans = 0;
    int curArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        //Approach is to do the same dfs we did last time.
        //We go through the grid and every time we find an island we count the area.
        //So we would have to keep a gloabal max that we increment if the current max increases

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    curArea = 0;
                    dfs(grid, i, j);
                    ans = Math.max(ans, curArea);
                }
            }
        }
        return ans;
    }


    //Two ways to do this, we can keep a visited array so we dont manipulate the data
    //To keep space at O(1) i am going to change the input array
    public void dfs(int grid[][], int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
        || grid[row][col] == 0){
            return;
        }

        curArea++;
        grid[row][col] = 0;

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
