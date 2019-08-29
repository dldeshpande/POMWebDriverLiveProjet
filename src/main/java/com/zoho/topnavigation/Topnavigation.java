package com.zoho.topnavigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zoho.base.Page;
import com.zoho.crm.accounts.CreateAccount;

public class Topnavigation {
	
	public static WebDriver driver;

	public Topnavigation(WebDriver driver) {
		
		this.driver = driver;
		
		}
	
	public void goToLeads()
	{
		driver.findElement(By.xpath("//a[.='Leads']")).click();
	}
	public void goToContacts()
	{
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
	}
	public void goToAccounts()
	{
		driver.findElement(By.xpath("//a[.='Accounts']")).click();
	}
	public void goToDeals()
	{
		driver.findElement(By.xpath("//a[.='Deals']")).click();
	}
	
	public CreateAccount docreateAccount()
	{
		/*driver.findElement(By.xpath("//span[contains(@class,'svgIcons')][@id='createIcon']")).click();
		driver.findElement(By.id("submenu_Accounts")).click();*/
		Page.click("createAccntLnk_XPATH");
		Page.click("subMenuLnk_ID");
		return new CreateAccount();
		
	}
}
