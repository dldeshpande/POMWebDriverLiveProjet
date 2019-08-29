package com.zoho.utility;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.zoho.base.Page;

public class Utilities extends Page {

	static Date d = new Date();
	public static String screeName;
	public static void captureScreenShots() throws IOException
	{
		screeName = d.toString().replace(':', '_').replace(' ', '_')+".png";
		
		File fileSrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(fileSrc, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screeName));
		
	}

@DataProvider(name = "dp")
public Object[][] getData(Method m)
{
	String sheetName = m.getName();
	int rows = excel.getRowCount(sheetName);
	int cols = excel.getColumnCount(sheetName);
	
	Object[][]data = new Object[rows-1][1];
	Hashtable<String, String> table = null;
	for(int rowNum=2;rowNum<=rows;rowNum++)
	{
		table = new Hashtable<String, String>();
	
	for(int colNum = 0; colNum<cols;colNum++)
	{
		table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
		data[rowNum-2][0] = table;
	}
}
	return data;
}

public static boolean isTestRunnable(String testName, ExcelReader excel)
{
	String sheetName = "testsuite";
	String RUNMODE ;
	int rows = excel.getRowCount(sheetName);
	for(int rownum=2;rownum<rows;rownum++)
	{
	String testCase = excel.getCellData(sheetName, "TCID", rownum);
	if(testCase.equalsIgnoreCase(testName))
	{
		RUNMODE = excel.getCellData(sheetName, "RUNMODE", rownum);
		if(RUNMODE.equals("Y"))
				
			return true;
			else
				return false;
	}
	}
	return false;
}
				}
	
	

