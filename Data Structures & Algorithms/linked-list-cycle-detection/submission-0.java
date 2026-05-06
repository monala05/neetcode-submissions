/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode>hashy = new HashSet();

        int index = 1;
        while(head != null){
            if(hashy.contains(head)){
                return true;
            }else{
                hashy.add(head);
            }

            head = head.next;
        }

        return false;
    }
}
