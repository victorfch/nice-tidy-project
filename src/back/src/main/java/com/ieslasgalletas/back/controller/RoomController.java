package com.ieslasgalletas.back.controller;

import java.util.List;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.ieslasgalletas.back.entity.*;
import com.ieslasgalletas.back.service.RoomService;
import com.ieslasgalletas.back.service.UserService;

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

	@PostMapping("/send-to-chambers")
	public boolean sendToChambermaids(@RequestBody List<RoomDTO> rooms) {
		for (RoomDTO room : rooms) {
			roomService.updateRoom(room, room.getId());
		}
		return true;
	}

	@GetMapping("/today/reserves")
	public List<Room> getTodayReservations(){
		Date todayDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return roomService.getTodayReservations(formatter.format(todayDate));
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/rooms")
	public Room addRoom(@RequestBody Room room) {
		return roomService.addRoom(room);
	}

	@PostMapping("/rooms/{id}")
	public Room updateRoom(@RequestBody RoomDTO room, @PathVariable int id) {
		return roomService.updateRoom(room, id);
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
