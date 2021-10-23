package com.proyecto.connections.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.proyecto.connections.model.Publication;

public interface PublicationRepository extends MongoRepository<Publication, Integer> {
	
	@Query("{ 'type' : ?0 }")
	List<Publication> findPublicationByType(String type);
	
	// cuenta cuantos usuarios tienen mayor o igual x años
	@Query("{'likes': {$gte:?0, $lte:?1}}")
	List<Publication> countPublicationLikes(int numOne, int numTwo);


}
