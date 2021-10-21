package com.proyecto.connections.model;

public class Publication {

	private int id;
	private String autor;
	private String urlImage;
	private boolean title; 
	private long likes;
	private long comments;
	public Publication() {}
	
	public Publication(int id, String autor, boolean title, String urlImage, long likes, long comments) {
		super();
		this.id = id;
		this.autor = autor;
		this.title = title;
		this.urlImage = urlImage;
		this.likes = likes;
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public boolean getTitle() {
		return title;
	}

	public void setTitle(boolean title) {
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
	
	
	
}
