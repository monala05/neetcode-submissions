class Solution {
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];

        for(int i =0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                dfs(i, j, -1, matrix);
            }
        }

        int res = -1;

        for(int i =0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }

    public int dfs(int row, int col, int last, int[][] matrix){
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length
        || last >= matrix[row][col]){
            return 0;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int res = 1;
        res = Math.max(res, 1 + dfs(row + 1, col, matrix[row][col], matrix));
        res = Math.max(res, 1 + dfs(row - 1, col, matrix[row][col], matrix));
        res = Math.max(res, 1 + dfs(row, col + 1, matrix[row][col], matrix));
        res = Math.max(res, 1 + dfs(row, col - 1, matrix[row][col], matrix));

        dp[row][col] = res;
        return res;
    }
}
