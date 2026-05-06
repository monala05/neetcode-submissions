class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder norm =  new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                norm.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        
        String normalized = norm.toString();
        System.out.println(normalized);
        int l = 0, r = normalized.length() -1;

        while(l < r){
            char left = normalized.charAt(l);
            char right = normalized.charAt(r);

            if(left != right){
                return false;
            }

            l++;
            r--;
        }

        return true;
        
    }
}
