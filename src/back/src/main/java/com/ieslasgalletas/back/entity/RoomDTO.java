package com.ieslasgalletas.back.entity;

import java.sql.Date;

public class RoomDTO {

    private int id;
    private int number;
    private int bedsNumber;
    private Date checkInDate;
    private Date checkOutDate;
    private boolean isClean;
    private boolean isOccupied;
    private boolean isUrgent;
    private int type;
    private Integer user_id;

    public RoomDTO() {}

    public RoomDTO(int id, int number, int bedsNumber, Date checkInDate, Date checkOutDate, boolean isClean,
                   boolean isOccupied, boolean isUrgent, int type, Integer user_id) {
        super();
        this.id = id;
        this.number = number;
        this.bedsNumber = bedsNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.isClean = isClean;
        this.isOccupied = isOccupied;
        this.isUrgent = isUrgent;
        this.type = type;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBedsNumber() {
        return bedsNumber;
    }

    public void setBedsNumber(int bedsNumber) {
        this.bedsNumber = bedsNumber;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean isClean) {
        this.isClean = isClean;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public void setUrgent(boolean isUrgent) {
        this.isUrgent = isUrgent;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(int userId) {
        this.user_id = userId;
    }

    @Override
    public String toString() {
        return "ReserveMaid [id=" + id + ", number=" + number + ", bedsNumber=" + bedsNumber + ", checkInDate="
                + checkInDate + ", checkOutDate=" + checkOutDate + ", isClean=" + isClean + ", isOccupied=" + isOccupied
                + ", isUrgent=" + isUrgent + ", type=" + type + ", userId=" + user_id + "]";
    }



}