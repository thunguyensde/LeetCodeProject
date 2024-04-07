import common.ListNode;

import java.util.List;

public class RemoveDuplicatesFromSortedList {
    /*
    83.

    requirement:
    Given the head of a sorted linked list,
    delete all duplicates such that each element appears only once. Return the linked list sorted as well.

    test case:
    _  2  2 -> 2
    _  2  2  3 -> 2 3
    _  1  2  2 -> 1 2
    _  1  2  2  3 -> 1 2 3
    */

    public ListNode removeDuplicatesFromSortedList(ListNode head) {
        ListNode dummy = new ListNode(-101, head);
        ListNode i = dummy.next;
        while (i != null) {
            if (i.next != null && i.next.val == i.val) {
                i.next = i.next.next;
            } else {
                i = i.next;
            }
        }
        return dummy.next;
    }
}
