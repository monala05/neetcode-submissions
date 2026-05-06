class Solution {
    public boolean isValid(String s) {
        Stack<Character> sta = new Stack();

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);

            //is a left
            if(cur == '{' || cur == '[' || cur == '('){
                sta.push(cur);
            } 

            if(cur == '}' || cur == ')' || cur == ']'){
                if(sta.isEmpty()){
                    return false;
                }

                char top = sta.pop();
                System.out.println("top == " + top + " cur == " + cur);
                if((top == '{' && cur != '}') || (top == '(' && cur != ')') || (top == '[' && cur != ']')){
        
                   return false;
                }
            }
        }

        if(sta.isEmpty() == false){
            return false;
        }

        return true;
    }
}
