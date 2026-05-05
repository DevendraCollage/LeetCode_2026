class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        int length = 0;
        ListNode tail = null;
        ListNode curr = head;

        while (curr != null) {
            tail = curr;
            curr = curr.next;
            length++;
        }

        k = k % length;
        int steps = (length - k) % length;

        if (steps == 0)
            return head;

        ListNode newTail = head;
        for (int i = 0; i < steps - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }
}