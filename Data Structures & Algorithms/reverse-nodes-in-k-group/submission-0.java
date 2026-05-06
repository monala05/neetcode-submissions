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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        ListNode prevTail = dummy;

        while(true){
            //check if we can reverse the current section
            int count = 0;
            ListNode check = current;
            while(check != null && count < k){
                count++;
                check = check.next;
            }

            if(count < k){
                break;
            }

            ListNode prev = null;
            ListNode tempCurrent = current;
            for(int i = 0; i < k; i++){
                ListNode nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }

            prevTail.next = prev;
            tempCurrent.next = current;
            prevTail = tempCurrent;

        }

        return dummy.next;
    }
}
