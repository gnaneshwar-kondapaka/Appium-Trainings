package com.test.nativeApps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calculator {

	private static AndroidDriver<WebElement> driver = null;
	private static Calculator calc = null;
	private String deviceName = "emulator-5554";
	private String appPackage = "com.google.android.calculator";
	private String appActivityName = "com.android.calculator2.Calculator";
	private int implicitWaitTime = 5;
	private String applicationFolderPath = "\\Application\\Calculator.com.apk";
	By plusButton = By.id("com.google.android.calculator:id/op_add");
	By equalsButton = By.id("com.google.android.calculator:id/eq");
	By finalResult = By.id("com.google.android.calculator:id/result_final");
	By minusButton = By.id("com.google.android.calculator:id/op_sub");
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException {

		String projectDirectory = System.getProperty("user.dir");
		Calculator calc = new Calculator();
		System.out.println("Test Script started");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, calc.deviceName);
		capabilities.setCapability(MobileCapabilityType.APP, projectDirectory + calc.applicationFolderPath);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, calc.appPackage);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, calc.appActivityName);
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(calc.implicitWaitTime, TimeUnit.SECONDS);

		int firstNumber = 1;
		int secondNumber = 2;
		System.out.println("Sum of given numbers is : "+calc.add(firstNumber, secondNumber));
		System.out.println("Difference of given numbers is : "+calc.subtraction(firstNumber, secondNumber));
		
		System.out.println("Test Passed successfully");
		Thread.sleep(20000);
		driver.quit();
	}
	
	
	private int add(int x, int y)
	{
		int sum = 0;
		driver.findElement(By.xpath("com.google.android.calculator:id/digit_"+x)).click();
		driver.findElement(calc.plusButton);
		driver.findElement(By.xpath("com.google.android.calculator:id/digit_"+y)).click();
		driver.findElement(calc.equalsButton);
		sum  = Integer.parseInt(driver.findElement(calc.finalResult).getText());
		return sum;
	}
	
	private int subtraction(int x, int y)
	{
		int sum = 0;
		driver.findElement(By.xpath("com.google.android.calculator:id/digit_"+x+"\"")).click();
		driver.findElement(calc.minusButton);
		driver.findElement(By.xpath("com.google.android.calculator:id/digit_"+y+"\"")).click();
		driver.findElement(calc.equalsButton);
		sum  = Integer.parseInt(driver.findElement(calc.finalResult).getText());
		return sum;
	}
	
}
