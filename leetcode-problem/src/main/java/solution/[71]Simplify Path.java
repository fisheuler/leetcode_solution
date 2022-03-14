package solution;//Given a string path, which is an absolute path (starting with a slash '/') to
//a file or directory in a Unix-style file system, convert it to the simplified ca
//nonical path. 
//
// In a Unix-style file system, a period '.' refers to the current directory, a 
//double period '..' refers to the directory up a level, and any multiple consecut
//ive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any
// other format of periods such as '...' are treated as file/directory names. 
//
// The canonical path should have the following format: 
//
// 
// The path starts with a single slash '/'. 
// Any two directories are separated by a single slash '/'. 
// The path does not end with a trailing '/'. 
// The path only contains the directories on the path from the root directory to
// the target file or directory (i.e., no period '.' or double period '..') 
// 
//
// Return the simplified canonical path. 
//
// 
// Example 1: 
//
// 
//Input: path = "/home/"
//Output: "/home"
//Explanation: Note that there is no trailing slash after the last directory nam
//e.
// 
//
// Example 2: 
//
// 
//Input: path = "/../"
//Output: "/"
//Explanation: Going one level up from the root directory is a no-op, as the roo
//t level is the highest level you can go.
// 
//
// Example 3: 
//
// 
//Input: path = "/home//foo/"
//Output: "/home/foo"
//Explanation: In the canonical path, multiple consecutive slashes are replaced 
//by a single one.
// 
//
// 
// Constraints: 
//
// 
// 1 <= path.length <= 3000 
// path consists of English letters, digits, period '.', slash '/' or '_'. 
// path is a valid absolute Unix path. 
// 
// Related Topics String Stack 
// 👍 1445 👎 329


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_71 {
    public String simplifyPath(String path) {

        Stack<Character> stack = new Stack<>();
        Set<Character> characterSet = new HashSet<>();
        characterSet.add('/');
        characterSet.add('.');
        for(int i =0;i<path.length();i++){
            char ch = path.charAt(i);
            if(characterSet.contains(ch)){
                if(stack.size()>0 && (ch == stack.peek())){
                    if(ch =='/'){

                    }else if (ch =='.'){
                        if((i+1)<path.length()){
                            if(ch == path.charAt(i+1)){
                                stack.push(ch);
                            }
                        }else{
                            stack.pop(); // pop first .

                            if(stack.size()>1){
                                stack.pop(); // pop fist /
                                while(stack.size()>1){
                                    if(stack.peek()!='/'){
                                        stack.pop();
                                    }
                                }
                            }
                        }
                    }
                }else{
                    stack.push(ch);
                }
            }else{
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(stack.size()>0){
            sb.append(stack.pop());
        }

        if(sb.length()>1&&sb.charAt(0)=='/'){
            sb.deleteCharAt(0);
        }


        return sb.reverse().toString();

    }

    public static void main(String[] args){
        Solution_71 solution = new Solution_71();

        String path="/a/./b/../../c/";

        System.out.println(solution.simplifyPath(path));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
