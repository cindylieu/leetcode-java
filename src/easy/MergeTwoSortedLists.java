package easy;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode temp1 = n1;
        temp1.next = new ListNode(2);
        temp1 = temp1.next;
        temp1.next = new ListNode(4);
        temp1 = n2;
        temp1.next = new ListNode(3);
        temp1 = temp1.next;
        temp1.next = new ListNode(4);

        MergeTwoSortedLists m = new MergeTwoSortedLists();
        System.out.println(m.mergeTwoLists(n1, n2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            } else {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }
        }

        if (l1 == null) {
            temp.next = l2;
        } else {
            temp.next = l1;
        }

        return head.next;
    }
}
