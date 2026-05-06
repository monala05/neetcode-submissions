class Solution {
    public int numDecodings(String s) {
         if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int ans = 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;


        for(int i = 1; i < s.length(); i++){
                if(s.charAt(i)!= '0'){
                    dp[i] += dp[i-1];
                }

                int converted = Integer.parseInt(s.substring(i - 1, i + 1));

                if(converted >= 10 && converted <= 26){
                    if(i > 1){
                        dp[i] += dp[i-2];
                    }else{
                        dp[i] += 1;
                    }
                }
            }

        return dp[dp.length - 1];

    }
}
