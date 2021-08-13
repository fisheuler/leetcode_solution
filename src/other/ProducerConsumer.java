/*
 * Copyright (c) 2021
 * All rights reserved.
 *
 */
package other;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author guozhaoliang
 * @created 2021/8/13
 */
public class ProducerConsumer {


    static int size = 100;
    static AtomicLong atomicLong = new AtomicLong(0);
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
                synchronized (queue){
                    while(queue.size() == size){
                        try {
                            queue.wait(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("producer "+index+"insert");
                    atomicLong.addAndGet(1);
                    queue.add(name);
                    queue.notifyAll();
                }
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
                synchronized (queue){
                    while(queue.size()==0){
                        try {
                            queue.wait(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("consumer " + index+ "queue out"+ queue.poll());
                    System.out.println("consumer number "+ atomicLong);
                }
            }
        }
    }

    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<5;i++){

            Producer producer = new ProducerConsumer.Producer(queue,i);
            producer.start();
        }

        for(int i=0;i<3;i++){
            Consumer consumer = new Consumer(queue,i);
            consumer.start();
        }
    }

}