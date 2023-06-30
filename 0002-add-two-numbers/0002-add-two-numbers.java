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
        ListNode p = l1, q = l2, head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;
        
        while(p != null || q != null){
            int val1 = p == null ? 0 : p.val;
            int val2 = q == null ? 0 : q.val;
            
            int curr_val = (val1 + val2 + carry);
            carry = curr_val / 10;
            
            ListNode node = new ListNode(curr_val % 10, null);
            cur.next = node;
            
            p = p == null ? null : p.next;
            q = q == null ? null : q.next;
            cur = cur.next;
        }
        
        if(carry != 0){
            ListNode node = new ListNode(carry, null);
            cur.next = node;
            cur = cur.next;
        }
                
        return head.next;
    }
}