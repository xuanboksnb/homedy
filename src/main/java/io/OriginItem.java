package io;

import java.util.Date;

public class OriginItem {
    int id;
    String title;
    String content;
    Integer sellType;
    Float minPrice;
    Float maxPrice;
    Float minArea;
    Float maxArea;
    Integer cateId;
    Integer cityId;
    Integer districtId;
    Integer numBedRoom;
    Integer viewCount;
    Integer callCount;
    Date startDate;
    Date endDate;

    public OriginItem(int id, String title, String content, Integer sellType, Float minPrice, Float maxPrice,
                      Float minArea, Float maxArea, Integer cateId, Integer cityId, Integer districtId,
                      Integer numBedRoom, Integer viewCount, Integer callCount, Date startDate, Date endDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.sellType = sellType;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minArea = minArea;
        this.maxArea = maxArea;
        this.cateId = cateId;
        this.cityId = cityId;
        this.districtId = districtId;
        this.numBedRoom = numBedRoom;
        this.viewCount = viewCount;
        this.callCount = callCount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return String.format("@%s[id=%s, title=%s, content=%s, sellType=%s, minPrice=%s, maxPrice=%s, minArea=%s," +
                        " maxArea=%s, cateId=%s, cityId=%s, districtId=%s, numBedRoom=%s, viewCount=%s, callCount=%s, startDate=%s, endDate=%s]",
                getClass(), id, title, content, sellType, minArea, maxArea, minArea, maxArea, cateId, cityId, districtId, numBedRoom, viewCount, callCount, startDate, endDate);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getSellType() {
        return sellType;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public Float getMinArea() {
        return minArea;
    }

    public Float getMaxArea() {
        return maxArea;
    }

    public Integer getCateId() {
        return cateId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public Integer getNumBedRoom() {
        return numBedRoom;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public Integer getCallCount() {
        return callCount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
