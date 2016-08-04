package com.oldenweb.request;

public class Site
{
    private String id;
    private String ver;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	@Override
    public String toString()
    {
        return "ClassPojo [id = "+id+"]";
    }
}