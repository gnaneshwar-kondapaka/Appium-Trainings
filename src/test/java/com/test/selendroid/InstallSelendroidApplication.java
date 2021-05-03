package com.test.selendroid;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.DrbgParameters.Capability;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class InstallSelendroidApplication {

	
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException

	{
		System.out.println("Test Script started");
		AndroidDriver<WebElement> driver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.settings");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.settings.Settings");
		
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		Thread.sleep(2000);
		System.out.println("Text : "+driver.findElement(By.id("com.android.settings:id/search_action_bar_title")).getText());
		//driver.findElement(By.id("com.android.settings:id/search_action_bar")).sendKeys("Apps");
		driver.findElement(By.id("com.android.settings:id/search_action_bar_title")).click();
		driver.findElement(By.id("android:id/search_src_text")).sendKeys("Apps");
		driver.findElement(By.id("android:id/button2")).click();
		driver.findElement(By.id("com.whatsapp:id/eula_accept")).click();
		driver.findElement(By.id("com.whatsapp:id/registration_cc")).clear();
		driver.findElement(By.id("com.whatsapp:id/registration_cc")).sendKeys("91");
		driver.findElement(By.id("com.whatsapp:id/registration_phone")).sendKeys("1231231231");
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Test Passed successfully");
		
		
		
		
		
	}
}
