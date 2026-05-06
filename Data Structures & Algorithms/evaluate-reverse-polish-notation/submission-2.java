class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack();

        for(int i = 0; i < tokens.length; i++){
            String c = tokens[i];
            if(c.equals("+")){
                int cur = s.pop() + s.pop();
                s.push(cur);
            }else if(c.equals("-")){
                int a = s.pop();
                int b = s.pop();
                 int cur = b - a;
                s.push(cur);
            }else if(c.equals("*")){
                int cur = s.pop() * s.pop();
                s.push(cur);
            }else if(c.equals("/")){
                int a = s.pop();
                int b = s.pop();
                 int cur = b / a;
                s.push(cur);
            }else{
                s.push(Integer.parseInt(c));
            }
        }

        return s.pop();
    }
}
