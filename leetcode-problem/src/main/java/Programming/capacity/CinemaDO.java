package Programming.capacity;

import java.io.Serializable;
import java.util.Date;

public class CinemaDO implements Serializable {

    private static final long serialVersionUID = 6717236803022832749L;
    private int id;
    private String name;
    private int cityId;
    private int lowerCityId;
    // 专资唯一8位编码
    private int uniqueNo;
    // json格式的info
    private String info;
    private Date createtm;
    private Date lastupdatetm;
    private int property;
    private long uniq;
    // 售票来源
    private int sellSrc;
    // 选座状态 0-待上线 1-上线中 2-已下线
    private int ticketingStatus;
    // 上线日期
    private Date onlineDate;
    // 下线日期
    private Date offlineDate;

    private int status;

    private long channelBit;

    private int machineType;

    private int goldenCatConditionFlag;

    //联系电话，优先级高于infoJ里的tel
    private String priorTel;

    public final int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final int getCityId() {
        return cityId;
    }

    public final void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getLowerCityId() {
        return lowerCityId;
    }

    public void setLowerCityId(int lowerCityId) {
        this.lowerCityId = lowerCityId;
    }

    public int getUniqueNo() {
        return uniqueNo;
    }

    public void setUniqueNo(int uniqueNo) {
        this.uniqueNo = uniqueNo;
    }

    public final String getInfo() {
        return info;
    }

    public final void setInfo(String info) {
        this.info = info;
    }

    public final int getProperty() {
        return property;
    }

    public final void setProperty(int property) {
        this.property = property;
    }

    public final long getUniq() {
        return uniq;
    }

    public final void setUniq(long uniq) {
        this.uniq = uniq;
    }

    public int getSellSrc() {
        return sellSrc;
    }

    public void setSellSrc(int sellSrc) {
        this.sellSrc = sellSrc;
    }

    public int getTicketingStatus() {
        return ticketingStatus;
    }

    public void setTicketingStatus(int ticketingStatus) {
        this.ticketingStatus = ticketingStatus;
    }

    public Date getOnlineDate() {
        return onlineDate;
    }

    public void setOnlineDate(Date onlineDate) {
        this.onlineDate = onlineDate;
    }

    public Date getOfflineDate() {
        return offlineDate;
    }

    public void setOfflineDate(Date offlineDate) {
        this.offlineDate = offlineDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getChannelBit() {
        return channelBit;
    }

    public void setChannelBit(long channelBit) {
        this.channelBit = channelBit;
    }

    public int getMachineType() {
        return machineType;
    }

    public void setMachineType(int machineType) {
        this.machineType = machineType;
    }

    public int getGoldenCatConditionFlag() {
        return goldenCatConditionFlag;
    }

    public void setGoldenCatConditionFlag(int goldenCatConditionFlag) {
        this.goldenCatConditionFlag = goldenCatConditionFlag;
    }

    public String getPriorTel() {
        return priorTel;
    }

    public void setPriorTel(String priorTel) {
        this.priorTel = priorTel;
    }


    public Date getCreatetm() {
        return createtm;
    }

    public void setCreatetm(Date createtm) {
        this.createtm = createtm;
    }

    public Date getLastupdatetm() {
        return lastupdatetm;
    }

    public void setLastupdatetm(Date lastupdatetm) {
        this.lastupdatetm = lastupdatetm;
    }
}
