package com.ieslasgalletas.back.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ieslasgalletas.back.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {
	public abstract User findByUsername(String username);

	@Query(value = "SELECT * from users WHERE role = 'ROLE_CHAMBERMAIDS'", nativeQuery = true)
	public abstract List<User> getChambermaids();
}
