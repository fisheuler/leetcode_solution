package solution;//You are given a nested list of integers nestedList. Each element is either an
//integer or a list whose elements may also be integers or other lists. Implement 
//an iterator to flatten it. 
//
// Implement the NestedIterator class: 
//
// 
// NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with 
//the nested list nestedList. 
// int next() Returns the next integer in the nested list. 
// boolean hasNext() Returns true if there are still some integers in the nested
// list and false otherwise. 
// 
//
// Your code will be tested with the following pseudocode: 
//
// 
//initialize iterator with nestedList
//res = []
//while iterator.hasNext()
//    append iterator.next() to the end of res
//return res
// 
//
// If res matches the expected flattened list, then your code will be judged as 
//correct. 
//
// 
// Example 1: 
//
// 
//Input: nestedList = [[1,1],2,[1,1]]
//Output: [1,1,2,1,1]
//Explanation: By calling next repeatedly until hasNext returns false, the order
// of elements returned by next should be: [1,1,2,1,1].
// 
//
// Example 2: 
//
// 
//Input: nestedList = [1,[4,[6]]]
//Output: [1,4,6]
//Explanation: By calling next repeatedly until hasNext returns false, the order
// of elements returned by next should be: [1,4,6].
// 
//
// 
// Constraints: 
//
// 
// 1 <= nestedList.length <= 500 
// The values of the integers in the nested list is in the range [-106, 106]. 
// 
// Related Topics Stack Tree Depth-First Search Design Queue Iterator 
// 👍 3118 👎 1096


//leetcode submit region begin(Prohibit modification and deletion)

import solution.adt.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> leftList;
    NestedInteger current;
    public NestedIterator(List<NestedInteger> nestedList) {
        leftList = nestedList.subList(1,nestedList.size());
        current = nestedList.get(0);
    }

    @Override
    public Integer next() {
        Integer result;
        if(current.isInteger()){
            result= current.getInteger();
            if(leftList.size()>0){
                current = leftList.remove(0);
            }else{
                current=null;
            }
        }else{
            leftList.addAll(0,current.getList());
            while(leftList.size()>0){
                current = leftList.remove(0);
                if(current.isInteger()){
                    break;
                }else{
                    leftList.addAll(0,current.getList());
                }
            }

            result = current.getInteger();
            if(leftList.size()>0){
                current = leftList.remove(0);
            }else{
                current=null;
            }

        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return current!=null || leftList.size()>0;
    }


    public static void main(String[] args){
        List<NestedInteger> nestedList = new ArrayList<>();
        NestedIterator i = new NestedIterator(nestedList);
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)
