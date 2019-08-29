package com.zoho.base;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	public static  ExtentReports extent;
	
	public static  ExtentReports geInstance()
	{
		if(extent==null)
		{
			extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html");
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\resources\\extentconfig\\ReportsConfig.xml"));
		
		}
		return extent;
	}
}
