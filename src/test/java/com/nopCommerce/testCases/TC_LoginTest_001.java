package com.nopCommerce.testCases;

import java.io.IOException;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.nopCommerce.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
		
		logger.info("URL is opened......");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User provided");
		
		lp.setPassword(password);
		logger.info("Password provided");
		
		lp.clickLogin();
		logger.info("Login button clicked");
		
		Thread.sleep(2000);
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			lp.clickLogout();
			Assert.assertTrue(true);
			logger.info("Login test passed");
		} else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}
		
}
