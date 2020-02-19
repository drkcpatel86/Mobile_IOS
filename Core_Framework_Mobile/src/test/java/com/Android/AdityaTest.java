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

public class AdityaTest {

	public static AndroidDriver<MobileElement> driver;
	// CTRL+SHIFT+O to import data
	
	@Test
	public void testApp() throws MalformedURLException, InterruptedException {
		File app=new File("C:\\Apk\\ContactManager.apk");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "HUAWEI Mate SE");
		caps.setCapability("udid", "4AV7N18202000104");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.0.0");
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability("noReset", "true");
		caps.setCapability("app", app.getAbsolutePath());
		
	/*	caps.setCapability("appPackage", "com.google.android.apps.maps");
		caps.setCapability("appActivity", "com.google.android.maps.MapsActivity");
		
		caps.setCapability("app", app.getAbsolutePath());
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability("noReset", "true");  */
		
		// Instantiate Appium Driver
		
		
			driver = new AndroidDriver<MobileElement>(new URL(
					"http://0.0.0.0:4723/wd/hub"), caps);
			
			// implicit wait
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//	driver.findElementByAccessibilityId("Show Invisible Contacts (Only)").click();
			Thread.sleep(7000);
			
			
			driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys("abc");
			driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys("9024563187");
			driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).sendKeys("xyz@gmail.com");
			Thread.sleep(3000);
			MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Show Invisible Contacts (Only)");
			el1.click();
			Thread.sleep(7000);
			driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton")).click();
			MobileElement el2 = (MobileElement) driver.findElementById("com.example.android.contactmanager:id/contactNameEditText");
			el2.sendKeys("abc"); 
			
			
			// by.id
		
	}
	
/*	@AfterTest
	public void quit() {
	driver.quit();*/
	
}