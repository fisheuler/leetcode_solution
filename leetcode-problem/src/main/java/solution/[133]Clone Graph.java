package solution;//Given a reference of a node in a connected undirected graph.
//
// Return a deep copy (clone) of the graph. 
//
// Each node in the graph contains a value (int) and a list (List[Node]) of its 
//neighbors. 
//
// 
//class Node {
//    public int val;
//    public List<Node> neighbors;
//}
// 
//
// 
//
// Test case format: 
//
// For simplicity, each node's value is the same as the node's index (1-indexed)
//. For example, the first node with val == 1, the second node with val == 2, and 
//so on. The graph is represented in the test case using an adjacency list. 
//
// An adjacency list is a collection of unordered lists used to represent a fini
//te graph. Each list describes the set of neighbors of a node in the graph. 
//
// The given node will always be the first node with val = 1. You must return th
//e copy of the given node as a reference to the cloned graph. 
//
// 
// Example 1: 
//
// 
//Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
//Output: [[2,4],[1,3],[2,4],[1,3]]
//Explanation: There are 4 nodes in the graph.
//1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
//2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
//3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
//4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
// 
//
// Example 2: 
//
// 
//Input: adjList = [[]]
//Output: [[]]
//Explanation: Note that the input contains one empty list. The graph consists o
//f only one node with val = 1 and it does not have any neighbors.
// 
//
// Example 3: 
//
// 
//Input: adjList = []
//Output: []
//Explanation: This an empty graph, it does not have any nodes.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the graph is in the range [0, 100]. 
// 1 <= Node.val <= 100 
// Node.val is unique for each node. 
// There are no repeated edges and no self-loops in the graph. 
// The Graph is connected and all nodes can be visited starting from the given n
//ode. 
// 
// Related Topics Hash Table Depth-First Search Breadth-First Search Graph 
// 👍 4936 👎 2256


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_133 {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    Map<Integer,List<Integer>> copyNodeValueMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        Map<Integer,Boolean> visitedMap = new HashMap<>();
        dfs(node,visitedMap);

        Map<Integer,Node> copyNodeMap = new HashMap<>();

        for(Integer val: copyNodeValueMap.keySet()){
            Node copy = new Node(val);
            copyNodeMap.put(val,copy);
        }
        for(Map.Entry<Integer,List<Integer>> entry: copyNodeValueMap.entrySet()){
            Integer val = entry.getKey();
            List<Integer> neighborList = entry.getValue();
            List<Node> copyNodeNeighborList = new ArrayList();
            for(Integer neighbor: neighborList){
                copyNodeNeighborList.add(copyNodeMap.get(neighbor));
            }
            copyNodeMap.get(val).neighbors = copyNodeNeighborList;
        }


        if(copyNodeMap.values()!=null && copyNodeMap.values().size()>0){
            copyNodeMap.values().iterator().next();
        }
        return null;
    }

    public void dfs(Node node,Map<Integer,Boolean> visitedMap){
        if(node==null){
            return;
        }
        if(!visitedMap.containsKey(node.val)){
            visitedMap.put(node.val,true);

            List<Integer> neighborList = new ArrayList<>();
            for(Node neighbour:node.neighbors){
                dfs(neighbour,visitedMap);
                neighborList.add(neighbour.val);
            }
            System.out.println("node val:" + node.val +" node List:" + Arrays.toString(neighborList.toArray()));
            copyNodeValueMap.put(node.val,neighborList);
        }
    }

    public static void main(String[] args){
        Solution_133 solution = new Solution_133();

        Node node1 = new Solution_133.Node(1);
        Node node2 = new Solution_133.Node(2);
        Node node3 = new Solution_133.Node(3);
        Node node4 = new Solution_133.Node(4);

        solution.addEdge(node1,node2);

        solution.addEdge(node2,node3);

        solution.addEdge(node3,node4);

        solution.addEdge(node4,node1);

        System.out.println("four node copy :" );
        Node cloneNode = solution.cloneGraph(node1);
        solution.dfs(cloneNode,new HashMap<>());


        System.out.println("one node copy :" );
        Node oneNode = new Node(1);

        Node oneNodeCopy = solution.cloneGraph(oneNode);

        solution.dfs(oneNodeCopy,new HashMap<>());

        System.out.println("null node copy :" );

        Node nodeNull = null;

        Node nodeNullCopy = solution.cloneGraph(nodeNull);

        solution.dfs(nodeNullCopy,new HashMap<>());

        Collection<Node> node = null;

        System.out.println("collecion null iterator test :"+ node.iterator().next() );;
    }

    public void addEdge(Node node1,Node node2){
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

    }



}
//leetcode submit region end(Prohibit modification and deletion)
