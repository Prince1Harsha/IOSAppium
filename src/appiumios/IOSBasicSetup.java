package appiumios;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSBasicSetup 
{
	static IOSDriver<IOSElement>driver;
	
//	protected AndroidDriver adriver;
//    protected WebDriverWait wait;
//    protected MobileActions mobileActions;
//    
//    public IOSBasicSetup (AndroidDriver driver){
//        this.adriver = driver;
//        mobileActions = new MobileActions(driver); //We are using MobileActions with this instance. Composition.
//        wait = new WebDriverWait(driver, 20);
//    }
    
	public static IOSDriver<IOSElement> capabilities() throws MalformedURLException 
	{

		DesiredCapabilities d = new DesiredCapabilities();
		
		d.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
		
		d.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		
		d.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST); //IOS Version > 10.2
		
		d.setCapability(MobileCapabilityType.APP, "//Users//harsha//Desktop//UICatalog.app");
		
		driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),d);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
}
