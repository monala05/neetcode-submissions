class Solution {
    public int countSubstrings(String s) {
        //Same as last question, only difference is this one doesnt care for longest. This one just wants you to find palindromes
        //Same principles apply, tricky part here will be to not count palindromes twice
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            //check for even length palindromes
            int l = i;
            int r = i;

            while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                count++;
                l--;
                r++;
            }

            //check for odd length
            l = i;
            r = i+1;
            
            while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                count++;
                l--;
                r++;
            }
        }

        return count;
    }
}
