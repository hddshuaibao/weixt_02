package com.selenium.util;

import com.selenium.base.DriverBase;

public class handleCookie {

	public DriverBase driver;
	public ProUtil pro;
	public handleCookie(DriverBase driver) {
		this.driver = driver;
		this.pro = new ProUtil("E:\\eclipseJEE\\workplace\\weixt_02\\cookie.properties");
	}
}
