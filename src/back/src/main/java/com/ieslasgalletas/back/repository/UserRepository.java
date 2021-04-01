package com.ieslasgalletas.back.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ieslasgalletas.back.entity.User;

public interface UserRepository extends JpaRepository<User, Serializable> {
	public abstract User findByUsername(String username);
}
