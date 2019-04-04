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

public class ModProSmokeTests extends BaseTest{
//	ExtentReports report = ExtentManager.getInstance();
//	ExtentTest test ;
	DriverScript ds ;
	SoftAssert softAssert; 
	String testCaseName="ModProSmokeTests";
	Xls_Reader xls = new Xls_Reader(Constants.DATA_XLS_PATH);
	
	@Test(dataProvider="getData", priority=1)
	public void OpenApp(Hashtable<String,String> data) throws MalformedURLException{
		// reports
		test = rep.startTest("Open App");
		test.log(LogStatus.INFO, "Starting the test "+testCaseName);
		if(! DataUtil.isTestRunnable(xls, testCaseName) || data.get(Constants.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is NO");
			throw new SkipException("Skipping the test as runmode is NO");
		}
		
		openapp();
		test.log(LogStatus.PASS, "Able to launch the App Successfully");
	
		Iclick("categoryLabel_xpath");
		/*  wait(2);
		Idriver.findElement(By.xpath("//XCUIElementTypeCell[@name=\"cell - 1\"]")).click();
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
		ITouchXNY(363,270);
		Iclick("Done_xpath");
		wait(1);

		//Unit Field 
	    Iclick("unit_xpath");
	    IclickAccs("Unit # FP-053");
		//WO#
		Iclick("woc_xpath");
		Iclick("woc_select_xpath");
		
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
		IclickAccs("Allow");
		
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
	
		test.log(LogStatus.PASS, "Able to verify Shift Start successfully");
	}
	@Test(priority=4, dependsOnMethods={"ShiftStart"})
	public void JobInfo() throws  InterruptedException{
		test = rep.startTest("Job Info");
		test.log(LogStatus.INFO, "Starting the test Job Info");
				IclickAccs("Job Info");
				wait(2);
				Iclick("gpslocation_xpath");
		
				scrolldownJSExe("311", "818", "267", "484");
				String key="256";
				Itype("rail_xpath", key);
				Iclick("Done2_xpath");
				wait(1);
				Iclick("newrail_xpath");
			 	Iclick("selectYes_xpath");
				Iclick("welderhead_xpath");
				wait(1);
				IclickAccs("S-111");
				wait(1);
				Iclick("polisher_xpath");
				wait(1);
				IclickAccs("WP 024237-03");
				wait(1);
				Iclick("puller_xpath");
				wait(1);
				IclickAccs("No Puller");
			
				String LineS="Line Segment:";
				scrolldownToString(LineS);
				wait(1);
				String RRC="TestRRCustomer";
				Itype("rrcustomer_xpath",RRC);
				wait(1);
				Iclick("Done2_xpath");
				String testGname="TestGangName";
				Itype("gangname_xpath",testGname);
				Iclick("Done2_xpath");
				wait(1);
				IclickAccs("divison");
				Iclick("Done2_xpath");
				wait(1);
				IclickAccs("sub_division");
				Iclick("Done2_xpath");
				wait(1);
				String TTID="TestTrackId";
				Itype("trackig_xpath",TTID);
				Iclick("Done2_xpath");
				wait(1);
				String LSeg="TestTrackId";
				Itype("linesegment_xpath",LSeg);
				Iclick("Done2_xpath");
				String CustCom="Customer Comments";
				scrolldownToString(CustCom);
				wait(1);
				String HolCome="TestHollandComments";
				Itype("hollandcomments_xpath",HolCome);
				Iclick("Done2_xpath");
				wait(1);
				String custcomen="TestCustomerComments";
				Itype("customercomments_xpath",custcomen);
				Iclick("Done2_xpath");	
				Iclick("Done_xpath");
				IclickAccs("Back");
			test.log(LogStatus.PASS, "Able to verify Job Info successfully");
	}
	
	@Test(priority=5, dependsOnMethods={"JobInfo"})
	public void Welds_Activities() throws  InterruptedException{
		test = rep.startTest("Welds & Activities");
		test.log(LogStatus.INFO, "Starting the test Welds & Activities");
		IclickAccs("Welds & Activities");
		IclickAccs("cell - 1");
		Iclick("description_xpath");
		IclickAccs("DeMobilization");
		String comme="TestComments";
		Itype("comments_xpath",comme);
		IclickAccs("Done");
		IclickAccs("Back");
		IclickAccs("Back");
		test.log(LogStatus.PASS, "Able to verify the Welds & Activities section successfully");
	}

	@Test(priority=6, dependsOnMethods={"Welds_Activities"})
	public void MissedWelds() throws  InterruptedException{
		test = rep.startTest("Missed Welds");
		test.log(LogStatus.INFO, "Starting the test Missed Welds");
		IclickAccs("Missed Welds");
		IclickAccs("Add");
		IclickAccs("responsible");
		IclickAccs("Holland");
		IclickAccs("reason");
		IclickAccs("Holco Equipment/DSP");
		String key="345";
		Itype("milePost_aid",key);
		Iclick("Done2_xpath");
		IclickAccs("Done");
		IclickAccs("Back");
		test.log(LogStatus.PASS, "Able to verify the Missed Welds section successfully");
	}
	

	@Test(priority=7, dependsOnMethods={"MissedWelds"})
	public void Inventory() throws  InterruptedException{
		test = rep.startTest("Inventory");
		test.log(LogStatus.INFO, "Starting the test Inventory");
		IclickAccs("Inventory Usage");
		IclickAccs("Add");
		IclickAccs("item_number");
		IclickAccs("EI0018323");
		IclickAccs("Done");
		IclickAccs("Back");
		test.log(LogStatus.PASS, "Able to verify the Inventory section successfully");
	}

	@Test(priority=8, dependsOnMethods={"Inventory"})
	public void HyRailBrake() throws  InterruptedException{
			test = rep.startTest("Hy-Rail Brake");
			test.log(LogStatus.INFO, "Starting the test Hy-Rail Brake Test");
			IclickAccs("Hy-Rail Brake Test");
			IclickAccs("Add");
			wait(5);
			wait(2);
			ITouchXNY(457,336);
			wait(2);
			Iclick("Done2_xpath");
		 	String key="245";
			Itype("milePost_aid",key);
			Iclick("Done2_xpath");
		 	String skey="23";
			Itype("speed_aid",skey);
			IclickAccs("weather");
			wait(1);
			Iclick("Done2_xpath");
			wait(1);
		 	IclickAccs("rail_condition");
		 	wait(1);
			Iclick("Done2_xpath");
			wait(1);
		    String Dkey="234";
		    Itype("distance_aid",Dkey);
			wait(1);
			Iclick("Done2_xpath");
			IclickAccs("temperature_sign");
			Iclick("Done2_xpath");
			IclickAccs("temperature_value");
			Iclick("Done2_xpath");
			IclickAccs("name");
			wait(2);
		    IclickAccs("ACEBEDO, ANTHONY");
		    String Nkey="ADAMS, MARQUIS";
		    Itype("comments_aid",Nkey);
		    Iclick("Done2_xpath");
		    IclickAccs("Done");
		    IclickAccs("Back");
		    scrolldownToString("Cust:");		
		test.log(LogStatus.PASS, "Able to verify the Hy-Rail Brake Test section successfully");
	}

	@Test(priority=9, dependsOnMethods={"HyRailBrake"})
	public void EndShift() throws  InterruptedException{
		test = rep.startTest("End Shift");
		test.log(LogStatus.INFO, "Starting the test End Shift Test");
		IclickAccs("End Shift");
		IclickAccs("Edit");
		IclickAccs("off_track");
		Iclick("Done2_xpath");
		String Offkey="345";
	    Itype("offmile_aid",Offkey);
		Iclick("Done2_xpath");
		IclickAccs("shift_end");
		Iclick("Done2_xpath");
		IclickAccs("Was anyone on the Holland Crew");
		IclickAccs("NO");
		IclickAccs("Done");
		IclickAccs("Back");		
		test.log(LogStatus.PASS, "Able to verify the HyRail Brake Test section successfully");
	}  
	
	@Test(priority=10, dependsOnMethods={"EndShift"})
	public void CrewTime() throws  InterruptedException{
		// reports
		test = rep.startTest("Crew Time");
		test.log(LogStatus.INFO, "Starting the test Crew Time");
		IclickAccs("Crew Time");
		IclickAccs("Add");
		ITouchXNY(457,391);
		wait(2);
		IclickAccs("ADAMSON, ERIK");
		IclickAccs("Done");
	    IclickAccs("Back");		
		test.log(LogStatus.PASS, "Able to verify the Crew Time Test section successfully");
	}  

	@Test(priority=11, dependsOnMethods={"CrewTime"})
	public void ProductionValue() throws  InterruptedException{
		// reports
		test = rep.startTest("Production Values");
		test.log(LogStatus.INFO, "Starting the test Production Values");
		IclickAccs("Production Values");	
	    IclickAccs("btn_add_edit");
	    IclickAccs("Joint Elimination");
		IclickAccs("Done");
	    String skey="25";
		Itype("Railroad_Crew_count_aid",skey);
	    Iclick("Done2_xpath");
	    scrolldownJSExe("311","818","267","484");
	    String plugkey="25";
		Itype("plug_installed_aid", plugkey);
		Iclick("Done2_xpath");
		
		String JoiKey="33";
		Itype("joints_removed_xpath",JoiKey);
		Iclick("Done2_xpath");
		String DFkey="15";
		Itype("Destressing_footage_aid",DFkey);
		Iclick("Done2_xpath");
		String Dkey="10";
	    Itype("Defects_Removed_aid",Dkey);
	    Iclick("Done2_xpath");
	    String RailKey="11";
		Itype("Rails_Cropped_aid",RailKey);
	    Iclick("Done2_xpath");
		String TheKey="23";
	    Itype("Thermite_Welds_Cutout_aid", TheKey);
	    Iclick("Done2_xpath");
	    String CWRKey="52";
	    Itype("CWR_Created_footage_aid",CWRKey);
	    Iclick("Done2_xpath");
	    IclickAccs("Done");
	    
		test.log(LogStatus.PASS, "Able to verify the Production Value Test section successfully");
	}
	
	
	@Test(priority=12, dependsOnMethods={"ProductionValue"})
	public void CheckingWeldsActivities() throws  InterruptedException{
		// reports
		test = rep.startTest("Marking Welds & Activities to Done");
		test.log(LogStatus.INFO, "Starting the test Checking Welds & Activitie");
		
		// Going back to Welds & Activities 
		scrollUpJSExe("311","818","267","2000");
		IclickAccs("Welds & Activities");
		IclickAccs("cell - 1");
		IclickAccs("Edit");
		IclickAccs("Done");
		IclickAccs("Back");
		IclickAccs("Back");
		scrolldownToString("Cust:");
	    test.log(LogStatus.PASS, "Able to verify the Checking Welds & Activitie Test section successfully");
		System.out.println("Able to verify the Checking Welds & Activitiet Test section successfully");
	}

	@Test(priority=13, dependsOnMethods={"CheckingWeldsActivities"})
	public void ReviewFullReport() throws  InterruptedException{
		// reports
		test = rep.startTest("Review Full Report");
		test.log(LogStatus.INFO, "Starting the test Review Full Report");
		
		IclickAccs("Review Full Report");
		IclickAccs("Back"); 
	    test.log(LogStatus.PASS, "Able to verify the Review Full Report Test section successfully");
		System.out.println("Able to verify the Review Full Report Test section successfully");
	}
	
	@Test(priority=14, dependsOnMethods={"ReviewFullReport"})
	public void Signature() throws  InterruptedException{
		// reports
		test = rep.startTest("Signature");
		test.log(LogStatus.INFO, "Starting the test Signature");
		IclickAccs("Signatures"); 
		IclickAccs("Customer"); 
		String CustKey="TestKey";
	   	Itype("customer_name_aid",CustKey);
	   	Iclick("Done3_xpath");
	    String custNum="6567876542";
	   	Itype("customer_number_aid",custNum);
	   	Iclick("Done3_xpath");
	   	drawAsignature(450, 500, 450, 450);
	   	//Holland signature 
	   	IclickAccs("Holland"); 
		IclickAccs("holland_name"); 
		Iclick("Done2_xpath");
		drawAsignature(526, 500, 700, 800);
	   	IclickAccs("Done");
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
