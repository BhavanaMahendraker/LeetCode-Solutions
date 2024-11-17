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
        ListNode p = list1, q = list2, res = new ListNode(), dummy = res;
        
        while(p != null || q!= null){
            int pVal = p == null ? Integer.MAX_VALUE : p.val;
            int qVal = q == null ? Integer.MAX_VALUE : q.val;
            
            if(pVal <= qVal){
                res.next = p;
                p = p.next;
            } else{
                res.next = q;
                q = q.next;
            }
            res = res.next;
        }
        
        return dummy.next;
        
    }
}

/*
1,2,4,5,6,7,8
p


1,3,4
q

pVal = pVal == null ? 0 : p.val
qVal = qVal == null ? 0 : q.val

pVal <=qVal
    res.next() = p
    p = p.next()
else
    res.next= q
    q = q.next
*/