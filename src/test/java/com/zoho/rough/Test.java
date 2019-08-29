package com.zoho.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.NewSessionPayload;

import com.zoho.CRMHomePage.CRMHome;
import com.zoho.base.Page;
import com.zoho.crm.accounts.CreateAccount;
import com.zoho.pages.HomoPage;
import com.zoho.pages.LoginPage;
import com.zoho.pages.ZohoApp;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		// WebDriver driver;
		
		
		HomoPage home = new HomoPage();
		
		LoginPage lp = home.doLogin();
		ZohoApp zp = lp.loginAccount("dldeshpande", "Talent_123");
		zp.gotoCRMHome();
	
		Thread.sleep(1000);
		CreateAccount ca=	Page.menu.docreateAccount();
        ca.createAccount("testing");
	}

}
