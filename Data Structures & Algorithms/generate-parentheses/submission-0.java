class Solution {
    List<String> ans;

    public List<String> generateParenthesis(int n) {
        //how can get get multiple strings
        //backtracking
        StringBuilder s = new StringBuilder();
        this.ans = new ArrayList();
        
        bt(s, 0, 0, n);
       
        return ans;
    }

    public void bt(StringBuilder s, int l, int r, int n){
        if(l == n && r == n){
            ans.add(s.toString());
        }

        if(l < n){
            s.append('(');
            bt(s, l + 1, r, n);
            s.deleteCharAt(s.length() - 1);
        }
        if(r < l){
            s.append(')');
            bt(s, l, r+1, n);
            s.deleteCharAt(s.length() -1);
        }
    }
}
