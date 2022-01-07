//There is a car with capacity empty seats. The vehicle only drives east (i.e., 
//it cannot turn around and drive west). 
//
// You are given the integer capacity and an array trips where trip[i] = [numPas
//sengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers 
//and the locations to pick them up and drop them off are fromi and toi respective
//ly. The locations are given as the number of kilometers due east from the car's 
//initial location. 
//
// Return true if it is possible to pick up and drop off all passengers for all 
//the given trips, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: trips = [[2,1,5],[3,3,7]], capacity = 4
//Output: false
// 
//
// Example 2: 
//
// 
//Input: trips = [[2,1,5],[3,3,7]], capacity = 5
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= trips.length <= 1000 
// trips[i].length == 3 
// 1 <= numPassengersi <= 100 
// 0 <= fromi < toi <= 1000 
// 1 <= capacity <= 105 
// 
// Related Topics Array Sorting Heap (Priority Queue) Simulation Prefix Sum 
// 👍 2188 👎 54


import java.util.TreeMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer,Integer> stopNum = new TreeMap<>();

        for(int[] t: trips){
            int num1=stopNum.getOrDefault(t[1],0)+t[0];
            stopNum.put(t[1],num1);

            int num2=stopNum.getOrDefault(t[2],0)-t[0];
            stopNum.put(t[2],num2);
        }

        for(int value: stopNum.values()){
            capacity = capacity - value;
            if(capacity<0){
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
