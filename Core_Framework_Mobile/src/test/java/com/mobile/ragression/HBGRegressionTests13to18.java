package com.mobile.ragression;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hybrid.mgmt.Constants;
import com.hybrid.mgmt.DataUtil;
import com.hybrid.mgmt.ExtentManager;
import com.hybrid.mgmt.Xls_Reader;
import com.mobile.datamanage.config.BaseTest;
import com.mobile.runner.DriverScript;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class HBGRegressionTests13to18 extends BaseTest{
//	ExtentReports report = ExtentManager.getInstance();
//	ExtentTest test ;
	DriverScript ds ;
	SoftAssert softAssert; 
	String testCaseName="HBGRegressionTests";
	Xls_Reader xls = new Xls_Reader(Constants.DATA_XLS_PATH);
	
	@Test(dataProvider="getData", priority=1)
	public void OpenApp(Hashtable<String,String> data) throws MalformedURLException{
		// reports
		test = rep.startTest("Opening an App and Selecting Parameter as Unit # BW-300 and WO# 15063");
		test.log(LogStatus.INFO, "Starting the test "+testCaseName);
		if(! DataUtil.isTestRunnable(xls, testCaseName) || data.get(Constants.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is NO");
			throw new SkipException("Skipping the test as runmode is NO");
		}
		
		openapp("appHBG");
		test.log(LogStatus.PASS, "Able to launch the App Successfully");
		
		Iclick("Appdata_aid");
		wait(5);
		Iclick("AppDOK_aid");

		//checking();
		//Idriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Production\"]")).click();
		Iclick("categoryLabel_xpath");
		
		Iclick("addreports_xpath");
		wait(5);
		ITouchXNY(363,270);
		Iclick("Done_xpath");
		wait(1);

		//Crew
	    IclickAccs("crewField");
	
	   
	    IclickAccs("Unit # BW-300");

	    //Iclick("woc_xpath");
	    Idriver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"workOrder\"]")).click();
	//    Idriver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"txt_work_order\"]" + "[@visible='true']")).click();
		System.out.println("Please select the First option displayed on IPAD screen");
	  
		sound();
		
		wait(10);
	//	Idriver.findElement(By.xpath("//XCUIElementTypeCell[@name=\"cell - 1\"]")).click();
		
		test.log(LogStatus.PASS, "Able to open New Report successfully");
		
		
	
		
				 //start shift 
				Iclick("selectShiftStart_xpath");
				//auto accept alert 
				checking();
				//IclickAccs("Allow");
				
				//shift shart 
				wait(2);
				Iclick("ShiftStart_xpath");
				Iclick("Done_2toolbar_xpath");
					
				//On site
				wait(2);
				ITouchXNY(391,325);
				wait(2);
				Iclick("Done_2toolbar_xpath");
			//	ITouchXNY(614,592);
				wait(4);
				
				//On Track MP
				IclickAccs("on_track");
				//ITouchXNY(421,415);
				wait(2);
				Iclick("Enter3_xpath");
				wait(3);
				//done 
				Iclick("Done_2toolbar_xpath");
				wait(3);
				
				//workcycles
				Iclick("workcyc_htec_xpath");
				wait(2);
				
				
			
				IclickAccs("btn_toolbar_done");
			//	wait(2);
			//	wait(6);
				
				//crew types
				IclickAccs("crew_Type");
				
		wait(2); 
		IclickAccs("btn_toolbar_done");
		IclickAccs("btn_done_navbar");
		
		test.log(LogStatus.PASS, "Able to Open an App and Selecting Parameter as Unit # BW-300 and WO# 15063");
	}
	

	@Test(priority=2, dependsOnMethods={"OpenApp"})
	public void HBGRegScenario13() throws  InterruptedException{
		test = rep.startTest("HBGRegScenario13");
		test.log(LogStatus.INFO, "Starting the test Verification of Division Field exists and it allows user to change it using Parameter as Unit BW-300 and WO# 15063");
		IclickAccs("Job Info");
		wait(4);
		Iclick("gpslocation_xpath");

		scrolldownToString("Line Segment:");
	
		
		IclickAccs("divison");
		String RRproj="TestRRDivision";
		Itype("Divisioninp_xpath","RRproj");
		Iclick("Done_xpath");
		
	test.log(LogStatus.PASS, "Able to verify Division Field exists and it allows user to change it using Parameter as Unit BW-300 and WO# 15063");

	}
	
	@Test(priority=3)
	public void HBGRegScenario14() throws  InterruptedException{
		test = rep.startTest("HBGRegScenario14");
		test.log(LogStatus.INFO, "Starting the test Verification of Sub-Division Field exists and it allows user to select sub-division from the spinner, using Parameter as Unit BW-300 and WO# 15063");
		
		
		IElementDisplayed("RRSubdivision_aid");

		IclickAccs("sub_division");
		String RRproj="TestRRSubDivision";
		Itype("Subdivisioninp_xpath","RRproj");
		Iclick("Done_xpath");
		

	test.log(LogStatus.PASS, "Able to verify Sub-Division Field exists and it allows user to change it using Parameter as Unit BW-300 and WO# 15063");
	}
	
	@Test(priority=4)
	//@Test(priority=4, dependsOnMethods={"ModProRegScenario2"})
	public void HBGRegScenario15() throws  InterruptedException{
		test = rep.startTest("HBGRegScenario15");
		
		test.log(LogStatus.INFO, "Starting the test on the Job Info screen that the “RR Job No./AFE” field exists and allows the user to type in whatever they want using Parameter as Unit BW-300 and WO# 15063");
		
		IElementDisplayed("RRJob_AFE_aid");
		
		String RRproj="TestRRProj_Costctr";
		Itype("RRJob_AFE_xpath","RRproj");
		Iclick("Done_xpath");
		test.log(LogStatus.PASS, "Able to verify on the Job Info screen that the “RR Job No./AFE” field exists and allows the user to type in whatever they want using Parameter as Unit BW-300 and WO# 15063");
	}
	@Test(priority=5)
	//@Test(priority=5, dependsOnMethods={"ModProRegScenario3"})
	public void HBGRegScenario16() throws  InterruptedException{
		test = rep.startTest("HBGRegScenario16");
		
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the “Region” field DOES NOT exist., using Parameter as Unit BW-300 and WO# 15063");
		
		verifyElementAbsent("Region_aid");
		
		test.log(LogStatus.PASS, "Able to the test that on the Job Info screen that the “Region” field DOES NOT exist., using Parameter as Unit BW-300 and WO# 15063");
		}
	

	
	@Test(priority=6)
	//@Test(priority=7, dependsOnMethods={"ModProRegScenario5"})
	public void HBGRegScenario17() throws  InterruptedException{
		test = rep.startTest("HBGRegScenario17");
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the “RR Proj. #/Cost Ctr” Field does not exists, using Parameter as Unit BW-300 and WO# 15063");
		verifyElementAbsent("RRProj_Costctr_xpath");
		test.log(LogStatus.PASS, "Able to the test Verification of “RR Proj. #/Cost Ctr” Field does not exists, using Parameter as Unit BW-300 and WO# 15063");
	
		}

	@Test(priority=7)
	//@Test(priority=6, dependsOnMethods={"ModProRegScenario4"})
	public void HBGRegScenario18() throws  InterruptedException{
		test = rep.startTest("HBGRegScenario18");
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the RR Word Ord./WLC Field does not exists, using Parameter as Unit BW-300 and WO# 15063");
		verifyElementAbsent("RRworkordWLC_aid");
		test.log(LogStatus.PASS, "Able to the test Verification of RR Word Ord./WLC Field does not exists, using Parameter as Unit BW-300 and WO# 15063");
	
	}
	
	
	
	@BeforeMethod
	public void init() {
		softAssert = new SoftAssert();
		try {
			super.init();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterTest
	public void quit(){
		test.log(LogStatus.INFO, "Closing the App");
		System.out.println("Closing the App");
		 Idriver.quit();
		if(ds!=null)
			ds.getKeywords().closeapp();
		
		if(rep!=null){
			rep.endTest(test);
			rep.flush();
		}
	}
	
	@DataProvider
	public Object[][] getData(){
		return DataUtil.getData(xls, testCaseName);
	}
}
