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
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author fisheuler
 * @created 2022/4/24
 */
public class TinyUrl_By_MurMurHash {

    public static  String generateRandomShortUrl()
    {

        final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++)
        {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, BASE62.length());
            sb.append(BASE62.charAt(randomIndex));
        }
        return sb.toString();
    }

    public static String getMd5Hash(String orig){
        // Create Instance of HashFunction (MD5)
        HashFunction hashFunction = Hashing.md5();

        // Pass input and charset to hashString() method
        HashCode hash = hashFunction.hashString(orig, StandardCharsets.UTF_8);
        return hash.toString();
    }

    public static String getMurMurHash(String orig){
        HashFunction hashFunction = Hashing.murmur3_32();
        HashCode hash = hashFunction.hashString(orig, StandardCharsets.UTF_8);
        return hash.toString();
    }

    public static void ReadFile(String fileName) {

        File file = new File(fileName);
        try {
            HashSet<String> urlSet = new HashSet<>(2000000);
            int collision = 0;
            int i = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                long start = System.currentTimeMillis();
                String line;
                while ((line = br.readLine()) != null) {

                    String[] urls = line.split(",");
                    String url = urls[1];

                    String murHash = getMd5Hash(url);

                    String hash = murHash.trim().substring(0,6);
                    if(url.contains(hash)){
                        collision++;
                    }
                    i++;
                    if(i%100000==0){
                        long end = System.currentTimeMillis();
                        System.out.println(i + "iteration: size:"+i+ " consume time :"+(end-start) + " collision :"+collision);
                        System.out.println(i + "iteration: collision percent " +((double)collision/(double)i)*(double)100);
                        start=end;
                    }
                    urlSet.add(hash);
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

//        ReadFile("/Users/guozhaoliang/Data/URL.csv");
        HashSet<String> randomSets = new HashSet<>(40000000);

        HashSet<String> md5Sets = new HashSet<>(40000000);
        long allStart = System.currentTimeMillis();
        int collision = 0;
        int i = 0;


        long start = System.currentTimeMillis();
        while(i<30000000){
            String url = generateRandomShortUrl();
            if(randomSets.contains(url)){
                continue;
            }
            randomSets.add(url);

            String md5 = getMurMurHash(url).substring(0,6);

            if(md5Sets.contains(md5)){
                collision++;
            }
            md5Sets.add(md5);
            i++;
            if(i%1000000==0){
                long end = System.currentTimeMillis();
                System.out.println(i + "iteration: size:"+i+ " consume time :"+(end-start) + " collision :"+collision);
                System.out.println(i + "iteration: collision percent " +((double)collision/(double)i)*(double)100);
                start=end;
            }

        }

    }




}