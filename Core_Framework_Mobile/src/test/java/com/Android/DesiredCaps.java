package com.Android;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DesiredCaps {
	
	public static AndroidDriver<MobileElement> driver;
	
	@Test
	public void testApp() throws MalformedURLException, InterruptedException{
		File app=new File("C:\\Apk\\Contact Manager.apk");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "HUAWEI Mate SE");
		caps.setCapability("udid", "4AV7N18202000104");
		caps.setCapability("plateformName", "Android");
		caps.setCapability("plateformVersion", "8.0.0");
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability("noReset", "true");
		caps.setCapability("app", app.getAbsolutePath());
		
		//caps.setCapability("appPackage", "com.google.android.apps.maps");
		//caps.setCapability("appActivity", "com.google.android.maps.MapsActivity");
		
		/*caps.setCapability("app", app.getAbsolutePath());
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability("noReset", "true");
		*/
		//instance Appium Driver
		
			driver = new AndroidDriver<MobileElement>(new URL(
					"http://0.0.0.0:4723/wd/hub"), caps);
			
			//implicit wait
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElementByAccessibilityId("Show Invisible Contacts (Only)").click();
			Thread.sleep(3000);
		
	}
	@AfterTest
	public void quit() {
		driver.quit();
	}
}
