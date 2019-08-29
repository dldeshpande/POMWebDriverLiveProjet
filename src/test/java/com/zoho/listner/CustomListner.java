package com.zoho.listner;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.zoho.base.Page;
import com.zoho.utility.Utilities;

public class CustomListner extends Page implements ITestListener 
{

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		test = extent.startTest(context.getName().toUpperCase());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		try {
			Utilities.captureScreenShots();
		} catch (IOException e) {
			System.setProperty("org.uncommons.reportng.escape-out", "false");
			Reporter.log("<br>");
			Reporter.log("<a href = "+Utilities.screeName+" >screenShot</a>");
			Reporter.log("<br>");
			Reporter.log("<a target = \"_blank\" href = "+Utilities.screeName+" >ScreenShot</a>");
			Reporter.log("<a target = \"_blank\" href = "+Utilities.screeName+" ><\"img src= "+Utilities.screeName+" height =350 width =250\"></img></a>");
		}
		test.log(LogStatus.FAIL, "Test case is Failed"+result.getThrowable());
		test.log(LogStatus.FAIL,test.addScreenCapture(Utilities.screeName));
		extent.endTest(test);
		extent.flush();
		}
		
		
	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
			}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(LogStatus.PASS, "Test Case getting Passed"+result.getName().toUpperCase());
		extent.endTest(test);
		extent.flush();
	}
	

	
	
}
