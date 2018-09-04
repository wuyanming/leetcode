package HighFrequence.Summary;

public class RemoveLinkedListElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode next = removeElements(head.next, val);
        if(head.val == val) return next;
        head.next = next;
        return head;
    }
}
