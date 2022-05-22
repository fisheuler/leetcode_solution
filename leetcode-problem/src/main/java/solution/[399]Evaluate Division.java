package solution;//You are given an array of variable pairs equations and an array of real number
//s values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai 
/// Bi = values[i]. Each Ai or Bi is a string that represents a single variable. 
//
// You are also given some queries, where queries[j] = [Cj, Dj] represents the j
//th query where you must find the answer for Cj / Dj = ?. 
//
// Return the answers to all queries. If a single answer cannot be determined, r
//eturn -1.0. 
//
// Note: The input is always valid. You may assume that evaluating the queries w
//ill not result in division by zero and that there is no contradiction. 
//
// 
// Example 1: 
//
// 
//Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a",
//"c"],["b","a"],["a","e"],["a","a"],["x","x"]]
//Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
//Explanation: 
//Given: a / b = 2.0, b / c = 3.0
//queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
// 
//
// Example 2: 
//
// 
//Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], 
//queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//Output: [3.75000,0.40000,5.00000,0.20000]
// 
//
// Example 3: 
//
// 
//Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"]
//,["a","c"],["x","y"]]
//Output: [0.50000,2.00000,-1.00000,-1.00000]
// 
//
// 
// Constraints: 
//
// 
// 1 <= equations.length <= 20 
// equations[i].length == 2 
// 1 <= Ai.length, Bi.length <= 5 
// values.length == equations.length 
// 0.0 < values[i] <= 20.0 
// 1 <= queries.length <= 20 
// queries[i].length == 2 
// 1 <= Cj.length, Dj.length <= 5 
// Ai, Bi, Cj, Dj consist of lower case English letters and digits. 
// 
// Related Topics Array Depth-First Search Breadth-First Search Union Find Graph
// Shortest Path 
// 👍 5210 👎 447


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>> graph = buildGraph(equations,values);

        double[] result = new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            result[i] = getPathWeight(queries.get(i).get(0),queries.get(i).get(1),new HashSet<>(),graph);
        }
        return result;
    }

    private double getPathWeight(String start, String end, Set<String> visited, Map<String,Map<String,Double>> graph){
        if(!graph.containsKey(start)){
            return -1.0;
        }

        if(graph.get(start).containsKey(end)){
            return graph.get(start).get(end);
        }
        visited.add(start);

        for(Map.Entry<String,Double> nei: graph.get(start).entrySet()){
            if(!visited.contains(nei.getKey())){
                double productWeight = getPathWeight(nei.getKey(),end,visited,graph);
                if(productWeight != -1.0){
                    return nei.getValue()*productWeight;
                }
            }
        }
        return -1.0;
    }


    private Map<String,Map<String,Double>> buildGraph(List<List<String>> equations,double[] values){
        Map<String,Map<String,Double>> graph = new HashMap<>();

        String u,v;

        for(int i=0;i<equations.size();i++){
            u = equations.get(i).get(0);
            v = equations.get(i).get(1);
            graph.putIfAbsent(u,new HashMap<>());
            graph.get(u).put(v,values[i]);
            graph.putIfAbsent(v,new HashMap<>());
            graph.get(v).put(u,1/values[i]);
        }
        return graph;
    }






    public static void main(String[] args){
        Solution_399 solution = new Solution_399();

        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a","b"));
        equations.add(Arrays.asList("b","c"));
        equations.add(Arrays.asList("bc","cd"));


        double[] values = {1.5,2.5,5.0};


        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a","c"));
        queries.add(Arrays.asList("c","b"));
        queries.add(Arrays.asList("bc","cd"));
        queries.add(Arrays.asList("cd","bc"));


        for(double d: solution.calcEquation(equations,values,queries)){
            System.out.println(d);
        }
    }




}
//leetcode submit region end(Prohibit modification and deletion)
