package com.selenium.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ProUtil {
	private Properties prop;
	private String filepath;
	/**
	 * 构造函数
	 * @throws Exception 
	 * */
	public ProUtil(String filepath){
		this.filepath = filepath;
		this.prop = readProperties();
	}
	/**
	 * 读取配置文件
	 * @throws Exception 
	 * */
	private Properties readProperties(){
		Properties properties = new Properties();
		try {
			
		FileInputStream file = new FileInputStream(filepath);
		InputStream in = new BufferedInputStream(file);	
		properties.load(in);
		in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
	/**
	 * 获取配置文件value
	 * */
	public String getPro(String key) {
		if(prop.containsKey(key)) {
			String keyValue = prop.getProperty(key);
			return keyValue;
		}else {
			System.out.println("关键字不存在");
			return "";
		}
	}
	
	/**
	 * 写入配置文件
	 * */
	public void writePro(String key,String value) {
		try {
			OutputStream out = new FileOutputStream(filepath);
			prop.setProperty(key, value);
			try {
				prop.store(out, "登录获取到的cookie");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
