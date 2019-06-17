package com.mobile.ragression;

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

public class ModProRegressionTests37to42 extends BaseTest{
//	ExtentReports report = ExtentManager.getInstance();
//	ExtentTest test ;
	DriverScript ds ;
	SoftAssert softAssert; 
	String testCaseName="ModProSmokeTests";
	Xls_Reader xls = new Xls_Reader(Constants.DATA_XLS_PATH);
	
	@Test(dataProvider="getData", priority=1)
	public void OpenApp(Hashtable<String,String> data) throws MalformedURLException{
		// reports
		test = rep.startTest("Opening an App and Selecting Parameter as MW-404 and WO# 101603");
		test.log(LogStatus.INFO, "Starting the test "+testCaseName);
		if(! DataUtil.isTestRunnable(xls, testCaseName) || data.get(Constants.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is NO");
			throw new SkipException("Skipping the test as runmode is NO");
		}
		
		openapp("appModPro");
		test.log(LogStatus.PASS, "Able to launch the App Successfully");
		
		Iclick("Appdata_aid");
		wait(5);
		Iclick("AppDOK_aid");
		//checking();
		Idriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Production\"]")).click();
		//Iclick("categoryLabel_xpath");
		
		//Code for new report 
	//	Iclick("categoryLabel_xpath");
		
		//verifyElementAbsent("addreports_xpath");
		Iclick("addreports_xpath");
		wait(4);
		ITouchXNY(363,270);
		
		
		Iclick("Done_xpath");
		wait(1);

		//Unit Field 
	    Iclick("unit_xpath");
	    
	   
	    //going down 
	   // scrolldownToString("Unit # MW-430");
	    
	    IclickAccs("Unit # MW-404");
	    
		//WO#
		Iclick("woc_xpath");
		Iclick("woc_select2_xpath");
		
		//start shift 
				Iclick("selectShiftStart_xpath");
				//auto accept alert 
				checking();
				//IclickAccs("Allow");
				
				//shift shart 
					wait(2);
					Iclick("ShiftStart_xpath");
					Iclick("Done2_xpath");
						
					//On Track 
					wait(4);
					ITouchXNY(391,325);
					wait(4);
					ITouchXNY(614,592);
					wait(4);
					
					//On Track MP
					wait(4);
					ITouchXNY(349,390);
					wait(2);
					Iclick("Enter3_xpath");
					wait(3);
					//done 
					Iclick("Done2_xpath");
					wait(3);
					
					//workcycles
					Iclick("workcycle_xpath");
					wait(2);
					TouchAction touchAction5 = new TouchAction(Idriver);
					wait(2);
					touchAction5.tap(PointOption.point(451, 495)).perform();
					wait(2);
					Iclick("Done2_xpath");
					wait(2);
					wait(6);
					
					TouchAction touchAction6 = new TouchAction(Idriver);
					wait(2);
					touchAction6.tap(PointOption.point(429, 575)).perform();
					wait(2); 
					wait(2);
					Iclick("Done2_xpath");
					wait(2);
					Iclick("Done1_xpath");
					wait(2);
					IclickAccs("Back");
		
					test.log(LogStatus.PASS, "Able to Open an App and Selecting Parameter as MW-404 and WO# 101603");
	}
	


	
	@Test(priority=2)
	//@Test(priority=14, dependsOnMethods={"ModProRegScenario12"})
	public void ModProRegScenario37() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario37");
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the “Region” field exists, and the user can type in to it , using Parameter as MW-404 and WO# 101603");
		
		IclickAccs("Job Info");
		wait(4);
		Iclick("gpslocation_xpath");

		
	

		scrolldownToString("Subdivision:");
				
		IElementDisplayed("Region_aid");
		
			String Region="Testregion";
		//	IgetElement("RRProj2_xpath").clear();
			Itype("Regioninp_xpath",Region);
			Iclick("Done2_xpath");

		
		test.log(LogStatus.PASS, "Able to the test verify that on the Job Info screen that the “Region” field exists, and the user can type in to it, using Parameter as MW-404 and WO# 101603");
	}
	
	@Test(priority=3)
	//@Test(priority=15, dependsOnMethods={"ModProRegScenario7"})
	public void ModProRegScenario38() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario38");
		
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the “Division” field exists, and the user can type in to it , using Parameter as MW-404 and WO# 101603");
		
		IElementDisplayed("Division_aid");
		
		String Region="TestDivision";
		Itype("Divisioninp_xpath",Region);
		Iclick("Done2_xpath");
	
		test.log(LogStatus.PASS, "Able to the test verify that on the Job Info screen that the “Division” field exists, and the user can type in to it, using Parameter as MW-404 and WO# 101603");
		
	}
	
	
	@Test(priority=4)
	//@Test(priority=16, dependsOnMethods={"ModProRegScenario14"})
	public void ModProRegScenario39() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario39");
	test.log(LogStatus.INFO, "Starting the test verify that the “Subdivision” field exists, and the user can type in to it, using Parameter as MW-404 and WO# 101603");
		
		
		
		IElementDisplayed("Subdivision_aid");
		
		String Region="TestSubDivision";
		Itype("Subdivisioninp_xpath",Region);
		Iclick("Done2_xpath");
	
		test.log(LogStatus.PASS, "Able to verify that the “Subdivision” field exists, and the user can type in to it , using Parameter as MW-404 and WO# 101603");		
	}
	
	@Test(priority=5)
	//@Test(priority=17, dependsOnMethods={"ModProRegScenario15"})
	public void ModProRegScenario40() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario40");
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the “RR Job No./AFE” field exist. and user can type in to it, using Parameter as MW-404 and WO# 101603");
		

		IElementDisplayed("RRJob_AFE_aid");
			
		
		test.log(LogStatus.PASS, "Able to the test Verification of RR Job No./AFE Field exists, and user can type in to it using Parameter as MW-404 and WO# 101603");
		
	}

	@Test(priority=6)
	//@Test(priority=17, dependsOnMethods={"ModProRegScenario16"})
	public void ModProRegScenario41() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario41");
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the RR Proj. #/Cost Ctr Field does not exists, using Parameter as MW-404 and WO# 101603");
		
		verifyElementAbsent("RRProj_Costctr_xpath");
			
		
		test.log(LogStatus.PASS, "Able to the test Verification of RR Proj. #/Cost Ctr Field does not exists, using Parameter as MW-404 and WO# 101603");
	}

	@Test(priority=7)
	//@Test(priority=18, dependsOnMethods={"ModProRegScenario17"})
	public void ModProRegScenario42() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario42");
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the RR Word Ord./WLC Field does not exists, using Parameter as MW-404 and WO# 101603");
		
		

			verifyElementAbsent("RRworkordWLC_aid");
			
		
		test.log(LogStatus.PASS, "Able to the test Verification of RR Word Ord./WLC Field does not exists, using Parameter as MW-404 and WO# 101603");
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
