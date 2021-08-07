/*
 * Copyright (c) 2021
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 2021/8/6
 */
public class Step {

    public static int stepSum(int n,int x, int y){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return stepSum(n-x,x,y) + stepSum(n-y,x,y);
    }

    public static void main(String[] args){
        System.out.println(stepSum(11,3,5));
    }

}