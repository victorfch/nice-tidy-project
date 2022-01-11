package com.ieslasgalletas.back.service;

import java.util.List;

import com.ieslasgalletas.back.entity.Room;
import com.ieslasgalletas.back.entity.RoomDTO;

public interface RoomService {
	public abstract List<Room> listAllRooms();

	public abstract List<Room> listAllReservations();

	public abstract Room addRoom(Room room);

	public abstract Room updateRoom(RoomDTO newRoom, int id);

	public abstract void deleteReservation(int id);

	public abstract void deleteRoom(int id);

	public abstract List<Room> listAllRoomsByUser(Integer id);

	public abstract Room addReserve(Room newReserve);

	public abstract List<Room> getTodayReservations(String format);
}
