/*
 * Copyright (c) 2022
 * All rights reserved.
 *
 */
package Programming.capacity;

import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author fisheuler
 * @created 2022/4/13
 */
public class Capacity {

    public static class ObjectSizeFetcher {
        private static Instrumentation instrumentation;

        public static void premain(String args, Instrumentation inst) {
            instrumentation = inst;
        }

        public static long getObjectSize(Object o) {
            return instrumentation.getObjectSize(o);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Integer i = 10;


        long startTime = System.nanoTime();

        transform();

        long endTime = System.nanoTime();

        System.out.println(endTime-startTime);



    }

    public static void transform() {
        List<CinemaDO> cinemaDOList = new ArrayList<>();
        for(int i=0;i<=20;i++){
            CinemaDO c = new CinemaDO();
            c.setId(1000000);
            c.setName("中国中影影院");
            c.setCityId(101);
            c.setLowerCityId(1000);
            c.setUniqueNo(2839494);

//            c.setInfo("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" +
//                    "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" +
//                    "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" +
//                    "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" +
//                    "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
//            );
            c.setCreatetm(new Date());
            c.setLastupdatetm(new Date());
            c.setProperty(1);
            c.setUniq(100);
            c.setSellSrc(100);
            c.setTicketingStatus(2);
            c.setOnlineDate(new Date());
            c.setOfflineDate(new Date());
            c.setStatus(1);
            c.setChannelBit(1020);

            cinemaDOList.add(c);
        }

        List<CinemaModel> cinemaModelList = new ArrayList<>();

        for(CinemaDO cinemaDO: cinemaDOList){
            CinemaModel cinemaModel = CinemaHelper.convert(cinemaDO);
            cinemaModelList.add(cinemaModel);
        }
    }

}