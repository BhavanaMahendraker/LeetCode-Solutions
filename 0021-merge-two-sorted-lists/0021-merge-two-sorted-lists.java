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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(), dummy = head;
        ListNode p = list1, q = list2;
        
        while(p != null || q != null){
            int val1 = p == null ? Integer.MAX_VALUE : p.val;
            int val2 = q == null ? Integer.MAX_VALUE : q.val;
            
            if(val1 < val2){
                head.next = p;
                p = p == null ? null : p.next;
            } else{
                head.next = q;
                q = q == null ? null : q.next;
            }
            head = head.next;
        }
        head.next = null;
        
        return dummy.next;
    }
}