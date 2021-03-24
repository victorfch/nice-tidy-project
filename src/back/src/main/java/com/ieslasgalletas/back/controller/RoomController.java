package com.ieslasgalletas.back.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ieslasgalletas.back.entity.Room;
import com.ieslasgalletas.back.service.RoomService;


@RestController
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/rooms")
	public List<Room> all() {
		return roomService.listAllRooms();	
	}

}
