package com.demo.lab2.Application;


public class MeetingRoom {

    private String roomId;
    private int capacity;
    private int floor;

    public MeetingRoom(String meetingId, int capacity, int floor) {
        this.roomId = meetingId;
        this.capacity = capacity;
        this.floor = floor;

    }

    //setter
//    public void setRoomId(String roomId) {
//        this.roomId = roomId;
//    }

    //getter
    public String getRoomId() {
        return roomId;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFloor() {
        return floor;
    }

    public String getRoomDetails() {
        return "Room id: " + roomId + " Capacity: " + capacity + " Floor: " + floor;
    }
}

