class Solution {
    public int characterReplacement(String s, int k) {
        int[] alphs = new int[26];

        int res = 0;
        int l = 0;

        for(int i = 0; i < s.length(); i++){
            alphs[s.charAt(i) - 'A']++;

            int max = 0;
            for(int j = 0; j < 26; j++){
                if(max < alphs[j]){max = alphs[j];}
            }

            if(i - l + 1  - max > k){
                alphs[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, i - l + 1);
        }
        
        return res;
    }
}
