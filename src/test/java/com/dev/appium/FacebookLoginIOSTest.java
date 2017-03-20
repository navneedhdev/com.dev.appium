package com.dev.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

public class FacebookLoginIOSTest {
	IOSDriver driver;
	File app = new File("/Users/Dev/Downloads/TestApp.app");
	@Test
	public void amazon() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("autoAcceptAlerts", true);
		
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 7");
        capabilities.setCapability("platformVersion", "10.2");
    
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        //driver.switchTo().alert().accept();
        try {
            Alert alert = driver.switchTo().alert();

            // check if alert exists
            // TODO find better way
            alert.getText();

            // alert handling
            
            alert.accept();
        } 
        catch (Exception e) {
        }
        Thread.sleep(1000);
        MobileElement elem = (MobileElement) driver.findElement(MobileBy.name("IntegerA"));
        elem.clear();
        System.out.println(elem.getLocation());
        elem.sendKeys("1");
        driver.findElement(MobileBy.name("IntegerB")).sendKeys("2");
        driver.findElement(MobileBy.name("ComputeSumButton")).click();
        int sum = Integer.parseInt(driver.findElement(MobileBy.name("Answer")).getText());
        Assert.assertEquals(sum,3);
        driver.findElement(MobileBy.name("show alert")).click();
        try {
            Alert alert = driver.switchTo().alert();

            // check if alert exists
            // TODO find better way
            alert.getText();

            // alert handling
            
            alert.accept();
        } 
        catch (Exception e) {
        }
        driver.hideKeyboard("PRESS_KEY", "Done");
        /* TouchAction actions= new TouchAction(driver);
         MobileElement elem = (MobileElement) driver.findElement(MobileBy.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]"));
         actions.press(elem).moveTo(100, 100).release().perform();*/
        System.out.println(driver.manage().window().getSize());
        
         Thread.sleep(10000);
        System.out.println(driver.getPageSource());
        driver.findElement(MobileBy.xpath("//XCUIElementTypeSlider[1]")).sendKeys("0.1");
        //driver.findElement(MobileBy.xpath("XCUIElementTypeSwitch[1]")).sendKeys("1");
        Thread.sleep(10000);
        driver.quit();
       
        

	}

}
