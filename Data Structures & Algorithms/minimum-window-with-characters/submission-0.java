class Solution {
    public String minWindow(String s, String t) {
        //Size of smallest window
        int min = Integer.MAX_VALUE;
        //Count of T characters
        HashMap<Character, Integer> needed = new HashMap();
        //counr of characters in current window
        HashMap<Character, Integer> windowCounts = new HashMap();

        //Count of completed characters in window
        int have = 0;

        String ans = "";
        int l = 0;

        for(int i = 0; i < t.length(); i++){
            needed.put(t.charAt(i), needed.getOrDefault(t.charAt(i), 0) + 1);
        }
        //count of original characters
        int counts = needed.size();

        for(int r = 0; r < s.length(); r++){
            char cur = s.charAt(r);

            //increase window
            windowCounts.put(cur, windowCounts.getOrDefault(cur, 0) + 1);

            //increase the counts if in T and the count is equal to total count in T
            if(needed.containsKey(cur) && windowCounts.get(cur).equals(needed.get(cur))){
                have++;
            }

            //Try and decrease window
            while(have == counts){
                
                // try and decrese our answer, only if current window is smaller than min
                if((r - l + 1) < min){
                    min = r - l + 1;
                    ans = s.substring(l, r +1);
                }
                //check if current left window character is part characters in T and reduce window
                char left = s.charAt(l);
                windowCounts.put(left, windowCounts.get(left) - 1);
                if(needed.containsKey(left) && windowCounts.get(left) < needed.get(left)){
                    have--;
                }
                l++;
            }
        }
        return ans;
    }
}
