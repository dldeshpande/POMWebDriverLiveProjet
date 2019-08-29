package com.zoho.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.zoho.base.TestBase;
import com.zoho.pages.HomoPage;
import com.zoho.pages.LoginPage;
import com.zoho.pages.ZohoApp;
import com.zoho.utility.Utilities;

public class LoginTest extends TestBase  {

	@Test(priority =1,dataProviderClass = Utilities.class,dataProvider = "dp")
	public void loginTest(Hashtable<String, String>data)
	{
		if(!data.get("RNMODE").equals("Y"))
		{
			throw new SkipException("Test case RunMode is"+"LoginTest"+"is set to No ");
		}
        HomoPage home = new HomoPage();
		LoginPage lp = home.doLogin();
		ZohoApp zp = new ZohoApp();
		zp = lp.loginAccount(data.get("username"),data.get("password"));
		// zp = lp.loginAccount("dldeshpande", "Talent_123");
	}
}
