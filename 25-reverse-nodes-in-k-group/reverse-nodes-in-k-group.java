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
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null)
            return head;
        int size = k; // Reverse every k nodes

        ListNode left = head;
        ListNode res = null; // Final head
        ListNode prevL = null; // Tail of previous reversed group
        ListNode right;
        while (true) {
            // Find the kth node of the current group
            right = left;
            for (int i = 0; i < size - 1; i++) {
                if (right == null) {
                    break;
                }
                right = right.next;
            }
            // Complete group of k nodes exists
            if (right != null) {
                // Save first node of the next group
                ListNode nextL = right.next;
                // Reverse exactly k nodes
                reverse(left, size);
                // Connect previous group to current reversed group
                if (prevL != null)
                    prevL.next = right;
                // left is now the tail of the current reversed group
                prevL = left;
                // right is the new head of the first reversed group
                if (res == null)
                    res = right;
                // Move to the next group
                left = nextL;
            } else {
                // Fewer than k nodes remain, so leave them unchanged
                if (prevL != null)
                    prevL.next = left;
                // Handles a list smaller than k
                if (res == null)
                    res = left;
                break;
            }
        }
        return res;
    }
    // Reverse exactly 'size' nodes
    private void reverse(ListNode left, int size) {
        ListNode curr = left;
        ListNode prev = null;
        while (size-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}