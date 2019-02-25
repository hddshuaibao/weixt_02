package com.selenium.page;

import com.selenium.base.Browser;
import com.selenium.base.DriverBase;
import com.selenium.bussiness.AttendanceGroupClockPro;
import com.selenium.util.ProUtil;
import com.selenium.util.getByLocator;

public class Test {
	
	
	public static void main (String[] args) {
		DriverBase driver = new DriverBase(Browser.CHROME);
		ProUtil pro = new ProUtil("E:\\eclipseJEE\\workplace\\weixt_02\\login.properties");
		LoginPage lp = new LoginPage(driver);
		AttendanceGroupPage agp = new AttendanceGroupPage(driver);
		AttendanceGroupClockPro agcp = new AttendanceGroupClockPro(driver);
		driver.getUrl(pro.getPro("url"));
		lp.sendkeysUser(pro.getPro("username"));
		lp.sendkeysPassword(pro.getPro("password"));
		lp.clickLoginBtn();
		lp.goApplication(pro.getPro("appname"));
		agp.buttonClick("设置扫码签到/考勤提醒");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		agcp.switchBtn();
		
		//System.out.println(getByLocator.getLocator("password"));
		//System.out.println(lp.getuserEle());
		//System.out.println(lp.element(getByLocator.getLocator("password")));
	}
}
