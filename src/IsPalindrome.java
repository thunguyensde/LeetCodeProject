import common.ListNode;

import java.util.List;

public class IsPalindrome {
    /*
    234.

    requirement:
    Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

    test case:
    1
    1 -> 2 -> 2 -> 1
    1 -> 2 -> 3 -> 1

    */
    ListNode startingNode;

    public boolean isPalindrome(ListNode head) {
        startingNode = head;
        return isPalindromeHelper(head);
    }

    private boolean isPalindromeHelper(ListNode node) {
        if (node == null) {
            return true;
        }
        if (!isPalindromeHelper(node.next)) {
            return false;
        }
        if (node.val != startingNode.val) {
            return false;
        }
        startingNode = startingNode.next;
        return true;
    }
}
