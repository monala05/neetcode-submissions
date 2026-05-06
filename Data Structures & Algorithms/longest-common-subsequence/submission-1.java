class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for(int i = 0; i < memo.length; i++){
            for(int j = 0; j < memo[0].length; j++){
                memo[i][j] = -1;
            }
        }
        return brute(text1 , text2, text1.length() - 1, text2.length() - 1, memo);
    }

    public int brute(String a, String b, int i, int j, int[][] memo){
        if(i < 0 || j < 0){
            return 0;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        if(a.charAt(i) == b.charAt(j)){
            memo[i][j] = 1 + brute(a, b, i -1, j - 1, memo);
            return memo[i][j];
        }

        memo [i][j] = Math.max(brute(a, b, i - 1, j, memo), brute(a, b, i, j -1, memo));
        return memo[i][j];
    }
}
