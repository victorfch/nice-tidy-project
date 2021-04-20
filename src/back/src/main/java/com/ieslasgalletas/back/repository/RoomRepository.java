package com.ieslasgalletas.back.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ieslasgalletas.back.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Serializable> {
	
	@Query(value = "SELECT * from rooms WHERE check_in_date IS NOT NULL", nativeQuery = true)
	public abstract List<Room> getReserves();
}
