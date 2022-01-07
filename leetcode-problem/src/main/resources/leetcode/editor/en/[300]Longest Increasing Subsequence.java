//Given an integer array nums, return the length of the longest strictly increas
//ing subsequence. 
//
// A subsequence is a sequence that can be derived from an array by deleting som
//e or no elements without changing the order of the remaining elements. For examp
//le, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0,3,2,3]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time co
//mplexity? 
// Related Topics Array Binary Search Dynamic Programming 
// 👍 8615 👎 183


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*

    https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation

    minArray数组：下表I记录的是长度为I的递增序列末尾的最大值

    minArray在遍历数组nums的时候关系维护如下：
    1 在minArray数组中找一个下标：使得  minArray[i-1]<nums<=minArray[i]
    然后更新minArray[i]下标的值
    2 如果找不到下标，需要将minArray现有最大下标值加1


    算法应用：
    Part of MUMmer (Maximum Unique Match finder) system for aligning entire genomes.
    Used in version control systems like Git etc.
    Used in Patience Diff, a diffing algorithm


    耐心排序 （patience sorting） 有相似的关系


     */
    public int lengthOfLIS(int[] nums) {
        int[] minArray = new int[nums.length+1];
        minArray[0] =nums[0];
        int nextIndex = 1;
        for(int i=1;i<nums.length;i++){
            int index = getIndex(minArray,nextIndex,nums[i]);
            if(index<nextIndex){
                minArray[index]=nums[i];
            }else{
                minArray[nextIndex] = nums[i];
                nextIndex++;
            }
        }
        return nextIndex;
    }

    public int getIndex(int[] minArray,int nextIndex,int value){
        int i=0;
        for(;i<nextIndex;i++){
            if(minArray[i]>=value){
                break;
            }
        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
