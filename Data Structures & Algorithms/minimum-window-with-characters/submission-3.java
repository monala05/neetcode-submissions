class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tCounts = new HashMap();
        HashMap<Character, Integer> window = new HashMap();
        int need = 0;
        int min = Integer.MAX_VALUE;
        String ans = "";
        for(int i = 0; i < t.length(); i++){
            char cur = t.charAt(i);
            tCounts.put(cur, tCounts.getOrDefault(cur, 0) + 1);
        }
        int have = tCounts.size();
        int l = 0;

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            window.put(cur, window.getOrDefault(cur, 0) + 1);
            if(tCounts.containsKey(cur) && tCounts.get(cur).equals(window.get(cur))){
                need++;
            }
            while(need == have){
                // check min size
                if((i - l + 1) < min){
                    min = i - l + 1;
                    ans = s.substring(l, i + 1);
                }
                char left = s.charAt(l);
                window.put(left, window.get(left) - 1);
                if(tCounts.containsKey(left) && window.get(left) < tCounts.get(left)){
                    need--;
                }
                l++;
            }
        }
        return ans;
    }
}
