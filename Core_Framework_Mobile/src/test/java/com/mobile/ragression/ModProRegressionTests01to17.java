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

public class ModProRegressionTests01to17 extends BaseTest{
//	ExtentReports report = ExtentManager.getInstance();
//	ExtentTest test ;
	DriverScript ds ;
	SoftAssert softAssert; 
	String testCaseName="ModProSmokeTests";
	Xls_Reader xls = new Xls_Reader(Constants.DATA_XLS_PATH);
	
	@Test(dataProvider="getData", priority=1)
	public void OpenApp(Hashtable<String,String> data) throws MalformedURLException{
		// reports
		test = rep.startTest("Opening an App and Selecting Parameter as MW-432 and WO#13211");
		test.log(LogStatus.INFO, "Starting the test "+testCaseName);
		if(! DataUtil.isTestRunnable(xls, testCaseName) || data.get(Constants.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is NO");
			throw new SkipException("Skipping the test as runmode is NO");
		}
		
		openapp("appModPro");
		test.log(LogStatus.PASS, "Able to launch the App Successfully");


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
	    scrolldownToString("Unit # MW-432");
	    
	    IclickAccs("Unit # MW-432");
	    
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
		
					test.log(LogStatus.PASS, "Able to Open an App and Selecting Parameter as MW-432 and WO#13211");
	}
	

	@Test(priority=2, dependsOnMethods={"OpenApp"})
	public void ModProRegScenario1() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario1");
		test.log(LogStatus.INFO, "Starting the test Verification of Division Field exists and it allows user to change it using Parameter as MW-432 and WO#13211");
				IclickAccs("Job Info");
				wait(4);
				Iclick("gpslocation_xpath");
		
				scrolldownToString("Division:");
				
				IElementDisplayed("Division_aid");
			
			//	Idriver.findElementByAccessibilityId("Division:").isDisplayed();
				
				IclickAccs("divison");
	
		
				WebElement DatePickerListItem = Idriver.findElement(By.xpath("//XCUIElementTypeSheet[@name=\"Division\"]"));
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
				
				Columns.get(0).sendKeys("CHICAGO");
			
			//	Columns.get(2).sendKeys("20130");
			//	Columns.get(3).sendKeys("PMAM");		
				
				Iclick("Done2_xpath");
		
	
			test.log(LogStatus.PASS, "Able to verify Division Field exists and it allows user to change it using Parameter as MW-432 and WO#13211");
	}
	
	@Test(priority=3, dependsOnMethods={"ModProRegScenario1"})
	public void ModProRegScenario2() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario2");
		test.log(LogStatus.INFO, "Starting the test Verification of Sub-Division Field exists and it allows user to change it using Parameter as MW-432 and WO#13211");
				
				//Idriver.findElementByAccessibilityId("Division:").isDisplayed();
				
				IElementDisplayed("Subdivision_aid");
		
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
				
				Columns.get(0).sendKeys("BROOKFIELD");
			//	wait(7);
			//	Columns.get(2).sendKeys("20130");
			//	Columns.get(3).sendKeys("PMAM");		
				
				Iclick("Done2_xpath");
		
				
	
