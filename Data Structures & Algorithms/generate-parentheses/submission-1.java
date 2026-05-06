class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        StringBuilder s = new StringBuilder();
        this.ans = new ArrayList();
        helper(s, n, 0, 0);

        return ans;
    }

    public void helper(StringBuilder s, int n, int l, int r){
        //exit case
        if(l + r == n * 2){
            ans.add(s.toString());
        }

        //generate left handed parantheses while we have left sided paran to add. Then backtrack when its full
        if(l < n){
            //add paren
            s.append('(');
            //recurse to add next paren
            helper(s, n, l + 1, r);
            //backtrack
            s.deleteCharAt(s.length() -1);
        }
        //we can only add left paren if we have less rights then lefts
        if(r < l){
            // add left paren
            s.append(')');
            //recurse while increasing l parens
            helper(s, n, l, r+1);
            //backtrack
            s.deleteCharAt(s.length() -1);
        }
    }
}
