package com.example.roomfindernepalasn;

public class RentRoomData {

    private String roomDescription;
    private String roomLocation;
    private String roomPrice;
    private int roomImage;

    public RentRoomData(String roomDescription, String roomLocation, String roomPrice, int roomImage) {
        this.roomDescription = roomDescription;
        this.roomLocation = roomLocation;
        this.roomPrice = roomPrice;
        this.roomImage = roomImage;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getRoomLocation() {
        return roomLocation;
    }

    public void setRoomLocation(String roomLocation) {
        this.roomLocation = roomLocation;
    }

    public String getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(int roomImage) {
        this.roomImage = roomImage;
    }
}
