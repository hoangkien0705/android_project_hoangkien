package com.oldenweb.request;

public class User {
	private String id;

	private String yob;

	private String gender;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYob() {
		return yob;
	}

	public void setYob(String yob) {
		this.yob = yob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", yob = " + yob + ", gender = "
				+ gender + "]";
	}
}
