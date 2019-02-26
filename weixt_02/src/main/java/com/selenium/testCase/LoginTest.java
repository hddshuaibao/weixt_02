package com.selenium.testCase;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.selenium.base.Browser;
import com.selenium.base.DriverBase;
import com.selenium.bussiness.LoginPro;
import com.selenium.util.handleCookie;

public class LoginTest extends CaseBase{

	public DriverBase driver;
	public LoginPro logpro;
	public handleCookie handcookie;
	static Logger logger = Logger.getLogger(LoginTest.class);
	
	@BeforeClass
	public void BeforeClass() {
		this.driver = InitDriver(Browser.CHROME);
		this.logpro = new LoginPro(driver);
		this.handcookie = new handleCookie(driver);
		
	}
	
	@Test
	public void login() {
		logger.debug("用log4j打印日志 ~~~~~进行登录");
		driver.getUrl("https://www.weixiaotong.com.cn/weixt/login");
		logpro.login("ghzdhcsxxadmin", "102684s");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logpro.assertEquals("光海自动化测试学校管理员");
		logger.info("登录成功");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		handcookie.writeCookie();
		
	}
	
	@AfterClass
	public void AfterTest() {
		driver.stop();
	}
}
