package TestNg_Listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.hybrid.mgmt.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class CustomListeners extends TestListenerAdapter{
	public ExtentReports rep = ExtentManager.getInstance();
	ExtentReports report = ExtentManager.getInstance();
	ExtentTest test ;
	
	public void onTestFailure(ITestResult tr) {
		System.out.println("Fail--" +tr.getName());
	//	test = rep.startTest(tr.getName());
		//test.log(LogStatus.FAIL, "Failed the test "+tr.getName());
		
		
/*		if(rep!=null){
			rep.endTest(test);
			rep.flush();  
		}*/
	}
	
	public void onTestSuccess(ITestResult tr) {
		System.out.println("Pass "+tr.getName());
		
	//	test = rep.startTest(tr.getName());
	//	test.log(LogStatus.PASS, "Passes the test "+tr.getName());
		
		
	/*	if(rep!=null){
			rep.endTest(test);
			rep.flush();
		}    */
	}
	
	public void onTestSkipped(ITestResult tr){
		System.out.println("Skipped--"+tr.getName());

		
		test = rep.startTest(tr.getName());
		test.log(LogStatus.SKIP, "Skipping the test "+tr.getName());
		
		
		if(rep!=null){
			rep.endTest(test);
			rep.flush();
		}
	}
	

}
