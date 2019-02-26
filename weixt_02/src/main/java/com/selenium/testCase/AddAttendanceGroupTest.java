package com.selenium.testCase;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.base.Browser;
import com.selenium.base.DriverBase;
import com.selenium.bussiness.AttendanceGroupPro;
import com.selenium.bussiness.LoginPro;
import com.selenium.page.AttendanceGroupPage;
import com.selenium.util.ProUtil;
import com.selenium.util.handleCookie;

import junit.framework.Assert;

public class AddAttendanceGroupTest extends CaseBase{

	public DriverBase driver;
	static Logger logger = Logger.getLogger(AddAttendanceGroupTest.class);
	public AttendanceGroupPro agp;
	public AttendanceGroupPage agpage;
	public LoginPro logpro;
	public ProUtil pro;
	public handleCookie handC;
	
	@BeforeClass
	public void BeforeClass() {
		this.driver = InitDriver(Browser.CHROME);
		this.agp = new AttendanceGroupPro(driver);
		this.logpro = new LoginPro(driver);
		this.agpage = new AttendanceGroupPage(driver);
		this.handC = new handleCookie(driver);
		this.pro = new ProUtil("E:\\eclipseJEE\\workplace\\weixt_02\\cookie.properties");
		driver.getUrl(pro.getPro("kqgpUrl"));
		driver.delAllCookies();
		handC.setCookie("JSESSIONID_COOKIE");
		handC.setCookie("JSSSID_COOKIE");
		driver.getUrl(pro.getPro("kqgpUrl"));
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
	
	@AfterClass
	public void afterClass() {
		driver.stop();
	}
	
}
