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

}
