class Solution {
    class PrefixTree {
    class Node{
        char val;
        List<Node> children;
        boolean endOfWord;
        public Node(){
            this.val = '0';
            this.children = new ArrayList();
            this.endOfWord = false;
        }

        public Node(char val){
            this.val = val;
            this.children = new ArrayList();
            this.endOfWord = false;
        }
    }

    Node root;

    public PrefixTree() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node temp = root;

        for(int i = 0; i < word.length(); i++){
            char cur = word.charAt(i);
            Node child = null;

            for(Node node: temp.children){
                if(node.val == cur){
                    child = node;
                    break;
                }
            }

            if(child == null){
                child = new Node(cur);
                temp.children.add(child);
            }


            temp = child;
        }
        temp.endOfWord = true;
    }

    public boolean search(String word) {
        Node temp = root;

        for(int i = 0; i < word.length(); i++){
            char cur = word.charAt(i);

            Node child = null;
            for(Node node: temp.children){
                if(node.val == cur){
                    child = node;
                }
            }
            if(child == null){return false;}
            
            temp = child;
        }

        return temp.endOfWord;
    }


}
    List<String> ans = new ArrayList();
    boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        PrefixTree tree = new PrefixTree();
        visited = new boolean[board.length][board[0].length];
        for(String word: words){
            tree.insert(word);
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                bt(board, new StringBuilder(), i, j, tree);
            }
        }
        
        return ans;
    }


    public void bt(char[][]board, StringBuilder word, int row, int col, PrefixTree tree){
        if(row < 0 || col < 0 || row >= board.length || 
        col >= board[0].length || visited[row][col] == true){
            return;
        }

        char cur = board[row][col];
        word.append(cur);
        visited[row][col] = true;
        if(tree.search(word.toString())){
            
            if(!ans.contains(word.toString())){ans.add(word.toString());}
        }

        bt(board, word, row + 1, col, tree);
        bt(board, word, row, col + 1, tree);
        bt(board, word, row - 1, col, tree);
        bt(board, word, row, col - 1, tree);

        word.deleteCharAt(word.length() - 1);
        visited[row][col] = false;
    }
}
