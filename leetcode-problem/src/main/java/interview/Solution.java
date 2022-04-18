/*
 * Copyright (c) 2022
 * All rights reserved.
 *
 */
package interview;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.PriorityQueue;

/**
 * @author fisheuler
 * @created 2022/4/13
 */
public class Solution {


    private static final int BUFFER_SIZE = 8;

    public static boolean download(String param, String fileName) throws IOException {
        File f = new File(fileName);
        URL url = new URL(param);
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);

        FileOutputStream out = new FileOutputStream(f);
        BufferedInputStream in = new BufferedInputStream(conn.getInputStream());

        // We can move the buffer declaration outside the loop
        byte[] buffer = new byte[BUFFER_SIZE];

        long dld = 0, expected = conn.getContentLengthLong(); // TODO expected will be -1 if the content length is unknown
        while (true) {
            int n = in.read(buffer);
            if (n == -1) break;
            else dld += n;
            out.write(buffer, 0, n);
        }
        out.close();
        System.out.println(dld + "B transmitted to " + f.getAbsolutePath());
        return true;
    }


    public static class Movie{
        String name;
        double length;
        BigDecimal review;
        Movie(String name,double length,String review){
            this.name =name;
            this.length = length;
            this.review = new BigDecimal(review);
        }

        @Override
        public String toString() {
            return "Movie{" +
                    "name='" + name + '\'' +
                    ", length=" + length +
                    ", review=" + review +
                    '}';
        }
    }
    public static void findTopKMovie(String fileName,int k){

        File file = new File(fileName);
        PriorityQueue<Movie> priorityQueue = new PriorityQueue<Movie>(
                (a,b) -> ((a.review.compareTo(b.review))));
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if(line.startsWith("name")){
                        continue;
                    }

                    String[] movie = line.split(",");
                    Movie item=null;
                    try{
                        item  = new Movie(movie[0],Double.parseDouble(movie[1]),movie[2]);

                    }catch(Exception e){
                        System.out.println("something error "+line);
                        e.printStackTrace();
                    }
                    if(item==null){
                        continue;
                    }

                    if(priorityQueue.size()<k){
                        priorityQueue.add(item);
                    }else{
                        if(priorityQueue.peek().review.compareTo(item.review) ==-1){
                            priorityQueue.poll();
                            priorityQueue.add(item);
                        }
                    }
                    // process the line.
                }
            }

            while(priorityQueue.size()>0){
                System.out.println(priorityQueue.poll());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args)  {
        String url = "https://gist.githubusercontent.com/CatTail/18695526bd1adcc21219335f23ea5bea/raw/54045ceeae6a508dec86330c072c43be559c233b/movies.csv";
        String fileName = "movies.csv";

//        try {
//            download(url,fileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println("Hello world");

        findTopKMovie(fileName,10);
    }



}