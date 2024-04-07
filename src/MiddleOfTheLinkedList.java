import common.ListNode;

import java.util.List;

public class MiddleOfTheLinkedList {
    /*
    876.

    requirement:
    Given the head of a singly linked list, return the middle node of the linked list.
    If there are two middle nodes, return the second middle node.

    test case:
    1 2 3 4 5
    1 2 3 4 5 6
    */

    public ListNode middleOfTheLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
