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
	private int id;

	@Column(name = "nickname")
	private String nickname;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "role")
	private String role;

	@Column(name = "password")
	private String password;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Room> rooms;

	public User() {
	}

	public User(int id, String nickname, String name, String surname, String role, String password) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getNickname() {
		return nickname;
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

	public List<Room> getRooms() {
		return rooms;
	}

	public String getFullName() {
		return name + " " + surname;

	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", name=" + name + ", surname=" + surname + ", role="
				+ role + ", password=" + password + "]";
	}
}
