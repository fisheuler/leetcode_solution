package solution;//Implement next permutation, which rearranges numbers into the lexicographicall
//y next greater permutation of numbers. 
//
// If such an arrangement is not possible, it must rearrange it as the lowest po
//ssible order (i.e., sorted in ascending order). 
//
// The replacement must be in place and use only constant extra memory. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [1,3,2]
// Example 2: 
// Input: nums = [3,2,1]
//Output: [1,2,3]
// Example 3: 
// Input: nums = [1,1,5]
//Output: [1,5,1]
// Example 4: 
// Input: nums = [1]
//Output: [1]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics Array Two Pointers 
// 👍 6513 👎 2146


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_31 {
    /*
        1,2,3,4,5,6,7,8


        1,2,3,4,5

        1,2,3,5,4


        1,2,4,3,5
        1,2,4,5,3

        1,2,5,3,4

        1,2,5,4,3




        1,3,2,4,5
        1,3,2,5,4

        1,6,2,5,4,3

        1,6,









        1,2,3,8,6,7,5,4  -> 1,2,3,


        1,2,3,4,5,6,7,8




        1,2,3,8,7,6,5,4

        3,2,1
     */
    public void nextPermutation(int[] nums) {
        if(nums.length<=0){
            return;
        }

        for(int j=nums.length-1;j>0;j--){
            if(nums[j]>nums[j-1]){
                int prev = nums[j-1];
                int i=j;
                int nextBig =Integer.MAX_VALUE;
                int nextBigIndex = -1;
                for(;i<nums.length;i++){
                    if(nums[i]>prev){
                        if(nums[i]<nextBig){
                            nextBig = nums[i];
                            nextBigIndex=i;
                        }
                    }
                }

                nums[j-1] = nextBig;
                nums[nextBigIndex] = prev;

                Arrays.sort(nums,j,nums.length);

                break;

            }
            if(j==1){
                Arrays.sort(nums);
            }
        }
    }

    public static void main(String[] args){
        Solution_31 solution = new Solution_31();
        int[] nums = new int[]{5,1,1};

        solution.nextPermutation(nums);
        print(nums);
    }

    public static void print(int[] nums){
        for(int num: nums){
            System.out.print(num + ",");
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
