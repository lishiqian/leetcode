package solution;

import org.junit.Test;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 // capacity  );
 *
 *        cache.put(1, 1);
 *        cache.put(2, 2);
 *        cache.get(1);       // returns 1
 *        cache.put(3, 3);    // evicts key 2
 *        cache.get(2);       // returns -1 (not found)
 *        cache.put(4, 4);    // evicts key 1
 *        cache.get(1);       // returns -1 (not found)
 *        cache.get(3);       // returns 3
 *        cache.get(4);       // returns 4
 */

/**
 * 题目大意：
 * 设计一个简单版的最近使用缓存模型。缓存空间有容量限制，时间复杂度要求是O(1)。
 * 其中“最近使用”是指最近被访问过(被cache.get调用过）。
 * https://blog.csdn.net/karen0310/article/details/75039604
 */
public class N146_LRUCache {
    public class LRUCache {
        public class Node{
            public int key;
            public int value;
            public Node pre;
            public Node next;

            public Node(int key,int value){
                this.key = key;
                this.value = value;
            }
        }

        private int capacity;
        private int size;
        private Node head;
        private Node tail; //尾指针 删除最后一个节点时候用到
        private HashMap<Integer,Node> map = new HashMap<Integer, Node>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            head = new Node(0,0);
            tail = head;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                Node node = map.get(key);
                moveToHead(node);
                return node.value;
            }else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(!map.containsKey(key)){ //如果没有这个缓存 新建一个节点加入链表头部;
                Node node = new Node(key,value);
                node.pre = head;
                if(head.next != null){
                    head.next.pre = node;
                    node.next = head.next;
                }
                head.next = node;
                map.put(key,node); //加入map 方便O(1)时间内查询这个节点
                size++;

                if(tail == head){
                    tail = node;
                }

                if(size > capacity){
                    removeLastNode();
                }
            }else{//如果存在这个缓存 更改缓存值，提升到链表头部
                Node node = map.get(key);
                node.value = value;
                moveToHead(node);
            }
        }

        //删除最久未使用节点
        private void removeLastNode() {
            int key = tail.key;
            tail = tail.pre;
            tail.next = null;
            map.remove(key);
            size--;
        }

        //讲这个节点提升到链表头部
        private void moveToHead(Node node){
            if(size == 1) return;
            if(head.next == node) return;

            if(tail == node){
                tail = tail.pre;
                tail.next = null;
            }else{
                node.next.pre = node.pre;
                node.pre.next = node.next;
            }

            //将节点插入头节点
            node.pre = head;
            if(head.next != null){
                head.next.pre = node;
                node.next = head.next;
            }
            head.next = node;
        }

        public void print(){
            System.out.println("************************");
            Node cur = head.next;
            while (cur != null){
                System.out.printf("* key = %d,value = %d\n",cur.key,cur.value);
                cur = cur.next;
            }
            System.out.println("************************");
        }
    }

    @Test
    public void test(){
        LRUCache cache = new LRUCache( 2);
        cache.put(1, 1);
        cache.print();
        cache.put(2, 2);
        cache.print();
        cache.get(1);
        cache.print();
        cache.put(3, 3);
        cache.print();
        cache.get(2);
        cache.print();
        cache.put(4, 4);
        cache.print();
        cache.get(1);
        cache.print();
        cache.get(3);
        cache.print();
        cache.get(4);
        cache.print();
    }

}
