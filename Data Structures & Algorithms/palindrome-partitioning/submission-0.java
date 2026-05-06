class Solution {
    
    List<List<String>> ans = new ArrayList();
    public List<List<String>> partition(String s) {
        List<String> cur = new ArrayList();
        bt(s, 0, cur);
        return ans;
    }

    public void bt(String s, int i, List<String> cur){
        if(i >= s.length()){
            ans.add(new ArrayList(cur));
            return;
        }

        for(int j = i; j < s.length(); j++){
            if(isPalindrome(s, i, j)){
                cur.add(s.substring(i, j + 1));
                bt(s,j + 1, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
