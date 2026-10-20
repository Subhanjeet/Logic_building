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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
    // dummy node jo head se phele rahega
    ListNode dummy = new ListNode();
    dummy.next = head;
    
    ListNode leftPre = dummy;
    ListNode current = head;

    for(int i=0; i<left-1; i++){
        leftPre = leftPre.next;
        current = current.next;
    }

    ListNode subListHead = current;

    ListNode preNode = null;
    for(int i=0; i<=right-left; i++){
        ListNode nextNode = current.next;
        current.next = preNode;
        preNode = current;
        current = nextNode;
    }

    //join the pieces
    leftPre.next = preNode;
    subListHead.next = current;

    return dummy.next;
    }
}