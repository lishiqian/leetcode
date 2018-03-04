package common;

/**
 * 单链表节点
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode creat(int[] arr){
        if(arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            cur.next = node;
            cur = node;
        }

        return head.next;
    }
}
