package com.ieslasgalletas.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ieslasgalletas.back.entity.Room;
import com.ieslasgalletas.back.service.RoomService;

@RestController
public class RoomController {

	@Autowired
	private RoomService roomService;

	@CrossOrigin
	@GetMapping("/rooms")
	public List<Room> all() {
		return roomService.listAllRooms();
	}
	
	@CrossOrigin
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/rooms")
	public Room addRoom(@RequestBody Room room) {
		return roomService.addRoom(room);
	}

	@PutMapping("/rooms/{id}")
	public void updateRoom(@RequestBody Room newRoom, @PathVariable int id) {
		roomService.updateRoom(newRoom, id);
	}

	@PutMapping("/reserve/{id}")
	public void deleteReservation(@PathVariable int id) {
		roomService.deleteReservation(id);
	}
	
	@CrossOrigin
	@DeleteMapping("/rooms/{id}")
	public void deleteRoom(@PathVariable int id) {
		roomService.deleteRoom(id);
	}
}
