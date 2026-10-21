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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) return head;   // Edge case: if list is empty or k is 0

        // 1. Calculate length and find the last node
        ListNode last = head;
        int n = 1;
        while (last.next != null) {
            last = last.next;       // last = 5    
            n++;                    // n = 5
        }

        // 2. Adjust k if it is larger than list length
        k = k % n;
        if (k == 0) return head;

        // 3. Find the node at position (n - k)
        ListNode temp = head;
        for (int i = 1; i < n - k; i++) {
            temp = temp.next;
        }

        // 4. Perform the rotation
        last.next = head;     // Connect last node to current head
        head = temp.next;     // Update head to the start of the new segment
        temp.next = null;     // Break the original connection

        return head;

    }
}