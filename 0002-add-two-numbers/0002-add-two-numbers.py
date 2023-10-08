# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        carry = 0
        head = ListNode(-1)
        dummy = ListNode()
        dummy.next = head
        
        while l1 or l2:
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            
            currVal = val1 + val2 + carry
            carry = currVal / 10
            currVal = currVal % 10
            
            newNode = ListNode(currVal)
            head.next = newNode
            head = head.next
            
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
            
        if carry:
            head.next = ListNode(carry)
            
        return dummy.next.next
            
            
            
        