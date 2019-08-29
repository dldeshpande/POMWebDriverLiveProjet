package com.zoho.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.zoho.base.Page;
import com.zoho.base.TestBase;
import com.zoho.crm.accounts.CreateAccount;
import com.zoho.pages.HomoPage;
import com.zoho.pages.LoginPage;
import com.zoho.pages.ZohoApp;
import com.zoho.utility.Utilities;

public class CreateAccountTest extends Page {
	@Test(priority =1,dataProviderClass = Utilities.class,dataProvider = "dp")
	public void loginTest(Hashtable<String, String>data)
	{
		
        HomoPage home = new HomoPage();
		LoginPage lp = home.doLogin();
		ZohoApp zp = new ZohoApp();
		zp = lp.loginAccount(data.get("username"),data.get("password"));
	}
	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void createAccountTest(Hashtable<String, String> data)
	{
		/*if(!Utilities.isTestRunnable("CreateAccountTest", excel))
				{
			throw new SkipException("Test case" +"CreateAccountTest"+" RunMode Set as N");
				}*/
		ZohoApp zp = new ZohoApp();
		zp.gotoCRMHome();
		CreateAccount ca=	Page.menu.docreateAccount();
        ca.createAccount(data.get("accountname"));
	}

}
