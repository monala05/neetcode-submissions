class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1){
            return s.length();
        }

        int maxLength = 0;
        HashSet<Character> hash = new HashSet();

        int l = 0, r = 1;
        int curLen = 1;
        hash.add(s.charAt(0));

        while(r < s.length()){
            char cur = s.charAt(r);
            if(!hash.contains(cur)){
                curLen++;
                hash.add(cur);
                r++;
                maxLength = Math.max(curLen, maxLength);
            }else{
                char prev = s.charAt(l);
                hash.remove(prev);
                curLen--;
                l++;
            }
        }


        return maxLength;
    }
}
