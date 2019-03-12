package com.selenium.testCase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.base.Browser;
import com.selenium.base.DriverBase;
import com.selenium.bussiness.CardPro;
import com.selenium.util.ProUtil;
import com.selenium.util.handleCookie;


public class CardTest extends CaseBase{

	public DriverBase driver;
	public CardPro cpro;
	public ProUtil pro;
	public handleCookie handleC;
	String filepath = "C:\\Users\\Administrator\\Downloads";
	
	@BeforeClass
	public void beforeClass() {
		this.driver = InitDriver(Browser.CHROME);
		this.cpro = new CardPro(driver);
		this.handleC = new handleCookie(driver);
		this.pro = new ProUtil("E:\\eclipseJEE\\workplace\\weixt_02\\cookie.properties");
		driver.getUrl(pro.getPro("kqcardUrl"));
		driver.delAllCookies();
		handleC.setCookie190("JSESSIONID_COOKIE");
		handleC.setCookie190("JSSSID_COOKIE");
		driver.getUrl(pro.getPro("kqcardUrl"));
	}
	
	@AfterClass
	public void afterClass() {
		driver.stop();
	}
	/**
	 * 导出测试用例
	 * */
	@Test
	public void testExport() {
		boolean export = cpro.exportCard(filepath);
		Assert.assertEquals(true, export);
	}
	
	@Test
	public void testAddCard() {
		cpro.addCard("1234877441");
	}
	
	
	/**
	 * 删除卡号测试用例
	 * */
	@Test
	public void testDelCard() {
		cpro.delcard("1234877441");
	}
	
	
}
