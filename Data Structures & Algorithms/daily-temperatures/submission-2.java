class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<int[]> s = new Stack<>();
        int[] ans = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            while(!s.isEmpty() && temperatures[i] > s.peek()[1]){
                ans[s.peek()[0]] = i - s.peek()[0];  
                s.pop();
            }

            s.push(new int[]{i, temperatures[i]});
        }

        return ans;
    }
}
