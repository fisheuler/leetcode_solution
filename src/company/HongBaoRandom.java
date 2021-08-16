/*
 * Copyright (c) 2021
 * All rights reserved.
 *
 */
package company;

/**
 * @author guozhaoliang
 * @created 2021/8/16
 */
public class HongBaoRandom {

    public static int[] getHB(int total,int number){
        if(total <=0){
            return null;
        }
        if(number<=0){
            return null;
        }

        int[] nums = new int[number];

        int i=0;
        int left = total;

        for(i=0;i<number-1;i++){
            int thisTime = (int) (Math.random()*( left/(number-i+1) *2));
            if(thisTime<=0){
                thisTime = 1;
            }
            nums[i]=thisTime;
            left = left - thisTime;
        }

        nums[i] = left;
        return nums;
    }


    public static void main(String[] args){

        int[] nums = getHB(1000,9);
        for(int num:nums){
            System.out.println(num);
        }

    }
}