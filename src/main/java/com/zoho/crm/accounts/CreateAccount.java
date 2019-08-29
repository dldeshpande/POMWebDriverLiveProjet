package com.zoho.crm.accounts;

import org.openqa.selenium.By;

import com.zoho.base.Page;
import com.zoho.utility.Utilities;

public class CreateAccount extends Page {

	
	public void createAccount(String name)
	{
		
		//driver.findElement(By.xpath("//input[@type='text'][@class='textField'][@id='Crm_Accounts_ACCOUNTNAME']")).sendKeys(name);
		type("accountTxt_XPATH", name);
	}
}
