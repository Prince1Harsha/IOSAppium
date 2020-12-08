package appiumios;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.Dimension;


import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class IOSTest extends IOSBasicSetup
{

	public static void main(String[] args) throws MalformedURLException 
	{

		IOSDriver<IOSElement>driver = capabilities();
		
//		driver.findElementByAccessibilityId("Alert Views").click();
//		
//		driver.findElementByXPath("//*[@value='Text Entry']").click();
//		
//		driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("hello"); //type attribute in ios inspector we can take as classname
//		
//		driver.findElementByName("OK").click();
//		
//		driver.navigate().back();
//
		Dimension size = driver.manage().window().getSize();
		int x = size.getWidth() / 2;
		int starty = (int) (size.getHeight() * 0.60);
		       
		int endy = (int) (size.getHeight() * 0.10);
		
		//driver.swipe(x,starty,x,endy,2000); DEPRECATED
		
		(new TouchAction(driver)).press(PointOption.point(x, starty))
	    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
	    .moveTo(PointOption.point(x, endy))
	    .release()
	    .perform();	
		
		driver.findElementByAccessibilityId("Steppers").click();
        driver.findElementByAccessibilityId("Increment").click();
        driver.findElementByAccessibilityId("Increment").click();
        System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(0).getText());
        
        System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(1).getText());
        driver.findElementByAccessibilityId("Decrement").click();
        
        System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(0).getText());
        driver.navigate().back();
        
        driver.findElementByAccessibilityId("Picker View").click();
        driver.findElementByName("Green color component value").sendKeys("220");
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(0).sendKeys("55");
        driver.findElementByXPath("//*[@name='Blue color component value']").sendKeys("130");
        
        driver.navigate().back();
	    }
	}

