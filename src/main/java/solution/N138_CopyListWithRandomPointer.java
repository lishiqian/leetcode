package solution;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 */

import common.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目大意：
 * 复制有随机指针的链表
 */
public class N138_CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode cur = head;
        RandomListNode copyCur = dummyHead;


        while (cur != null){
            RandomListNode copyNode = new RandomListNode(cur.label);
            copyCur.next = copyNode;
            copyCur = copyCur.next;

            map.put(cur,copyCur);
            cur = cur.next;
        }

        cur = head;
        copyCur = dummyHead.next;

        while (cur != null){
            if(cur.random != null){
                copyCur.random = map.get(cur.random);
            }
            cur = cur.next;
            copyCur = copyCur.next;
        }

        return dummyHead.next;
    }
}
