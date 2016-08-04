package com.oldenweb.request;

public class GlispaRequest {
	private Site site;

	private String[] bcat;

	private Imp[] imp;

	private Device device;

	private User user;

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public String[] getBcat() {
		return bcat;
	}

	public void setBcat(String[] bcat) {
		this.bcat = bcat;
	}

	public Imp[] getImp() {
		return imp;
	}

	public void setImp(Imp[] imp) {
		this.imp = imp;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ClassGlispaRequest [site = " + site + ", bcat = " + bcat + ", imp = "
				+ imp + ", device = " + device + ", user = " + user + "]";
	}
}
