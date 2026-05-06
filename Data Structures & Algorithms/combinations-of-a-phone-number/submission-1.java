class Solution {
    String[] alph = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
    List<String> ans = new ArrayList();


    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList();
        }
        bt(digits, 0, new StringBuilder());
        return ans;
    }


    public void bt(String digit, int index, StringBuilder cur){

        if(digit.length() == cur.length()){
            ans.add(cur.toString());
            return;
        }



        int key = digit.charAt(index) - '0';
        String possibleValues = alph[key];

        for(int i = 0; i < possibleValues.length(); i++){
            Character curDig = possibleValues.charAt(i);
            cur.append(curDig);
            
            bt(digit, index + 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
