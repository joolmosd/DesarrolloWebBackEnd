package com.proyecto.connections.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {
	// @Id
	private String identification;
	private String names;
	private String lastNames;
	private String gender;
	private String password;
	private String user;
	private String email;
	private String rol;
	private boolean active;
	private int age;
	List<Publication> publications;

	public User() {
	}

	public User(String identification, String names, String lastNames, int age, String gender,
			List<Publication> publications, String user, String password, String email, String rol, boolean active) {
		super();
		this.identification = identification;
		this.names = names;
		this.lastNames = lastNames;
		this.age = age;
		this.gender = gender;
		this.publications = publications;
		this.email = email;
		this.user = user;
		this.password = password;
		this.rol = rol;
		this.active = active;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastNames() {
		return lastNames;
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
