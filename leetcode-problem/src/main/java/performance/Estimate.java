/*
 * Copyright (c) 2022
 * All rights reserved.
 *
 */
package performance;

/**
 * @author fisheuler
 * @created 2022/5/9
 */
public class Estimate {
    public static void main(String[] args){
        /*
        100M * 100
        100,000,000 * 100

        10 000 000 000;
         */
        long total = 10000000000l;

        long qps = total / ( 24*3600);

        System.out.println("qps:"+qps);

    }
}