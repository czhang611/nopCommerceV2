package com.nopCommerce.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopCommerce.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	String baseURL = readconfig.getApplicationURL();
	String username = readconfig.getUsername();
	String password = readconfig.getPassword();
//	public String baseURL = "http://admin-demo.nopcommerce.com/";
//	public String username = "admin@yourstore.com";
//	public String password = "admin";

	public static WebDriver driver;

	public static Logger logger;

	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {

		logger = Logger.getLogger("nopEcommerce");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			// Chrome
//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver_win32//chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("edge")) {
			// Edge
			System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
			driver = new EdgeDriver();
		} else if (br.equals("firefox")) {
			// Firefox 0.23.0
//			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
//			driver = new FirefoxDriver();

			// Firefox 0.29.1
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath2());
			driver = new FirefoxDriver();
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public static String randomstring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(6);
		return (generatedString1);
	}
	
	public static String randomNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(5);
		return (generatedString2);
	}
}
