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

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {


    }

















}
//leetcode submit region end(Prohibit modification and deletion)
