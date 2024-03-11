import common.ListNode;

public class ReverseLinkedList {
    /*
    206.

    requirement:
    - Given the head of a singly linked list, reverse the list, and return the reversed list.

    test case:
    1 -> 2 -> 3 -> 4 -> 5 -> null
    null <- 1 <- 2 <- 3 <- 4 <- 5

    solution:
    - iterative
    - recursive

    dry run:

    complexity:
    - time: O(n)
    - space: O(n)
    */

    public ListNode reverseLinkedList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public ListNode recursivelyReverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode ans = recursivelyReverseLinkedList(next);
        next.next = head;
        return ans;
    }

    public ListNode simplifiedRecursiveReverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ans = simplifiedRecursiveReverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return ans;
    }
}
