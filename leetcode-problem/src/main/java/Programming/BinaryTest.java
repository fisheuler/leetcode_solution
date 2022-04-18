/*
 * Copyright (c) 2022
 * All rights reserved.
 *
 */
package Programming;

/**
 * @author fisheuler
 * @created 2022/3/22
 */
public class BinaryTest {


    public static void main(String[] args){


        int a = 100+1<<3;
        int b = 1<<3;
        int c = a&(~b);
        int d = 0x3fe;
        System.out.println(a +"\t" + Integer.toBinaryString(a)


                +"\t" + Integer.bitCount(a)
                +"\t" + Integer.toBinaryString(a&(-a))

        );


        System.out.println(b +"\t" + Integer.toBinaryString(b));
        System.out.println(c +"\t" + Integer.toBinaryString(c));

        System.out.println(d +"\t" + Integer.toBinaryString(d));

    }




}