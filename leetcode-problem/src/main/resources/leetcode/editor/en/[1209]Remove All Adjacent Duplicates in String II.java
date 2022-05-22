//You are given a string s and an integer k, a k duplicate removal consists of c
//hoosing k adjacent and equal letters from s and removing them, causing the left 
//and the right side of the deleted substring to concatenate together. 
//
// We repeatedly make k duplicate removals on s until we no longer can. 
//
// Return the final string after all such duplicate removals have been made. It 
//is guaranteed that the answer is unique. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcd", k = 2
//Output: "abcd"
//Explanation: There's nothing to delete. 
//
// Example 2: 
//
// 
//Input: s = "deeedbbcccbdaa", k = 3
//Output: "aa"
//Explanation: 
//First delete "eee" and "ccc", get "ddbbbdaa"
//Then delete "bbb", get "dddaa"
//Finally delete "ddd", get "aa" 
//
// Example 3: 
//
// 
//Input: s = "pbbcggttciiippooaais", k = 2
//Output: "ps"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 105 
// 2 <= k <= 104 
// s only contains lower case English letters. 
// 
// Related Topics String Stack 
// 👍 2679 👎 53


import java.util.LinkedList;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String s, int k) {
        int i=0,n = s.length(),count[] = new int[n];
        char[] stack = s.toCharArray();
        for(int j=0;j<n;++j,++i){
            stack[i]=stack[j];
            if(i>0 &&stack[i-1]==stack[j]){
                count[i]=count[i-1]+1;
            }else{
                count[i]=1;
            }
            if(count[i] == k){
                i = i - k;
            }
        }
        return new String(stack,0,i);
    }



    public String removeDuplicate(String s ,int k){
        int[] count = new int[s.length()];
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            sb.append(c);
            int last = sb.length()-1;
            if(last>0 && sb.charAt(last)==sb.charAt(last-1)){
                count[last] = 1  + count[last-1];
            }else{
                count[last]=1;
            }
            if(count[last]>=k){
                sb.delete(sb.length()-k,sb.length());
            }
        }
        return sb.toString();
    }


    class Node{
        char ch;
        int count;
    }
    public String removeDuplicates(String s, int k){
        Stack<Node> stack = new LinkedList<Node>();

        for(int i=0;i<s.length();i++){
            if(stack.size()>0){
                if(s.charAt(i) == stack.peek().ch){
                    stack.peek().count++;
                    if(stack.peek().count == k){
                        stack.pop();
                    }
                }
            }else{
                stack.push(new Node(s.charAt(i),1));
            }
        }

    }



















}
//leetcode submit region end(Prohibit modification and deletion)
