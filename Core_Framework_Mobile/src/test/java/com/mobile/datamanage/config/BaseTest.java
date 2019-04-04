package com.mobile.datamanage.config;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.hybrid.mgmt.Constants;
import com.hybrid.mgmt.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;





public class BaseTest {
	
	public WebDriver driver;
	public Properties prop;
	public ExtentReports rep = ExtentManager.getInstance();
	public ExtentTest test;
	public Properties envProp;
	boolean gridRun=false;
	public IOSDriver<MobileElement> Idriver;

	 
	
	public void init() throws IOException{
		
		System.out.println("Intialize class called");
		if(prop==null){
			prop = new Properties();
			String path = System.getProperty("user.dir")+"//src//test//resources//project.properties";
			try {
				FileInputStream fs = new FileInputStream(path);
				prop.load(fs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		}
	
	
	public String openapp(){
		test.log(LogStatus.INFO, "Opening the app");
		// init the prop object
	/*	prop = new Properties();
		String path = System.getProperty("user.dir")+"//src//test//resources//project.properties";
		try {
			FileInputStream fs = new FileInputStream(path);
			prop.load(fs);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}   */
	
		File app = new File(prop.getProperty("appPath"));
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		 
		 capabilities.setCapability("platformName",prop.getProperty("platformName"));
		 capabilities.setCapability("platformVersion", prop.getProperty("platformVersion"));
		 capabilities.setCapability("deviceName",prop.getProperty("deviceName"));
		 capabilities.setCapability("udid",prop.getProperty("udid"));
		 capabilities.setCapability("autoGrantPermissions",prop.getProperty("autoGrantPermissions"));
		 capabilities.setCapability("noReset",prop.getProperty("noReset"));
		 capabilities.setCapability("app", app.getAbsolutePath());

	       try {
	    	   Idriver =  new IOSDriver<MobileElement>(new URL(prop.getProperty("hubURL")), capabilities);
			//driver = new RemoteWebDriver(new URL(prop.getProperty("hubURL")), capabilities);
			//aDriver = (AndroidDriver<AndroidElement>)driver;
			//iDriver =  (IOSDriver)driver;
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.FAIL, "APP could not be opened " +  e.getMessage());
			Assert.fail("Driver failed to start - "+ e.getMessage());
		}
	       Idriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	       test.log(LogStatus.INFO, "Opened app successfully");
		return Constants.PASS;
	}
	
/*	public String IclickAccs(String locatorKey) {
		test.log(LogStatus.INFO, "Looking for an element "+locatorKey);
		System.out.println("Looking for an element "+locatorKey);
		wait(2);
		Idriver.findElementByAccessibilityId(locatorKey).click();
		test.log(LogStatus.INFO, "Clicked on "+locatorKey);
		System.out.println("Clicked on "+locatorKey);
		//IgetElement(Name).click();
		return Constants.PASS;
	}
	*/
	public String IclickAccs(String Name) {
		try{
			test.log(LogStatus.INFO, "Looking for an element "+Name);
			System.out.println("Looking for an element "+Name);
			Idriver.findElementByAccessibilityId(Name).click();
			test.log(LogStatus.INFO, "Clicked on "+Name);
			System.out.println("Clicked on "+Name);
		
		}catch(Exception ex){
			reportFailure("Test failed - " +ex.getMessage());
		}
		
		return Constants.PASS;
	}  
	

	
	public String Iclick(String locatorKey) {
		test.log(LogStatus.INFO, "Looking for an element "+locatorKey);
		System.out.println("Looking for an element "+locatorKey);
		wait(2);
		IgetElement(locatorKey).click();
		test.log(LogStatus.INFO, "Clicked on "+locatorKey);
		System.out.println("Clicked on "+locatorKey);
		return Constants.PASS;
	}
	
	public String Itype(String locatorKey,String string){
		test.log(LogStatus.INFO, "Typing in  "+locatorKey);
		wait(2);
		IgetElement(locatorKey).sendKeys(string);
		test.log(LogStatus.INFO, "Found an element "+locatorKey+" Typing values as "+string);
		System.out.println("Found an element "+locatorKey+" Typing values as "+string);
		return Constants.PASS;
	}
	
	public void ITouchXNY(int X, int Y) {
		test.log(LogStatus.INFO, "Performing Touch Action on X axis "+X+" and Y axis "+Y);
		wait(2);
		TouchAction touchAction = new TouchAction(Idriver);
		touchAction.tap(PointOption.point(X, Y)).perform();  
		test.log(LogStatus.INFO, "Performed Touch Action on X axis "+X+" and Y axis "+Y);
		System.out.println("Performed Touch Action on X axis "+X+" and Y axis "+Y);
		//return Constants.PASS;
	}
	
	public void scrolldownJSExe(String startx, String starty, String endx, String endy) {
		JavascriptExecutor js = (JavascriptExecutor) Idriver;
		HashMap<String, String> swipeObject = new HashMap<String, String>();
		
			 swipeObject.put("direction", "down"); //up for swipe
		     swipeObject.put("startX", startx);
		     swipeObject.put("startY", starty);
		     swipeObject.put("endX", endx); //"90");
		     swipeObject.put("endY", "endy"); //"200");
		     swipeObject.put("duration", "2000");
		     //js.executeScript("mobile: swipe", swipeObject); 
		     js.executeScript("mobile: scroll", swipeObject);
	}
	
	public void scrollUpJSExe(String startx, String starty, String endx, String endy) {
		JavascriptExecutor js = (JavascriptExecutor) Idriver;
		HashMap<String, String> swipeObject = new HashMap<String, String>();
		
			 swipeObject.put("direction", "up"); //up for swipe
		     swipeObject.put("startX", startx);
		     swipeObject.put("startY", starty);
		     swipeObject.put("endX", endx); //"90");
		     swipeObject.put("endY", "endy"); //"200");
		     swipeObject.put("duration", "2000");
		     //js.executeScript("mobile: swipe", swipeObject); 
		     js.executeScript("mobile: scroll", swipeObject);
	     
	}
	
	public void scrolldownToString(String Name) {
		JavascriptExecutor js2 = (JavascriptExecutor) Idriver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		wait(2);
		scrollObject.put("direction", "down");
		scrollObject.put("name", Name);
		scrollObject.put("toVisible", "not an empty string");
		js2.executeScript("mobile: scroll", scrollObject);
	}
	
	public void drawAsignature(int A, int B, int C, int D) {
    TouchAction action = new TouchAction(Idriver); 
    action.press(PointOption.point(A, B)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                    .moveTo(PointOption.point(C, D)).release().perform();
	}	
 
	public MobileElement IgetElement(String locatorKey){
		MobileElement e=null;
	
		
	/*	prop = new Properties();
		String path = System.getProperty("user.dir")+"//src//test//resources//project.properties";
		try {
			FileInputStream fs = new FileInputStream(path);
			prop.load(fs);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  */
		
		
		try{
			if(locatorKey.endsWith("_xpath"))
				e = Idriver.findElement(By.xpath(prop.getProperty(locatorKey)));
			else if(locatorKey.endsWith("_id"))
				e = Idriver.findElement(By.id(prop.getProperty(locatorKey)));
			else if(locatorKey.endsWith("_aid"))
				e= Idriver.findElementByAccessibilityId(prop.getProperty(locatorKey));
			else{
				reportFailure("Locator not found "+locatorKey);
			}
		}catch(Exception ex){
			reportFailure("Test failed - " +ex.getMessage());
		}
		
		return e;
	}

	
	
/***********************Validations***************************/
public boolean verifyTitle(){
	return false;		
}
public boolean isElementPresent(String locatorKey){
	List<WebElement> elementList=null;
	if(locatorKey.endsWith("_id"))
		elementList = driver.findElements(By.id(prop.getProperty(locatorKey)));
	else if(locatorKey.endsWith("_name"))
		elementList = driver.findElements(By.name(prop.getProperty(locatorKey)));
	else if(locatorKey.endsWith("_xpath"))
		elementList = driver.findElements(By.xpath(prop.getProperty(locatorKey)));
	else{
		reportFailure("Locator not correct - " + locatorKey);
		Assert.fail("Locator not correct - " + locatorKey);
	}
	
	if(elementList.size()==0)
		return false;	
	else
		return true;
}





/*****************************Reporting********************************/
public void reportPass(String msg){
	test.log(LogStatus.PASS, msg);
}

public void reportFailure(String msg){
	test.log(LogStatus.FAIL, msg);
	takeScreenshot();
	Assert.fail(msg);
}


public void takeScreenshot(){
	Date d = new Date();
	String screenshotFile=d.toString().replace(":", "_").replace(" ","_")+".png";
	String path=Constants.SCREEN_PATH+screenshotFile;

	File scrFile = ((TakesScreenshot)Idriver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(scrFile, new File(path));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	test.log(LogStatus.INFO,"Snapshot below: ("+screenshotFile+")"+
			 test.addScreenCapture(path));
}

public void DefaultLanding(){
	driver.switchTo().defaultContent();
}

public void FrameIndex(int Number){
	driver.switchTo().frame(Number);
}

public void TotalAvailFrames() {
	int total = driver.findElements(By.tagName("iframe")).size();
	System.out.println("Total frames - "+ total);
	test.log(LogStatus.INFO, "Total"+total+"Frames available on this page");
}
public  void SmartFrames(String bType) {
		if(bType.equals("Mozilla"))	{
			wait(2);
			System.out.println("SmartFrames Identifed for Mozilla");
			test.log(LogStatus.INFO, "SmartFrames Identifed for Mozilla");
			driver.switchTo().frame(2);
		
		}
	else if(bType.equals("Chrome")){
		wait(2);
		test.log(LogStatus.INFO, "SmartFrames Identifed for Chrome");
		driver.switchTo().frame(1);
		System.out.println("SmartFrames Identifed for Chrome");
	}
	}

public void wait(int timeToWaitInSec){
	try {
		Thread.sleep(timeToWaitInSec * 1000);
		System.out.println("Waiting for "+timeToWaitInSec+" seconds");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void acceptAlert(){
	WebDriverWait wait = new WebDriverWait(driver,5);
	wait.until(ExpectedConditions.alertIsPresent());
	test.log(LogStatus.INFO,"Accepting alert");
	driver.switchTo().alert().accept();
	driver.switchTo().defaultContent();
}

public void waitForPageToLoad() throws InterruptedException {
	wait(1);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	String state = (String)js.executeScript("return document.readyState");
	
	while(!state.equals("complete")){
		wait(2);
		state = (String)js.executeScript("return document.readyState");
	}
}



/************************App functions****/



}