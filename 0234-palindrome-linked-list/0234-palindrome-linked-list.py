# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        dq = collections.deque()
        
        if not head:
            return True
        
        while head:
            dq.append(head.val)
            head = head.next
            
        while len(dq) > 1:
            if dq.popleft() != dq.pop():
                return False
            
        return True