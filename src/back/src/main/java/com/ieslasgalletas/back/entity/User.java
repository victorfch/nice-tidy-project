package com.ieslasgalletas.back.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	private Integer id;


	@Column(name = "username", unique = true, nullable = false, length = 45)
	private String username;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "role")
	private String role;

	@Column(name = "password", nullable = false, length = 60)
	private String password;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Room> rooms;

	public User() {
	}

	public User(Integer id, String username, String name, String surname, String role, String password) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getRole() {
		return role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public String getFullName() {
		return name + " " + surname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", surname=" + surname + ", role="
				+ role + ", password=" + password + ", rooms=" + rooms + "]";
	}
}
