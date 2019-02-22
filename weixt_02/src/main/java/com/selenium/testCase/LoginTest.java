package com.selenium.testCase;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.selenium.base.Browser;
import com.selenium.base.DriverBase;
import com.selenium.bussiness.LoginPro;

public class LoginTest extends CaseBase{

	public DriverBase driver;
	public LoginPro logpro;
	static Logger logger = Logger.getLogger(LoginTest.class);
	public LoginTest() {
		this.driver = InitDriver(Browser.CHROME);
		this.logpro = new LoginPro(driver);
	}
	
	/**
	 * 进入微校通登录页
	
	@Test(dependsOnMethods= {"getLoginPage"})
	public void getLoginPage() {
		driver.getUrl("https://www.weixiaotong.com.cn/weixt/login");
		driver.maxWindow();
		try {
			driver.sleep();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 * */
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
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.stop();
	}
	
}
