/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        /*
        // Solution 1: TC = O(N), SC = O(N)
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = head;
        
        while(p != null){
            if(set.contains(p)) return true;
            set.add(p);
            p = p.next;
        }
        
        return false;
        */
        
        // Solution 1:  TC = O(N), SC = O(1) 
        
        ListNode dummy = new ListNode(); 
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        
        return false;
    }
}