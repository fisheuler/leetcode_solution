package solution;//There are n servers numbered from 0 to n - 1 connected by undirected server-to
//-server connections forming a network where connections[i] = [ai, bi] represents
// a connection between servers ai and bi. Any server can reach other servers dire
//ctly or indirectly through the network. 
//
// A critical connection is a connection that, if removed, will make some server
//s unable to reach some other server. 
//
// Return all critical connections in the network in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
//Output: [[1,3]]
//Explanation: [[3,1]] is also accepted.
// 
//
// Example 2: 
//
// 
//Input: n = 2, connections = [[0,1]]
//Output: [[0,1]]
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 105 
// n - 1 <= connections.length <= 105 
// 0 <= ai, bi <= n - 1 
// ai != bi 
// There are no repeated connections. 
// 
// Related Topics Depth-First Search Graph Biconnected Component 
// 👍 3421 👎 138


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1192_2 {


    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(List<Integer> oneConnection :connections) {
            graph[oneConnection.get(0)].add(oneConnection.get(1));
            graph[oneConnection.get(1)].add(oneConnection.get(0));
        }
        HashSet<List<Integer>> connectionsSet = new HashSet<>(connections);
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        dfs(graph, 0, 0, rank, connectionsSet);
        return new ArrayList<>(connectionsSet);
    }

    int dfs(List<Integer>[] graph, int node, int depth, int[] rank, HashSet<List<Integer>> connectionsSet){
        if (rank[node]>=0){
            return rank[node]; // already visited node. return its rank
        }
        rank[node] = depth;
        int minDepthFound = depth; // can be Integer.MAX_VALUE also.
        for(Integer neighbor: graph[node]){
            if (rank[neighbor] == depth-1){ // ignore parent
                continue;
            }
            int minDepth = dfs(graph, neighbor, depth+1, rank, connectionsSet);
            minDepthFound = Math.min(minDepthFound, minDepth);
            if (minDepth <= depth){
                // to avoid the sorting just try to remove both combinations. of (x,y) and (y,x)
                connectionsSet.remove(Arrays.asList(node, neighbor));
                connectionsSet.remove(Arrays.asList(neighbor, node));
            }
        }
        return minDepthFound;
    }


    public static void main(String[] args){
        Solution_1192 solution = new Solution_1192();

        int n = 4;

        List<Integer> firstEdge = new ArrayList<Integer>(Arrays.asList(0,1));
        List<Integer> secondEdge = new ArrayList<Integer>(Arrays.asList(1,2));
        List<Integer> thirdEdge = new ArrayList<Integer>(Arrays.asList(2,0));
        List<Integer> fourthEdge = new ArrayList<Integer>(Arrays.asList(1,3));

        List<List<Integer>> edge = new ArrayList<List<Integer>>(Arrays.asList(firstEdge,
                secondEdge,thirdEdge,fourthEdge));


        String s= "lee(t(c)o)de)";
        System.out.println(solution.criticalConnections(n,edge));
    }




}
//leetcode submit region end(Prohibit modification and deletion)
