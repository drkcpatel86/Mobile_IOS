package com.Android;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class launchCalculator {

	public static AndroidDriver<MobileElement> driver;
	// CTRL+SHIFT+O to import data
	
	@Test
	public void testApp() throws MalformedURLException, InterruptedException {
		//File app=new File("C:\\Apk\\ExactCalculator.apk");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "HUAWEI Mate SE");
		caps.setCapability("udid", "4AV7N18202000104");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.0.0");
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability("noReset", "true");
	//	caps.setCapability("app", app.getAbsolutePath());
		
		caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		
//		caps.setCapability("app", app.getAbsolutePath());
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability("noReset", "true");
		// Instantiate Appium Driver
		
		
			driver = new AndroidDriver<MobileElement>(new URL(
					"http://0.0.0.0:4723/wd/hub"), caps);
			
			// implicit wait
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//driver.findElementByAccessibilityId("Show Invisible Contacts (Only)").click();
			
			Thread.sleep(7000);
			driver.findElement(By.id("com.android.calculator2:id/op_clr")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();
			driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
			driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("com.android.calculator2:id/eq")).click();
			
			String sum= driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
			System.out.println(sum);
			

		
	}
	
	@AfterTest
	public void quit() {
	driver.quit();
	}
}