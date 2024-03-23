
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        stack = []
        current = head
        
        # 리스트를 순회하면서 모든 노드를 스택에 삽입
        while current:
            stack.append(current)
            current = current.next
            
        # 스택이 비어 있으면, 빈 리스트를 반환
        if not stack:
            return None
        
        # 스택에서 노드를 꺼내어 연결 리스트를 재구성
        new_head = stack.pop()
        current = new_head
        while stack:
            current.next = stack.pop()
            current = current.next
        current.next = None  # 마지막 노드의 next를 None으로 설정
        
        return new_head