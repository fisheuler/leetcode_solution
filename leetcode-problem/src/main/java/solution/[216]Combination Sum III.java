package solution;//Find all valid combinations of k numbers that sum up to n such that the follow
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


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_216 {
    static Map<Integer,List<List<Integer>>> map = new HashMap<>();
    {
        loadMap();
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> sumItem = map.get(n);
        if(sumItem==null){
            return new ArrayList<>();
        }
        List<List<Integer>> answer = new ArrayList<>();
        for(List<Integer> item: sumItem){
            if(item.size() == k){
                answer.add(item);
            }
        }
        return answer;
    }

    public static void loadMap(){
        if(map.size()>0){
            return;
        }
        for(int i=1;i<10;i++){
            Map<Integer,List<List<Integer>>> temp = new HashMap<>();

            for(Map.Entry<Integer,List<List<Integer>>> entry: map.entrySet()){
                int sum = entry.getKey();
                List<List<Integer>> sumList = entry.getValue();
                List<List<Integer>> newSumList = new ArrayList<>();
                for(List<Integer> item: sumList){
                    List<Integer> itemList = new ArrayList<>(item);
                    itemList.add(i);
                    newSumList.add(itemList);
                }
                temp.put(sum+i,newSumList);
            }

            List<List<Integer>> one = new ArrayList<>();
            List<Integer> item = new ArrayList<>();
            item.add(i);
            one.add(item);
            if(temp.containsKey(i)){
                temp.get(i).addAll(one);
            }else{
                temp.put(i,one);
            }
            for(Map.Entry<Integer,List<List<Integer>>> entry: temp.entrySet()){
                int sum = entry.getKey();
                if(map.containsKey(sum)){
                    map.get(sum).addAll(entry.getValue());
                }else{
                    map.put(sum,entry.getValue());
                }
            }
        }


    }

    public static void main(String[] args){
        Solution_216 solution = new Solution_216();

        for(List<Integer> answer: solution.combinationSum3(3,9)){
            for(Integer item:answer){
                System.out.print(item+",");
            }
            System.out.println();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
