//You are given a string s, and an array of pairs of indices in the string pairs
// where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string. 
//
// You can swap the characters at any pair of indices in the given pairs any num
//ber of times. 
//
// Return the lexicographically smallest string that s can be changed to after u
//sing the swaps. 
//
// 
// Example 1: 
//
// 
//Input: s = "dcab", pairs = [[0,3],[1,2]]
//Output: "bacd"
//Explaination: 
//Swap s[0] and s[3], s = "bcad"
//Swap s[1] and s[2], s = "bacd"
// 
//
// Example 2: 
//
// 
//Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
//Output: "abcd"
//Explaination: 
//Swap s[0] and s[3], s = "bcad"
//Swap s[0] and s[2], s = "acbd"
//Swap s[1] and s[2], s = "abcd" 
//
// Example 3: 
//
// 
//Input: s = "cba", pairs = [[0,1],[1,2]]
//Output: "abc"
//Explaination: 
//Swap s[0] and s[1], s = "bca"
//Swap s[1] and s[2], s = "bac"
//Swap s[0] and s[1], s = "abc"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10^5 
// 0 <= pairs.length <= 10^5 
// 0 <= pairs[i][0], pairs[i][1] < s.length 
// s only contains lower case English letters. 
// 
// Related Topics Hash Table String Depth-First Search Breadth-First Search Unio
//n Find 
// 👍 1738 👎 53


import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.ArrayList;
import java.util.Collections;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    static int N = 100001;

    boolean[] visited = new boolean[N];
    List<Integer>[] adj = new ArrayList[N];

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        for(int i=0;i<s.length();i++){
            adj[i] = new ArrayList<>();
        }

        for(List<Integer> edge: pairs){
            int source = edge.get(0);
            int destination = edge.get(1);
            adj[source].add(destination);
            adj[destination].add(source);
        }

        char[] answer = new char[s.length()];

        for(int vertex=0;vertex<s.length();vertex++){
            if(!visited[vertex]){
                List<Character> characterList = new ArrayList<>();
                List<Integer> indices = new ArrayList<>();
                DFS(s,vertex,characterList,indices);
                Collections.sort(characterList);
                Collections.sort(indices);

                for(int index =0;index<characterList.size();index++){
                    answer[indices.get(index)] = characterList.get(index);
                }
            }
        }

        return new String(answer);

    }


    public static void DFS(String s,int vertex,List<Character> characterList,
                           List<Integer> indices){

        if(visited[vertex]==true){
            return;
        }
        characterList.add(s.charAt(vertex));
        indices.add(vertex);

        visited[vertex] = true;

        for(int adjacent: adj[vertex]){
            if(!visited[adjacent]){
                DFS(s,adjacent,characterList,indices,visited,adj);
            }
        }

    }



}
//leetcode submit region end(Prohibit modification and deletion)
