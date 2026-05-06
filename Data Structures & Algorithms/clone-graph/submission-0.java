/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashSet<Node> visited = new HashSet();
    HashMap<Node, Node> hash = new HashMap();

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        return dfs(node);
    }

    public Node dfs(Node node){
        //If already visited return the new node?
        if(visited.contains(node)){
            return hash.get(node);
        }

        Node newNode = new Node(node.val);
        hash.put(node, newNode);
        visited.add(node);

        for(int i = 0; i < node.neighbors.size(); i++){
                newNode.neighbors.add(dfs(node.neighbors.get(i)));
        }

        return newNode;

    }
}