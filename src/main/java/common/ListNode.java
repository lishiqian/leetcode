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

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
}
