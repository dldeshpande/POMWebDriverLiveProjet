package com.zoho.base;

import org.testng.annotations.AfterSuite;

public class TestBase {
	
	@AfterSuite
	public void teardown()
	{
	
	Page.quit();

}}
