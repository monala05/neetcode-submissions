class Solution {
    HashMap<String, Integer> dp = new HashMap<>();
    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
    }

    public int dfs(int i, boolean buying, int[] prices){
        if(i >= prices.length){
            return 0;
        }

        String key = i + "-" + buying;
        if(dp.containsKey(key)){
            return dp.get(key);
        }

        //holding current cost
        int holding = dfs(i +  1, buying, prices);
        if(buying){
            int buy = dfs(i+1, false, prices) - prices[i];
            dp.put(key, Math.max(buy, holding));
        }else{
            int sell = dfs(i + 2, true, prices) + prices[i];
            dp.put(key, Math.max(sell, holding));
        }

        return dp.get(key);
    }

}
