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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cur = 1;
        int l1Sum = 0;
        while(l1 != null){
            l1Sum += l1.val * cur;
            cur *= 10;
            l1 = l1.next;
        }

        cur = 1;
        int l2Sum = 0;
        while(l2 != null){
            l2Sum += l2.val * cur;
            cur *= 10;
            l2 = l2.next;
        }


        int ans = l1Sum + l2Sum;
        ListNode dummy = new ListNode(0);
        ListNode back = dummy;

        while(ans > 0){
            back.next = new ListNode(ans % 10);
            ans = ans/ 10;

            back = back.next;

        }
        if(dummy.next == null){
            return new ListNode(0);
        }

        return dummy.next;
    }
}
