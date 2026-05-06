class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return helper(0, wordDict, s, dp);
    }

    public boolean helper(int index,List<String> wordDict, String s, Boolean[] dp){
        //Base case
        if(index == s.length()){
            return true;
        }
        //Return if index already computed
        if(dp[index] != null){
            return dp[index];
        }

        for(String word: wordDict){
            //check if work fits in the string and if it is equal to the subnstring starting at current index
            if(index + word.length() <= s.length() && s.substring(index, index + word.length()).equals(word)){
                //we found a word that fits in the string
                //We now check the rest of the string
                if(helper(index + word.length(), wordDict, s, dp)){
                    dp[index] = true;
                    return true;
                }
            }
        }

        dp[index] = false;
        return false;
    }
}
