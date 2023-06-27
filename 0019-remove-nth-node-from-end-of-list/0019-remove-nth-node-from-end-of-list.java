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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k = 1;
        ListNode dummy = new ListNode(), p = dummy, q = dummy;
        dummy.next = head;
        while(k <= n+1){
            p = p.next;
            k++;
        }
        
        while(p != null){
            p = p.next;
            q = q.next;
        }
        
        q.next = q.next.next;
        
        return dummy.next;
    }
}