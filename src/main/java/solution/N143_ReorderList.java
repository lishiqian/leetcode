package solution;

import common.ListNode;
import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 *  reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 *  You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *  Example 1:
 *
 *  Given 1->2->3->4, reorder it to 1->4->2->3.
 *  Example 2:
 *
 *  Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class N143_ReorderList {
    public void reorderList(ListNode head) {
        if(head == null) return;

        ListNode cur = head.next;
        ArrayList<ListNode> arr = new ArrayList<ListNode>();

        while (cur != null){
           arr.add(cur);
           cur = cur.next;
        }

        cur = head;
        for (int i = 0,j = arr.size() - 1; i <= j; ) {
            cur.next = arr.get(j--);
            cur = cur.next;

            if(i <= j){
                cur.next = arr.get(i++);
                cur = cur.next;
            }

        }
        cur.next = null;
    }

    @Test
    public void test(){
        ListNode listNode = ListNode.stringToListNode("[1,2,3,4]");
        reorderList(listNode);
    }
}
