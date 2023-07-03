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
    /*
    public ListNode mergeKLists(ListNode[] lists) {
        // TC = O(NlogK), SC = O(logK)
        // Here, N = total num of nodes, K = total num of lists
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> {
            if(a.val < b.val) return -1;
            if(a.val == b.val) return 0;
            return 1; // a.val > b.val
        });
        ListNode res = new ListNode();
        ListNode dummy = res;
        
        // TC: O(logK) --> K = num of lists
        // SC: O(K)
        for(ListNode list: lists){ 
            if(list != null)
                pq.add(list);
        }
        
        // TC: O(NKlogK) ==> N = total num of nodes
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
    */

    // TC = O(NlogK)
    // Here, N = total num of nodes, K = total num of lists
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        
        int interval = 1;
        while(interval < lists.length){
            for(int i=0; i + interval <lists.length; i+= 2 * interval){
                lists[i] = mergeTwoLists(lists[i], lists[i+interval]);
                System.out.println(i);
            }
            interval *= 2;
        }
        
        return lists[0];
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy, l1 = list1, l2 = list2;
        
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                head.next = l1;
                l1 = l1.next == null ? null : l1.next;
            } else if(l2.val < l1.val){
                head.next = l2;
                l2 = l2.next == null ? null : l2.next;
            }
            head = head.next;
        }
        
        if(l1 != null)
            head.next = l1;
        if(l2 != null)
            head.next = l2;
        
        return dummy.next;
    }
        
        
}