class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];

        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }



        return brute(m -1, n -1, memo);
    }

    public int brute(int i, int j, int[][] memo){
        if(i == 0 || j == 0){
            return 1;
        }

        if(i < 0 || j < 0){
            return 0;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        memo[i][j] = brute(i - 1, j, memo) + brute(i, j -1, memo);
        return memo[i][j];
    }
}
