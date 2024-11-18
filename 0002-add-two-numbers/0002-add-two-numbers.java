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
        int carry = 0;
        ListNode head = new ListNode(-1), currNode = head;
        
        while(l1 != null || l2 != null){
            int l1Val = l1 == null ? 0 : l1.val; // 9
            int l2Val = l2 == null ? 0 : l2.val; // 9
            
            int currVal = l1Val + l2Val + carry; // 18
            currNode.next = new ListNode(currVal % 10); // 8
            carry = currVal / 10; // 1
            
            currNode = currNode.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        
        if(carry != 0){
            currNode.next = new ListNode(carry);
        }
        
        return head.next;
    }
}

/*
[2,4,3]
[5,6,7,9,9,9]
[7,0,1,0,0,0,1]

l1 or 0 + l2 or 0 + carry
store mod in currNode 10 -> 0
carry = 1
next....

if carry != 0
    store carry

*/