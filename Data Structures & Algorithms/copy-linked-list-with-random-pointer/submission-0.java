/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hashy = new HashMap();
        hashy.put(null, null);

        Node temp = head;
        while(temp != null){
            Node cur = new Node(temp.val);
            hashy.put(temp, cur);
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            Node cur = hashy.get(temp);
            cur.next = hashy.get(temp.next);
            cur.random = hashy.get(temp.random);

            temp = temp.next;

        }

        return hashy.get(head);
    }
}
