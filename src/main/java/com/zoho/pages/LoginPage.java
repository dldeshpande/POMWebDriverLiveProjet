package com.zoho.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zoho.base.Page;

public class LoginPage extends Page {

	public ZohoApp loginAccount(String username,String password)
	{
		/*driver.findElement(By.name("lid")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		
		driver.findElement(By.id("signin_submit")).click();*/
		type("userName_NAME", username);
		type("password_NAME", password);
		click("signBtn_ID");
		return new ZohoApp();
	}
}
