# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        result = ListNode(-1)  # 더미 노드로 시작하는 결과 리스트
        cursor = result  # 현재 위치를 가리키는 커서
        
        while list1 and list2:
            if list1.val < list2.val:
                cursor.next = list1  # list1의 현재 노드를 결과 리스트에 연결
                list1 = list1.next  # list1을 다음 노드로 이동
            else:
                cursor.next = list2  # list2의 현재 노드를 결과 리스트에 연결
                list2 = list2.next  # list2를 다음 노드로 이동
            cursor = cursor.next  # 커서를 다음 위치로 이동 (중요)
            
        # 남아 있는 노드들을 결과 리스트에 연결
        cursor.next = list1 if list1 is not None else list2
        
        return result.next  # 더미 노드를 제외한 결과 리스트 반환
        