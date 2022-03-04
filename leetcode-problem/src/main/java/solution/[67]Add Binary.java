package solution;//Given two binary strings a and b, return their sum as a binary string.
//
// 
// Example 1: 
// Input: a = "11", b = "1"
//Output: "100"
// Example 2: 
// Input: a = "1010", b = "1011"
//Output: "10101"
// 
// 
// Constraints: 
//
// 
// 1 <= a.length, b.length <= 104 
// a and b consist only of '0' or '1' characters. 
// Each string does not contain leading zeros except for the zero itself. 
// 
// Related Topics Math String Bit Manipulation Simulation 
// 👍 3948 👎 468


//leetcode submit region begin(Prohibit modification and deletion)
class Solutio_67 {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        if (a == null || a.length() == 0) {
            return b;
        }

        if (b == null || b.length() == 0) {
            return a;
        }
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carryBit = 0;

        while (i >= 0 || j >= 0) {
            int avalue = i>=0?a.charAt(i) - '0':0;
            int bvalue = j>=0?b.charAt(j) - '0':0;
            int sum = (avalue + bvalue + carryBit) % 2;
            carryBit = (avalue + bvalue + carryBit) / 2;
            sb.append(sum);
            i--;
            j--;
        }
        if(carryBit>0){
            sb.append(carryBit);
        }

        return sb.reverse().toString();

    }

    public static void main(String[] args){

        System.out.println(addBinary("11","1"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
