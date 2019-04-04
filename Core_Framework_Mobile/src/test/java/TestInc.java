

import java.io.IOException;
import java.util.Hashtable;

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

public class TestInc {
	ExtentReports report = ExtentManager.getInstance();
	ExtentTest test ;
	DriverScript ds ;
	String testCaseName="TestInc";
	String testCaseName1="Andromoney";
	SoftAssert softAssert; 
	Xls_Reader xls = new Xls_Reader(Constants.DATA_XLS_PATH);
	
	
	@Test(dataProvider="getData", priority=1)
	public void testInc(Hashtable<String,String> data) throws InterruptedException{
		// reports
		test = report.startTest("Test INC");
		test.log(LogStatus.INFO, "Starting the test "+testCaseName);
		if(! DataUtil.isTestRunnable(xls, testCaseName) || data.get(Constants.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is NO");
			throw new SkipException("Skipping the test as runmode is NO");
		}
		
		
		ds = new DriverScript(test);
		ds.executeKeywords(testCaseName,data);
		test.log(LogStatus.INFO, "Ending the test ");
	//	ds.getKeywords().reportPass("Test Passed");  
		test.log(LogStatus.PASS, "Able to launch the App and Click on the location");
		
		
		
	/*	test = report.startTest("Andromoney");
		test.log(LogStatus.INFO, "Starting the test "+testCaseName1);
		
		
		ds.executeKeywords(testCaseName1,data);
		test.log(LogStatus.INFO, "Ending the test ");
		test.log(LogStatus.PASS, "Closing the KP App");	*/
	}
	
	
	@Test(dataProvider="getData", priority=2)
	public void Sample(Hashtable<String,String> data1){
		test = report.startTest("Andromoney");
		test.log(LogStatus.INFO, "Starting the test "+testCaseName1);
		if(! DataUtil.isTestRunnable(xls, testCaseName1) || data1.get(Constants.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is NO");
			throw new SkipException("Skipping the test as runmode is NO");
		}
		
		ds = new DriverScript(test);
		ds.getKeywords().sleeptime(1000);
		ds.executeKeywords(testCaseName1,data1);
		test.log(LogStatus.INFO, "Ending the test ");
	//	ds.getKeywords().reportPass("Test Passed");  
		test.log(LogStatus.PASS, "Closing the KP App");	
		
		
	}  
	@BeforeMethod
	public void init() throws IOException {
		softAssert = new SoftAssert();
		
	}
	
	@AfterTest
	public void quit(){
		// driver.quit
		
		try {
			softAssert.assertAll();
		}catch (Error e) {
			test.log(LogStatus.FAIL, e.getMessage());
		}
		
		if(ds!=null)
			//ds.getKeywords().closeapp();
		
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
