package com.zoho.CRMHomePage;

import org.openqa.selenium.By;

import com.zoho.base.Page;

public class CRMHome extends Page {

	public void goToLeads()
	{
		
	}
	
	public void goToHome()
	{
		driver.findElement(By.id("4157323000000228086")).click();
	}
	
	public void goTocustmize() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[.='Customize Home page']")).click();
		
		
	}
	
}
