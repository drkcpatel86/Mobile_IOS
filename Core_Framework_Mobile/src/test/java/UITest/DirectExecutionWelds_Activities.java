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
public class DirectExecutionWelds_Activities {

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
		

			
	/*		//Welds & Activities
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
					   
					
				*/	
				    
			   JavascriptExecutor js4 = (JavascriptExecutor) driver;
					HashMap<String, String> scrollObject4 = new HashMap<String, String>();
					scrollObject4.put("direction", "down");
					scrollObject4.put("name", "Cust:");
					scrollObject4.put("toVisible", "not an empty string");
					js4.executeScript("mobile: scroll", scrollObject4);     
	/*			    
	// End Shift Section 
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
			*/		
		/*			
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
		*/
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
			             
			/*	    
			 		JavascriptExecutor js6 = (JavascriptExecutor) driver;
					HashMap<String, String> scrollObject6 = new HashMap<String, String>();
					scrollObject6.put("duration", "4.0");
					scrollObject6.put("fromX", "500");
					scrollObject6.put("fromY", "100");
					scrollObject6.put("toX", "500");
					scrollObject6.put("toY", "400");
					js6.executeScript("mobile: dragFromToForDuration", scrollObject6);   
					
				    */
				//	 Thread.sleep(5000); 
					 
					
		             /*	 int startX=450;
					 int startY=500;
					 int endX=450;
					 int endY=450;
				    
					 int startX=239;
					 int startY=135;
					 int endX=200;
					 int endY=400;   
					 
					 new TouchAction((driver))
					    .press(new PointOption<>().withCoordinates(startX, startY))
					    .moveTo(new PointOption<>().withCoordinates(endX, endY))
				//	    .moveTo(new PointOption<>().withCoordinates(endX+50, endY+50))
					    .release()
					    .perform();
					 Thread.sleep(5000); */
	}


	@AfterTest
	public void quit() {
	driver.quit();
	}
}