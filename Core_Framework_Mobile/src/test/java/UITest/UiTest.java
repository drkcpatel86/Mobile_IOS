package UITest;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class UiTest {

	@Test
	public void launchApp() {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "iOS");
		cap.setCapability("platformVersion", "12.0");
		cap.setCapability("deviceName", "iPad");
		cap.setCapability("udid", "51374c6ffa892bda089f11d0a63abd50c9256193");
		
		
		cap.setCapability("autoGrantPermissions", "true");
		cap.setCapability("noReset", "true");
//		caps.setCapability("app", app.getAbsolutePath());
		
	}
	
	
}
