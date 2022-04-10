package solution;//Given an array of integers arr, return true if and only if it is a valid mount
//ain array. 
//
// Recall that arr is a mountain array if and only if: 
//
// 
// arr.length >= 3 
// There exists some i with 0 < i < arr.length - 1 such that:
// 
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 
// 
// 
// 
//
// 
// Example 1: 
// Input: arr = [2,1]
//Output: false
// Example 2: 
// Input: arr = [3,5,5]
//Output: false
// Example 3: 
// Input: arr = [0,3,2,1]
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 104 
// 0 <= arr[i] <= 104 
// 
// Related Topics Array 
// 👍 1450 👎 123


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_941 {
    public boolean validMountainArray(int[] arr) {
        // climb the mountain

        int i =1 ;
        boolean haveClimb = false;
        for(;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                haveClimb = true;
                continue;
            }
            break;
        }
        boolean haveDown = false;
        // go downhill
        for(;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                haveDown =true;
                continue;
            }
            return false;
        }

        return haveClimb && haveDown;

    }

    public static void main(String[] args){
        Solution_941 solution = new Solution_941();


        System.out.println(solution.validMountainArray(new int[]{0,3,2,1}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
