package com.oldenweb.request;

public class Banner {
	private int w;

	private String id;

	private int type;

	private int h;

	public void setW(int w) {
		this.w = w;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setH(int h) {
		this.h = h;
	}

	@Override
	public String toString() {
		return "ClassPojo [w = " + w + ", id = " + id + ", type = " + type
				+ ", h = " + h + "]";
	}
}
