//Find all valid combinations of k numbers that sum up to n such that the follow
//ing conditions are true: 
//
// 
// Only numbers 1 through 9 are used. 
// Each number is used at most once. 
// 
//
// Return a list of all possible valid combinations. The list must not contain t
//he same combination twice, and the combinations may be returned in any order. 
//
// 
// Example 1: 
//
// 
//Input: k = 3, n = 7
//Output: [[1,2,4]]
//Explanation:
//1 + 2 + 4 = 7
//There are no other valid combinations. 
//
// Example 2: 
//
// 
//Input: k = 3, n = 9
//Output: [[1,2,6],[1,3,5],[2,3,4]]
//Explanation:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//There are no other valid combinations.
// 
//
// Example 3: 
//
// 
//Input: k = 4, n = 1
//Output: []
//Explanation: There are no valid combinations.
//Using 4 different numbers in the range [1,9], the smallest sum we can get is 1
//+2+3+4 = 10 and since 10 > 1, there are no valid combination.
// 
//
// 
// Constraints: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
// Related Topics Array Backtracking 
// 👍 2820 👎 74


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static Map<Integer,List<List<Integer>>> map = new HashMap<>();
    {

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        
    }

    public static loadMap(){
        Map<Integer,List<List<Integer>>> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1;i<10;i++){
            Map<Integer,List<List<Integer>>> temp = new ArrayList<>();

            for(Map.Entry<Integer,List<List<Integer>>> en)
            temp.addAll(list);
            for(List<Integer> item:list){
                temp.add(item.add(i));
            }
            List<Integer> item = new ArrayList<>();
            item.add(i);
            temp.add(item);
            list = temp;
        }

    }

    public static dfs(int i,List<Integer> currentList,int sum){
        if(i>9){
            return;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
