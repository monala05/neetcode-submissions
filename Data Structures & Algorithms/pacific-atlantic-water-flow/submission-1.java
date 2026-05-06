class Solution {
    private boolean[][] atl;
    private boolean[][] pac;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList();
        int m = heights.length;
        int n = heights[0].length;

        atl = new boolean[heights.length][heights[0].length];
        pac = new boolean[heights.length][heights[0].length];;


        // DFS from Pacific Ocean (top and left edges)
        for (int i = 0; i < m; i++) {
            dfs(heights, pac, i, 0, heights[i][0]); // left edge
            dfs(heights, atl, i, n - 1, heights[i][n - 1]); // right edge
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pac, 0, j, heights[0][j]); // top edge
            dfs(heights, atl, m - 1, j, heights[m - 1][j]); // bottom edge
        }


        //Check both arrays for a match

        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                if(atl[i][j] && pac[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }


        return ans;
    }

    public void dfs(int[][] grid, boolean[][] visited, int row, int col, int last){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
            return;
        }

        if(grid[row][col] < last || visited[row][col] == true){
            return;
        }

        visited[row][col] = true;

        dfs(grid, visited, row + 1, col , grid[row][col]);
        dfs(grid, visited, row -1, col, grid[row][col]);
        dfs(grid, visited, row, col + 1, grid[row][col]);
        dfs(grid, visited, row, col - 1, grid[row][col]);

    }
}
