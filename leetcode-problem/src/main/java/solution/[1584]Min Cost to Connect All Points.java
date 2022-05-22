package solution;//You are given an array points representing integer coordinates of some points
//on a 2D-plane, where points[i] = [xi, yi]. 
//
// The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan dist
//ance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value
// of val. 
//
// Return the minimum cost to make all points connected. All points are connecte
//d if there is exactly one simple path between any two points. 
//
// 
// Example 1: 
//
// 
//Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
//Output: 20
//Explanation: 
//
//We can connect the points as shown above to get the minimum cost of 20.
//Notice that there is a unique path between every pair of points.
// 
//
// Example 2: 
//
// 
//Input: points = [[3,12],[-2,5],[-4,1]]
//Output: 18
// 
//
// 
// Constraints: 
//
// 
// 1 <= points.length <= 1000 
// -106 <= xi, yi <= 106 
// All pairs (xi, yi) are distinct. 
// 
// Related Topics Array Union Find Minimum Spanning Tree 
// 👍 1266 👎 46


import java.util.Comparator;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1584 {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        int res = 0;
        int i = 0;
        int connected = 0;

        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        while(connected<n){
            visited[i] = true;

            for(int j=0;j<n;j++){
                if(!visited[j]){
                    pq.add(new int[]{Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]),j});
                }
            }
            while(pq.size()>0 && visited[pq.peek()[1]]){
                pq.poll();
            }
            if(pq.size()<1){
                break;
            }
            int[] pop = pq.poll();

            res += pop[0];
            i = pop[1];
            connected++;
        }

        return res;
    }



    public static void main(String[] args){
        Solution_1584 solution = new Solution_1584();
        int[][] points = new int[][]{
                {0,0},{2,2},{3,10},{5,2},{7,0}
        };

        System.out.println(solution.minCostConnectPoints(points));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
