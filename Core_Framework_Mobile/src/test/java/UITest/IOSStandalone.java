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
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class IOSStandalone {

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
			
			// Implicit wait
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//	driver.findElementByAccessibilityId("Search)").click();
			
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Production\"]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"addReport\"]")).click();
			Thread.sleep(3000);
		

			
		 //   driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"dateField\"]")).click(); 
			
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(PointOption.point(363, 270)).perform();  
			
		/*	WebElement DatePickerListItem = driver.findElement(By.xpath("//XCUIElementTypeDatePicker[@name=\"date_picker\"]"));
			DatePickerListItem.click();	
			
			
			WebElement DatePickerWheel1 = 
					driver.findElement(By.xpath("//XCUIElementTypeDatePicker"));		
			List<WebElement> Columns =
					DatePickerWheel1.findElements(By.xpath("//XCUIElementTypePickerWheel"));
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			Map<String, Object> hp = new HashMap<String, Object>(); 
			hp.put("order", "next");
			hp.put("offset", 0.15);
			hp.put("element", Columns.get(0));
			js.executeScript("mobile: selectPickerWheelValue", hp);
			System.out.println(Columns.get(0).getAttribute("value"));
			
			Columns.get(1).sendKeys("20");
			Columns.get(2).sendKeys("2030");
		//	Columns.get(3).sendKeys("PM");		
			
			Thread.sleep(7000);
			Columns.get(0).sendKeys("March");
			Columns.get(1).sendKeys("20");
			Columns.get(2).sendKeys("2019");
			
			Thread.sleep(7000);
			*/
		    	//done button 
		    	driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
		    	Thread.sleep(3000);
			
			//Unit Field 
		    	//driver.findElementByAccessibilityId("unitField").click();
			driver.findElement(By.xpath("//XCUIElementTypeCell[@name=\"cell_unit\"]")).click();
			Thread.sleep(2000);
			//select Unit#FP-055
			driver.findElementByAccessibilityId("Unit # FP-053").click();
			Thread.sleep(2000);
			//WO#
			driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"woField\"]")).click();
			//workorder list_customer
			driver.findElement(By.xpath("//XCUIElementTypeCell[@name=\"cell - 1\"]")).click();
			Thread.sleep(2000);
			
			//start shift 
			driver.findElement(By.xpath("//XCUIElementTypeCell[@name=\"cell_start_shift\"]")).click();
			
			//auto accept alert 
				driver.findElementByAccessibilityId("Allow").click();
			        
		/*	  try   
			  {    
			    if(driver.findElementByAccessibilityId("Allow").isDisplayed() )     
			    {      
			      /**when the element is found do this  
			    	driver.findElementByAccessibilityId("Allow").click();
			    }    
			  }      
			  catch(Exception e)     
			  {       
			   /**include the else part here   
				  System.out.println("no Alert Allow needed");
			  }       
			}   */
			
			
			/*
			try {
			if (driver.findElementByAccessibilityId("Allow").isDisplayed()) {
				System.out.println("Alert Displayed");
				 driver.findElementByAccessibilityId("Allow").click();
			} else {
				System.out.println("Alert didnot appear");
			}
			
			
			if(wait.until(ExpectedConditions.alertIsPresent())==null){
                                 System.out.println("alert was not present");
                           }
                           else
                           {
                            Alert alert = driver.switchTo().alert();
                           alert.accept();
                           System.out.println("alert was present and accepted");
                           }
		*/
	//	   
			Thread.sleep(2000);
			//shift shart 
			driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"shift_start\"]")).click();
			
	/*		Thread.sleep(2000);
			TouchAction touchAction1 = new TouchAction(driver);
			touchAction1.tap(PointOption.point(402, 270)).perform();
			Thread.sleep(4000);   */
			
			
				//done 
				driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
			
			//On Track 
				
			//driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"on_track\"]")).click();
			Thread.sleep(4000);
			TouchAction touchAction2 = new TouchAction(driver);
			touchAction2.tap(PointOption.point(391, 325)).perform();  
			Thread.sleep(2000);  
			
				//done 
			Thread.sleep(4000);
		//	driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"])[2]]")).click();
			TouchAction touchAction3 = new TouchAction(driver);
			touchAction3.tap(PointOption.point(614, 592)).perform(); 
			Thread.sleep(4000);
			
			//On Track MP
			Thread.sleep(4000);
			TouchAction touchAction4 = new TouchAction(driver);
			touchAction4.tap(PointOption.point(349, 390)).perform();
			Thread.sleep(2000);
			//enter 3 
			driver.findElement(By.xpath("//XCUIElementTypeKey[@name=\"3\"]")).click();
			Thread.sleep(3000);
			//done 
			driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
			Thread.sleep(3000);
			
			//workcycles
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Work Cycle:\"]")).click();
			Thread.sleep(2000);
			TouchAction touchAction5 = new TouchAction(driver);
			Thread.sleep(2000);
			touchAction5.tap(PointOption.point(451, 495)).perform();
			Thread.sleep(2000);
			
			//done 
			driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
			
			
			
			
			//Crew Type
			Thread.sleep(2000);
		//	driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"crew_Type\"]")).click();
			Thread.sleep(6000);
			TouchAction touchAction6 = new TouchAction(driver);
			Thread.sleep(2000);
			touchAction6.tap(PointOption.point(429, 575)).perform();
			Thread.sleep(2000);  
			
			
			//done 
			Thread.sleep(2000);
			 driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
			
		/*	 Thread.sleep(4000);
			 TouchAction touchAction7 = new TouchAction(driver);
			touchAction7.tap(PointOption.point(614, 592)).perform();  */
			
			//main dnone 
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[1]")).click();
			
			//back 
			Thread.sleep(2000);
			TouchAction touchAction8 = new TouchAction(driver);
			touchAction8.tap(PointOption.point(182, 96)).perform();
			
			
			/*
			//Job Info sections 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//XCUIElementTypeCell[@name=\"cell_job\"]")).click();
			
			//city
			Thread.sleep(2000);
			driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTextField")).sendKeys("Bartlett");
			
			//state
			Thread.sleep(3000);
			driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeTextField")).click();
			Thread.sleep(3000);
				//scrolling
				Dimension dimension = driver.manage().window().getSize();
				
				Double scrollHeightStart = dimension.getHeight() * 0.5;
				int scrollStart = scrollHeightStart.intValue();
				
				Double scrollheightEnd=dimension.getHeight() * 0.2;
				int scrollEnd =scrollheightEnd.intValue();
				
				
				new TouchAction((PerformsTouchActions)driver())
				.press(PointOption.point(0, scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(0, scrollEnd))
				.release().perform();
				
			
			
				driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Illinois, US\"]")).click();
			
			//country
			Thread.sleep(3000);
			driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeTextField")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"United States\"]")).click();
			
			//county
			Thread.sleep(2000);
			driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeTextField")).sendKeys("DuPage");
			
			//Zip
			Thread.sleep(2000);
			driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[6]/XCUIElementTypeTextField")).sendKeys("60103");
			*/
		
			
			
			
			//Job Info sections 
			Thread.sleep(2000);
			driver.findElementByAccessibilityId("Job Info").click();
			
			//click on location 
			Thread.sleep(4000);
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Tap here to Get Current Location from GPS\"]")).click();
			
			//Optionl Edit 
			/*Thread.sleep(2000);
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Edit\"]")).click();
			Thread.sleep(2000);  */
			//scroll 
			
			JavascriptExecutor js5 = (JavascriptExecutor) driver;
			HashMap<String, String> swipeObject = new HashMap<String, String>();
			
				 swipeObject.put("direction", "down"); //up for swipe
			     swipeObject.put("startX", "311");
			     swipeObject.put("startY", "818");
			     swipeObject.put("endX", "267"); //"90");
			     swipeObject.put("endY", "484"); //"200");
			     swipeObject.put("duration", "2000");
			     //js.executeScript("mobile: swipe", swipeObject); 
			     js5.executeScript("mobile: scroll", swipeObject);
			
			     
			     
			     
		

			     
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
					driver.findElementByAccessibilityId("No Puller").click();
				
					
					

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
		
			/*	// RR Job No./AFE
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"rr_job_number\"]")).sendKeys("TestRRNumber");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
				// Region 
				Thread.sleep(3000);
				driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"region\"]")).sendKeys("TestRegion");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();   
				*/
				
				
				// Divison 		
				Thread.sleep(3000);
				driver.findElementByAccessibilityId("divison").click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
				
			//	driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"divison\"]")).sendKeys("TestDivision");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[25]/XCUIElementTypeTextField")).sendKeys("TestingDivision");
			//	driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MOD PRO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[25]/XCUIElementTypeTextField")).sendKeys("TestingDivison");
				Thread.sleep(2000);
			//	driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
				
				//SubDivision
				Thread.sleep(3000);
				driver.findElementByAccessibilityId("sub_division").click();
				
			//	driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"sub_division\"]")).sendKeys("TestSubDivision");
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
				
				//back
				Thread.sleep(2000);
				driver.findElementByAccessibilityId("Back").click();
				
		//Welds & Activities
				Thread.sleep(2000);
				driver.findElementByAccessibilityId("Welds & Activities").click();
				
				//select first cell 
				Thread.sleep(2000);
				driver.findElementByAccessibilityId("cell - 1").click();
				
				//Description
				driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"activity_description\"]")).click();
				Thread.sleep(2000);
				
				//select Demobilization 
				driver.findElementByAccessibilityId("DeMobilization").click();
				Thread.sleep(2000);
				//comments
				driver.findElement(By.xpath("//XCUIElementTypeTextView[@name=\"comments\"]")).sendKeys("TestComments");
				
				//done 
				driver.findElementByAccessibilityId("Done").click();
				Thread.sleep(2000);
				
				//back
				driver.findElementByAccessibilityId("Back").click();
				Thread.sleep(2000);
				
				//again back
				driver.findElementByAccessibilityId("Back").click();
				Thread.sleep(2000);
				
		//Missed Welds 
				driver.findElementByAccessibilityId("Missed Welds").click();
				Thread.sleep(2000);
				
				//Add Report
				driver.findElementByAccessibilityId("Add").click();
				Thread.sleep(2000);
				
				//Responsible 
				driver.findElementByAccessibilityId("responsible").click();
				Thread.sleep(2000);
				
				//select Holland
				driver.findElementByAccessibilityId("Holland").click();
				Thread.sleep(2000);
				
				//Reason
				driver.findElementByAccessibilityId("reason").click();
				Thread.sleep(2000);
				
				//select Holco Equipmet/DSP
				driver.findElementByAccessibilityId("Holco Equipment/DSP").click();
				Thread.sleep(2000);
				
				//Mile Post 
				driver.findElementByAccessibilityId("milePost").sendKeys("345");
				Thread.sleep(2000);
				  
				   //Done 
				   driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
				   Thread.sleep(2000);
			
				//Main Done 
					driver.findElementByAccessibilityId("Done").click();
					Thread.sleep(2000);
					
				  //Main Back  
					driver.findElementByAccessibilityId("Back").click();
					Thread.sleep(2000);
					
		//Inventory Usage		
					driver.findElementByAccessibilityId("Inventory Usage").click();
					Thread.sleep(2000);
					
					//Add Report
					driver.findElementByAccessibilityId("Add").click();
					Thread.sleep(2000);
					
					//Item Number 
					driver.findElementByAccessibilityId("item_number").click();
					Thread.sleep(2000);
					  //selectEI
					driver.findElementByAccessibilityId("EI0018323").click();
					Thread.sleep(2000);
					
					//Main Done 
					driver.findElementByAccessibilityId("Done").click();
					Thread.sleep(2000);
					
					 //Main Back  
					driver.findElementByAccessibilityId("Back").click();
					Thread.sleep(2000);   
					
		 //Hy-Rail Brake Test 
					driver.findElementByAccessibilityId("Hy-Rail Brake Test").click();
					Thread.sleep(2000);
					
					//Add Report
					driver.findElementByAccessibilityId("Add").click();
					Thread.sleep(5000);
					
					//Date & Time 
					Thread.sleep(2000);
					TouchAction touchAction9 = new TouchAction(driver);
					touchAction9.tap(PointOption.point(457, 336)).perform();
					Thread.sleep(2000);
					   //done 
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
					
					//Mile Post 
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("milePost").sendKeys("245");
						Thread.sleep(2000);   
						//done 
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
							
					    //Speed 
					    Thread.sleep(2000);
						driver.findElementByAccessibilityId("speed").sendKeys("23");
						
						
					// Weather condition 
						Thread.sleep(2000);
						driver.findElementByAccessibilityId("weather").click();
						
						//done 
						Thread.sleep(3000);
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
					    
					// Rail Condition 
					    Thread.sleep(3000);
					    driver.findElementByAccessibilityId("rail_condition").click();
					  //done 
						Thread.sleep(3000);
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
						
					//Approx stopping Distance 
					    Thread.sleep(3000);
						driver.findElementByAccessibilityId("distance").sendKeys("234");
						//done 
						Thread.sleep(3000);
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
						
					 //Temperature 
						Thread.sleep(2000);
					    driver.findElementByAccessibilityId("temperature_sign").click();
					    	//done 
						Thread.sleep(2000);
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
						
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("temperature_value").click();
					    	//done 
						Thread.sleep(2000);
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
					    
					//Name 
					    Thread.sleep(2000);
					   
					    driver.findElementByAccessibilityId("name").click();
					    Thread.sleep(4000);
					    driver.findElementByAccessibilityId("ACEBEDO, ANTHONY").click();
					    
					//Comments:
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("comments").sendKeys("ADAMS, MARQUIS"); 
					 	//done 
						Thread.sleep(2000);
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
					//Main Done 
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("Done").click();
					    
					    //Main Back  
					     Thread.sleep(2000); 
						driver.findElementByAccessibilityId("Back").click();
						   
						
					//scroll 
					    
				   JavascriptExecutor js4 = (JavascriptExecutor) driver;
						HashMap<String, String> scrollObject4 = new HashMap<String, String>();
						scrollObject4.put("direction", "down");
						scrollObject4.put("name", "Cust:");
						scrollObject4.put("toVisible", "not an empty string");
						js4.executeScript("mobile: scroll", scrollObject4);     
					    
		// End Shift  
						Thread.sleep(2000); 
						driver.findElementByAccessibilityId("End Shift").click();
								
					//Edit 
						Thread.sleep(2000); 
						driver.findElementByAccessibilityId("Edit").click();
						
					//Off Track 
						Thread.sleep(2000); 
						driver.findElementByAccessibilityId("off_track").click();
						//done 
						Thread.sleep(2000);
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
					    
					 //Off Track MP:
					    Thread.sleep(2000); 
						driver.findElementByAccessibilityId("off_mile_post").sendKeys("345");
						//done 
						Thread.sleep(2000);
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
					    
					  //Shift End:
					    Thread.sleep(2000); 
						driver.findElementByAccessibilityId("shift_end").click();
						Thread.sleep(2000);
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
					    
					  //Was anyone injured 
					    Thread.sleep(2000); 
						driver.findElementByAccessibilityId("Was anyone on the Holland Crew").click();
						//select NO 
						Thread.sleep(2000); 
						driver.findElementByAccessibilityId("NO").click();
						
					  //Main Done 
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("Done").click();
						
					    //Main Back  
					     Thread.sleep(2000); 
						driver.findElementByAccessibilityId("Back").click();
						
			// Crew Time section 	
						Thread.sleep(2000);
					    driver.findElementByAccessibilityId("Crew Time").click();
					    
					  //Add Report
					    Thread.sleep(2000);
						driver.findElementByAccessibilityId("Add").click();
						
						
						//Name: 
						Thread.sleep(2000);
						TouchAction touchAction10 = new TouchAction(driver);
						touchAction10.tap(PointOption.point(457, 391)).perform();
						Thread.sleep(2000);
						
						//select name 
						Thread.sleep(2000);
						driver.findElementByAccessibilityId("ADAMSON, ERIK").click();
						
						//Main Done 
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("Done").click();
						
					    //Main Back  
					     Thread.sleep(2000); 
						driver.findElementByAccessibilityId("Back").click();
						
		// Production value section 
						Thread.sleep(2000);
					    driver.findElementByAccessibilityId("Production Values").click();
					    
					    //Work Types:
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("btn_add_edit").click();
					      //select Joint Elimination 
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("Joint Elimination").click();
					       //Main done 
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("Done").click();
					    
					    
					    //Rail road crew count 
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("Railroad_Crew_count").sendKeys("25");
					    	//done 
						Thread.sleep(2000);
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
					    
					    
					    JavascriptExecutor js10 = (JavascriptExecutor) driver;
						HashMap<String, String> swipeObject10 = new HashMap<String, String>();
						
							 swipeObject10.put("direction", "down"); //up for swipe
						     swipeObject10.put("startX", "311");
						     swipeObject10.put("startY", "818");
						     swipeObject10.put("endX", "267"); //"90");
						     swipeObject10.put("endY", "484"); //"200");
						     swipeObject10.put("duration", "2000");
						     //js.executeScript("mobile: swipe", swipeObject); 
						     js10.executeScript("mobile: scroll", swipeObject10);
					    
					    
					    
					    
					    //Plugs installed 
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("Plugs_Installed").sendKeys("25");
								//done 
						Thread.sleep(2000);
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();

					    //Joints removed 
					    Thread.sleep(2000);
					    driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"Joints_Removed\"]")).sendKeys("234");
								//done 
						Thread.sleep(2000);
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
					
					    //Destressing footage
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("Destressing_footage").sendKeys("15");
								//done 
						Thread.sleep(2000);
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
					    
					  //Defects Removed 
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("Defects_Removed").sendKeys("10");
								//done 
						Thread.sleep(2000);
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
					    
			    
					     //Rails_Cropped
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("Rails_Cropped").sendKeys("11");
								//done 
						Thread.sleep(2000);
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
					    
					    //Thermite Welds Cutout:
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("Thermite_Welds_Cutout").sendKeys("23");
								//done 
						Thread.sleep(2000);
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
					    
					    //CWR_Created_footage
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("CWR_Created_footage").sendKeys("52");
								//done 
						Thread.sleep(2000);
					    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
					  
					    //Main done 
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("Done").click();
					    
			// Going back to Welds & Activities 
					    
					    JavascriptExecutor js11 = (JavascriptExecutor) driver;
						HashMap<String, String> swipeObject11 = new HashMap<String, String>();
						
							 swipeObject11.put("direction", "up"); //up for swipe
						     swipeObject11.put("startX", "311");
						     swipeObject11.put("startY", "818");
						     swipeObject11.put("endX", "267"); //"90");
						     swipeObject11.put("endY", "484"); //"200");
						     swipeObject11.put("duration", "2000");
						     //js.executeScript("mobile: swipe", swipeObject); 
						     js11.executeScript("mobile: scroll", swipeObject11);
					    
					    Thread.sleep(2000);
						driver.findElementByAccessibilityId("Welds & Activities").click();
						
						//select first cell 
						Thread.sleep(2000);
						driver.findElementByAccessibilityId("cell - 1").click();
						
						//Edit
						 Thread.sleep(2000);
							driver.findElementByAccessibilityId("Edit").click();
						
		
						//done 
						driver.findElementByAccessibilityId("Done").click();
						Thread.sleep(2000);
						
						//back
						driver.findElementByAccessibilityId("Back").click();
						Thread.sleep(2000);
						
						//again back
						driver.findElementByAccessibilityId("Back").click();
						Thread.sleep(2000);
					    
						  JavascriptExecutor js9 = (JavascriptExecutor) driver;
							HashMap<String, String> scrollObject9 = new HashMap<String, String>();
							scrollObject9.put("direction", "down");
							scrollObject9.put("name", "Cust:");
							scrollObject9.put("toVisible", "not an empty string");
							js9.executeScript("mobile: scroll", scrollObject9);    
						
			//	Review Full Report 
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("Review Full Report").click(); 
					    
					    //Main Back
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("Back").click();   
			
			// Signature 		    
				
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("Signatures").click();
					    
					    //customer signature 
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("Customer").click();
					    
					    //Customer Name:
					    Thread.sleep(2000);
					    driver.findElementByAccessibilityId("customer_name").sendKeys("TestKP");
					  //done 
					      driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[3]")).click();
					    
					    
					    //customer #
					    driver.findElementByAccessibilityId("customer_number").sendKeys("5165268768");
					    //done 
					      driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[3]")).click(); 
		
					    
					    TouchAction action5 = new TouchAction(driver); 
			             action5.press(PointOption.point(450, 500)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
			                             .moveTo(PointOption.point(450, 450)).release().perform();
					    
					    
			           //Holland signature 
						    Thread.sleep(2000);
						    driver.findElementByAccessibilityId("Holland").click();
						    
						   //Name
						    Thread.sleep(2000);
						    driver.findElementByAccessibilityId("holland_name").click();
						    
						    //done 
						    Thread.sleep(1000);
						    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Done\"])[2]")).click();
			             
						    TouchAction action7 = new TouchAction(driver); 
				             action7.press(PointOption.point(526, 500)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				                             .moveTo(PointOption.point(700, 800)).release().perform();
						    
				             //Main Done 
							    Thread.sleep(2000);
							    driver.findElementByAccessibilityId("Done").click();  
			
			
	}			
	
	private PerformsTouchActions driver() {
		// TODO Auto-generated method stub
		return null;
	}

	@AfterTest
	public void quit() {
	driver.quit();
	}
}