package com.ieslasgalletas.back.service;

import java.util.List;

import com.ieslasgalletas.back.entity.Room;
import com.ieslasgalletas.back.entity.User;

public interface RoomService {
	public abstract List<Room> listAllRooms();
	
	public abstract void addRoom(Room room);

	public abstract void updateRoom(Room newRoom, int id);

	public abstract void deleteReservation(int id);
}
