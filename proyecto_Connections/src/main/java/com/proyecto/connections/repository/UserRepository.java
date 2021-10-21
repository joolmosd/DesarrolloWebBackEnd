package com.proyecto.connections.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.proyecto.connections.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	@Query("{ 'names' : /.*?0.*/ }")
	List<User> findUsersByName(String name);

	// cuenta cuantos usuarios tienen mayor o igual 50 años
	@Query("{ 'age' :{$gte:15}  }")
	List<User> countUsersAge();

	// le digo que me traiga los usuarios segun un genero y los ordene de forma
	// Ascendente por la edad
	@Query("{ 'gender' : ?0 }")
	List<User> orderMinByGender(String gender, org.springframework.data.domain.Sort sort);

	// le digo que me traiga los usuarios segun un genero
	@Query("{ 'gender' : ?0 }")
	List<User> findUserGender(String gender);

}
