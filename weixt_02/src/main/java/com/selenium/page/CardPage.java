package com.selenium.page;

import com.selenium.base.DriverBase;
import com.selenium.testCase.LoginTest;
import com.selenium.util.getByLocator;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;


public class CardPage extends BasePage {
	
	static Logger logger = Logger.getLogger(LoginTest.class); 
	public CardPage(DriverBase driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获取班级ele
	 * */
	public List<WebElement> bjEle(){
		return this.elementList(getByLocator.getLocator("bjlist"));
	}
	/**
	 * 获取班级选择框ele
	 * */
	public WebElement bjselectEle(){
		return this.element(getByLocator.getLocator("bjselect"));
	}
	/**
	 * 点击选择框
	 * */
	public void clickselect() {
		this.click(this.bjselectEle());
	}
	
	/**
	 * 点击选择班级
	 * */
	public void clickBj(String bjname) {
		List<WebElement> bjlist = this.bjEle();
		for(WebElement bj:bjlist) {
			if(bj.getText().equals(bjname)) {
				this.click(bj);
				break;
			}
			//logger.info("没有找到班级");
		}
	}
	
	/**
	 * 获取radioele
	 * */
	public WebElement radioele(){
		return this.element(getByLocator.getLocator("radio"));
	}
	/**
	 * 点击radio
	 * */
	public void clickradio() {
		this.click(this.radioele());
	}
	/**
	 * 获取卡片数量ele
	 * */
	public WebElement cardNoEle() {
		return this.element(getByLocator.getLocator("cardno"));
	}
	/**
	 * 返回卡片数量
	 * */
	public int cardNo() {
		String no = this.cardNoEle().getText();
		int cardno = Integer.parseInt(no);
		return cardno;
	}
	
	/**
	 * 获取卡号输入框ele
	 * */
	public WebElement inputCardEle() {
		return this.element(getByLocator.getLocator("sendcard"));
	}
	/**
	 * 输入卡号
	 * */
	public void sendkeysCard(String card) {
		this.sendKeys(this.inputCardEle(), card);
	}
	/**
	 * 卡号新增按钮ele
	 * */
	public WebElement newCardEle() {
		return this.element(getByLocator.getLocator("newcard"));
	}
	/**
	 * 点击新增按钮
	 * */
	public void clickNewCard() {
		this.click(this.newCardEle());
	}
	
	/**
	 * 获取新增卡号ele
	 * */
	public WebElement cardlistEle() {
		return this.element(getByLocator.getLocator("cardtext"));
	}
	/**
	 * 获取新增卡号
	 * */
	public String addedCardNo() {
		return cardlistEle().getText();
	}
	/**
	 * 获取导出按钮ele
	 * */
	public WebElement exportBtnEle() {
		return this.element(getByLocator.getLocator("exportbtn"));
	}
	/**
	 * 点击导出按钮
	 * */
	public void clickexport() {
		this.click(this.exportBtnEle());
	}
	/**
	 * 返回导出前后文档中文件数
	 * */
	public int fileNumber(String filepath) {
		File dir = new File(filepath);
		File[] dir_contents = dir.listFiles();
		return dir_contents.length;
	}
	/**
	 * 获取删除卡号ele
	 * */
	public WebElement delcardEle() {
		return this.element(getByLocator.getLocator("delcard"));
	}
	
	/**
	 * 点击删除按钮
	 * */
	public void clickdel() {
		this.click(this.delcardEle());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.alertOk();
	}
	
}
