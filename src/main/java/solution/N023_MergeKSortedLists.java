package solution;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

import common.ListNode;

import java.util.PriorityQueue;

/**
 * 题目大意:
 * 合并K个有序的链表，合并后依然有序
 */
public class N023_MergeKSortedLists {

    //n*n时间复杂度超时
//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode start = new ListNode(0);
//        ListNode current = start;
//        int index = 0;
//
//        while (true){
//            ListNode tempMinNode = null;
//
//            //找出链表的最小节点
//            for (int i = 0; i < lists.length; i++) {
//                if(lists[i] != null){
//                    if(tempMinNode == null) {
//                        tempMinNode = lists[i];
//                        index = i;
//                    } else{
//                        if(tempMinNode.val > lists[i].val) {
//                            tempMinNode = lists[i];
//                            index = i;
//                        }
//                    }
//                }
//            }
//
//            if(tempMinNode == null) break;
//
//            current.next = tempMinNode;
//            lists[index] = lists[index].next; //使用后的节点向后移动
//            current = current.next;
//        }
//
//
//        return start.next;
//    }


    //遍历加入优先级队列
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null){
                queue.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }

        ListNode start = new ListNode(0);
        ListNode current = start;

        while (!queue.isEmpty()){
            current.next = new ListNode(queue.poll());
            current = current.next;
        }
        return start.next;
    }

    //方法3 链表俩俩归并 参考归并排序


}
