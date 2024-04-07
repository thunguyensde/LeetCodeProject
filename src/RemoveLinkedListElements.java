import common.ListNode;

import java.util.List;

public class RemoveLinkedListElements {
    /*
    203.

    requirements:
    Given the head of a linked list and an integer val,
    remove all the nodes of the linked list that has Node.val == val, and return the new head.

    test case:
    _ 2 --> _
    _ 2 1 --> 1
    _ 1 2 --> 1
    _ 1 2 2 3 --> 1 3
    */

    public ListNode removeNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode i = dummy;
        while (i.next != null) {
            if (i.next.val == val) {
                i.next = i.next.next;
            } else {
                i = i.next;
            }
        }
        return dummy.next;
    }
}
