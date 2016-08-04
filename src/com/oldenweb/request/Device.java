package com.oldenweb.request;

public class Device {
	private String[] instapps;

    private String os;

    private Geo geo;

    private String osv;

    private Ids ids;

    private String ua;

    private String ip;

    public String[] getInstapps ()
    {
        return instapps;
    }

    public void setInstapps (String[] instapps)
    {
        this.instapps = instapps;
    }

    public String getOs ()
    {
        return os;
    }

    public void setOs (String os)
    {
        this.os = os;
    }

    public Geo getGeo ()
    {
        return geo;
    }

    public void setGeo (Geo geo)
    {
        this.geo = geo;
    }

    public String getOsv ()
    {
        return osv;
    }

    public void setOsv (String osv)
    {
        this.osv = osv;
    }

    public Ids getIds ()
    {
        return ids;
    }

    public void setIds (Ids ids)
    {
        this.ids = ids;
    }

    public String getUa ()
    {
        return ua;
    }

    public void setUa (String ua)
    {
        this.ua = ua;
    }

    public String getIp ()
    {
        return ip;
    }

    public void setIp (String ip)
    {
        this.ip = ip;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [instapps = "+instapps+", os = "+os+", geo = "+geo+", osv = "+osv+", ids = "+ids+", ua = "+ua+", ip = "+ip+"]";
    }
}
