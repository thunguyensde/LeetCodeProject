import common.ListNode;

import java.util.List;

public class IntersectionOfTwoLinkedLists {
    /*
    160.

    requirement:
    Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
    If the two linked lists have no intersection at all, return null.
    a + b

    */

    public ListNode findIntersection(ListNode headA, ListNode headB) {
        ListNode i = headA;
        ListNode j = headB;

        while (i != j) {
            i = i == null ? headB : i.next;
            j = j == null ? headA : j.next;
        }
        return i;
    }
}
