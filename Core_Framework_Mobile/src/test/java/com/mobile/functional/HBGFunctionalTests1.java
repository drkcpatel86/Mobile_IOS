package com.mobile.functional;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

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
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class HBGFunctionalTests1 extends BaseTest{
//	ExtentReports report = ExtentManager.getInstance();
//	ExtentTest test ;
	DriverScript ds ;
	SoftAssert softAssert; 
	String testCaseName="HTECRegressionTests";
	Xls_Reader xls = new Xls_Reader(Constants.DATA_XLS_PATH);
	
	@Test(dataProvider="getData", priority=1)
	public void OpenApp(Hashtable<String,String> data) throws MalformedURLException{
		// reports
		test = rep.startTest("Opening an App and Selecting Parameter as number Unit # BW-876");
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
		wait(2);
		ITouchXNY(363,270);
		Iclick("Done_xpath");
		wait(1);


		//Crew
	    IclickAccs("crewField");
	  //going down 
	    scrolldownToString("Unit # BW-876");
	    IclickAccs("Unit # BW-876");

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
				IclickAccs("Save");
				test.log(LogStatus.PASS, "Able to Open an App, Selecting Parameter number BW-876 and supplying all the details");
	}
	

	
	
	@Test(priority=2)
	//@Test(priority=6, dependsOnMethods={"ModProRegScenario4"})
	public void HBGFunctionalTest() throws  InterruptedException{
		test = rep.startTest("HBGFunction1");
		test.log(LogStatus.INFO, "Starting the test with parameter BW-876, verify the Frog Build 570 3/16 displayed on inventory usage screen");
		
		wait(2);
		Idriver.findElement(By.xpath("//XCUIElementTypeCell[@name=\"cell - 1\"]")).click();
		
		//scrolldownToString("Inventory Usage");
		IclickAccs("Inventory Usage (8)");
		
		//
		if (verifyElementPresent("FrongBuild_aid")) {
			  System.out.println("Element Frog Build 570 3/16 found on the first page");
			} else { 
			  // block of code to be executed if the condition is false
				System.out.println("Element didnot found on the first page so scolling down for finding the element");
				scrolldownToString("FrongBuild_aid");
				verifyElementPresent("FrongBuild_aid");
				System.out.println("Element Frog Build 570 3/16 found on the second page");
			}
		

	
		test.log(LogStatus.PASS, "Able to the test with parameter BW-876, verify the Frog Build 570 3/16 displayed on inventory usage screen");
	}
	
	@Test(priority=3)
	//@Test(priority=6, dependsOnMethods={"ModProRegScenario4"})
	public void HBGFunctionalTest2() throws  InterruptedException{
		test = rep.startTest("HBGFunction2");
		test.log(LogStatus.INFO, "Starting the test with parameter BW-876, verify the Low Hydrogen Mild Steel Rod displayed on inventory usage screen");
		
		//
		
		try {
			//IgetElement("Lowhydrogen_aid").isDisplayed()	;
			Idriver.findElementByAccessibilityId("EI100151").isDisplayed();
			System.out.println("Element Low Hydrogen Mild Steel Rod found on the first page");		
			}
			catch(Exception e) {
			  //  Block of code to handle errors
				System.out.println("Element didnot found on the first page so scolling down for finding the element");
				scrolldownToString("EI100151");
				verifyElementPresent("Lowhydrogen_aid");
				System.out.println("Element Low Hydrogen Mild Steel Rod found on the second page");
			}

	
		test.log(LogStatus.PASS, "Able to the test with parameter BW-876, verify the Low Hydrogen Mild Steel Rod displayed on inventory usage screen");
	}
	
	@Test(priority=4)
	//@Test(priority=6, dependsOnMethods={"ModProRegScenario4"})
	public void HBGFunctionalTest3() throws  InterruptedException{
		test = rep.startTest("HBGFunction3");
		test.log(LogStatus.INFO, "Starting the test with parameter BW-876, verify the Surfacing Stone 6 * 3 displayed on inventory usage screen");
		
		//
		
		try {
			//IgetElement("SurfacingStone_aid").isDisplayed()	;	
			Idriver.findElementByAccessibilityId("EI100100").isDisplayed();
			System.out.println("Element Surfacing Stone 6 * 3 found on the first page");		
			}
			catch(Exception e) {
			  //  Block of code to handle errors
				System.out.println("Element didnot found on the first page so scolling down for finding the element");
				scrolldownToString("EI100100");
				verifyElementPresent("SurfacingStone_aid");
				System.out.println("Element Surfacing Stone 6 * 3 found on the second page");
			}

	
		test.log(LogStatus.PASS, "Able to the test with parameter BW-876, verify the Surfacing Stone 6 * 3 displayed on inventory usage screen");
	}
	
	@Test(priority=5)
	//@Test(priority=6, dependsOnMethods={"ModProRegScenario4"})
	public void HBGFunctionalTest4() throws  InterruptedException{
		test = rep.startTest("HBGFunction4");
		test.log(LogStatus.INFO, "Starting the test with parameter BW-876, verify the Hydralic Impact Wr. displayed on inventory usage screen");
		
		//
		
		try {
			Idriver.findElementByAccessibilityId("PR112-HW").isDisplayed();
			//IgetElement("HydralicImpact_aid").isDisplayed()	;	
			System.out.println("Element Hydralic Impact Wr. found on the first page");		
			}
			catch(Exception e) {
			  //  Block of code to handle errors
				System.out.println("Element didnot found on the first page so scolling down for finding the element");
				scrolldownToString("PR112-HW");
				verifyElementPresent("HydralicImpact_aid");
				System.out.println("Element Hydralic Impact Wr. found on the second page");
			}

	
		test.log(LogStatus.PASS, "Able to the test with parameter BW-876, verify the Hydralic Impact Wr.  displayed on inventory usage screen");
	}
	
	@Test(priority=6)
	//@Test(priority=6, dependsOnMethods={"ModProRegScenario4"})
	public void HBGFunctionalTest5() throws  InterruptedException{
		test = rep.startTest("HBGFunction5");
		test.log(LogStatus.INFO, "Starting the test with parameter BW-876, verify the EQUIPMENT-Cutting Torch Oxi displayed on inventory usage screen");
		
		//
		
		try {
			Idriver.findElementByAccessibilityId("EQUIPMENT-Cutting Torch Oxi").isDisplayed();
			//IgetElement("CuttingTorch_aid").isDisplayed()	;	
			System.out.println("Element EQUIPMENT-Cutting Torch Ox found on the first page");		
			}
			catch(Exception e) {
			  //  Block of code to handle errors
				System.out.println("Element didnot found on the first page so scolling down for finding the element");
				scrolldownToString("PR112-CT");
				verifyElementPresent("CuttingTorch_aid");
				System.out.println("Element EQUIPMENT-Cutting Torch Ox found on the second page");
			}

	
		test.log(LogStatus.PASS, "Able to the test with parameter BW-876, verify the Hydralic Impact Wr.  displayed on inventory usage screen");
	}
	@Test(priority=7)
	//@Test(priority=6, dependsOnMethods={"ModProRegScenario4"})
	public void HBGFunctionalTest6() throws  InterruptedException{
		test = rep.startTest("HBGFunction6");
		test.log(LogStatus.INFO, "Starting the test with parameter BW-876, verify the Straight Grinding Stone 1 * 8 displayed on inventory usage screen");
		
		//
		
		try {
			Idriver.findElementByAccessibilityId("EI100101").isDisplayed();
			//IgetElement("Straight_Grindin_aid").isDisplayed()	;	
			System.out.println("Element Straight Grinding Stone 1 * 8 found on the first page");		
			}
			catch(Exception e) {
			  //  Block of code to handle errors
				System.out.println("Element didnot found on the first page so scolling down for finding the element");
				scrolldownToString("EI100101");
				Idriver.findElementByAccessibilityId("EI100101").isDisplayed();
				System.out.println("Element Straight Grinding Stone 1 * 8 found on the second page");
			}

	
		test.log(LogStatus.PASS, "Able to the test with parameter BW-876, verify the Straight Grinding Stone 1 * 8 displayed on inventory usage screen");
	}
	
	@Test(priority=8)
	//@Test(priority=6, dependsOnMethods={"ModProRegScenario4"})
	public void HBGFunctionalTest7() throws  InterruptedException{
		test = rep.startTest("HBGFunction7");
		test.log(LogStatus.INFO, "Starting the test with parameter BW-876, verify the Fuel Charge displayed on inventory usage screen");
		
		//
		
		try {
			Idriver.findElementByAccessibilityId("Fuel Charge").isDisplayed();
			//IgetElement("fuelCharge_aid").isDisplayed()	;	
			System.out.println("Element  Fuel Charge found on the first page");		
			}
			catch(Exception e) {
			  //  Block of code to handle errors
				System.out.println("Element didnot found on the first page so scolling down for finding the element");
				scrolldownToString("PR023");
				verifyElementPresent("fuelCharge_aid");
				System.out.println("Element Fuel Charge found on the second page");
			}

	
		test.log(LogStatus.PASS, "Able to the test with parameter BW-876, verify the Fuel Charge displayed on inventory usage screen");
	}
	
	@Test(priority=9)
	//@Test(priority=6, dependsOnMethods={"ModProRegScenario4"})
	public void HBGFunctionalTest8() throws  InterruptedException{
		test = rep.startTest("HBGFunction9");
		test.log(LogStatus.INFO, "Starting the test with parameter BW-876, verify the Billable Helper displayed on inventory usage screen");
		
		//
		
		try {
			Idriver.findElementByAccessibilityId("Billable Helper").isDisplayed();
			//IgetElement("BillableHelper_aid").isDisplayed()	;	
			System.out.println("Element found on the first page");		
			}
			catch(Exception e) {
			  //  Block of code to handle errors
				System.out.println("Element Billable Helper didnot found on the first page so scolling down for finding the element");
				scrolldownToString("PR024");
				verifyElementPresent("BillableHelper_aid");
				System.out.println("Element Billable Helper found on the second page");
			}

	
		test.log(LogStatus.PASS, "Able to the test with parameter BW-876, verify the Billable Helper displayed on inventory usage screen");
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
