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

public class HTECFunctionalTests2 extends BaseTest{
//	ExtentReports report = ExtentManager.getInstance();
//	ExtentTest test ;
	DriverScript ds ;
	SoftAssert softAssert; 
	String testCaseName="HTECRegressionTests";
	Xls_Reader xls = new Xls_Reader(Constants.DATA_XLS_PATH);
	
	@Test(dataProvider="getData", priority=1)
	public void OpenApp(Hashtable<String,String> data) throws MalformedURLException{
		// reports
		test = rep.startTest("Opening an App and Selecting Parameter as number TC-098");
		test.log(LogStatus.INFO, "Starting the test "+testCaseName);
		if(! DataUtil.isTestRunnable(xls, testCaseName) || data.get(Constants.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is NO");
			throw new SkipException("Skipping the test as runmode is NO");
		}
		
		openapp("appHTEC");
		test.log(LogStatus.PASS, "Able to launch the App Successfully");
		
		Iclick("Appdata_aid");
		wait(5);
		Iclick("AppDOK_aid");

		//checking();
		//Idriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Production\"]")).click();
		Iclick("categoryLabel_xpath");
		
		Iclick("addreports_xpath");
		
		IclickAccs("txt_date");
		Iclick("Done_toolbar_xpath");
		wait(1);

		//Crew
	    IclickAccs("txt_crew");
	    
		TouchAction action = new TouchAction(Idriver); 
	    action.press(PointOption.point(115, 915)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
	                        .moveTo(PointOption.point(115, 150)).release().perform();
		 
	    TouchAction action2 = new TouchAction(Idriver); 
	     action2.press(PointOption.point(115, 915)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
	                        .moveTo(PointOption.point(115, 150)).release().perform();
	       
	       TouchAction action3 = new TouchAction(Idriver); 
	       action3.press(PointOption.point(115, 915)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
	                        .moveTo(PointOption.point(115, 150)).release().perform();
	       
	    IclickAccs("Crew # TC-098");

	    
	    
//	    Idriver.findElement(By.xpath("//*[@accessibilityLabel='txt_work_order']")).click();
	    Idriver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"txt_work_order\"]" + "[@visible='true']")).click();
		System.out.println("Please select the first option displayed on IPAD screen");
	  
		sound();
		
		wait(10);
		
				 //start shift 
				Iclick("selectShiftStart_xpath");
				//auto accept alert 
				checking();
				//IclickAccs("Allow");
				
				//shift shart 
				wait(2);
				Iclick("ShiftStart_xpath");
				Iclick("Done_toolbar_xpath");
				
				//On site
				wait(2);
				ITouchXNY(391,325);
				wait(2);
				Iclick("Done_toolbar_xpath");
			//	ITouchXNY(614,592);
				wait(4);
				
				//On Track MP
				wait(4);
				ITouchXNY(421,415);
				wait(2);
				Iclick("Enter3_xpath");
				wait(3);
				//done 
				Iclick("Done_toolbar_xpath");
				wait(3);
				
				//workcycles
				Iclick("workcyc_htec_xpath");
				wait(2);
				TouchAction touchAction5 = new TouchAction(Idriver);
				wait(2);
				touchAction5.tap(PointOption.point(427, 495)).perform();
				wait(2);
				Iclick("Done_toolbar_xpath");
			//	wait(2);
			//	wait(6);
				
				//crew types
				TouchAction touchAction6 = new TouchAction(Idriver);
				wait(2);
				touchAction6.tap(PointOption.point(444, 575)).perform();
				wait(2); 
				wait(2);
				Iclick("Done_toolbar_xpath");
				
				
				//Have you 
				Iclick("Straight_edge_xpath");
				IclickAccs("NO");
				Iclick("btn_done_xpath");
		
				test.log(LogStatus.PASS, "Able to Open an App and Selecting Parameter number TC-098");
	}
	

	
	
	@Test(priority=2)
	//@Test(priority=6, dependsOnMethods={"ModProRegScenario4"})
	public void HTECFunctionalTest() throws  InterruptedException{
		test = rep.startTest("HTECRegScenario7");
		test.log(LogStatus.INFO, "Starting the test Able to the verify that User Truck number TC 098 Create a production report with a CN CAN Work Order.  Tap the Crew Time screen, then tap the + to add a new employee.  Verify that the Job Role field exists, that it is required, and it allows the user to select one of the following options from a spinner: Thermite Welder, Supervisor, Operator, Mechanic, Track Worker, or Foreman");
		
		//IclickAccs("btn_edit_done");
		scrolldownToString("Crew Time");
		IclickAccs("Crew Time");
		IclickAccs("btn_plus");
		IElementDisplayed("Job_Role_aid");
		IElementDisplayed("red_dot_aid");
		
		String RRproj="TestRRProj_Costctr";
		IclickAccs("job_role");
		
		
		//WebElement DatePickerListItem = Idriver.findElement(By.xpath("//XCUIElementTypeSheet[@name=\"job_role\"]"));
		//DatePickerListItem.click();	
		
		
		WebElement DatePickerWheel1 = 
				Idriver.findElement(By.xpath("//XCUIElementTypePicker"));		
		List<WebElement> Columns =
				DatePickerWheel1.findElements(By.xpath("//XCUIElementTypePickerWheel"));
		
		JavascriptExecutor js = (JavascriptExecutor)Idriver;
		Map<String, Object> hp = new HashMap<String, Object>(); 
		hp.put("order", "next");
		hp.put("offset", 0.15);
		hp.put("element", Columns.get(0));
		js.executeScript("mobile: selectPickerWheelValue", hp);
		
		
		System.out.println(Columns.get(0).getAttribute("value"));
	//	System.out.println(Columns.get(1).getAttribute("value"));
		Columns.get(0).sendKeys("MECHANIC");
		test.log(LogStatus.PASS, "Able to change job role to MECHANIC in Job Role Wheel Picker");
		
		Columns.get(0).sendKeys("TRACK WORKER");
		test.log(LogStatus.PASS, "Able to change job role to TRACK WORKER in Job Role Wheel Picker");
		
		Columns.get(0).sendKeys("FOREMAN");
		test.log(LogStatus.PASS, "Able to change job role to FOREMAN in Job Role Wheel Picker");
		
		Columns.get(0).sendKeys("THERMITE WELDER");
		test.log(LogStatus.PASS, "Able to change job role to THERMITE WELDER in Job Role Wheel Picker");
		
		Columns.get(0).sendKeys("SUPERVISOR");
		test.log(LogStatus.PASS, "Able to change job role to SUPERVISOR in Job Role Wheel Picker");
		
		Columns.get(0).sendKeys("OPERATOR");
		test.log(LogStatus.PASS, "Able to change job role to SUPERVISOR in Job Role Wheel Picker");
		
	//	wait(7);
	//	Columns.get(2).sendKeys("20130");
	//	Columns.get(3).sendKeys("PMAM");	
		
		
		
		IclickAccs("toolbar_done");
	
		test.log(LogStatus.PASS, "Able to the verify that User Truck number TC 098 Create a production report with a CN CAN Work Order.  Tap the Crew Time screen, then tap the + to add a new employee.  Verify that the Job Role field exists, that it is required, and it allows the user to select one of the following options from a spinner: Thermite Welder, Supervisor, Operator, Mechanic, Track Worker, or Foreman");
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
