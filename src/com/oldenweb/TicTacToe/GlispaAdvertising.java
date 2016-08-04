package com.oldenweb.TicTacToe;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.gson.Gson;
import com.oldenweb.request.Banner;
import com.oldenweb.request.Device;
import com.oldenweb.request.Geo;
import com.oldenweb.request.GlispaRequest;
import com.oldenweb.request.Ids;
import com.oldenweb.request.Imp;
import com.oldenweb.request.Site;
import com.oldenweb.request.User;
import com.oldenweb.utils.SaveFileProperties;

public class GlispaAdvertising implements IRequest, Response.Listener<JSONObject>, Response.ErrorListener {
	private String url = "http://rtb-us.platform.glispa.com/native-ad/6e309f982040d88df5973da27fa7bf8e";
	GlispaRequest request = new GlispaRequest();
	private Context context;
	Gson gson = new Gson();
	
	public GlispaAdvertising(Context context) {
		this.context = context;
	}
	
	@Override
	public void excuteRequest() {
		Banner banner = new Banner();
		banner.setId("MainPage-Shuffle");
		banner.setType(1);
		banner.setW(128);
		banner.setH(128);
		Imp imp = new Imp();
		imp.setBanner(banner);
		
		Device device = new Device();
		Ids ids = new Ids();
		ids.setAndroidid(Secure.getString(context.getContentResolver(), Secure.ANDROID_ID));
		try {
			ids.setGaid(AdvertisingIdClient.getAdvertisingIdInfo(context).getId());
		} catch (Exception e) {
		}
		Geo geo = new Geo();
		geo.setCountry("US");
		List<String> listPack = getListPackageUser();
		device.setIds(ids);
		device.setGeo(geo);
		device.setInstapps(listPack.toArray(new String[listPack.size()]));
		device.setIp(getLocalIpAddress());
		device.setOs("android");
		device.setOsv(String.valueOf(Build.VERSION.SDK_INT));
		device.setUa("Mozilla/5.0 (Linux; Android 4.3;Build/JS) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.99 Mobile Safari/537.36");
		
		Site site = new Site();
		site.setId(context.getApplicationContext().getPackageName());
		PackageInfo pInfo;
		try {
			pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
			site.setVer(pInfo.versionName);
		} catch (Exception e) {
		}
		
		User user = new User();
		user.setId("42043");
		
		request.setImp(new Imp[]{imp});
		request.setBcat(new String[]{"34"});//Game-Action
		request.setDevice(device);
		request.setSite(site);
		request.setUser(user);
		
		RequestQueue requestQueue = Volley.newRequestQueue(context);
		String strRequest = gson.toJson(request);
		JsonObjectRequest jsObjRequest = null;
		try {
			jsObjRequest = new JsonObjectRequest(url, new JSONObject(strRequest), this, this);
			jsObjRequest.setShouldCache(false);
			requestQueue.add(jsObjRequest);
		} catch (JSONException e) {
		}
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("URL", url);
		param.put("RequestObj", strRequest);
		Properties requestProperties = new Properties();
		SaveFileProperties saveFile = new SaveFileProperties("/storage/sdcard0/Android/data/request_data.properties", param, "Request", requestProperties);
		saveFile.saveProperties();
	}

	@Override
	public void onResponse(JSONObject arg0) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("Response", gson.toJson(arg0));
		Properties reponseProperties = new Properties();
		SaveFileProperties saveFile = new SaveFileProperties("/storage/sdcard0/Android/data/reponse_data.properties", param, "Reponse", reponseProperties);
		saveFile.saveProperties();
	}

	@Override
	public void onErrorResponse(VolleyError arg0) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("Error", gson.toJson(arg0));
		Properties errorProperties = new Properties();
		SaveFileProperties saveFile = new SaveFileProperties("/storage/sdcard0/Android/data/error_data.properties", param, "Reponse", errorProperties);
		saveFile.saveProperties();
	}
	
	private List<String> getListPackageUser() {
		List<String> listPackage = new ArrayList<>();
		PackageManager pm = context.getPackageManager();
		List<ApplicationInfo> listPackages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
		for (ApplicationInfo itemPack : listPackages) {
			listPackage.add(itemPack.packageName);
		}
		return listPackage;
	}
	
	public String getLocalIpAddress() {
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					InetAddress inetAddress = enumIpAddr.nextElement();

					String ip = inetAddress.getHostAddress().toString();
					return ip;
				}
			}
		} catch (Exception ex) {
			Log.e("IP Address", ex.toString());
		}
		return null;
	}

}
