/*
 * Copyright (c) 2022
 * All rights reserved.
 *
 */
package Programming;

/**
 * @author fisheuler
 * @created 2022/3/14
 */
public class Singleton {
    public static Singleton s;

    Singleton(){
    }

    {
        s = new Singleton();
    }


    public static void main(String[] args){
        Singleton s = Singleton.s;

    }
}