package com.roytuts.springmvc.jdbc.crud.model;

public class Teacher {

	private int id;
	private String name;
	private String expertise;

	public Teacher() {
	}

	public Teacher(int id, String name, String expertise) {
		this.id = id;
		this.name = name;
		this.expertise = expertise;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

}
