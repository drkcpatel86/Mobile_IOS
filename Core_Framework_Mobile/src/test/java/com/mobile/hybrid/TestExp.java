package com.mobile.hybrid;


import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybrid.mgmt.Constants;
import com.hybrid.mgmt.DataUtil;
import com.hybrid.mgmt.ExtentManager;
import com.hybrid.mgmt.Xls_Reader;
import com.mobile.runner.DriverScript;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestExp {
	
	ExtentReports report = ExtentManager.getInstance();
	ExtentTest test ;
	DriverScript ds ;
	String testCaseName="TestExp";
	Xls_Reader xls = new Xls_Reader(Constants.DATA_XLS_PATH);
	
	@Test(dataProvider="getData")
	public void testExp(Hashtable<String,String> data){
		// reports
		test = report.startTest("Test Expend");
		test.log(LogStatus.INFO, "Starting the test "+testCaseName);
		
		if(! DataUtil.isTestRunnable(xls, testCaseName) || data.get(Constants.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is NO");
			throw new SkipException("Skipping the test as runmode is NO");
		}
		
		
		ds = new DriverScript(test);
		test.log(LogStatus.INFO, "Ending the test ");
		ds.getKeywords().reportPass("Test Passed");
		test.log(LogStatus.PASS, "Able to launch the App and Click on the location");
	}
	@AfterMethod
	public void quit(){
		// driver.quit
		if(ds!=null)
			ds.getKeywords().closeapp();
		
		if(report!=null){
			report.endTest(test);
			report.flush();
		}
	}
	
	@DataProvider
	public Object[][] getData(){
		return DataUtil.getData(xls, testCaseName);
	}
	
	
}
