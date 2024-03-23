class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        current, prev = head, None
        
        
        while current:
            next_temp, current.next = current.next, prev # 위치 변경
            prev, current = current, next_temp # 다음 node setting

            
        return prev
