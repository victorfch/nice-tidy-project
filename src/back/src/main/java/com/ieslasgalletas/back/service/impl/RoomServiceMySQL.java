package com.ieslasgalletas.back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieslasgalletas.back.entity.Room;
import com.ieslasgalletas.back.repository.RoomRepository;
import com.ieslasgalletas.back.service.RoomService;

@Service
public class RoomServiceMySQL implements RoomService {
	@Autowired
	private RoomRepository roomRepository;

	@Override
	public List<Room> listAllRooms() {
		return roomRepository.findAll();
	}

	@Override
	public Room addRoom(Room room) {
		return roomRepository.save(room);
	}

	
	@Override
	public void updateRoom(Room newRoom, int id) {
		roomRepository.findById(id).map(room -> {
			room.setClean(newRoom.isClean());
			room.setOccupied(newRoom.isOccupied());
			room.setUrgent(newRoom.isUrgent());
			return roomRepository.save(room);
		});
	}

	@Override
	public void deleteReservation(int id) {
		roomRepository.findById(id).map(room -> {
			room.setCheckInDate(null);
			room.setCheckOutDate(null);
			room.setClean(true);
			room.setUrgent(false);
			room.setOccupied(false);
			return roomRepository.save(room);
		});
	}
}
