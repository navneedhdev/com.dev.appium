package com.dev.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.jna.platform.win32.Version;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FacebookLogin {
	AndroidDriver driver;
	DesiredCapabilities cap = DesiredCapabilities.android();
	@BeforeTest
	public void setUp() throws MalformedURLException
	{
		

		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"YT910WYBHE");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION , "4.3");
		cap.setCapability(MobileCapabilityType.PLATFORM,"Android");
		
	}
	
	@Test
	public void openFacebook() throws MalformedURLException
	{
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.get("https://www.facebook.com");
		driver.quit();
	}
	
	@Test
	public void guru99App() throws MalformedURLException, InterruptedException
	{
		cap.setCapability("appPackage", "com.vector.guru99");
		cap.setCapability("appActivity","com.vector.guru99.BaseActivity");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		if(driver.findElement(By.id("android:id/home")).isDisplayed())
		{
			driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Course List\").index(1)")).click();;
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"SAP CO\"))")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Lesson #11\"))")).click();
			Thread.sleep(10000);
		}

		driver.quit();
	}
	
	
}
