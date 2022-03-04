//On an infinite plane, a robot initially stands at (0, 0) and faces north. The 
//robot can receive one of three instructions: 
//
// 
// "G": go straight 1 unit; 
// "L": turn 90 degrees to the left; 
// "R": turn 90 degrees to the right. 
// 
//
// The robot performs the instructions given in order, and repeats them forever.
// 
//
// Return true if and only if there exists a circle in the plane such that the r
//obot never leaves the circle. 
//
// 
// Example 1: 
//
// 
//Input: instructions = "GGLLGG"
//Output: true
//Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then 
//returns to (0,0).
//When repeating these instructions, the robot remains in the circle of radius 2
// centered at the origin. 
//
// Example 2: 
//
// 
//Input: instructions = "GG"
//Output: false
//Explanation: The robot moves north indefinitely. 
//
// Example 3: 
//
// 
//Input: instructions = "GL"
//Output: true
//Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0
//, 0) -> ... 
//
// 
// Constraints: 
//
// 
// 1 <= instructions.length <= 100 
// instructions[i] is 'G', 'L' or, 'R'. 
// 
// Related Topics Math String Simulation 
// 👍 2372 👎 549


import solution.Solution_1041;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Map<String, Character> directionMap;
    public static {
        Map<String, Character> map = new HashMap<>();
        map.put("NL",'W');
        map.put("NR",'E');

        map.put("SL",'E');
        map.put("SR",'W');

        map.put("EL",'N');
        map.put("ER",'S');

        map.put("WL",'S');
        map.put("WR",'N');
    }




    public class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public boolean isRobotBounded(String instructions) {

        Point p = new Point(0,0);

        char direction = 'N';

        for(int i=0;i<instructions.length();i++){
            char inst= instructions.charAt(i);
            if(inst == 'G'){
                updatePoint(p,direction);
            }else{
                direction = nextDirection(direction,inst);
            }
        }

        return p.x==0 && p.y==0 || direction!='N';

    }


    public char nextDirection(char cur,char input){

        String key = Character.toString(cur)+ Character.toString(input);

        return directionMap.get(key);

    }

    public void updatePoint(Point p, char direction){
        if(direction == 'N'){
            p.y++;
        }else if (direction == 'S'){
            p.y--;
        }else if (direction == 'E'){
            p.x++;
        }else if (direction == 'W'){
            p.x--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
