package com.ieslasgalletas.back.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieslasgalletas.back.entity.Room;
import com.ieslasgalletas.back.exception.RoomNotFound;
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
	public Room updateRoom(Room newRoom, int id) {
		Optional<Room> room = roomRepository.findById(id);
		if (!room.isPresent()) {
			throw new RoomNotFound();
		}
		return roomRepository.save(newRoom);
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

	@Override
	public Room addReserve(Room newReserve) {
		Integer number = newReserve.getNumber();
		Room room = roomRepository.findByNumber(number);
		if (room == null) {
			throw new RoomNotFound();
		}
		room.setCheckInDate(newReserve.getCheckInDate());
		room.setCheckOutDate(newReserve.getCheckOutDate());
		return roomRepository.save(room);
	}
}
