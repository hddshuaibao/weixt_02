package com.selenium.testCase;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium.base.Browser;
import com.selenium.base.DriverBase;
import com.selenium.bussiness.AttendanceGroupPro;
import com.selenium.bussiness.LoginPro;
import com.selenium.page.AttendanceGroupPage;

import junit.framework.Assert;

public class AddAttendanceGroupTest extends CaseBase{

	public DriverBase driver;
	static Logger logger = Logger.getLogger(AddAttendanceGroupTest.class);
	public AttendanceGroupPro agp;
	public AttendanceGroupPage agpage;
	public LoginPro logpro;
	public AddAttendanceGroupTest() {
		this.driver = InitDriver(Browser.CHROME);
		this.agp = new AttendanceGroupPro(driver);
		this.logpro = new LoginPro(driver);
		this.agpage = new AttendanceGroupPage(driver);
	}
	
	@BeforeTest
	@Parameters({"username","password"})
	public void login(String username,String password) {
		logger.debug("用log4j打印日志 ~~~~~进行登录");
		driver.getUrl("https://www.weixiaotong.com.cn/weixt/login");
		
		logpro.login(username, password);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logpro.assertEquals("光海自动化测试学校管理员");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		agpage.goApplication("考勤安防");
	}
	
	@Test
	public void addBanci() {
		int[] sttimeNo= {9,10};
		int[] endtimeNo= {17,10};
		String banciTime ="09:50-17:50";
		agp.addBanci("自动化班次",sttimeNo,endtimeNo);
		Assert.assertEquals(true, agp.ifHadBanci("自动化班次"));
		Assert.assertEquals(true, agp.checkBanciTime("自动化班次", banciTime));
	}
	
	@AfterTest
	public void afterTest() {
		driver.stop();
	}
	
}
