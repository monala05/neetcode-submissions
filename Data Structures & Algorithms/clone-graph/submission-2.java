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
    HashMap<Node, Node> hashy = new HashMap<>();
    public Node cloneGraph(Node node) {
    if(node == null) return null;
       return dfs(node); 
    }

    public Node dfs(Node node){
        if(hashy.containsKey(node)){
            return hashy.get(node);
        }

        Node clone = new Node(node.val, new ArrayList<>());
        hashy.put(node, clone);
        List<Node> cur = node.neighbors;

        for(int i = 0; i < cur.size(); i++){
            Node nei = cur.get(i);
            clone.neighbors.add(dfs(nei));
        }

        return clone;
    }
}