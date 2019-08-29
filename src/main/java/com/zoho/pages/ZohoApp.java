package com.zoho.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zoho.base.Page;

public class ZohoApp extends Page {

	public void gotoCRMHome()
	{
		//driver.findElement(By.xpath("//div[.='CRM'][@class='app-nm']")).click();
		click("crmLnk_XPATH");
	}
}
