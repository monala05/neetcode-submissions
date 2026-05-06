class Solution {
    List<String> cur = new ArrayList();
    List<List<String>> ans = new ArrayList();

    public List<List<String>> partition(String s) {

        bt(s,0);
        return ans;    
    }

    public void bt(String s, int i){
        if(i >= s.length()){
            ans.add(new ArrayList(cur));
            return;
        }

        for(int j = i; j < s.length(); j++){
            if(isPalindrome(s, i, j)){
                cur.add(s.substring(i, j+1));
                bt(s, j+1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int i, int j){
        
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
