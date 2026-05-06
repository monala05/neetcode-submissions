class Solution {
    String s1;
    String s2;
    String s3;
    Boolean dp[][];

    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

        dp = new Boolean[s1.length() + 1][s2.length()+1];
        return helper(0,0,0);
    }

    public boolean helper(int i, int j, int k){
        if(k == s3.length()){
            return (i == s1.length()) && j == s2.length();
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        boolean res = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            res = helper( i+1, j, k+1);
        }
        
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            res = helper( i, j+1, k+1);
        }

        dp[i][j] = res;
        return res;
    }
}
