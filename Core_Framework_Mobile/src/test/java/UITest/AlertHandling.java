package UITest;import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;


public class AlertHandling {
	public static IOSDriver<MobileElement> driver;
	public void deleteSubVar() throws Exception  
	{         
	  try   
	  {    
	    if((driver.findElement(By.xpath("")).isDisplayed() ))     
	    {      
	      /**when the element is found do this*/     
	    }    
	  }      
	  catch(Exception e)     
	  {       
	   /**include the else part here*/     
	  }       
	}   

}
