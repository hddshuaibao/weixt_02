package com.selenium.page;

import com.selenium.base.DriverBase;
import com.selenium.testCase.LoginTest;
import com.selenium.util.getByLocator;

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
	 * 点击选择班级
	 * */
	public void clickBj(String bjname) {
		List<WebElement> bjlist = this.bjEle();
		for(WebElement bj:bjlist) {
			if(bj.getText().equals(bjname)) {
				this.click(bj);
			}else {
				logger.info("没有找到班级");
			}
		}
	}
	
	/**
	 * 获取radioele
	 * */
	public WebElement radioele(){
		return this.element(getByLocator.getLocator("radioid"));
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
	
	
	
}
