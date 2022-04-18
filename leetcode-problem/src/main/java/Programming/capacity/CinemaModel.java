package Programming.capacity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class CinemaModel implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(CinemaModel.class);
    private static final Long serialVersionUID = -522658679217079623L;

    private Integer id;
    private String name;
    private String telephone;
    //废弃字段
    private Integer brandId;
    //废弃字段
    private String brand;

    private Integer verifyBrandId;

    private String verifyBrand;

    private Integer cityId;
    private Integer lowerCityId;
    // 专资唯一8位编码
    private Integer uniqueNo;
    private Integer areaId;
    // 行政区

    private String area;
    //废弃字段
    private Integer districtId;
    // 商圈

    private String district;

    private String address;

    private Double longitude;

    private Double latitude;
    private String bus;
    private String subway;
    private String subwayStation;
    private String drive;
    private String park;
    private String notice;
    private String imgs;
    private String avgScore;
    // 客服联系人
    private String serviceContact;
    // 外部售票影院ID
    private String cinemaPK;
    // 售票来源
    private Integer sellSrc;
    // 选座状态 0-未映射售票系统影院 1-上线中 2-已到期 3-手工下线 4-等待上线 5-有映射售票系统影院，但不是选座影院
    private Integer ticketingStatus;
    // 上线日期
    private Date onlineDate;
    // 下线日期
    private Date offlineDate;
    // 取票地址
    private String takeTicketPlace;
    // 售票时限：开场前多久停止售票
    private Integer validSellMin;
    // 影院是否支持二维码 (0-不支持 1-猫眼提供的二维码 2-售票系统提供的二维码)
    private Integer supportQR = 1;
    // 1是0否
    private Integer imax;
    // 影院特色
    private String feature;
    // 选座起始价
    private Integer startPrice;
    // 2d参考价
    private Integer rpFor2D;
    // 3d参考价
    private Integer rpFor3D;
    // 猫眼上线时间，非选座项目上线时间
    private Date maoyanOnlineDate;
    private Long createInSecs;
    private Long lastUpdateInSecs;
    private Integer property;
    private Integer status;
    // 上映影片数
    private Integer movieNum;
    // 上映影院数
    private Integer showNum;
    // 评论人数
    private Integer snum;
    // 总体评分
    private Float s;
    // 观影效果评分
    private Float s1;
    // 服务质量评分
    private Float s2;
    // 周边环境评分
    private Float s3;

    // 表示渠道是否授权的位图
    private Long channelBit;
    // 是否使用出票机 (后台设置)
    private Boolean useMachine = false;
    // 取票机摆放位置
    private String machinePlacement;
    // 取票机使用方式
    private String machineUsePattern;
    // 取票机图片
    private String machineImg;
    // 影院特色标签描述
    private String featureTags;

    // 是否有猫眼出票机
    private Boolean hasMaoyanMachine;
    // 售票系统每单限制售票数
    private Integer buyNumLimit;
    // 后台每单限制售票数
    private Integer adminBuyNumLimit;
    // 是否展示原价
    private Boolean showOriginalPrice = true;
    // 影院可售日期
    private Integer sellDateLimit = 0;
    // 客服须知
    private String staffNote;
    /**
     * 负责bd的mis账号
     *
     */
    @Deprecated
    private String bdLogin;
    /**
     * 负责bd姓名
     *
     */
    @Deprecated
    private String bdName;
    /**
     * 负责bd电话
     *
     */
    @Deprecated
    private String bdPhone;

    // 0 - 不允许, 1 － 允许用户自助退款, 2 － 允许客服电话，手动退票
    private Integer allowRefundTag = 2;
    // 开场前多少分钟，允许调用售票系统backTicket接口 或 联系影院进行退票
    private Integer allowRefundTime = 0;

    //独家影院标志
    private Boolean exclusive;
    //0:营业中，1：倒闭 ，2：筹建中 3：暂停营业
    private Integer closeStatus;

    //位置信息，地标 商圈 行政区
    private String loc;

    //主门店的Id
    private Integer majorId;
    // 点评门店id
    private Integer dpShopId;
    //行政区国家编码
    private Integer locationId;
    //城市国家编码
    private Integer cityLocationId;
    //geoId(商圈Id)
    private Integer bareaId;
    //商圈名称
    private String bareaName;

    //厅的信息
    private Long hallType;

    // 是否可退票，后台设置，已废弃
    private Boolean canRefund;
    // 支持开场前退款时间，单位分钟，已废弃
    private Integer refundTime = -1;
    // 退票描述 已废弃
    private String refundDesc;

    //专资id最近更新时间
    private String uniqueLastUpdateTime;

    //是否支持联合支付 false: 不支持，true: 支持
    //默认支持
    private Boolean isUnionPay = true;

    //是否支持改签 0:不支持改签 1:自助改签
    private Integer endorse;

    //改签的时间限制 分钟
    private Integer endorseTime = -1;

    //影院的所属geo城市信息
    private List<Integer> geoCityIds;
    //影院所属的geo信息
    private List<Integer> geoAreas;

    //订单的提示文案信息
    private String orderTips;

    //影院是否支持包场 1:支持,0:不支持
    private Integer buyout;

    //是否自动从取票机同步取票信息
    private Boolean isAutoSyncMachineInfo;

    //生效渠道列表
    private Set<Integer> effectiveChannels;
    // 当前生效的影投id
    private Integer investmentId;
    //金毛影院的标识的满足条件flag
    private Integer goldenCatConditionFlag;

    //点评升级的shopUUID
    private String shopUUID;

    private Integer mtSource;

    private Integer poiId;

    private Integer poiBrandId;

    private String poiBrandName;

    // 安心影院标签设置成功的时间（默认有7天有效期，七天过去之后消失）
    private long safeCinemaTagSetTime;


    public Integer getMtSource() {
        return mtSource;
    }

    public void setMtSource(Integer mtSource) {
        this.mtSource = mtSource;
    }

    public Integer getPoiBrandId() {
        return poiBrandId;
    }

    public void setPoiBrandId(Integer poiBrandId) {
        this.poiBrandId = poiBrandId;
    }

    public String getPoiBrandName() {
        return poiBrandName;
    }

    public void setPoiBrandName(String poiBrandName) {
        this.poiBrandName = poiBrandName;
    }

    public String getPark() {
        return park;
    }

    public void setFeatureTags(String featureTags) {
        this.featureTags = featureTags;
    }

    public Boolean isHasMaoyanMachine() {
        return hasMaoyanMachine;
    }

    public Boolean isShowOriginalPrice() {
        return showOriginalPrice;
    }

    public void setShowOriginalPrice(Boolean showOriginalPrice) {
        this.showOriginalPrice = showOriginalPrice;
    }

    public Boolean isCanRefund() {
        return canRefund;
    }

    public Boolean isUnionPay() {
        return isUnionPay;
    }

   

    
    public void setChannelBit(Long channelBit) {
        this.channelBit = channelBit;
    }

    public Boolean getUseMachine() {
        return useMachine;
    }

   
    
    public Boolean getHasMaoyanMachine() {
        return hasMaoyanMachine;
    }

   
    

    public Boolean getShowOriginalPrice() {
        return showOriginalPrice;
    }

   
    

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Long getHallType() {
        return hallType;
    }

    public void setHallType(Long hallType) {
        this.hallType = hallType;
    }

    public Boolean getUnionPay() {
        return isUnionPay;
    }

    public void setUnionPay(Boolean unionPay) {
        isUnionPay = unionPay;
    }

    public Integer getPoiId() {
        return poiId;
    }

    public void setPoiId(Integer poiId) {
        this.poiId = poiId;
    }

    public final Integer getId() {
        return id;
    }

    public final void setId(Integer id) {
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getTelephone() {
        return telephone;
    }

    public final void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public final Integer getBrandId() {
        return verifyBrandId;
    }

    @Deprecated
    public final void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public final String getBrand() {
        return verifyBrand;
    }

    @Deprecated
    public final void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getValidSellMin() {
        return validSellMin;
    }

    public Integer getValidSellMin(Integer showSource) {
        return validSellMin;
    }

    public void setValidSellMin(Integer validSellMin) {
        this.validSellMin = validSellMin;
    }

    public Integer getLowerCityId() {
        return lowerCityId;
    }

    public void setLowerCityId(Integer lowerCityId) {
        this.lowerCityId = lowerCityId;
    }

    public Integer getUniqueNo() {
        return uniqueNo;
    }

    public void setUniqueNo(Integer uniqueNo) {
        this.uniqueNo = uniqueNo;
    }

    public Date getMaoyanOnlineDate() {
        return maoyanOnlineDate;
    }

    public void setMaoyanOnlineDate(Date maoyanOnlineDate) {
        this.maoyanOnlineDate = maoyanOnlineDate;
    }

    public Integer getBuyout() {
        return buyout;
    }

    public void setBuyout(Integer buyout) {
        this.buyout = buyout;
    }

    public Integer getAdminBuyNumLimit() {
        return adminBuyNumLimit;
    }

    public void setAdminBuyNumLimit(Integer adminBuyNumLimit) {
        this.adminBuyNumLimit = adminBuyNumLimit;
    }


    public final Integer getCityId() {
        return cityId;
    }

    public final void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public final Integer getAreaId() {
        return locationId;
    }

    public final void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public final String getArea() {
        return area;
    }

    public final void setArea(String area) {
        this.area = area;
    }

    public final Integer getDistrictId() {
        return districtId;
    }

    public final void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public final String getDistrict() {
        return district;
    }

    public final void setDistrict(String district) {
        this.district = district;
    }

    public final String getAddress() {
        return address;
    }

    public final void setAddress(String address) {
        this.address = address;
    }

    public final Double getLongitude() {
        return longitude;
    }

    public final void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public final Double getLatitude() {
        return latitude;
    }

    public final void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public final String getBus() {
        return bus;
    }

    public final void setBus(String bus) {
        this.bus = bus;
    }

    public final String getSubway() {
        return subway;
    }

    public final void setSubway(String subway) {
        this.subway = subway;
    }

    public final String getSubwayStation() {
        return subwayStation;
    }

    public final void setSubwayStation(String subwayStation) {
        this.subwayStation = subwayStation;
    }

    public final String getDrive() {
        return drive;
    }

    public final void setDrive(String drive) {
        this.drive = drive;
    }


    public final String getParkOld() {
        return this.park;
    }

    public final void setPark(String park) {
        this.park = park;
    }

    public final String getNotice() {
        return notice;
    }

    public final void setNotice(String notice) {
        this.notice = notice;
    }

    public String getOrderTips() {
        return orderTips;
    }

    public void setOrderTips(String orderTips) {
        this.orderTips = orderTips;
    }


    public String getServiceContactWithJSON() {
        return serviceContact;
    }

    public void setServiceContact(String serviceContact) {
        this.serviceContact = serviceContact;
    }

    public final Long getCreateInSecs() {
        return createInSecs;
    }

    public final void setCreateInSecs(Long createInSecs) {
        this.createInSecs = createInSecs;
    }

    public final Long getLastUpdateInSecs() {
        return lastUpdateInSecs;
    }

    public final void setLastUpdateInSecs(Long lastUpdateInSecs) {
        this.lastUpdateInSecs = lastUpdateInSecs;
    }

    public final Integer getProperty() {
        return property;
    }

    public final void setProperty(Integer property) {
        this.property = property;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getImax() {
        return imax;
    }

    public void setImax(Integer imax) {
        this.imax = imax;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    public Integer getMovieNum() {
        return movieNum;
    }

    public void setMovieNum(Integer movieNum) {
        this.movieNum = movieNum;
    }

    public Integer getShowNum() {
        return showNum;
    }

    public void setShowNum(Integer showNum) {
        this.showNum = showNum;
    }

    public Float getS() {
        return s;
    }

    public void setS(Float s) {
        this.s = s;
    }

    public Float getS1() {
        return s1;
    }

    public void setS1(Float s1) {
        this.s1 = s1;
    }

    public Float getS2() {
        return s2;
    }

    public void setS2(Float s2) {
        this.s2 = s2;
    }

    public Float getS3() {
        return s3;
    }

    public void setS3(Float s3) {
        this.s3 = s3;
    }

    public String getCinemaPK() {
        return cinemaPK;
    }

    public void setCinemaPK(String cinemaPK) {
        this.cinemaPK = cinemaPK;
    }

    public Integer getSellSrc() {
        return sellSrc;
    }

    public void setSellSrc(Integer sellSrc) {
        this.sellSrc = sellSrc;
    }

    public Integer getTicketingStatus() {
        return ticketingStatus;
    }

    public void setTicketingStatus(Integer ticketingStatus) {
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

    public String getTakeTicketPlace() {
        return takeTicketPlace;
    }

    public void setTakeTicketPlace(String takeTicketPlace) {
        this.takeTicketPlace = takeTicketPlace;
    }

    public Integer getSupportQR() {
        return supportQR;
    }

    public void setSupportQR(Integer supportQR) {
        this.supportQR = supportQR;
    }

    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getRpFor2D() {
        return rpFor2D;
    }

    public void setRpFor2D(Integer rpFor2D) {
        this.rpFor2D = rpFor2D;
    }

    public Integer getRpFor3D() {
        return rpFor3D;
    }

    public void setRpFor3D(Integer rpFor3D) {
        this.rpFor3D = rpFor3D;
    }

    public Long getChannelBit() {
        return channelBit;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }


    public Boolean isUseMachine() {
        return useMachine;
    }

    public void setUseMachine(Boolean useMachine) {
        this.useMachine = useMachine;
    }

    public String getMachinePlacement() {
        return machinePlacement;
    }

    public void setMachinePlacement(String machinePlacement) {
        this.machinePlacement = machinePlacement;
    }

    public String getMachineUsePattern() {
        return machineUsePattern;
    }

    public void setMachineUsePattern(String machineUsePattern) {
        this.machineUsePattern = machineUsePattern;
    }

    public String getMachineImg() {
        return machineImg;
    }

    public void setMachineImg(String machineImg) {
        this.machineImg = machineImg;
    }

    public Boolean hasMaoyanMachine() {
        return hasMaoyanMachine;
    }

    public void setHasMaoyanMachine(Boolean b) {
        hasMaoyanMachine = b;
    }

    public String getRefundDesc() {
        return refundDesc;
    }

    public void setRefundDesc(String refundDesc) {
        this.refundDesc = refundDesc;
    }

    public Boolean canRefund() {
        return allowRefundTag == 1;
    }

    public void setCanRefund(Boolean canRefund) {
        this.canRefund = canRefund;
    }

    public String getFeatureTags() {
        return featureTags;
    }

    public String getAvgScore() {
        return avgScore;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getCityLocationId() {
        return cityLocationId;
    }

    public void setCityLocationId(Integer cityLocationId) {
        this.cityLocationId = cityLocationId;
    }

    public Integer getBareaId() {
        return bareaId;
    }

    public void setBareaId(Integer bareaId) {
        this.bareaId = bareaId;
    }

    public String getBareaName() {
        return bareaName;
    }

    public void setBareaName(String bareaName) {
        this.bareaName = bareaName;
    }

    public void setAvgScore(String avgScore) {
        this.avgScore = avgScore;
    }



    public Integer getBuyNumLimit() {
        return buyNumLimit;
    }

    public void setBuyNumLimit(Integer buyNumLimit) {
        this.buyNumLimit = buyNumLimit;
    }

    public Integer getSellDateLimit() {
        return sellDateLimit;
    }

    public void setSellDateLimit(Integer sellDateLimit) {
        this.sellDateLimit = sellDateLimit;
    }

    public String getStaffNote() {
        return staffNote;
    }

    public void setStaffNote(String staffNote) {
        this.staffNote = staffNote;
    }


    public Integer getVerifyBrandId() {
        return verifyBrandId;
    }

    public void setVerifyBrandId(Integer verifyBrandId) {
        this.verifyBrandId = verifyBrandId;
    }

    public String getVerifyBrand() {
        return verifyBrand;
    }

    public void setVerifyBrand(String verifyBrand) {
        this.verifyBrand = verifyBrand;
    }

    public String getBdLogin() {
        return bdLogin;
    }

    public void setBdLogin(String bdLogin) {
        this.bdLogin = bdLogin;
    }

    public String getBdName() {
        return bdName;
    }

    public void setBdName(String bdName) {
        this.bdName = bdName;
    }

    public String getBdPhone() {
        return bdPhone;
    }

    public void setBdPhone(String bdPhone) {
        this.bdPhone = bdPhone;
    }

    public Integer getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Integer refundTime) {
        this.refundTime = refundTime;
    }


    public Boolean getIsUnionPay() {
        return isUnionPay;
    }

    public void setIsUnionPay(Boolean isUnionPay) {
        this.isUnionPay = isUnionPay;
    }

    public Integer getEndorse() {
        return endorse;
    }

    public void setEndorse(Integer endorse) {
        this.endorse = endorse;
    }

    public Integer getEndorseTime() {
        return endorseTime;
    }

    public void setEndorseTime(Integer endorseTime) {
        this.endorseTime = endorseTime;
    }

    public List<Integer> getGeoCityIds() {
        return geoCityIds;
    }

    public void setGeoCityIds(List<Integer> geoCityIds) {
        this.geoCityIds = geoCityIds;
    }

    public List<Integer> getGeoAreas() {
        return geoAreas;
    }

    public void setGeoAreas(List<Integer> geoAreas) {
        this.geoAreas = geoAreas;
    }

    public String getUniqueLastUpdateTime() {
        return uniqueLastUpdateTime;
    }

    public void setUniqueLastUpdateTime(String uniqueLastUpdateTime) {
        this.uniqueLastUpdateTime = uniqueLastUpdateTime;
    }

    public Integer getGoldenCatConditionFlag() {
        return goldenCatConditionFlag;
    }

    public void setGoldenCatConditionFlag(Integer goldenCatConditionFlag) {
        this.goldenCatConditionFlag = goldenCatConditionFlag;
    }

    /**
     * 是否允许用户自主退款
     *
     * @return
     */
    public Boolean allowRefund() {
        return allowRefundTag == 1;
    }

    /**
     * 是否支持改签
     *
     * @return
     */
    public Boolean allowEndorse() {
        return endorse == 1;
    }

    // 是否允许，客服联系影院手动退票
    public Boolean allowCinemaManualRefund() {
        return allowRefundTag == 2;
    }

    public Integer getAllowRefundTag() {
        return allowRefundTag;
    }

    public void setAllowRefundTag(Integer allowRefundTag) {
        this.allowRefundTag = allowRefundTag;
    }

    public Integer getAllowRefundTime() {
        return allowRefundTime;
    }

    public void setAllowRefundTime(Integer allowRefundTime) {
        this.allowRefundTime = allowRefundTime;
    }

    public Boolean isExclusive() {
        return exclusive;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public void setExclusive(Boolean exclusive) {
        this.exclusive = exclusive;
    }

    public Integer getCloseStatus() {
        return closeStatus;
    }

    public void setCloseStatus(Integer closeStatus) {
        this.closeStatus = closeStatus;
    }

    
    

    public Integer getDpShopId() {
        return dpShopId;
    }

    public void setDpShopId(Integer dpShopId) {
        this.dpShopId = dpShopId;
    }

    public String getShopUUID() {
        return shopUUID;
    }

    public void setShopUUID(String shopUUID) {
        this.shopUUID = shopUUID;
    }

    public Integer getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(Integer investmentId) {
        this.investmentId = investmentId;
    }

    public Boolean isAutoSyncMachineInfo() {
        return isAutoSyncMachineInfo;
    }

    public void setAutoSyncMachineInfo(Boolean autoSyncMachineInfo) {
        isAutoSyncMachineInfo = autoSyncMachineInfo;
    }

    public void setEffectiveChannels(Set<Integer> effectiveChannels) {
        this.effectiveChannels = effectiveChannels;
    }


    public long getSafeCinemaTagSetTime() {
        return safeCinemaTagSetTime;
    }

    public void setSafeCinemaTagSetTime(long safeCinemaTagSetTime) {
        this.safeCinemaTagSetTime = safeCinemaTagSetTime;
    }

    @Override
    public String toString() {
        return "CinemaModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", brandId=" + brandId +
                ", brand='" + brand + '\'' +
                ", verifyBrandId=" + verifyBrandId +
                ", verifyBrand='" + verifyBrand + '\'' +
                ", cityId=" + cityId +
                ", lowerCityId=" + lowerCityId +
                ", uniqueNo=" + uniqueNo +
                ", areaId=" + areaId +
                ", area='" + area + '\'' +
                ", districtId=" + districtId +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", bus='" + bus + '\'' +
                ", subway='" + subway + '\'' +
                ", subwayStation='" + subwayStation + '\'' +
                ", drive='" + drive + '\'' +
                ", park='" + park + '\'' +
                ", notice='" + notice + '\'' +
                ", imgs='" + imgs + '\'' +
                ", avgScore='" + avgScore + '\'' +
                ", serviceContact='" + serviceContact + '\'' +
                ", cinemaPK='" + cinemaPK + '\'' +
                ", sellSrc=" + sellSrc +
                ", ticketingStatus=" + ticketingStatus +
                ", onlineDate=" + onlineDate +
                ", offlineDate=" + offlineDate +
                ", takeTicketPlace='" + takeTicketPlace + '\'' +
                ", validSellMin=" + validSellMin +
                ", supportQR=" + supportQR +
                ", imax=" + imax +
                ", feature='" + feature + '\'' +
                ", startPrice=" + startPrice +
                ", rpFor2D=" + rpFor2D +
                ", rpFor3D=" + rpFor3D +
                ", maoyanOnlineDate=" + maoyanOnlineDate +
                ", createInSecs=" + createInSecs +
                ", lastUpdateInSecs=" + lastUpdateInSecs +
                ", property=" + property +
                ", status=" + status +
                ", movieNum=" + movieNum +
                ", showNum=" + showNum +
                ", snum=" + snum +
                ", s=" + s +
                ", s1=" + s1 +
                ", s2=" + s2 +
                ", s3=" + s3 +
                ", channelBit=" + channelBit +
                ", useMachine=" + useMachine +
                ", machinePlacement='" + machinePlacement + '\'' +
                ", machineUsePattern='" + machineUsePattern + '\'' +
                ", machineImg='" + machineImg + '\'' +
                ", featureTags='" + featureTags + '\'' +
                ", hasMaoyanMachine=" + hasMaoyanMachine +
                ", buyNumLimit=" + buyNumLimit +
                ", adminBuyNumLimit=" + adminBuyNumLimit +
                ", showOriginalPrice=" + showOriginalPrice +
                ", sellDateLimit=" + sellDateLimit +
                ", staffNote='" + staffNote + '\'' +
                ", bdLogin='" + bdLogin + '\'' +
                ", bdName='" + bdName + '\'' +
                ", bdPhone='" + bdPhone + '\'' +
                ", allowRefundTag=" + allowRefundTag +
                ", allowRefundTime=" + allowRefundTime +
                ", exclusive=" + exclusive +
                ", closeStatus=" + closeStatus +
                ", loc='" + loc + '\'' +
                ", majorId=" + majorId +
                ", dpShopId=" + dpShopId +
                ", locationId=" + locationId +
                ", cityLocationId=" + cityLocationId +
                ", bareaId=" + bareaId +
                ", bareaName='" + bareaName + '\'' +
                ", hallType=" + hallType +
                ", canRefund=" + canRefund +
                ", refundTime=" + refundTime +
                ", refundDesc='" + refundDesc + '\'' +
                ", uniqueLastUpdateTime='" + uniqueLastUpdateTime + '\'' +
                ", isUnionPay=" + isUnionPay +
                ", endorse=" + endorse +
                ", endorseTime=" + endorseTime +
                ", geoCityIds=" + geoCityIds +
                ", geoAreas=" + geoAreas +
                ", orderTips='" + orderTips + '\'' +
                ", buyout=" + buyout +
                ", isAutoSyncMachineInfo=" + isAutoSyncMachineInfo +
                ", effectiveChannels=" + effectiveChannels +
                ", investmentId=" + investmentId +
                ", goldenCatConditionFlag=" + goldenCatConditionFlag +
                ", shopUUID='" + shopUUID + '\'' +
                ", mtSource=" + mtSource +
                ", poiId=" + poiId +
                ", poiBrandId=" + poiBrandId +
                ", poiBrandName='" + poiBrandName + '\'' +
                ", safeCinemaTagSetTime=" + safeCinemaTagSetTime+'\''+
                '}';
    }

}
