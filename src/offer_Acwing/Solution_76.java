/*
 * Copyright (c) 2021 koolearn.com
 * All rights reserved.
 *
 */
package offer_Acwing;

import java.util.ArrayList;
import java.util.List;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 2021/8/11
 */
public class Solution_76 {
    public List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> result =  new ArrayList<>();

        int left=1,right=2;
        int curSum = left + right;
        while(left<=sum/2){
            if(curSum<sum){
                right ++;
                curSum = curSum + right;
            }else if (curSum == sum){
                result.add(getRange(left,right));
                curSum= curSum - left;
                left ++;
            }else{
                curSum = curSum - left;
                left++;
            }
        }
        return result;
    }

    public List<Integer> getRange(int left,int right){
        List<Integer> range = new ArrayList();
        for(int i=left;i<=right;i++){
            range.add(i);
        }
        return range;
    }


}