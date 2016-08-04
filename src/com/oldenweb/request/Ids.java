package com.oldenweb.request;

public class Ids {
	private String androidid;

    private String gaid;

    public String getAndroidid ()
    {
        return androidid;
    }

    public void setAndroidid (String androidid)
    {
        this.androidid = androidid;
    }

    public String getGaid ()
    {
        return gaid;
    }

    public void setGaid (String gaid)
    {
        this.gaid = gaid;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [androidid = "+androidid+", gaid = "+gaid+"]";
    }
}
