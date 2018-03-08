package solution;

import common.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class N082_RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode priv = dummy;
        ListNode currnt = head;

        int dupliCount = 1;
        while (currnt != null){
            if(currnt.next != null ){
                if(currnt.next.val == currnt.val){
                    dupliCount++;
                }else{
                    if(dupliCount >= 2){
                        priv.next = currnt.next;
                        dupliCount = 1;
                    }else {
                        priv = priv.next;
                    }
                }

            }else{
                if(dupliCount >= 2) priv.next = null;
            }
            currnt = currnt.next;
        }

        return dummy.next;
    }
}
