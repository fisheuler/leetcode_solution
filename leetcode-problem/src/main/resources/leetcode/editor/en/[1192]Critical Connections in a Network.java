//There are n servers numbered from 0 to n - 1 connected by undirected server-to
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
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
//        Arrays.fill(graph,new ArrayList<>());

        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }

        for(List<Integer> connect:connections){
            graph[connect.get(0)].add(connect.get(1));
            graph[connect.get(1)].add(connect.get(0));
        }

        HashSet<List<Integer>> connectionSet = new HashSet<>(connections);

        int[] rank = new int[n];

        Arrays.fill(rank,-2);

        dfs(graph,0,0,rank,connectionSet);

        return new ArrayList<>(connectionSet);
    }

    int dfs(List<Integer>[] graph,int node,int depth,int[] rank,HashSet<List<Integer>> connectionsSet){

        if(rank[node]>=0){
            return rank[node];
        }

        rank[node] = depth;

        int minDepth = depth;

        for(Integer neighbor: graph[node]){
            if(rank[neighbor] == depth-1){
                continue;
            }
            int nDepth = dfs(graph,neighbor,depth+1,rank,connectionsSet);
            if(nDepth <=depth){
                connectionsSet.remove(Arrays.asList(node,neighbor));
                connectionsSet.remove(Arrays.asList(neighbor,node));
            }
            minDepth = Math.min(minDepth,nDepth);

        }
        return minDepth;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
