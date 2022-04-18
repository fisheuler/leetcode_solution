package Programming.capacity;

import java.util.Date;

/**
 * Created by wangshaofeng on 2019/6/20.
 */
public class CinemaHelper {


    public static CinemaModel convert(CinemaDO cinemaDO) {
        if (cinemaDO == null) {
            return null;
        }
        CinemaModel cinemaModel = new CinemaModel();
        cinemaModel.setId(cinemaDO.getId());
        cinemaModel.setName(cinemaDO.getName());
        cinemaModel.setCityId(cinemaDO.getCityId());
        cinemaModel.setLowerCityId(cinemaDO.getLowerCityId());
        cinemaModel.setUniqueNo(cinemaDO.getUniqueNo());
        Date createtm = cinemaDO.getCreatetm();
        if (createtm != null) {
            cinemaModel.setCreateInSecs(createtm.getTime());
        }
        Date lastupdatetm = cinemaDO.getLastupdatetm();
        if (lastupdatetm != null) {
            cinemaModel.setLastUpdateInSecs(lastupdatetm.getTime());
        }
        cinemaModel.setProperty(cinemaDO.getProperty());
        cinemaModel.setStatus(cinemaDO.getStatus());
        cinemaModel.setSellSrc(cinemaDO.getSellSrc());
        cinemaModel.setTicketingStatus(cinemaDO.getTicketingStatus());
        cinemaModel.setOnlineDate(cinemaDO.getOnlineDate());
        cinemaModel.setOfflineDate(cinemaDO.getOfflineDate());
        cinemaModel.setChannelBit(cinemaDO.getChannelBit());
        cinemaModel.setGoldenCatConditionFlag(cinemaDO.getGoldenCatConditionFlag());

        String infoJ = cinemaDO.getInfo();

        return cinemaModel;
    }




}
