//Implement the RandomizedCollection class: 
//
// 
// RandomizedCollection() Initializes the RandomizedCollection object. 
// bool insert(int val) Inserts an item val into the multiset if not present. Re
//turns true if the item was not present, false otherwise. 
// bool remove(int val) Removes an item val from the multiset if present. Return
//s true if the item was present, false otherwise. Note that if val has multiple o
//ccurrences in the multiset, we only remove one of them. 
// int getRandom() Returns a random element from the current multiset of element
//s (it's guaranteed that at least one element exists when this method is called).
// The probability of each element being returned is linearly related to the numbe
//r of same values the multiset contains. 
// 
//
// You must implement the functions of the class such that each function works i
//n average O(1) time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["RandomizedCollection", "insert", "insert", "insert", "getRandom", "remove", 
//"getRandom"]
//[[], [1], [1], [2], [], [1], []]
//Output
//[null, true, false, true, 2, true, 1]
//
//Explanation
//RandomizedCollection randomizedCollection = new RandomizedCollection();
//randomizedCollection.insert(1);   // return True. Inserts 1 to the collection.
// Returns true as the collection did not contain 1.
//randomizedCollection.insert(1);   // return False. Inserts another 1 to the co
//llection. Returns false as the collection contained 1. Collection now contains [
//1,1].
//randomizedCollection.insert(2);   // return True. Inserts 2 to the collection,
// returns true. Collection now contains [1,1,2].
//randomizedCollection.getRandom(); // getRandom should return 1 with the probab
//ility 2/3, and returns 2 with the probability 1/3.
//randomizedCollection.remove(1);   // return True. Removes 1 from the collectio
//n, returns true. Collection now contains [1,2].
//randomizedCollection.getRandom(); // getRandom should return 1 and 2 both equa
//lly likely.
// 
//
// 
// Constraints: 
//
// 
// -231 <= val <= 231 - 1 
// At most 2 * 105 calls will be made to insert, remove, and getRandom. 
// There will be at least one element in the data structure when getRandom is ca
//lled. 
// 
// Related Topics Array Hash Table Math Design Randomized 
// 👍 1284 👎 101


//leetcode submit region begin(Prohibit modification and deletion)
class RandomizedCollection {

    HashMap<Integer,Set<Integer>> itemIndexMap;
    ArrayList<Integer> itemList;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        itemIndexMap = new HashMap();
        itemList = new ArrayList();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = false;
        Set<Integer> itemIndex = itemIndexMap.get(val);
        if(itemIndex==null){
            itemIndex = new HashSet();
            contains=true;
        }
        itemList.add(val);
        itemIndex.add(itemList.size()-1);
        itemIndexMap.put(val,itemIndex);
        return contains;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> itemIndex = itemIndexMap.get(val);
        if(itemIndex==null || itemIndex.size()==0){
            return false;
        }
        Integer valIndex = itemIndex.iterator().next();
        if(valIndex == itemList.size()-1){
            itemList.remove(valIndex);
        }else{
            Integer changeValue = itemList.remove(itemList.size()-1);
            itemIndexMap.get(changeValue).remove(itemList.size());
            itemIndexMap.get(changeValue).add(valIndex);
            itemList.set(valIndex,changeValue);
        }
        if(itemIndex.size()==0){
            itemIndexMap.remove(val);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int randomIndex = rand.nextInt(itemList.size());
        return itemList.get(randomIndex);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)
