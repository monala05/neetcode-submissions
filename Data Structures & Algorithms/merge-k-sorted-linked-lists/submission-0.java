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
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                heap.offer(lists[i]);
            }
        }

        while(!heap.isEmpty()){
            ListNode cur = heap.poll();
            head.next = cur;
            head = head.next;

            if(cur.next != null){
                heap.offer(cur.next);
            }


        }

        return dummy.next;
    }
}
