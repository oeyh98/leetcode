
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode temp = head;
        List<Integer> arr = new ArrayList<>();
        
        for(ListNode list:lists){
            while(list != null){
                arr.add(list.val);
                list = list.next;
            }
        }
        
        Collections.sort(arr);
        for(int i : arr){
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return head.next;
    }
}