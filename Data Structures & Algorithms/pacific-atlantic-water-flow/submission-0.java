class Solution {
    //two seperate arrays to track if a cell can reach either ocean
    boolean[][] pac;
    boolean[][] atl;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int rows = heights.length;
        int cols = heights[0].length;
        
        pac = new boolean[rows][cols];
        atl = new boolean[rows][cols];


        //We are simply trying to find if we can reach a boundary
        
        //check first row
        for(int i = 0; i < heights.length; i++){
            dfs(heights, pac, i, 0, heights[i][0]);
            dfs(heights, atl, i, cols - 1, heights[i][cols - 1]);

        }

        //Check first col
        for(int j = 0; j < heights[0].length; j++){
              dfs(heights, pac, 0, j, heights[0][j]);
              dfs(heights, atl, rows - 1, j, heights[rows - 1][j]);
        }

        //Check boolean arrays for a cell that is true for both
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(pac[i][j] == true && atl[i][j] == true){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(i);
                    cur.add(j);
                    ans.add(cur);
                }
            }
        }

        return ans;

    }

    public void dfs(int[][] heights, boolean[][] visited, int row, int col, int last){
        if(row < 0 || col < 0 || row >= heights.length || col >= heights[0].length){
            return;
        }
        
        if(visited[row][col] || heights[row][col] < last){
            return;
        }

        visited[row][col] = true;

        dfs(heights, visited, row + 1, col,heights[row][col]);
        dfs(heights, visited, row - 1, col, heights[row][col]);
        dfs(heights, visited, row, col -1,heights[row][col]);
        dfs(heights, visited, row, col + 1,heights[row][col]);
    }



}
