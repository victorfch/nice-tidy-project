package com.ieslasgalletas.back.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "rooms")
public class Room {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "number", unique = true)
	private int number;

	@Column(name = "beds_number")
	private int bedsNumber;

	@Column(name = "check_in_date")
	private Date checkInDate;

	@Column(name = "check_out_date")
	private Date checkOutDate;

	@Column(name = "is_clean")
	private boolean isClean;

	@Column(name = "is_occupied")
	private boolean isOccupied;

	@Column(name = "is_urgent")
	private boolean isUrgent;

	@Column(name = "type")
	private int type;

	@ManyToOne()
	@JoinColumn(name = "user_id", nullable = true)
	private User user;


	public Room() {
	}

	public Room(int id, int number, int bedsNumber, Date checkInDate, Date checkOutDate, boolean isClean,
				boolean isOccupied, boolean isUrgent, int type, User user) {
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
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public int getNumber() {
		return number;
	}

	public int getBedsNumber() {
		return bedsNumber;
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

	public Integer getUser_id() {
		if (user == null) {
			return -1;
		}
		return user.getId();
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", number=" + number + ", bedsNumber=" + bedsNumber + ", checkInDate=" + checkInDate
				+ ", checkOutDate=" + checkOutDate + ", isClean=" + isClean + ", isOccupied=" + isOccupied
				+ ", isUrgent=" + isUrgent + ", type=" + type + ", user=" + user + "]";
	}

}
