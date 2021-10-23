package com.proyecto.connections.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.proyecto.connections.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	User findByUser(String userName);
	// cuenta cuantos usuarios tienen mayor o igual x años
	@Query("'age': {$gte:?0,$lte:?1}}")
	List<User> countUsersAge();

	// le digo que me traiga los usuarios segun un genero
	@Query("{ 'gender' : ?0 }")
	List<User> findUserGender(String gender);

	// le digo que me traiga los usuarios segun un genero
	@Query("{ 'rol' : ?0 }")
	List<User> findUserRol(String rol);

}
