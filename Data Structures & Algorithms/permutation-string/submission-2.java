class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        
        
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        for(int i = 0; i < s1.length(); i++){
            s1Arr[s1.charAt(i) -'a']++;
            s2Arr[s2.charAt(i) - 'a']++;
        }
        int l = 0;
        int matchCount = 0;
        for(int j = 0; j < 26; j++){
            if(s1Arr[j] == s2Arr[j]){
                matchCount++;
            }
        }
        if(matchCount == 26){
            return true;
        }


        for(int i = s1.length(); i < s2.length(); i++){
            s2Arr[s2.charAt(l) - 'a']--;
            s2Arr[s2.charAt(i) - 'a']++;
            l++;

            matchCount = 0;
            for(int j = 0; j < 26; j++){
                if(s1Arr[j] == s2Arr[j]){
                    matchCount++;
                }
            }

            if(matchCount == 26)return true;
        }

        return false;
    }
}
