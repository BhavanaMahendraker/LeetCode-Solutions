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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> {
            if(a.val < b.val) return -1;
            if(a.val == b.val) return 0;
            return 1; // a.val > b.val
        });
        ListNode res = new ListNode();
        ListNode dummy = res;
        
        // TC: O(logK) ==> K = num of lists
        for(ListNode list: lists){ 
            if(list != null)
                pq.add(list);
        }
        
        // TC: O(NlogK) ==> N = total num of nodes
        while(pq.size() != 0){
            ListNode curr = pq.poll();
            res.next = curr;
            res = res.next;
            
            if(curr.next != null){
                pq.add(curr.next);
            }
        }
        
        return dummy.next;
    }
}