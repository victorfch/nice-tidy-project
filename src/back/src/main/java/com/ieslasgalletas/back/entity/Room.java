package com.ieslasgalletas.back.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rooms")
public class Room {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="number")
	private int number;
	
	@Column(name="beds_number")
	private int bedsNumber;
	
	@Column(name="check_in_date")
	private Date checkInDate;
	
	@Column(name="check_out_date")
	private Date checkOutDate;
	
	
	@Column(name="is_clean")
	private boolean isClean;
	
	@Column(name="is_occupied")
	private boolean isOccupied;
	
	@Column(name="is_urgent")
	private boolean isUrgent;
	
	@Column(name="maid_id")
	private int maidId;
	
	@Column(name="type")
	private int type;
	
	
	public Room() {
	}
	

	public Room(int id, int number, int bedsNumber, Date checkInDate, Date checkOutDate, boolean isClean,
			boolean isOccupied, boolean isUrgent, int maidId, int type) {
		super();
		this.id = id;
		this.number = number;
		this.bedsNumber = bedsNumber;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.isClean = isClean;
		this.isOccupied = isOccupied;
		this.isUrgent = isUrgent;
		this.maidId = maidId;
		this.type = type;
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

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public boolean isClean() {
		return isClean;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public boolean isUrgent() {
		return isUrgent;
	}

	public int getMaidId() {
		return maidId;
	}

	public int getType() {
		return type;
	}


	@Override
	public String toString() {
		return "Room [id=" + id + ", number=" + number + ", bedsNumber=" + bedsNumber + ", checkInDate=" + checkInDate
				+ ", checkOutDate=" + checkOutDate + ", isClean=" + isClean + ", isOccupied=" + isOccupied
				+ ", isUrgent=" + isUrgent + ", maidId=" + maidId + ", type=" + type + "]";
	}

}
