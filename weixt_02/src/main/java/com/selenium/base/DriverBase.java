package com.selenium.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class DriverBase{
	
	public WebDriver driver;
	public DriverBase(Browser browser) {
		 this.driver = DriverFactory.getDriver(browser);
	}
	
	/*
	 * 进入网页
	 * */
	public void getUrl(String url) {
		driver.get(url);
		System.out.println("进入"+url);
	}

	/*
	 * 关闭浏览器
	 * */
	public void stop() {
		driver.close();
		System.out.println("关闭浏览器");
		
	}
	
	
	/**
	 * 定位元素封装
	 * */
	public WebElement findElement(By by) {
		WebElement ele = driver.findElement(by);
		return ele;
	}
	
	/**
	 * 定位元素集合封装
	 * */
	public List<WebElement> findElements(By by) {
		List<WebElement> ele = driver.findElements(by);
		return ele;
	}
	
	/**
	 * 放大页面窗口
	 * */
	public void maxWindow() {
		driver.manage().window().maximize();
		System.out.println("放大浏览器窗口");
	}
	
	/**
	 * 鼠标mouseover操作
	 * */
	public void mouseOverAction(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	/**
	 * 转换到模态框
	 * */
	public void switchToModal() {
		driver.switchTo().activeElement();
	}
	
	
	
	
	
}
