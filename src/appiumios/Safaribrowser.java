package appiumios;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;


import org.openqa.selenium.remote.DesiredCapabilities;

public class Safaribrowser {

	static IOSDriver<IOSElement>driver;


public static void main(String args[]) throws MalformedURLException

{

DesiredCapabilities dc = new DesiredCapabilities();

dc.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");

//dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");

dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");

dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST); //IOS Version > 10.2


driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

driver.get("http://google.com");

//driver.findElementByName("Email").sendKeys("rahul");

//driver.findElementByName("Passwd").sendKeys("rahul");

driver.findElementByName("q").sendKeys("harsha");
}
}