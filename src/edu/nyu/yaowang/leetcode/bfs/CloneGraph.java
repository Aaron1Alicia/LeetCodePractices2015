package edu.nyu.yaowang.leetcode.bfs;

import java.util.*;

/**
 * Created by Yao on 2/16/15.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if(node==null) {
            return node;
        }

        Queue<UndirectedGraphNode> queue =
                new LinkedList<UndirectedGraphNode>();
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node.label, newNode);

        queue.add(node);

        while(!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            int n = cur.neighbors.size();

            for(int i=0; i<n; i++) {

                Integer label = cur.neighbors.get(i).label;

                if(!map.containsKey(label)) {
                    UndirectedGraphNode tmp = new UndirectedGraphNode(label);
                    map.put(label, tmp);
                    map.get(cur.label).neighbors.add(tmp);
                    queue.add(cur.neighbors.get(i));

                } else {
                    map.get(cur.label).neighbors.add(map.get(label));
                }

            }



        }

        return newNode;

    }

     class UndirectedGraphNode {
             int label;
             List<UndirectedGraphNode> neighbors;
             UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
         };
}
