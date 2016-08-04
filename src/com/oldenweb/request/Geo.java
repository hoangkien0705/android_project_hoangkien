package com.oldenweb.request;

public class Geo {
	 private String lon;

	    private String lat;

	    private String city;

	    private String country;

	    public String getLon ()
	    {
	        return lon;
	    }

	    public void setLon (String lon)
	    {
	        this.lon = lon;
	    }

	    public String getLat ()
	    {
	        return lat;
	    }

	    public void setLat (String lat)
	    {
	        this.lat = lat;
	    }

	    public String getCity ()
	    {
	        return city;
	    }

	    public void setCity (String city)
	    {
	        this.city = city;
	    }

	    public String getCountry ()
	    {
	        return country;
	    }

	    public void setCountry (String country)
	    {
	        this.country = country;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [lon = "+lon+", lat = "+lat+", city = "+city+", country = "+country+"]";
	    }
}
