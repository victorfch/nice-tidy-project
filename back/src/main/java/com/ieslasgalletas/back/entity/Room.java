package com.ieslasgalletas.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room {
	
	@Id
	@GeneratedValue
	@Column
	private int id;
	
	@Column(name="room_number")
	private int roomNumber;
	
	@Column(name="is_taken")
	private boolean isTaken;
	
	@Column(name="is_clean")
	private boolean isClean;
	
	public Room() {
	}
	
	public Room(int id, int roomNumber, boolean isTaken, boolean isClean) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.isTaken = isTaken;
		this.isClean = isClean;
	}

	public int getId() {
		return id;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public boolean isTaken() {
		return isTaken;
	}

	public boolean isClean() {
		return isClean;
	}
	

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomNumber=" + roomNumber + ", isTaken=" + isTaken + ", isClean=" + isClean + "]";
	}
	
}
