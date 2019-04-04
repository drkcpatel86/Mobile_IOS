package com.mobile.runner;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import com.hybrid.mgmt.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class GenericKeywords {
	//WebDriver driver;
	ExtentTest test;
	IOSDriver<IOSElement> aDriver;
	Properties prop;
	IOSDriver iDriver;
	
	public GenericKeywords(ExtentTest test){
		this.test=test;
	}
	
	public String openapp(){
		test.log(LogStatus.INFO, "Opening the app");
		// init the prop object
		prop = new Properties();
		String path = System.getProperty("user.dir")+"//src//test//resources//project.properties";
		try {
			FileInputStream fs = new FileInputStream(path);
			prop.load(fs);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		File app = new File(prop.getProperty("apkPath"));
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		 
		 capabilities.setCapability("platformName",prop.getProperty("platformName"));
		 capabilities.setCapability("platformVersion", prop.getProperty("platformVersion"));
		 capabilities.setCapability("deviceName",prop.getProperty("deviceName"));
		 capabilities.setCapability("udid",prop.getProperty("udid"));
		 capabilities.setCapability("autoGrantPermissions",prop.getProperty("autoGrantPermissions"));
		 capabilities.setCapability("noReset",prop.getProperty("noReset"));
		 capabilities.setCapability("app", app.getAbsolutePath());

	       try {
	    	   aDriver =  new IOSDriver<IOSElement>(new URL(prop.getProperty("hubURL")), capabilities);
			//driver = new RemoteWebDriver(new URL(prop.getProperty("hubURL")), capabilities);
			//aDriver = (AndroidDriver<AndroidElement>)driver;
			//iDriver =  (IOSDriver)driver;
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.FAIL, "APP could not be opened " +  e.getMessage());
			Assert.fail("Driver failed to start - "+ e.getMessage());
		}
	       aDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	       test.log(LogStatus.INFO, "Opened app successfully");
		return Constants.PASS;
	}
	
	public String click(String locatorKey) {
		test.log(LogStatus.INFO, "Clicking "+locatorKey);
		getElement(locatorKey).click();
		return Constants.PASS;
	}
	
	public String type(String locatorKey,String data){
		test.log(LogStatus.INFO, "Typing in  "+locatorKey);
		getElement(locatorKey).sendKeys(data);	
		return Constants.PASS;
	}
	
	public IOSElement getElement(String locatorKey){
		IOSElement e=null;
		
		try{
			if(locatorKey.endsWith("_xpath"))
				e = aDriver.findElement(By.xpath(prop.getProperty(locatorKey)));
			else if(locatorKey.endsWith("_id"))
				e = aDriver.findElement(By.id(prop.getProperty(locatorKey)));
			else{
				reportFailure("Locator not found "+locatorKey);
			}
		}catch(Exception ex){
			reportFailure("Test failed - " +ex.getMessage());
		}
		
		return e;
	}
	
	public String closeapp(){
		test.log(LogStatus.INFO,"Closing app");
		if(aDriver!=null){
			aDriver.quit();
			aDriver=null;
		}
		return Constants.PASS;
	}
	
	public String verifyText(String locatorKey,String expectedText){
		test.log(LogStatus.INFO,"Verifying text");
		String actualtext = getElement(locatorKey).getText();
		if(actualtext.equals(expectedText))
			return Constants.PASS;
		else{
			test.log(LogStatus.INFO, "Fail - Text Did not match " + actualtext);
			return "Fail - Text Did not match " + actualtext;
		}
	}
	
	/**************************reporting functions***********************************/
	public void reportFailure(String failureMsg){
		//take screenshot
		takeScreenshot();
		test.log(LogStatus.FAIL, failureMsg);
		Assert.fail(failureMsg);
	}
	
	public void reportPass(String passMsg){
		//take screenshot
		takeScreenshot();
		test.log(LogStatus.PASS, passMsg);
	}
	public void sleeptime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void takeScreenshot(){
		Date d = new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ","_")+".png";
		String path=Constants.SCREEN_PATH+screenshotFile;

		File scrFile = ((TakesScreenshot)aDriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO,"Snapshot below: ("+screenshotFile+")"+
				 test.addScreenCapture(path));
	}
	
}
