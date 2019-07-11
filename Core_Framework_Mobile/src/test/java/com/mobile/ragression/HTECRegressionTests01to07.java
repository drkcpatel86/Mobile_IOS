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

public class HTECRegressionTests01to07 extends BaseTest{
//	ExtentReports report = ExtentManager.getInstance();
//	ExtentTest test ;
	DriverScript ds ;
	SoftAssert softAssert; 
	String testCaseName="HTECRegressionTests";
	Xls_Reader xls = new Xls_Reader(Constants.DATA_XLS_PATH);
	
	@Test(dataProvider="getData", priority=1)
	public void OpenApp(Hashtable<String,String> data) throws MalformedURLException{
		// reports
		test = rep.startTest("Opening an App and Selecting Parameter as Unit BW-876 and WO# 14472");
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
	    IclickAccs("Crew # TC-005");

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
		
				test.log(LogStatus.PASS, "Able to Open an App and Selecting Parameter as Unit BW-876 and WO# 14472");
	}
	

	@Test(priority=2, dependsOnMethods={"OpenApp"})
	public void HTECRegScenario1() throws  InterruptedException{
		test = rep.startTest("HTECRegScenario1");
		test.log(LogStatus.INFO, "Starting the test Verification of Sub-Division Field exists and it allows user to select sub-division from the spinner, using Parameter as Unit BW-876 and WO# 14472");
		
		IclickAccs("Job Info");
		wait(4);
		Iclick("gpslocation_xpath");

		scrolldownToString("Track ID:");
		
		IElementDisplayed("RRSubdivision_aid");

		IclickAccs("sub_division");
		
		IElementDisplayed("Subdivision_xpath");
		//Idriver.findElement(By.xpath("//XCUIElementTypeSheet[@name=\"SubDivision\"]/XCUIElementTypePicker")).isDisplayed();
		

		WebElement DatePickerListItem = Idriver.findElement(By.xpath("//XCUIElementTypeSheet[@name=\"SubDivision\"]"));
		DatePickerListItem.click();	
		
		
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
		
		Columns.get(0).sendKeys("AL | BEAUMONT | AL377");
	//	wait(7);
	//	Columns.get(2).sendKeys("20130");
	//	Columns.get(3).sendKeys("PMAM");		
		
		Iclick("Done_xpath");

		

	test.log(LogStatus.PASS, "Able to verify Sub-Division Field exists and it allows user to change it using Parameter as BW-876 and WO# 14472");
	
	}
	
	@Test(priority=3)
	public void HTECRegScenario2() throws  InterruptedException{
		test = rep.startTest("HTECRegScenario2");
		test.log(LogStatus.INFO, "Starting the test on the Job Info screen that the “RR Proj. #/Cost Ctr” field exists and allows the user to type in whatever they want using Parameter as BW-876 and WO# 14472");
				
		IElementDisplayed("RRProj_Costctr_xpath");
		
		String RRproj="TestRRProj_Costctr";
		Itype("RRProj_Costctr_htec_xpath","RRproj");
		Iclick("Done_xpath");
				
	
		test.log(LogStatus.PASS, "Able to verify on the Job Info screen that the “RR Proj. #/Cost Ctr” field exists and allows the user to type in whatever they want using Parameter as BW-876 and WO# 14472");
	}
	
	@Test(priority=4)
	//@Test(priority=4, dependsOnMethods={"ModProRegScenario2"})
	public void HTECRegScenario3() throws  InterruptedException{
		test = rep.startTest("HTECRegScenario3");
		
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the “Region” field DOES NOT exist., using Parameter as BW-876 and WO# 14472");
		
		verifyElementAbsent("Region_aid");
		
		test.log(LogStatus.PASS, "Able to the test that on the Job Info screen that the “Region” field DOES NOT exist., using Parameter as BW-876 and WO# 14472");
		}
	@Test(priority=5)
	//@Test(priority=5, dependsOnMethods={"ModProRegScenario3"})
	public void HTECRegScenario4() throws  InterruptedException{
		test = rep.startTest("HTECRegScenario4");
		
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the Division Field does not exists, using Parameter as BW-876 and WO# 14472");
		

		verifyElementAbsent("Division_name");
	
	
		test.log(LogStatus.PASS, "Able to the test Verification of Division Field does not exists, using Parameter as BW-876 and WO# 14472");
	
		}
	

	
	@Test(priority=6)
	//@Test(priority=7, dependsOnMethods={"ModProRegScenario5"})
	public void HTECRegScenario5() throws  InterruptedException{
		test = rep.startTest("HTECRegScenario5");
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the RR Word Ord./WLC Field does not exists, using Parameter as BW-876 and WO# 14472");
		
		verifyElementAbsent("RRworkordWLC_aid");
			
		
		test.log(LogStatus.PASS, "Able to the test Verification of RR Word Ord./WLC Field does not exists, using Parameter as BW-876 and WO# 14472");
	}

	@Test(priority=7)
	//@Test(priority=6, dependsOnMethods={"ModProRegScenario4"})
	public void HTECRegScenario6() throws  InterruptedException{
		test = rep.startTest("HTECRegScenario6");
		test.log(LogStatus.INFO, "Starting the test Verification of RR Job No./AFE: Field exists and it allows user to type it using Parameter as BW-876 and WO# 14472");
				
		verifyElementAbsent("RRJob_AFE_name");
	
		test.log(LogStatus.PASS, "Able to the test Verification of RR Job No./AFE: Field exists and it allows user to type it using Parameter as BW-876 and WO# 14472");
	}
	
	@Test(priority=8)
	//@Test(priority=6, dependsOnMethods={"ModProRegScenario4"})
	public void HTECRegScenario7() throws  InterruptedException{
		test = rep.startTest("HTECRegScenario7");
		test.log(LogStatus.INFO, "Starting the test verify that the Job Role field is added and a value is required in the “Crew Time” screen in the “Crew Time” section of the app., using Parameter as BW-876 and WO# 14472");
		
		IclickAccs("btn_edit_done");
		scrolldownToString("Crew Time");
		IclickAccs("Crew Time");
		IclickAccs("btn_plus");
		IElementDisplayed("Job_Role_aid");
		IElementDisplayed("red_dot_aid");
		
		String RRproj="TestRRProj_Costctr";
		IclickAccs("job_role");
		IclickAccs("toolbar_done");
	
		test.log(LogStatus.PASS, "Able to the verify that the Job Role field is added and a value is required in the “Crew Time” screen in the “Crew Time” section of the app.using Parameter as BW-876 and WO# 14472");
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
