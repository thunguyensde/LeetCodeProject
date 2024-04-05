import common.ListNode;

public class MergeTwoSortedList {
    /*
    21.

    requirement:
    You are given the heads of two sorted linked lists list1 and list2
    Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
    Return the head of the merged linked list.

    test case:
    1 - 2 - 3
    4 - 5 - 6 - 7

    merge(1,4)
    merge(2,4)
    merge(3,4)
    merge(null,4)
    merge(null,5)
    merge(null,6)
    merge(null,7)
    merge(null,null)
    */

    public ListNode mergeTwoSortedList(ListNode list1, ListNode list2) {
        ListNode i = new ListNode();
        ListNode ans = i;
        while (list1 != null || list2 != null) {
            if (list1 == null || (list2 != null && list1.val > list2.val)) {
                i.next = list2;
                list2 = list2.next;
            } else {
                i.next = list1;
                list1 = list1.next;
            }
            i = i.next;
        }
        return ans.next;
    }

    public ListNode mergeTwoSortedListRecursively(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            list2.next = mergeTwoSortedListRecursively(list1, list2.next);
            return list2;
        }

        if (list2 == null) {
            list1.next = mergeTwoSortedListRecursively(list1.next, list2);
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoSortedListRecursively(list1.next, list2);
            return list1;
        }

        list2.next = mergeTwoSortedListRecursively(list1, list2.next);
        return list2;
    }

    public ListNode enhancedMergeTwoSortedListRecursively(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = enhancedMergeTwoSortedListRecursively(list1.next, list2);
            return list1;
        }

        list2.next = enhancedMergeTwoSortedListRecursively(list1, list2.next);
        return list2;
    }
}
