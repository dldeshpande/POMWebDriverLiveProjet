package com.zoho.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.zoho.topnavigation.Topnavigation;
import com.zoho.utility.ExcelReader;
import com.zoho.utility.Utilities;

public class Page {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\resources\\excel\\TestData.xlsx");
	public org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("DevpinoyLogger");
	public ExtentReports extent = ExtentManager.geInstance();
	public static  ExtentTest test;
	public static Topnavigation menu;
	public Reporter report = new Reporter();
	
	public Page()
	
	{
	
		if(driver==null)
		{
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\resources\\properties\\config.properties");
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.debug("config file loaded");
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\resources\\properties\\OR.properties");
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.debug("OR file loaded");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	if(config.getProperty("browser").equals("chrome"))
			{
		
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\executable\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	driver = new ChromeDriver(options);
			}
	else if(config.getProperty("browser").equals("firefox"))
	{
		driver = new FirefoxDriver();
	}
	driver.get("https://www.zoho.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	menu = new Topnavigation(driver);
			
	}
}
	public static void quit()
	{
		driver.quit();
	}
	
	public static void click (String locator)
	{
	
		if(locator.endsWith("_ID"))
		{		
		driver.findElement(By.id(OR.getProperty(locator))).click();
		}	
		else if (locator.endsWith("_NAME"))
		{	
			driver.findElement(By.name(OR.getProperty(locator))).click();
		}	
		else if ((locator.endsWith("_XPATH")))
				{	
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}
						
		//test.log(LogStatus.INFO, "Click an Element"+locator);
	}
		
		public static void type (String locator,String value)
		{
		
			if(locator.endsWith("_ID"))
			{		
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);;
			}	
			else if (locator.endsWith("_NAME"))
			{	
				driver.findElement(By.name(OR.getProperty(locator))).sendKeys(value);
			}	
			else if ((locator.endsWith("_XPATH")))
					{	
				driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
			}
			//test.log(LogStatus.INFO, "Type an Element"+locator+"Value is"+value);
		}
			
			public static boolean verifyEquals(String Expected,String Actual) throws IOException
			{
				System.setProperty("org.uncommon.reportng.escap-out", "false");
				try {
					return true;
				} catch (Throwable t) {
					Utilities.captureScreenShots();
					
					Reporter.log("<a> href = "+Utilities.screeName+">ScreenShot</a>" +t.getMessage() );
					Reporter.log("<a> target = \"_blank\" href = "+Utilities.screeName+" \"<img src = "+Utilities.screeName+" height = 450 width =350>\"</img></a>" );
					
					test.addScreenCapture(Utilities.screeName);
					
					
				}
				return false;
				
			}
			
		
	
}
	

