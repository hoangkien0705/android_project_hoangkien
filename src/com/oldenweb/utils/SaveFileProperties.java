package com.oldenweb.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import android.content.Context;

public class SaveFileProperties {
	private String pathFile;
	private Map<String, String> param;
	private String storeFile;
	private Properties properties;
	
	public SaveFileProperties(String pathFile, Map<String, String> param, String storeFile, Properties properties) {
		this.pathFile = pathFile;
		this.param = param;
		this.storeFile = storeFile;
		this.properties = properties;
	}
	
	public boolean checkLoadConfigFile(Context context) {
		try {
			File configFile = new File(pathFile);
			properties.clear();
			if (configFile.exists()) {
				param.putAll(getContentFile());
			} 
			for (Map.Entry<String, String> entry : param.entrySet()) {
			    properties.setProperty(entry.getKey(), entry.getValue());
			}
			saveProperties();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public  void saveProperties() {
		try {
			File configFile = new File(pathFile);
			FileOutputStream fos = new FileOutputStream(configFile);
			properties.store(fos, storeFile);
		} catch (Exception e) {
		}
	}
	
	public Map<String, String> getContentFile() {
		Properties prop = new Properties();
		Map<String, String> map = new HashMap<>();
		FileInputStream fileStream;
		try {
			fileStream = new FileInputStream(pathFile);
			prop.load(fileStream);
			Enumeration<?> e = prop.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = prop.getProperty(key);
				map.put(key, value);
			}
		} catch (Exception e) {
			return null;
		}
		return map;
	}

}
