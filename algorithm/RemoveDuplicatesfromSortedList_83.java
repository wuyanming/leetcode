package HighFrequence.Summary;

public class RemoveDuplicatesfromSortedList_83 {
    //Approach 1: Straight-Forward Approach
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
    //Complexity Analysis
    //Time complexity : O(n)O(n). Because each node in the list is checked exactly once to determine if it is a duplicate or not,
    //the total run time is O(n)O(n), where nn is the number of nodes in the list.
    //
    //Space complexity : O(1)O(1). No additional space is used.
}
