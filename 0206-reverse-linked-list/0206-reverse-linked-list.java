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
    public ListNode reverseList(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
        
        
//         ListNode curr = head, prev = null;
        
//         while(curr != null){
//             ListNode next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }
        
//         return prev;
    }
}

/*
// recursive:
1,2,3,4,5,null
        c r
        
base case: 
    c.next == null -> return c

newHead = recuriveCallReturnedValue
c.next.next = c
c.next = null
return newHead


// non-recursive
1,2,3,4,5
        p c 
          n
p = null

n = c.next
c.next = p
p = c
c = next




*/