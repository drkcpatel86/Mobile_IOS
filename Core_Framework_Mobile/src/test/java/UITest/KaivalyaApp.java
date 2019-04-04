package UITest;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class KaivalyaApp {

	public static IOSDriver<MobileElement> driver;
	// CTRL+SHIFT+O to import data
	
	@Test
	public void testApp() throws MalformedURLException, InterruptedException {
		File app=new File("/Users/KPatel/desktop/Useful_IPA/PayRoll_v4.2.ipa");
		
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
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"default value img\"]")).click();
			Thread.sleep(7000);
	/*		driver.findElement(By.id("com.whatsapp:id/search_src_text")).sendKeys("Papa USA");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.TextView")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.whatsapp:id/entry")).sendKeys("--Ignore--TestingAndroid-viaAppium");
			Thread.sleep(1000);
			driver.findElement(By.id("com.whatsapp:id/send")).click();
			Thread.sleep(3000); */
		//	driver.findElement(By.id("com.android.calculator2:id/eq")).click();
			
	//		String sum= driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
	//		System.out.println(sum);
			

		
	}
	
	@AfterTest
	public void quit() {
	driver.quit();
	}
}