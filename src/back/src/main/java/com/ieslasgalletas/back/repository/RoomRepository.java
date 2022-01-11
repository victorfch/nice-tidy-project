package com.ieslasgalletas.back.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ieslasgalletas.back.entity.Room;
import com.ieslasgalletas.back.entity.RoomDTO;

@Repository
public interface RoomRepository extends JpaRepository<Room, Serializable> {

	@Query(value = "SELECT * from rooms WHERE check_in_date IS NOT NULL", nativeQuery = true)
	public abstract List<Room> getReserves();

	@Query(value = "SELECT * FROM rooms r WHERE r.user_id = :id", nativeQuery = true)
	public abstract List<Room> getRoomsByUser(@Param("id") Integer id);

	@Query(value = "SELECT * from rooms WHERE number = :number", nativeQuery = true)
	public abstract Room findByNumber(@Param("number") Integer number);

	@Query(value = "SELECT * from rooms WHERE check_out_date = :date and is_clean = false", nativeQuery = true)
	public abstract List<Room> getTodayReservations(String date);
}
