class Solution {
    public int largestRectangleArea(int[] heights) {
    
        Stack<Integer> s = new Stack();
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            int cur = heights[i];

            while(!s.isEmpty() && cur < heights[s.peek()]){
                //we need to pop and check 
                int lastHeight = heights[s.pop()];
                int width;
                if(s.isEmpty()){
                    width = i;
                }else{
                    width = i  - s.peek() - 1;
                }
                max =  Math.max(max, lastHeight * width);
            }
            s.push(i);
        }

        while(!s.isEmpty()){
                //we need to pop and check 
                int lastHeight = heights[s.pop()];
                int width;
                if(s.isEmpty()){
                    width = heights.length;
                }else{
                    width = heights.length - 1 - s.peek();
                }
                max =  Math.max(max, lastHeight * width);
        }   

        return max;

    }
}
