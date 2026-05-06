class Solution {

    public int change(int amount, int[] coins) {
        //Memo array, we do all the coins and all the values up will amount
        //We account for 0
        int[][] memo = new int[coins.length + 1][amount + 1];
        Arrays.sort(coins);

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(coins, 0 , amount, memo);
    }

    public int dfs(int[] coins, int i, int rem, int[][] memo){
        if(rem == 0){return 1;}
        if(i >= coins.length){return 0;}
        //This is the memo step, check if coin denomination has an answer
        if(memo[i][rem] != -1){return memo[i][rem];}

        int res = 0;

        if(rem >= coins[i]){
            res = dfs(coins, i + 1, rem, memo);
            res += dfs(coins, i, rem - coins[i], memo);
        }
        
        memo[i][rem] = res;
        return res;
    }
}
