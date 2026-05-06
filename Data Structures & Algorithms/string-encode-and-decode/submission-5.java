class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < strs.size(); i++){
            int cur = strs.get(i).length();

            sb.append(cur);
            sb.append('#');
            sb.append(strs.get(i));
        }
        
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList();
        System.out.println(str);
        int i = 0;
        while(i < str.length()){
            StringBuilder sb = new StringBuilder();

            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }  
            
            System.out.println(j);
            int size = Integer.valueOf(str.substring(i , j ));
            
            //#2we
            System.out.println(size);
            i = j + 1 + size;
            sb.append(str.substring(j + 1, i));

            ans.add(sb.toString());
        }
        return ans;
    }
}
