package com.proyecto.connections.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.proyecto.connections.model.Publication;

public interface PublicationRepository extends MongoRepository<Publication, Integer> {

}
