package com.ieslasgalletas.back.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieslasgalletas.back.entity.Room;
import com.ieslasgalletas.back.repository.RoomRepository;
import com.ieslasgalletas.back.service.RoomService;

@Service
public class RoomServiceMySQL implements RoomService {

	private static final Logger LOG = LoggerFactory.getLogger("ProductController");

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public List<Room> listAllRooms() {
		return roomRepository.findAll();
	}
	
	@Override
	public List<Room> listAllReservations() {
		return roomRepository.getReserves();
	}


	@Override
	public List<Room> listAllRoomsByUser(Integer id) {
		return roomRepository.getRoomsByUser(id);
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
			room.setUrgent(false);
			room.setOccupied(false);
			return roomRepository.save(room);
		});
	}
	
	@Override
	public void deleteRoom(int id) {
		roomRepository.deleteById(id);
	}

}
