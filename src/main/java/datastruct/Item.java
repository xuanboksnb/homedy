package datastruct;

import datastruct.feature.*;

public class Item {
    private String id;
    private Acreage acreage;
    private Location location;
    private Price price;
    private Content content;
    private RoomNumber roomNumber;
    private Pair<Long, Long> datetime; // timestamp
    private long viewedTime;
    private boolean forSale;
    private int category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Acreage getAcreage() {
        return acreage;
    }

    public void setAcreage(Acreage acreage) {
        this.acreage = acreage;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public RoomNumber getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(RoomNumber roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Pair<Long, Long> getDatetime() {
        return datetime;
    }

    public void setDatetime(Pair<Long, Long> datetime) {
        this.datetime = datetime;
    }

    public long getViewedTime() {
        return viewedTime;
    }

    public void setViewedTime(long viewedTime) {
        this.viewedTime = viewedTime;
    }

    public boolean isForSale() {
        return forSale;
    }

    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
