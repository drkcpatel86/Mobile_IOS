package com.mobile.datamanage.config;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.mobile.runner.DriverScript;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class HTECSmokeTests extends BaseTest{
//	ExtentReports report = ExtentManager.getInstance();
//	ExtentTest test ;
	DriverScript ds ;
	SoftAssert softAssert; 
	String testCaseName="HTECSmokeTests";
	Xls_Reader xls = new Xls_Reader(Constants.DATA_XLS_PATH);
	
	@Test(dataProvider="getData", priority=1)
	public void OpenApp(Hashtable<String,String> data) throws MalformedURLException{
		// reports
		test = rep.startTest("Open App "+testCaseName);
		test.log(LogStatus.INFO, "Starting the test "+testCaseName);
		if(! DataUtil.isTestRunnable(xls, testCaseName) || data.get(Constants.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is NO");
			throw new SkipException("Skipping the test as runmode is NO");
		}
		
		openapp("appHTEC");
		test.log(LogStatus.PASS, "Able to launch the App Successfully");
		takeScreenshot();
		//checking();
		Iclick("categoryLabel_xpath");
		 
	/*	Idriver.findElement(By.xpath("//XCUIElementTypeCell[@name=\"cell - 1\"]")).click();
		wait(3);
		
		
		//scroll can be used after hy rail section 
	   
	   JavascriptExecutor js4 = (JavascriptExecutor) Idriver;
			HashMap<String, String> scrollObject4 = new HashMap<String, String>();
			scrollObject4.put("direction", "down");
			scrollObject4.put("name", "Cust:");
			scrollObject4.put("toVisible", "not an empty string");
			js4.executeScript("mobile: scroll", scrollObject4);    
		*/
		
	}
	
	@Test(dataProvider="getData", priority=2,dependsOnMethods={"OpenApp"})
	public void newReport(Hashtable<String,String> data) throws  InterruptedException{
		// reports
		test = rep.startTest("New Report");
		test.log(LogStatus.INFO, "Starting the test New Report");
		Iclick("categoryLabel_xpath");
		Iclick("addreports_xpath");
		wait(3);
		ITouchXNY(363,270);
		Iclick("Done_toolbar_xpath");
		wait(1);

		//Crew
	    IclickAccs("txt_crew");
	    IclickAccs("Crew # TC-002");

//	    Idriver.findElement(By.xpath("//*[@accessibilityLabel='txt_work_order']")).click();
	    Idriver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"txt_work_order\"]" + "[@visible='true']")).click();
		System.out.println("Please select the first option displayed on IPAD screen");
	  
		sound();
		sound();
		wait(10);
	//	Idriver.findElement(By.xpath("//XCUIElementTypeCell[@name=\"cell - 1\"]")).click();
		
		test.log(LogStatus.PASS, "Able to open New Report successfully");
		
		
	}
	
	@Test(priority=3,dependsOnMethods={"newReport"})
	public void ShiftStart() throws  InterruptedException{
		// reports
		test = rep.startTest("Shift Start");
		test.log(LogStatus.INFO, "Starting the test Shift Start");

		//start shift 
		Iclick("selectShiftStart_xpath");
		//auto accept alert 
		checking();
		
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
	
		test.log(LogStatus.PASS, "Able to verify Shift Start successfully");
	}
	
	
	@Test(priority=4, dependsOnMethods={"ShiftStart"})
	public void JobInfo() throws  InterruptedException{
		test = rep.startTest("Job Info");
		test.log(LogStatus.INFO, "Starting the test Job Info");
				wait(2);
				IclickAccs("Job Info");
				wait(5);
				Iclick("gpslocation_xpath");
				
				//temp
				IclickAccs("temprature");
				IclickAccs("2");
				IclickAccs("5");
				Iclick("Done_toolbar_xpath");
				//weather
				IclickAccs("weather");
				Iclick("Done_toolbar_xpath");
				
				String tracId="Track ID:";
				scrolldownToString(tracId);
				
			
				String RRC="TestRRCustomer";
				Itype("rrcustomer_xpath",RRC);
				Iclick("Done_xpath");
				
				//RR Region
				String RRR="TestRegion";
				Itype("rrregion_xpath",RRR);
				Iclick("Done_xpath");
				
				//RR Division
				String RRD="TestDivision";
				Itype("rrdivi_xpath",RRD);
				Iclick("Done_xpath");
				
				IclickAccs("sub_division");
				Iclick("Done_xpath");
				
				String TTID="TestTrackId";
				Itype("track_htec_xpath",TTID);
				Iclick("Done_xpath");
				
				
				
				String CustCom="Customer Comments";
				scrolldownToString(CustCom);
			//	wait(1);
				String HolCome="TestHollandComments";
				Itype("hollandcomments_xpath",HolCome);
				Iclick("Done_xpath");
			//	wait(1);
				String custcomen="TestCustomerComments";
				Itype("customercomments_xpath",custcomen);
				Iclick("Done_xpath");
				wait(1);
				Iclick("Done_Main_xpath");
				
			test.log(LogStatus.PASS, "Able to verify Job Info successfully");
	}
	
	@Test(priority=5, dependsOnMethods={"JobInfo"})
	public void Activities() throws  InterruptedException{
		test = rep.startTest("Activities");
		test.log(LogStatus.INFO, "Starting the test Activities");
		IclickAccs("Activities");
		IclickAccs("cell - 1");
		Iclick("htec_activity_description_xpath");
		IclickAccs("DeMobilization");
		String comme="TestComments";
		Itype("comments_xpath",comme);
		Iclick("Done_xpath");
		wait(1);
		Iclick("btn_done_xpath");
		IclickAccs("Back");
		test.log(LogStatus.PASS, "Able to verify the Activities section successfully");
	}

	//@Test(priority=2)
	@Test(priority=6, dependsOnMethods={"Activities"})
	public void InventoryUsage() throws  InterruptedException{
		test = rep.startTest("Inventory Usage");
		test.log(LogStatus.INFO, "Starting the test Inventory Usage");
		IclickAccs("Inventory Usage");
		Idriver.findElement(By.xpath("//XCUIElementTypeNavigationBar[@name=\"Inventory Usage\"]")).click();
		IclickAccs("btn_add");
		
	//	IclickAccs("description");
		IclickAccs("cell - 2");
		Iclick("btn_done_xpath"); 
		wait(1);
		sound();
		IclickAccs("Back");
		System.out.println("Please touch on Back button on Ipad screen");
		wait(10);
		test.log(LogStatus.PASS, "Able to verify the Inventory Usage section successfully");
	}
	
	@Test(priority=7, dependsOnMethods={"InventoryUsage"})
	public void Equipments() throws  InterruptedException{
		test = rep.startTest("Equipments");
		test.log(LogStatus.INFO, "Starting the test Equipments");
		IclickAccs("Equipment");
		IclickAccs("btn_add_navbar");
		
		IclickAccs("cell - 4");
		IclickAccs("Grapple Truck HTEC 06 Sterling (7602)");
		
		Iclick("btn_done_xpath");
		IclickAccs("Back");
		test.log(LogStatus.PASS, "Able to verify the Equipments section successfully");
	}
	

	@Test(priority=8, dependsOnMethods={"Equipments"})
	public void MaterialUsage() throws  InterruptedException{
		test = rep.startTest("Material Usage");
		test.log(LogStatus.INFO, "Starting the test Material Usage");
		IclickAccs("Material Usage");
		IclickAccs("btn_add_navbar");
		
		IclickAccs("Insulated-Joints");
		IclickAccs("unit_Of_Measurement");
		//IclickAccs("Done");
		wait(3);
		ITouchXNY(611,593);
		
		
		IclickAccs("suppliedBy");
		IclickAccs("Holland");   //611 593
		Iclick("btn_done_xpath");
		IclickAccs("Back");
		test.log(LogStatus.PASS, "Able to verify the Material Usage section successfully");
	}
	
	@Test(priority=9, dependsOnMethods={"MaterialUsage"})
	public void HyRailBrake() throws  InterruptedException{
			test = rep.startTest("Hy-Rail Brake Test");
			test.log(LogStatus.INFO, "Starting the test Hy-Rail Brake Test");
			scrolldownToString("Cust:");	
			
			IclickAccs("Hy-Rail Brake Test");
			IclickAccs("btn_add_navbar");
			
			wait(2);
			//Unit/Equipment 
			String ukey="testunit";
			Itype("Unite_htec_aid",ukey);
			ITouchXNY(611,593);
			
			IclickAccs("date_and_time");
			ITouchXNY(611,593);
		
			
		 	String key="245";
			Itype("milePost_aid",key);
			ITouchXNY(611,586);
			
		 	String skey="23";
			Itype("speed_aid",skey);
			ITouchXNY(611,586);
			
			IclickAccs("weather");
			wait(1);
			ITouchXNY(611,586);
			wait(1);
		 	IclickAccs("rail_condition");
		 	wait(1);
		 	ITouchXNY(611,586);
			wait(1);
		    String Dkey="234";
		    Itype("distance_aid",Dkey);
			wait(1);
			ITouchXNY(611,586);
			
			IclickAccs("temperature_sign");
			ITouchXNY(611,586);
			IclickAccs("temperature_value");
			ITouchXNY(611,586);
			IclickAccs("name");
			wait(2);
		    IclickAccs("AGUIRRE, MARTIN");
		    String Nkey="AGUIRRE, MARTIN";
		    Itype("comments_aid",Nkey);
		    Iclick("Done_xpath");
		    Iclick("btn_done_xpath");
		    IclickAccs("Back");
		    	
		test.log(LogStatus.PASS, "Able to verify the Hy-Rail Brake Test section successfully");
	}   

	@Test(priority=10, dependsOnMethods={"HyRailBrake"})
	public void EndShift() throws  InterruptedException{
		test = rep.startTest("End Shift");
		test.log(LogStatus.INFO, "Starting the test End Shift Test");
		IclickAccs("End Shift");
		
		IclickAccs("off_site");
		Iclick("Done_toolbar_xpath");
		
		IclickAccs("shift_end");
		Iclick("Done_toolbar_xpath");
		IclickAccs("Was there a Holland Welding Unit (MOD or HBG) working with your crew today?");
		IclickAccs("NO");
		
		IclickAccs("You indicated that HTEC was the only crew working today - Is that correct?");
		IclickAccs("YES");
		
		IclickAccs("Was anyone on the Holland Crew Injured today?");
		IclickAccs("NO");
		
		Iclick("btn_done_xpath");
			
		test.log(LogStatus.PASS, "Able to verify the End Shift Test section successfully");
	}  
	
	@Test(priority=11, dependsOnMethods={"EndShift"})
	public void CrewTime() throws  InterruptedException{
		test = rep.startTest("Crew Time");
		test.log(LogStatus.INFO, "Starting the test Crew Time Test");
		IclickAccs("Crew Time");
		
		IclickAccs("btn_plus");
		Iclick("htec_empName_xpath");
			
		IclickAccs("AGUIRRE, MARTIN");
		Iclick("btn_done_xpath");
		IclickAccs("Back");
		test.log(LogStatus.PASS, "Able to verify the Crew Time Test section successfully");
	}  
	
	@Test(priority=12, dependsOnMethods={"CrewTime"})
	public void ProductionValues() throws  InterruptedException{
		
		test = rep.startTest("Production Values");
		test.log(LogStatus.INFO, "Starting the test Production Values");
		IclickAccs("Production Values");	
	    IclickAccs("btn_add_edit");
	    IclickAccs("Joint Elimination");
	    Iclick("btn_done_xpath");
	    
	    String skey="25";
		Itype("Railroad_Crew_count_aid",skey);
		ITouchXNY(611,586);
	    
	
		String rail="Surfacing";
		scrolldownToString(rail);
		
		wait(2);
		String CWRKey="52";
	    Itype("CWR_Created_footage_aid",CWRKey);
	    ITouchXNY(611,586);  
	    
	    
	    String DFkey="15";
		Itype("Destressing_footage_aid",DFkey);
		ITouchXNY(611,586);
		
		
		
	    String plugkey="25";
		Itype("plug_installed_aid", plugkey);
		ITouchXNY(611,586);
		
	
	    String RailKey="11";
		Itype("Rails_Cropped_aid",RailKey);
		ITouchXNY(611,586);
		
		Iclick("btn_done_xpath");
		
		test.log(LogStatus.PASS, "Able to verify the Crew Time Test section successfully");
	} 
	
	@Test(priority=13, dependsOnMethods={"ProductionValues"})
	public void DoneActivities() throws  InterruptedException{
		// reports
		test = rep.startTest("Going back to Activities to Done");
		test.log(LogStatus.INFO, "Starting the test going back to Activities to Done");
		
		// Going back to Welds & Activities 
		scrollUpJSExe("311","818","267","2000");
		IclickAccs("Activities");
		
		IclickAccs("Back");
		scrolldownToString("Cust:");
	    test.log(LogStatus.PASS, "Able to verify the going back to Activities to Done section successfully");
		
	}
	
	@Test(priority=14, dependsOnMethods={"DoneActivities"})
	public void ReviewFullReport() throws  InterruptedException{
		// reports
		test = rep.startTest("Review Full Report");
		test.log(LogStatus.INFO, "Starting the test Review Full Report");
		
		IclickAccs("Review Full Report");
		IclickAccs("Back"); 
	    test.log(LogStatus.PASS, "Able to verify the Review Full Report Test section successfully");
		System.out.println("Able to verify the Review Full Report Test section successfully");
	}  
	
	@Test(priority=15, dependsOnMethods={"ReviewFullReport"})
	public void Signature() throws  InterruptedException{
		// reports
		test = rep.startTest("Signature");
		test.log(LogStatus.INFO, "Starting the test Signature");
		IclickAccs("Signatures"); 
		IclickAccs("Customer"); 
		String CustKey="TestKey";
	   	Itype("customer_name_aid",CustKey);
	   	Iclick("Done_xpath");
	    String custNum="6567876542";
	   	Itype("customer_number_aid",custNum);
	   	Iclick("Done_toolbar2_xpath");
	   	drawAsignature(450, 500, 450, 450);
	   	//Holland signature 
	   	IclickAccs("Holland"); 
		IclickAccs("holland_name"); 
		Iclick("Done_toolbar_xpath");
		drawAsignature(526, 500, 700, 800);
	   	IclickAccs("btn_done_navbar");
	   	wait(2);
	   	takeScreenshot();
		test.log(LogStatus.PASS, "Able to verify the Signature Test section successfully");
		System.out.println("Able to verify the Signature Test section successfully");
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
