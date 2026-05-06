class Solution {
    public boolean checkValidString(String s) {
        int leftMax = 0;
        int rightMax = 0;

        for(int i =0; i < s.length(); i++){
            char cur = s.charAt(i);

            if(cur == '('){
                leftMax++;
                rightMax++;
            }else if(cur == ')'){
                leftMax--;
                rightMax--;
            }else{
                leftMax--;
                rightMax++;
            }

            if(rightMax < 0){
                return false;
            }

            leftMax = Math.max(leftMax, 0);
        }
        return leftMax == 0;
    }
}
