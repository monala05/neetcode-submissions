class Solution {
    public String longestPalindrome(String s) {
        //So the idea is to treat a character as the middle and check if its
        //its a palindrome from middle out.
        //The brute force method would be to check every 
        String ans = "";
        int maxLength = -1;

        for(int i = 0; i < s.length(); i++){
            //check for palindrome using odd center
                int l = i;
                int r = i;
                while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r  - l > maxLength){
                    maxLength = r - l;
                    ans = s.substring(l, r + 1);
                }
                    l--;
                    r++;
                }
            //check for palindrome using even center
                l = i;
                r = i + 1;
                while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                    if(r  - l > maxLength){
                        maxLength = r - l;
                        ans = s.substring(l, r + 1);
                    }
                    l--;
                    r++;
                }
        }


        return ans;
    }
}
