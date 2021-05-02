package com.ieslasgalletas.back.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ieslasgalletas.back.entity.Room;
import com.ieslasgalletas.back.service.RoomService;

@CrossOrigin
@RestController
public class RoomController {

	@Autowired
	private RoomService roomService;

	@GetMapping("/rooms")
	public List<Room> all() {
		return roomService.listAllRooms();
	}
	
	@GetMapping("/reserves")
	public List<Room> getReservations() {
		return roomService.listAllReservations();
	}

	@GetMapping("/reserve/{id}")
	public List<Room> getReservationsByUser(@PathVariable Integer id){
		return roomService.listAllRoomsByUser(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/rooms")
	public Room addRoom(@RequestBody Room room) {
		return roomService.addRoom(room);
	}

	@PostMapping("/rooms/{id}")
	public Room updateRoom(@RequestBody Room newRoom, @PathVariable int id) {
		return roomService.updateRoom(newRoom, id);
	}
	
	@PostMapping("/reserves")
	public Room newReserve(@RequestBody Room newReserve) {
		return roomService.addReserve(newReserve);
	}

	@DeleteMapping("/reserve/{id}")
	public void deleteReservation(@PathVariable int id) {
		roomService.deleteReservation(id);
	}
	
	@DeleteMapping("/rooms/{id}")
	public void deleteRoom(@PathVariable int id) {
		roomService.deleteRoom(id);
	}
}