			test.log(LogStatus.PASS, "Able to verify Sub-Division Field exists and it allows user to change it using Parameter as MW-432 and WO#13211");
	}
	
	@Test(priority=4)
	//@Test(priority=4, dependsOnMethods={"ModProRegScenario2"})
	public void ModProRegScenario3() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario3");
		test.log(LogStatus.INFO, "Starting the test Verification of RR Proj. #/Cost Ctr Field exists and it allows user to type it using Parameter as MW-432 and WO#13211");
				
		IElementDisplayed("RRProj_Costctr_xpath");
		
		String RRproj="TestRRProj_Costctr";
		Itype("RRProj_xpath","RRproj");
		Iclick("Done2_xpath");
				
	
		test.log(LogStatus.PASS, "Able to the test Verification of RR Proj. #/Cost Ctr Field exists and it allows user to type it using Parameter as MW-432 and WO#13211");
	}
	@Test(priority=5)
	//@Test(priority=5, dependsOnMethods={"ModProRegScenario3"})
	public void ModProRegScenario4() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario4");
		test.log(LogStatus.INFO, "Starting the test Verification of RR Work Ord./WLC: Field exists and it allows user to type it using Parameter as MW-432 and WO#13211");
				
		IElementDisplayed("RRworkordWLC_aid");
		
		String RRproj="TestRRProj_Costctr";
		Itype("RRProj_xpath","RRproj");
		
				
	
		test.log(LogStatus.PASS, "Able to the test Verification of RR Work Ord./WLC: Field exists and it allows user to type it using Parameter as MW-432 and WO#13211");
	}
	
	@Test(priority=6)
	//@Test(priority=6, dependsOnMethods={"ModProRegScenario4"})
	public void ModProRegScenario5() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario5");
		test.log(LogStatus.INFO, "Starting the test Verification of RR Job No./AFE: Field exists and it allows user to type it using Parameter as MW-432 and WO#13211");
				
		IElementDisplayed("RRJob_AFE_aid");
		
		String RRproj="TestRRProj_Costctr";
		Itype("RRJob_AFE_xpath","RRproj");
		
				
	
		test.log(LogStatus.PASS, "Able to the test Verification of RR Job No./AFE: Field exists and it allows user to type it using Parameter as MW-432 and WO#13211");
	}
	
	@Test(priority=7)
	//@Test(priority=7, dependsOnMethods={"ModProRegScenario5"})
	public void ModProRegScenario6() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario6");
		test.log(LogStatus.INFO, "Starting the test Verification of Region Field does not exists, using Parameter as MW-432 and WO#13211");
				
		IElementDisplayed("RRJob_AFE_aid");
		
		//if(!isElementPresent("Region_aid"))
			verifyElementAbsent("Region_aid");	
		System.out.println("Region is not Displayed");	
		//reportFailure("Resource is not present by please verify Xpath");
		
		//Idriver.findElement(By.xpath("//XCUIElementTypeCell[@name=\"cell - 1\"]")).click();
		
		test.log(LogStatus.PASS, "Able to the test Verification of Region Field does not exists, using Parameter as MW-432 and WO#13211");
	}

	@Test(priority=8)
	//@Test(priority=8, dependsOnMethods={"ModProRegScenario6"})
	public void ModProRegScenario7() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario7");
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the “Subdivision” field exists and allows the user to select a subdivision from a spinner., using Parameter as MW-406 and WO# 13534");
		
				
		IclickAccs("Done");
		IclickAccs("Back");
		IclickAccs("Save");
		 wait(2);
		Idriver.findElement(By.xpath("//XCUIElementTypeCell[@name=\"cell - 1\"]")).click();
		
		IclickAccs("Edit");
		
		//Unit Field 
		ITouchXNY(339,332);
	   // Iclick("unit_xpath");
	    IclickAccs("Unit # MW-406");
	    
	    //wo
	    ITouchXNY(335,398);
		Iclick("woc_select2_xpath");
		
		IclickAccs("Done");
		
		
		IclickAccs("Job Info");
		IclickAccs("Edit");

		scrolldownToString("Subdivision:");
		
		IElementDisplayed("Subdivision_aid");
	
	//	Idriver.findElementByAccessibilityId("Division:").isDisplayed();
		
		IclickAccs("sub_division");


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
		
		Columns.get(0).sendKeys("IA | CHEROKEE | IA387");
	
	//	Columns.get(2).sendKeys("20130");
	//	Columns.get(3).sendKeys("PMAM");		
		
		Iclick("Done2_xpath");

		
		test.log(LogStatus.PASS, "Able to the test verify that on the Job Info screen that the “Subdivision” field exists and allows the user to select a subdivision from a spinner., using Parameter as MW-406 and WO# 13534");
	}
	
	@Test(priority=9)
	//@Test(priority=9, dependsOnMethods={"ModProRegScenario7"})
	public void ModProRegScenario8() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario8");
		
		test.log(LogStatus.INFO, "Starting the test Verification of RR Proj. #/Cost Ctr Field exists and it allows user to type it using Parameter as MW-406 and WO# 13534");
		
		IElementDisplayed("RRProj_Costctr_xpath");
		
		String RRproj="TestRRProj_Costctr";
		Itype("RRProj2_xpath","RRproj");
		Iclick("Done2_xpath");
				
	
		test.log(LogStatus.PASS, "Able to the test Verification of RR Proj. #/Cost Ctr Field exists and it allows user to type it using Parameter as MW-406 and WO# 13534");		
		
	}
	
	@Test(priority=10)
	//@Test(priority=10, dependsOnMethods={"ModProRegScenario8"})
	public void ModProRegScenario9() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario9");
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the Region Field does not exists, using Parameter as MW-406 and WO# 13534");
		
		
	//	if(!isElementPresent("Region_aid"))
			verifyElementAbsent("Region_aid");
			//System.out.println("Region Field does not exists");
		
		test.log(LogStatus.PASS, "Able to the test Verification of Region Field does not exists, using Parameter as MW-432 and WO#13211");
				
	
	}
	
	@Test(priority=11)
	//@Test(priority=11, dependsOnMethods={"ModProRegScenario9"})
	public void ModProRegScenario10() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario10");
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the Division Field does not exists, using Parameter as MW-406 and WO# 13534");
		

			verifyElementAbsent("Division_name");
			//System.out.println("Division Field does not exists");
		
		test.log(LogStatus.PASS, "Able to the test Verification of Division Field does not exists, using Parameter as MW-406 and WO# 13534");
		
	}
	
	@Test(priority=12)
	//@Test(priority=12, dependsOnMethods={"ModProRegScenario10"})
	public void ModProRegScenario11() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario11");
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the RR Word Ord./WLC Field does not exists, using Parameter as MW-406 and WO# 13534");
		
		//if(!isElementPresent("RRworkordWLC_aid"))RRworkordWLC_aid
			verifyElementAbsent("RRworkordWLC_aid");
			System.out.println("RR Word Ord./WLC Field does not exists");
		
		test.log(LogStatus.PASS, "Able to the test Verification of RR Word Ord./WLC Field does not exists, using Parameter as MW-406 and WO# 13534");
	}

	@Test(priority=13)
	//@Test(priority=13, dependsOnMethods={"ModProRegScenario11"})
	public void ModProRegScenario12() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario12");
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the RR Job No./AFE Field does not exists, using Parameter as MW-406 and WO# 13534");
		
		

			verifyElementAbsent("RRJob_AFE_aid");
			System.out.println("RR Job No./AFEC Field does not exists");
		
		test.log(LogStatus.PASS, "Able to the test Verification of RR Job No./AFE Field does not exists, using Parameter as MW-406 and WO# 13534");
	}
	
	
	@Test(priority=14)
	//@Test(priority=14, dependsOnMethods={"ModProRegScenario12"})
	public void ModProRegScenario13() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario13");
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the “Subdivision” field exists and allows the user to select a subdivision from a spinner., using Parameter as MW-430 and WO# 13066");
		
				
		IclickAccs("Done");
		IclickAccs("Back");
		IclickAccs("Save");
		 wait(2);
		Idriver.findElement(By.xpath("//XCUIElementTypeCell[@name=\"cell - 1\"]")).click();
		
		IclickAccs("Edit");
		
		//Unit Field 
		ITouchXNY(339,332);
	   // Iclick("unit_xpath");
		//going down 
	    scrolldownToString("Unit # MW-430");
	    IclickAccs("Unit # MW-430");
	    
	    //wo
	    ITouchXNY(335,398);
		Iclick("woc_select2_xpath");
		
		IclickAccs("Done");
		
		
		IclickAccs("Job Info");
		IclickAccs("Edit");

		scrolldownToString("Subdivision:");
		
		IElementDisplayed("Subdivision_aid");
	
	//	Idriver.findElementByAccessibilityId("Division:").isDisplayed();
		
		IclickAccs("sub_division");


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
		
		Columns.get(0).sendKeys("AB | CAMROSE | AB607");
	
	//	Columns.get(2).sendKeys("20130");
	//	Columns.get(3).sendKeys("PMAM");		
		
		Iclick("Done2_xpath");

		
		test.log(LogStatus.PASS, "Able to the test verify that on the Job Info screen that the “Subdivision” field exists and allows the user to select a subdivision from a spinner., using Parameter as MW-430 and WO# 13066");
	}
	
	@Test(priority=15)
	//@Test(priority=15, dependsOnMethods={"ModProRegScenario7"})
	public void ModProRegScenario14() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario14");
		
		test.log(LogStatus.INFO, "Starting the test Verification of RR Proj. #/Cost Ctr Field exists and it allows user to type it using Parameter as MW-430 and WO# 13066");
		
		IElementDisplayed("RRProj_Costctr_xpath");
		
		String RRproj="TestRRProj_Costctr";
		IgetElement("RRProj2_xpath").clear();
		Itype("RRProj2_xpath","RRproj");
		Iclick("Done2_xpath");
				
	
		test.log(LogStatus.PASS, "Able to the test Verification of RR Proj. #/Cost Ctr Field exists and it allows user to type it using Parameter as MW-430 and WO# 13066");		
		
	}
	
	
	@Test(priority=16)
	//@Test(priority=16, dependsOnMethods={"ModProRegScenario14"})
	public void ModProRegScenario15() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario15");
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the Region Field does not exists, using Parameter as MW-430 and WO# 13066");
		
			verifyElementAbsent("Region_aid");
		
		test.log(LogStatus.PASS, "Able to the test Verification of Region Field does not exists, using Parameter as MW-430 and WO# 13066");
				
	
	}
	
	@Test(priority=17)
	//@Test(priority=17, dependsOnMethods={"ModProRegScenario15"})
	public void ModProRegScenario16() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario16");
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the Division Field does not exists, using Parameter as MW-430 and WO# 13066");
		

			verifyElementAbsent("Division_name");
			
		
		test.log(LogStatus.PASS, "Able to the test Verification of Division Field does not exists, using Parameter as MW-430 and WO# 13066");
		
	}

	@Test(priority=17)
	//@Test(priority=17, dependsOnMethods={"ModProRegScenario16"})
	public void ModProRegScenario17() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario16");
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the RR Word Ord./WLC Field does not exists, using Parameter as MW-430 and WO# 13066");
		
		//if(!isElementPresent("RRworkordWLC_aid"))RRworkordWLC_aid
			verifyElementAbsent("RRworkordWLC_aid");
			System.out.println("RR Word Ord./WLC Field does not exists");
		
		test.log(LogStatus.PASS, "Able to the test Verification of RR Word Ord./WLC Field does not exists, using Parameter as MW-406 and WO# 13534");
	}

	@Test(priority=18)
	//@Test(priority=18, dependsOnMethods={"ModProRegScenario17"})
	public void ModProRegScenario18() throws  InterruptedException{
		test = rep.startTest("ModProRegScenario18");
		test.log(LogStatus.INFO, "Starting the test verify that on the Job Info screen that the RR Job No./AFE Field does not exists, using Parameter as MW-430 and WO# 13066");
		
		

			verifyElementAbsent("RRJob_AFE_aid");
			System.out.println("RR Job No./AFEC Field does not exists");
		
		test.log(LogStatus.PASS, "Able to the test Verification of RR Job No./AFE Field does not exists, using Parameter as MW-430 and WO# 13066");
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
