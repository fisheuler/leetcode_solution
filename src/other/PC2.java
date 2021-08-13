/*
 * Copyright (c) 2021
 * All rights reserved.
 *
 */
package other;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author guozhaoliang
 * @created 2021/8/13
 */
public class PC2 {
    private static final int size = 1000;
    static AtomicLong atomicLong = new AtomicLong(0);
    private static final Lock lock = new ReentrantLock();
    private static final Condition fullCondition = lock.newCondition();
    private static final Condition emptyCondition = lock.newCondition();

    static class Producer extends  Thread{
        Queue queue;
        String name;
        int index;
        public Producer(Queue queue ,int index){
            this.queue = queue;
            this.index = index;
            this.name = String.valueOf(index);
        }

        @Override
        public void run() {

            while(true){
                lock.lock();
                while(queue.size() == size){
                    try {
                        fullCondition.await(5, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                System.out.println("producer "+index+"insert");
                atomicLong.addAndGet(1);
//                System.out.println("add  number "+ atomicLong);
                queue.add(name);
                emptyCondition.signalAll();
                lock.unlock();
            }

        }
    }

    static class Consumer extends  Thread{
        Queue queue;
        int index;
        public Consumer(Queue queue,int index){
            this.queue = queue;
            this.index = index;
        }
        @Override
        public void run(){
            while(true){
                lock.lock();
                while(queue.size()==0){
                    try {
                        emptyCondition.await(5,TimeUnit.SECONDS);
                    } catch (InterruptedException e) {

                    }
                }
                queue.poll();
//                System.out.println("consumer " + index+ "queue out"+ queue.poll());

                if(atomicLong.get()%1000==0){
                    System.out.println("consumer number "+ atomicLong);
                }


                fullCondition.signalAll();
                lock.unlock();

            }
        }
    }

    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<1;i++){
            Producer producer = new Producer(queue,i);
            producer.start();
        }

        for(int i=0;i<1;i++){
            Consumer consumer = new Consumer(queue,i);
            consumer.start();
        }
    }


}