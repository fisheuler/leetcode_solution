/*
 * Copyright (c) 2021
 * All rights reserved.
 *
 */
package solution.Programming.circle;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * https://zhuanlan.zhihu.com/p/270171164
 *
 * @author guozhaoliang
 * @created 2021/8/16
 */
public class CirclePrint {

    private int times;
    private int state;
    private Lock lock = new ReentrantLock();

    public CirclePrint(int times){
        this.times = times;
    }

    private void printLetter(String name,int targetNum){
        for(int i=0;i<times;){
            lock.lock();
            if(state%3 == targetNum){
                state ++;
                i++;
                System.out.println(name);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args){
        CirclePrint circlePrint = new CirclePrint(10);

        new Thread(() -> {
            circlePrint.printLetter("B",1);
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                circlePrint.printLetter("A",0);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                circlePrint.printLetter("C",2);
            }
        }).start();
    }

}