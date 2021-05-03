/******* Test Case to verify the calling functionality in a moblie dailer application **********/
package com.test.nativeApps;

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

public class testDailer {

	private String deviceName = "emulator-5554";
	private String appPackage = "com.android.dialer";
	private String appActivityName = "com.android.dialer.main.impl.MainActivity";
	private int implicitWaitTime = 5;
	int mobileNumber = 1122334455;
	By speedDail = By.id("com.android.dialer:id/speed_dial_tab");
	By dailPad = By.id("com.android.dialer:id/fab");
	By callerIcon = By.id("com.android.dialer:id/caller");

	public static void main(String args[]) throws MalformedURLException, InterruptedException {

		AndroidDriver<WebElement> driver = null;
		testDailer dailer = new testDailer();

		System.out.println("Test Script started");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, dailer.deviceName);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, dailer.appPackage);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, dailer.appActivityName);
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(dailer.implicitWaitTime, TimeUnit.SECONDS);

		
		driver.findElement(dailer.speedDail).click();
		driver.findElement(dailer.dailPad).click();
		String mobileNum = Integer.toString(dailer.mobileNumber);
		/** Dail the number **/
		for (int i = 0; i < mobileNum.length(); i++) {
			String mobileDigit = mobileNum.substring(i, i + 1);
			driver.findElement(By.xpath("//*[contains(@content-desc, " + mobileDigit + ")]")).click();
		}
		/*
		 * for(int i=mobileNum.length()-1; i>=0; i--) { String mobileDigit =
		 * mobileNum.substring(i, i+1);
		 * driver.findElement(By.xpath("//*[contains(@content-desc, "+mobileDigit+")]"))
		 * .click(); }
		 */ 
		driver.findElement(dailer.callerIcon).click();
		System.out.println("Test Passed successfully");
		driver.quit();
	}
}
