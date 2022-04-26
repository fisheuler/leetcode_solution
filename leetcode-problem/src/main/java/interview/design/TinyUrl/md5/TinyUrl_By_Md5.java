/*
 * Copyright (c) 2022
 * All rights reserved.
 *
 */
package interview.design.TinyUrl.md5;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

/**
 * @author fisheuler
 * @created 2022/4/24
 */
public class TinyUrl_By_Md5 {


    public static String getMd5Hash(String orig){
        // Create Instance of HashFunction (MD5)
        HashFunction hashFunction = Hashing.md5();

        // Pass input and charset to hashString() method
        HashCode hash = hashFunction.hashString(orig, StandardCharsets.UTF_8);
        return hash.toString();
    }

    public static void ReadFile(String fileName) {

        File file = new File(fileName);
        try {
            HashSet<String> url = new HashSet<>(2000000);
            int collision = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if(line.length()<7){
                        System.out.println(line);
                        continue;
                    }

                    String md5 = line.trim().substring(0,7);
                    if(url.contains(md5)){
                        collision++;
                    }
                    url.add(md5);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("collison:" + collision);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args){
        HashSet<String> randomSets = new HashSet<>(40000000);

        HashSet<String> md5Sets = new HashSet<>(40000000);
        long allStart = System.currentTimeMillis();
        int collision = 0;
        int i = 0;
        long start = System.currentTimeMillis();
//        while(i<30000000){
//            String url = generateRandomShortUrl();
//            if(randomSets.contains(url)){
//                continue;
//            }
//            randomSets.add(url);
//
//            String md5 = getMd5Hash(url).substring(0,6);
//
//            if(md5Sets.contains(md5)){
//                collision++;
//            }
//            md5Sets.add(md5);
//            i++;
//            if(i%1000000==0){
//                long end = System.currentTimeMillis();
//                System.out.println(i + "iteration: size:"+i+ " consume time :"+(end-start) + " collision :"+collision);
//                System.out.println(i + "iteration: collision percent " +((double)collision/(double)i)*(double)100);
//                start=end;
//            }
//
//        }

    }




}