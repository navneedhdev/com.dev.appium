package com.dev.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class FacebookLoginIOSTest {
	IOSDriver driver;
	
	@Test
	public void amazon() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 6");
        capabilities.setCapability("platformVersion", "10.2");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        capabilities.setCapability("app", "https://s3.amazonaws.com/appium/TestApp8.4.app.zip");
        driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        Thread.sleep(10000);
        

	}

}
