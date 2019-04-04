package UITest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.interactions.touch.TouchActions;
public class DirectExecution {

	public static IOSDriver<MobileElement> driver;
	// CTRL+SHIFT+O to import data
	
	@Test
	public void testApp() throws MalformedURLException, InterruptedException {
		File app=new File("/Users/KPatel/desktop/Useful_IPA/HPro.ipa");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "iOS");
		caps.setCapability("platformVersion", "12.0");
		caps.setCapability("deviceName", "iPad");
		caps.setCapability("udid", "51374c6ffa892bda089f11d0a63abd50c9256193");
		
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability("noReset", "true");
		caps.setCapability("app", app.getAbsolutePath());

		
		
		driver = new IOSDriver<MobileElement>(new URL(
				"http://0.0.0.0:4723/wd/hub"), caps);
			
			// implicit wait
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//	driver.findElementByAccessibilityId("Search)").click();
		
			driver.findElementByAccessibilityId("Production").click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//XCUIElementTypeCell[@name=\"cell - 1\"]")).click();
			Thread.sleep(3000);
		

			
			//Job Info sections 
			Thread.sleep(2000);
			driver.findElementByAccessibilityId("Job Info").click();
			
			//click on location 
			Thread.sleep(4000);
		//	driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Tap here to Get Current Location from GPS\"]")).click();
			
			//Optionl Edit 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Edit\"]")).click();
			Thread.sleep(2000);
			//scroll 
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> swipeObject = new HashMap<String, String>();
			
				 swipeObject.put("direction", "down"); //up for swipe
			     swipeObject.put("startX", "311");
			     swipeObject.put("startY", "818");
			     swipeObject.put("endX", "267"); //"90");
			     swipeObject.put("endY", "484"); //"200");
			     swipeObject.put("duration", "2000");
			     //js.executeScript("mobile: swipe", swipeObject); 
			     js.executeScript("mobile: scroll", swipeObject);
			
			     
			     
			     
		

			     
		  //Rail Section 
			     Thread.sleep(2000);
			     driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"rail_section\"]")).sendKeys("256");
			 //    driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[13]/XCUIElementTypeTextField")).sendKeys("256");
			     Thread.sleep(2000);
			     //done 
			     driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
					Thread.sleep(3000);
			  
			// New Rail 
					driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"new_rail\"]")).click();
				//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[14]/XCUIElementTypeTextField")).click();
					Thread.sleep(2000);			
					//Input Yes 
					driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"YES\"]")).click();
					Thread.sleep(3000);
					
					
			//Welder Head 
					driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"welder_head\"]")).click();
				//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[15]/XCUIElementTypeTextField")).click();
					Thread.sleep(3000);
					//select first option 
					driver.findElementByAccessibilityId(("S-111")).click();
			
			//polisher
					Thread.sleep(3000);
					driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"polisher\"]")).click();
				//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[16]/XCUIElementTypeTextField")).click();
					Thread.sleep(3000);
					driver.findElementByAccessibilityId("WP 024237-03").click();
					
					
			//Puller 
					Thread.sleep(3000);
					driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"puller\"]")).click();
				//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[17]/XCUIElementTypeTextField")).click();
					Thread.sleep(3000);
					driver.findElementByAccessibilityId("EPL-1208").click();
				
					
					

			 	JavascriptExecutor js2 = (JavascriptExecutor) driver;
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("direction", "down");
				scrollObject.put("name", "Line Segment:");
				scrollObject.put("toVisible", "not an empty string");
				js2.executeScript("mobile: scroll", scrollObject);
			     
		
			     
			     
			     
			/*    TouchAction action = new TouchAction(driver); 
			     action.press(PointOption.point(115, 915)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
			                     .moveTo(PointOption.point(115, 150)).release().perform();
			     
			     Thread.sleep(3000);  */
		
				
		// RR Customer 
				Thread.sleep(3000);
				driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"rr_customer\"]")).sendKeys("TestRRCustomer");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[18]/XCUIElementTypeTextField")).sendKeys("TesttingRRCustomer");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[18]/XCUIElementTypeTextField")).sendKeys("Testing");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
		// Gang #/Name
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"gang_name\"]")).sendKeys("TestGangName");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[20]/XCUIElementTypeTextField")).sendKeys("TestingGangName");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[20]/XCUIElementTypeTextField")).sendKeys("TestingGangName");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
		
		// RR Job No./AFE
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"rr_job_number\"]")).sendKeys("TestRRNumber");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[23]/XCUIElementTypeTextField")).sendKeys("TestingRRJobNo");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[23]/XCUIElementTypeTextField")).sendKeys("TestingRRJobNo");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
	    // Region 
				Thread.sleep(3000);
				driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"region\"]")).sendKeys("TestRegion");
				driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[24]/XCUIElementTypeTextField")).sendKeys("testingRegion");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[24]/XCUIElementTypeTextField")).sendKeys("TestingRegion");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
				
		// Divison 		
				Thread.sleep(3000);
				driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"divison\"]")).sendKeys("TestDivision");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[25]/XCUIElementTypeTextField")).sendKeys("TestingDivision");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[25]/XCUIElementTypeTextField")).sendKeys("TestingDivison");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
		//SubDivision
				Thread.sleep(3000);
				driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"sub_division\"]")).sendKeys("TestSubDivision");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[26]/XCUIElementTypeTextField")).sendKeys("TestingSubDivision");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[26]/XCUIElementTypeTextField")).sendKeys("TestingSubDivison");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
		//Track Id
				Thread.sleep(3000);
				driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"track_segment\"]")).sendKeys("TestTrackId");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[27]/XCUIElementTypeTextField")).sendKeys("TestingTrackId");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[27]/XCUIElementTypeTextField")).sendKeys("TestingTrackID");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
		//Line Segment
				Thread.sleep(3000);
				driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"line_segment\"]")).sendKeys("TestLineSegment");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[28]/XCUIElementTypeTextField")).sendKeys("TestingLineSegment");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[28]/XCUIElementTypeTextField")).sendKeys("TestingLineSegment");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
				
				JavascriptExecutor js3 = (JavascriptExecutor) driver;
				HashMap<String, String> scrollObject1 = new HashMap<String, String>();
				scrollObject1.put("direction", "down");
				scrollObject1.put("name", "Customer Comments");
				scrollObject1.put("toVisible", "not an empty string");
				js2.executeScript("mobile: scroll", scrollObject1);
		
		//Holland Comments 
				Thread.sleep(3000);
				driver.findElement(By.xpath("//XCUIElementTypeTextView[@name=\"holland_comments\"]")).sendKeys("TestHollandComments");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[29]/XCUIElementTypeTextView")).sendKeys("TestingHollandComments");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[29]/XCUIElementTypeTextView")).sendKeys("TestingHollandComments");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
				
		//Customer Comments 
				Thread.sleep(3000);
				driver.findElement(By.xpath("//XCUIElementTypeTextView[@name=\"customer_comments\"]")).sendKeys("TestCustomerComments");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[30]/XCUIElementTypeTextView")).sendKeys("TestingHollandComments");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[30]/XCUIElementTypeTextView")).sendKeys("TestingHollandComments");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();	
				
		//Final Done 
				driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
				
				
	}	
	
	


	



	@AfterTest
	public void quit() {
	driver.quit();
	}
}