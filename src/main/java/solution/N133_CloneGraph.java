package solution;

import common.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 *
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 *
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 *
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 *
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 *
 *     1
 *    / \
 *   /   \
 *  0 --- 2
 *       / \
 *       \_/
 */
public class N133_CloneGraph {

//    //BFS复制
//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        if(node == null) return null;
//        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
//        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
//        UndirectedGraphNode graph = new UndirectedGraphNode(node.label);
//        map.put(node,graph);
//        queue.add(node);
//
//        while (!queue.isEmpty()){
//            UndirectedGraphNode curNode = queue.poll();
//            for (UndirectedGraphNode neighbor : curNode.neighbors) {
//                if(!map.containsKey(neighbor)){
//                    UndirectedGraphNode copyNeighborNode = new UndirectedGraphNode(neighbor.label);
//                    map.put(neighbor,copyNeighborNode);
//                    queue.add(neighbor);
//                }
//                map.get(curNode).neighbors.add(map.get(neighbor));
//            }
//        }
//
//        return graph;
//    }

    //DFS 复制
    HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if(node == null) return null;
        if(map.containsKey(node))
            return map.get(node);
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        map.put(node,copyNode);

        for (UndirectedGraphNode var : node.neighbors) {
            copyNode.neighbors.add(cloneGraph(var));
        }

        return copyNode;
    }

}
