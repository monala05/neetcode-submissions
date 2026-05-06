class Solution {
    public List<Integer> partitionLabels(String s) {
        int start = 0; 
        int end = 0;
        HashMap<Character, Integer> hashy = new HashMap();
        List<Integer> ans = new ArrayList();

        //get a map of the end index of strings
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            hashy.put(a, i);
        }

        for(int i = 0; i < s.length(); i++){
            int curEnd = hashy.get(s.charAt(i));
            end = Math.max(end, curEnd);

            if(i == end){
                ans.add(end - start + 1);
                start = end + 1;
            }
        }


        return ans;
    }
}
