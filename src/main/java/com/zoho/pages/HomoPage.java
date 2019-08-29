package com.zoho.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zoho.base.Page;

public class HomoPage extends Page {
	
	public void goToCustomers()
	{
		driver.findElement(By.xpath("(//a[.='Customers'])[2]")).click();
	}
	
	public void goToSupport()
	{
	
		driver.findElement(By.xpath("(//a[.='Support'])[2]")).click();
	}
	public void goToSignUpforFree()
	{
		driver.findElement(By.xpath("//a[.='Free Sign Up']")).click();
	}
	public LoginPage doLogin()
	{
		driver.findElement(By.xpath("//a[.='Login']")).click();
		
		return new LoginPage();
	}
	
}
