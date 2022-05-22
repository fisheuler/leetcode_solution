/*
 * Copyright (c) 2022
 * All rights reserved.
 *
 */
package performance.memory;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

/**
 * @author fisheuler
 * @created 2022/5/9
 */
public class Md5Test {

    // Create Instance of HashFunction (MD5)
    static HashFunction hashFunction = Hashing.md5();
    public static String getMd5Hash(long j){
        // Pass input and charset to hashString() method
        HashCode hash = hashFunction.hashString(String.valueOf(j), StandardCharsets.UTF_8);
        return hash.toString();
    }

    /*

j:=10000000 consume:5759
j:=20000000 consume:4775
j:=30000000 consume:4797
j:=40000000 consume:5045
j:=50000000 consume:5162
j:=60000000 consume:5640

1kw数据，md5 需要5s左右



检测一下String.valueOf(i)耗时

j:=0 consume:0
j:=10000000 consume:456
j:=20000000 consume:429
j:=30000000 consume:375
j:=40000000 consume:359
j:=50000000 consume:354
j:=60000000 consume:464
j:=70000000 consume:450
j:=80000000 consume:528
j:=90000000 consume:467


所以1kw的数据做md5操作，需要 5000 - 500= 4500  4.5s左右

1KW的的数据 大小约为 100MB 每秒大约 20M左右处理数据


     */
    public static void testMd5Hash(){

        long start = System.currentTimeMillis();
        for(long j=0;j<Long.MAX_VALUE;j++){
            String.valueOf(j);
            if(j%10000000 == 0){
                long end = System.currentTimeMillis();
                System.out.println("j:="+j + " consume:" + (end - start));
                start = end;
            }
        }

    }


    public static void main(String[] args){
        long start = System.currentTimeMillis();
        testMd5Hash();
        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }


}