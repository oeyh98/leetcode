# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        result = cursor = ListNode()
        
        carry = 0
        while l1 or l2 or carry:
            temp = carry
            
            if l1:
                temp += l1.val
                l1 = l1.next
            
            if l2:
                temp += l2.val
                l2 = l2.next
                
            carry, val = divmod(temp, 10)
            cursor.next = ListNode(val)
            cursor = cursor.next
            
        return result.next