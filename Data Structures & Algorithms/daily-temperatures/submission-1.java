class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int result[] = new int[temperatures.length];
        Stack<int[]> s = new Stack();

        for(int i = 0; i < temperatures.length; i++){
            int t = temperatures[i];

            while(!s.isEmpty() && t > s.peek()[0]){
                int[] pair = s.pop();
                result[pair[1]] = i - pair[1];
            }

            s.push(new int[]{t, i});
        }

        return result;   
    }

    
}
