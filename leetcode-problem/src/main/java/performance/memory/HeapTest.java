/*
 * Copyright (c) 2022
 * All rights reserved.
 *
 */
package performance.memory;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author fisheuler
 * @created 2022/5/9
 */
public class HeapTest {

    public static void testPriorityQueue(){



        /*

        1Kw个数，1.2s左右处理完，大概100M个数据

        1M钟大概可以处理 100M个
        10,000,000  * 8 byte
            M   K
        100,000,000 byte  -> 100M
         */

//        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(long i=0;i<10000;i++){
            priorityQueue.offer(i);
        }
        long start = System.currentTimeMillis();
        for(long j=0;j<Long.MAX_VALUE;j++){
            priorityQueue.add(j);
            priorityQueue.poll();
            if(j%10000000 == 0){
                long end = System.currentTimeMillis();
                System.out.println("j:="+j + " consume:" + (end - start));
                start = end;
            }
        }

    }

    public static void main(String[] args){
        long start = System.currentTimeMillis();
        testPriorityQueue();
        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }
}