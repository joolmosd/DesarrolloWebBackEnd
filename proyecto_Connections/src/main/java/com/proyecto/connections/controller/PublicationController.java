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

import com.proyecto.connections.model.Publication;
import com.proyecto.connections.model.User;
import com.proyecto.connections.repository.PublicationRepository;

import io.swagger.annotations.Api;

@Api(tags = { "Class: PublicationController" }) // tag defined in SwaggerConfig.java
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class PublicationController {

	@Autowired
	PublicationRepository publicationRepository;

	@PostMapping("/postPublication")
	public Publication postPublication(@RequestBody Publication publication) {
		return publicationRepository.save(publication);

	}

	@PostMapping("/postListPublications")
	public List<Publication> postListPublications(@RequestBody List<Publication> publications) {
		return publicationRepository.saveAll(publications);
	}

	@GetMapping("/getPublication/{id}")
	public Publication getPublication(@PathVariable int id) {
		return publicationRepository.findById(id).get();
	}

	@GetMapping("/getAllPublications")
	public List<Publication> getAllPublications() {
		return publicationRepository.findAll();
	}

	@PutMapping("putPublication")
	public Publication putPublication(@RequestBody Publication publication, @PathVariable int id) {
		Publication update_publication = publicationRepository.findById(id).get();
		update_publication.setAutor(publication.getAutor());
		update_publication.setComments(publication.getComments());
		update_publication.setLikes(publication.getLikes());
		update_publication.setTitle(publication.getTitle());
		update_publication.setUrlImage(publication.getUrlImage());
		publicationRepository.save(update_publication);
		return update_publication;

	}

	@DeleteMapping("deletePublication/id")
	public String deleteUsuarioById(@PathVariable int id) {
		publicationRepository.deleteById(id);
		return "Publication Deleted!!";
	}

	@DeleteMapping("deleteAllPublications")
	public String deleteAllUsers() {
		publicationRepository.deleteAll();
		return "Publications Deleted";
	}
}
