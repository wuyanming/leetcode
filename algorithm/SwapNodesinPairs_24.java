package HighFrequence.Summary;

public class SwapNodesinPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if ((head == null) || (head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}
