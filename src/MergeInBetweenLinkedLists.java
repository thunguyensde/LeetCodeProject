import common.ListNode;

public class MergeInBetweenLinkedLists {
    /*
    1669.

    */

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // 0.   1.   2.   3.   4.   5
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        //        -> 8 -> 9      -> 6
        // a = 2
        // b = 4
        // 8 -> 9

        // - node 2 = (a - 1)th node
        // - node 8: already there
        // - node 9 = end of list2
        // - node 6 = (b + 1)th node
        // 2 -> 8

        ListNode i = getIthNode(list1, a - 1);
        ListNode j = list2;
        ListNode k = list2;
        while (k.next != null) {
            k = k.next;
        }
        ListNode l = getIthNode(list1, b + 1);

        i.next = j;
        k.next = l;

        return list1;
    }

    private ListNode getIthNode(ListNode head, int ith) {
        int i = 0;
        while (head != null && i < ith) {
            head = head.next;
            i++;
        }
        return head;
    }
}
