package solution;//You are given an array of integers stones where stones[i] is the weight of the
// ith stone. 
//
// We are playing a game with the stones. On each turn, we choose the heaviest t
//wo stones and smash them together. Suppose the heaviest two stones have weights 
//x and y with x <= y. The result of this smash is: 
//
// 
// If x == y, both stones are destroyed, and 
// If x != y, the stone of weight x is destroyed, and the stone of weight y has 
//new weight y - x. 
// 
//
// At the end of the game, there is at most one stone left. 
//
// Return the smallest possible weight of the left stone. If there are no stones
// left, return 0. 
//
// 
// Example 1: 
//
// 
//Input: stones = [2,7,4,1,8,1]
//Output: 1
//Explanation: 
//We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
//we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
//we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
//we combine 1 and 1 to get 0 so the array converts to [1] then that's the value
// of the last stone.
// 
//
// Example 2: 
//
// 
//Input: stones = [1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 1000 
// 
// Related Topics Array Heap (Priority Queue) 
// 👍 2578 👎 54


import java.util.Comparator;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priority = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for(int stone:stones){
            priority.add(stone);
        }

        while(priority.size()>=2){
            int first = priority.poll();
            int second = priority.poll();
            if(first != second){
                int diff = first>second?first-second:second-first;
                priority.add(diff);
            }
        }
        if(priority.size()==1){
            return priority.poll();
        }
        return 0;
    }

    public static void main(String[] args){
        Solution_1046 solution = new Solution_1046();
        int[] stones = new int[]{2,7,4,1,8,1};
        System.out.println(solution.lastStoneWeight(stones));
    }


}
//leetcode submit region end(Prohibit modification and deletion)
