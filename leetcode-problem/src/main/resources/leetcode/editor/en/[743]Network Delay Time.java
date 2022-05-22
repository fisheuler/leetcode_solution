//You are given a network of n nodes, labeled from 1 to n. You are also given ti
//mes, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui 
//is the source node, vi is the target node, and wi is the time it takes for a sig
//nal to travel from source to target. 
//
// We will send a signal from a given node k. Return the time it takes for all t
//he n nodes to receive the signal. If it is impossible for all the n nodes to rec
//eive the signal, return -1. 
//
// 
// Example 1: 
//
// 
//Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: times = [[1,2,1]], n = 2, k = 1
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: times = [[1,2,1]], n = 2, k = 2
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// All the pairs (ui, vi) are unique. (i.e., no multiple edges.) 
// 
// Related Topics Depth-First Search Breadth-First Search Graph Heap (Priority Q
//ueue) Shortest Path 
// 👍 4096 👎 277


import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Integer,List<Pair<Integer,Integer>>> adj = new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        for(int[] time : times){
            int source = time[0];
            int des = time[1];
            int travelTime = time[2];

            adj.putIfAbsent(source,new ArrayList<>());
            adj.get(source).add(new Pair(travelTime,dest));
        }

        int[] signalReceviedAt = new int[n+1];
        Arrays.fill(signalReceviedAt,Integer.MAX_VALUE);
        dijkstra(signalReceviedAt,k,n);

        int answer= Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            answer = Math.max(answer,signalReceviedAt[i]);
        }
        return answer == Integer.MAX_VALUE?-1:answer;
    }

    private void dijkstra(int[] signalReceivedAt,int source ,int n){
        Queue<Pair<Integer,Integer>> pq = new PriorityQueue<Pair<Integer,Integer>>(
                Comparator.comparing(Pair::getKey));
        pq.add(new Pair(0,source));

        signalReceivedAt[source] = 0;

        while(!pq.isEmpty()){
            Pair<Integer,Integer> topPair = pq.remove();

            int currNode = topPair.getValue();
            int currNodeTime = topPair.getKey();

            if(currNodeTime > signalReceivedAt[currNode]){
                continue;
            }

            if(!adj.containsKey(currNode)){
                continue;
            }

            for(Pair<Integer,Integer> edge: adj.get(currNode)){
                int time = edge.getKey();
                int neighborNode = edge.getValue();

                if(signalReceivedAt[neighborNode]>currNodeTime + time){
                    signalReceivedAt[neighborNode] = currNodeTime + time;
                    pq.add(new Pair(signalReceivedAt[neighborNode],neighborNode));
                }
            }
        }
    }






























}
//leetcode submit region end(Prohibit modification and deletion)
