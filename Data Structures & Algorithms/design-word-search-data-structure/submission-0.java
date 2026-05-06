class WordDictionary {
    class Node{
        char val;
        List<Node> children;
        boolean endOfWord;

        public Node(){
            this.val = '0';
            this.children = new ArrayList();
            endOfWord = false;
        }

        public Node(char val){
            this.val = val;
            this.children = new ArrayList();
            endOfWord = false;
        }
    }

    Node root = null;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node temp = root;

        for(int i = 0; i < word.length(); i++){
            char cur = word.charAt(i);
            Node next = null;

            for(Node node: temp.children){
                if(cur == node.val){
                    next = node;
                    break;
                }
            }
            if(next == null){
                next = new Node(cur);
                temp.children.add(next);
            }

            temp = next;
        }
        temp.endOfWord = true;
    }

    public boolean search(String word) {

        return searchHelper(word, root, 0);
    }

    public boolean searchHelper(String word, Node node, int index){
        if(index == word.length()){
            return node.endOfWord;
        }
        char cur = word.charAt(index);

        if (cur == '.') {
            // If the current character is '.', we check all children recursively
            for (Node child : node.children) {
                if (searchHelper(word, child, index + 1)) {
                    return true; // If any child path matches, return true immediately
                }
            }
            return false; // If no children match, return false
        } else {
            for (Node child : node.children) {
                if (child.val == cur) {
                    return searchHelper(word, child, index + 1); // Add return statement here
                }
            }
            return false;
        }

    }
}
