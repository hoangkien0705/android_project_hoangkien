package com.oldenweb.request;

public class Imp {
	 private Banner banner;

	    public Banner getBanner ()
	    {
	        return banner;
	    }

	    public void setBanner (Banner banner)
	    {
	        this.banner = banner;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [banner = "+banner+"]";
	    }
}
