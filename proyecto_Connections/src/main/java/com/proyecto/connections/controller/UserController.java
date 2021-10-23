package com.proyecto.connections.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.connections.model.User;
import com.proyecto.connections.repository.UserRepository;

import io.swagger.annotations.Api;

@Api(tags = { "Class: UserController" }) // tag defined in SwaggerConfig.java
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/postUser")
	public User postUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@PostMapping("/postListUsers")
	public List<User> postListUsuarios(@RequestBody List<User> users) {
		return userRepository.saveAll(users);
	}

	@GetMapping("/getUser/{id}")
	public User getUsuario(@PathVariable String id) {
		return userRepository.findById(id).get();
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsuario() {
		return userRepository.findAll();
	}

	@GetMapping("/countUsersAge")
	public List<User> countUsersAge() {
		return userRepository.countUsersAge();
	}

	@GetMapping("/findUserGender/{gender}")
	public List<User> findUserGender(@PathVariable String gender) {
		return userRepository.findUserGender(gender);
	}

	@GetMapping("/findUserRol/{rol}")
	public List<User> findUserRol(@PathVariable String rol) {
		return userRepository.findUserRol(rol);
	}

	

	@PutMapping("putUsuario")
	public User putUsuario(@RequestBody User user, @PathVariable String id) {

		User update_user = userRepository.findById(id).get();

		update_user.setNames(user.getNames());
		update_user.setLastNames(user.getLastNames());
		update_user.setAge(user.getAge());
		update_user.setGender(user.getGender());
		update_user.setPublications(user.getPublications());
		update_user.setUser(user.getUser());
		update_user.setPassword(user.getPassword());
		update_user.setEmail(user.getEmail());
		update_user.setRol(user.getRol());
		update_user.setActive(user.isActive());

		userRepository.save(update_user);
		return update_user;
	}

	@DeleteMapping("deleteUser/id")
	public String deleteUsuarioById(@PathVariable String id) {
		userRepository.deleteById(id);
		return "User Deleted!!";
	}

	@DeleteMapping("deleteAllUsers")
	public String deleteAllUsers() {
		userRepository.deleteAll();
		return "Users Deleted!!";
	}
}
