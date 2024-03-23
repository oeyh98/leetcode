# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
        def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        # 둘 중 하나의 리스트가 끝에 도달하면, 나머지 리스트를 반환
        
            if not list1:
                return list2
            if not list2:
                return list1

            # list1의 값이 더 작거나 같은 경우
            if list1.val <= list2.val:
                # list1의 다음 노드를 list1과 list2의 다음 노드 중 작은 값과 재귀적으로 병합
                list1.next = self.mergeTwoLists(list1.next, list2)
                return list1
            else:
                # list2의 다음 노드를 list1과 list2 중 작은 값과 재귀적으로 병합
                list2.next = self.mergeTwoLists(list1, list2.next)
                return list2
