package com.selenium.bussiness;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.selenium.base.DriverBase;
import com.selenium.page.CardPage;



public class CardPro {

	public DriverBase driver;
	public CardPage cp;
	static Logger logger = Logger.getLogger(CardPro.class);
	
	public CardPro(DriverBase driver) {
		this.driver = driver;
		this.cp = new CardPage(driver);
	}
	
	/**
	 * 新增卡号
	 * */
	public void addCard(String cardno) {
		logger.info("开始新增卡号---------------");
		cp.clickselect();
		cp.clickBj("一年（9）班");
		if(cp.bjselectEle().getText().equals("一年（9）班")) {
			logger.info("点击班级成功");
		}else {
			logger.info("点击班级失败");
		}
		cp.clickradio();
		if(cp.radioele().isSelected()) {
			logger.info("点击学生成功");
		}else {
			logger.info("学生点击不成功");
		}
		if(cp.addedCardNo().equals(cardno)) {
			cp.clickdel();
			logger.info("有相同卡号，删除卡号"+cardno);
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//driver.fresh();
		}
		cp.sendkeysCard(cardno);
		logger.info("输入卡号："+cardno);
		cp.clickNewCard();
		logger.info("点击新增");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualno = cp.addedCardNo();
	    Assert.assertEquals(cardno, actualno);
	    logger.info("卡号"+cardno+"新增成功");
	}
	
	/**
	 * 导出卡片名单,验证按钮能否导出
	 * */
	public boolean exportCard(String filepath) {
		int beforeno;
		int afterno;
		beforeno = cp.fileNumber(filepath);
		logger.info("开始导出卡号---------------");
		logger.info("导出前的文件数是"+beforeno);
		cp.clickexport();
		logger.info("点击卡片导出按钮");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		afterno = cp.fileNumber(filepath);
		logger.info("导出后的文件数"+afterno);
		if(beforeno+1==afterno) {
			logger.info("导出卡片成功");
			return true;
		}else {
			logger.info("导出卡片失败");
			return false;
		}
	}
	/**
	 * 删除卡号
	 * */
	public void delcard(String cardno) {
		logger.info("开始删除卡号---------------");
		cp.clickselect();
		cp.clickBj("一年（9）班");
		if(cp.bjselectEle().getText().equals("一年（9）班")) {
			logger.info("点击班级成功");
		}else {
			logger.info("点击班级失败");
		}
		cp.clickradio();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cp.radioele().isSelected()) {
			logger.info("点击选择学生成功");
		}else {
			logger.info("点击选择学生失败");
		}
		if(cp.assertElementIs(cp.delcardEle())) {
			
		}else { 
			logger.info("并没有要删除的卡号");
			this.addCard(cardno);
		}
		cp.clickdel();
		logger.info("点击删除卡号");
		Assert.assertEquals(cp.addedCardNo(), cardno);
		logger.info("删除卡号成功");
	}

}
