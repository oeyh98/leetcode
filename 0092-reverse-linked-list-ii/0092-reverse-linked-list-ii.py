# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if not head or left == right:
            return head

        # 더미 노드를 생성하고, 이를 연결 리스트의 시작 부분에 위치시킵니다.
        dummy = ListNode(0)
        dummy.next = head
        prev = dummy

        # 'prev'를 'm' 번째 노드의 바로 이전 노드까지 이동시킵니다.
        for _ in range(left - 1):
            prev = prev.next
        
        # 역순으로 만들 부분의 시작점을 'start'로 지정합니다.
        # 'then'은 'start' 다음 노드를 가리키며, 이 노드부터 역순으로 만들기 시작합니다.
        start = prev.next
        then = start.next

        # 'left'과 'right' 사이의 노드들을 역순으로 만듭니다.
        for _ in range(right - left):
            start.next = then.next
            then.next = prev.next
            prev.next = then
            then = start.next
        
        return dummy.next
            