/*
 * Copyright (c) 2021
 * All rights reserved.
 *
 */
package solution.Programming.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author guozhaoliang
 * @created 2021/9/7
 *
 * Examplefrom :https://www.cnblogs.com/CodeBear/p/10911177.html
 *
 * https://developer.aliyun.com/article/773205
 *
 *
 * https://git.postgresql.org/gitweb/?p=postgresql.git;a=commitdiff;h=9ee014fc899a28a198492b074e32b60ed8915ea9
 *
 *
 */
public class BloomFilterTest {
    private static int size = 1000000;
    private static double fpp = 0.001;

    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),size,fpp);

    public static void main(String[] args){
        for( int i = 0;i<size;i++){
            bloomFilter.put(i);
        }

        int count = 0;
        for(int i=size;i<2*size;i++){
            if(bloomFilter.mightContain(i)){
                count++;
                System.out.println(i+"误判了");
            }
        }
        System.out.println("总共误判数目"+count);

        double falsePro= count/size;
        System.out.println("误判概率"+falsePro);
    }
}

















