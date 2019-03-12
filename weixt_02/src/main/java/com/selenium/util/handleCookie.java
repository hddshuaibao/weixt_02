package com.selenium.util;

import java.util.Set;

import org.openqa.selenium.Cookie;

import com.selenium.base.DriverBase;

public class handleCookie {

	public DriverBase driver;
	public ProUtil pro;
	public handleCookie(DriverBase driver) {
		this.driver = driver;
		this.pro = new ProUtil("E:\\eclipseJEE\\workplace\\weixt_02\\cookie.properties");
	}
	
	public void setCookie190(String cookieName) {
		String value = pro.getPro(cookieName);
		Cookie cookie = new Cookie(cookieName, value);
		driver.setCookie(cookie);
	}
	public void setCookie(String cookieName) {
		String value = pro.getPro(cookieName);
		Cookie cookie = new Cookie(cookieName, value);
		driver.setCookie(cookie);
	}
	
	public void writeCookie() {
		Set<Cookie> cookies = driver.getCookies();
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("JSSSID_COOKIE")) {
				pro.writePro(cookie.getName(), cookie.getValue());
			}else if(cookie.getName().equals("JSESSIONID_COOKIE")) {
				pro.writePro(cookie.getName(), cookie.getValue());
			}
		}
	}
	
}
