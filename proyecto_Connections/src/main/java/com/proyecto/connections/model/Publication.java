package com.proyecto.connections.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Publications")
public class Publication {
	//@Id
	private long id;
	private String author;
	private String urlImage;
	private String title;
	private String type;
	private long likes;
	private long comments;
	public Publication() {}
	
	public Publication(long id, String author, String title, String urlImage, long likes, long comments, String type) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.urlImage = urlImage;
		this.likes = likes;
		this.comments = comments;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public long getLikes() {
		return likes;
	}

	public void setLikes(long likes) {
		this.likes = likes;
	}

	public long getComments() {
		return comments;
	}

	public void setComments(long comments) {
		this.comments = comments;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
