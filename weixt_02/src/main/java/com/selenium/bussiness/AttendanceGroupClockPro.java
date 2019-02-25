package com.selenium.bussiness;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.selenium.base.DriverBase;
import com.selenium.page.AttendanceGroupPage;
import com.selenium.util.ProUtil;


public class AttendanceGroupClockPro {

	public DriverBase driver;
	public AttendanceGroupPage agp;
	static Logger logger = Logger.getLogger(AttendanceGroupClockPro.class);
	public ProUtil pro;
	public AttendanceGroupClockPro(DriverBase driver) {
		this.driver = driver;
		this.agp = new AttendanceGroupPage(driver);
		this.pro = new ProUtil("E:\\eclipseJEE\\workplace\\weixt_02\\element.properties");
	}
	/**
	 * 点击switch 按钮pro
	 * */
	public void switchBtn() {
		String style = agp.getSwitchStyle();
		if(style.equals(pro.getPro("switchShutDStyle"))) {
			Assert.assertEquals(agp.ifDisabled(),true);
			logger.info("按钮置灰下，打卡范围不可输入");
		}else {
			agp.clickSwitch();
			logger.info("按钮开启下，点击置灰");
			Assert.assertEquals(agp.ifDisabled(),true);
			logger.info("按钮置灰下，打卡范围不可输入");
		}
		agp.clickSwitch();
		agp.clickAddress();
		Assert.assertEquals(agp.ifToAmap(), pro.getPro("AmapUrl"));
		
		
	}
	
	
	
	
}
