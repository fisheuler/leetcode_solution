/*
 * Copyright (c) 2021
 * All rights reserved.
 *
 */
package sword;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 2021/7/29
 */
public class KSmallSet {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, Comparator.reverseOrder());

        for(int num: input){
            if(priorityQueue.size()<k){
                priorityQueue.add(num);
            }else{
                if(priorityQueue.peek()>num){
                    priorityQueue.poll();
                    priorityQueue.add(num);
                }
            }

        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(priorityQueue);
        return arrayList;
    }
}