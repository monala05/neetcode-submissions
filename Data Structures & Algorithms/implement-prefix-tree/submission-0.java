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

    HashMap<Character, Node> hash;
    Node root;

    public PrefixTree() {
        this.hash = new HashMap<Character, Node>();
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

    public boolean startsWith(String prefix) {
        Node temp = root;

        for(int i = 0; i < prefix.length(); i++){
            char cur = prefix.charAt(i);

            Node child = null;
            for(Node node: temp.children){
                if(node.val == cur){
                    child = node;
                }
            }
            if(child == null){return false;}
            
            temp = child;
        }

        return true;
    }
}
