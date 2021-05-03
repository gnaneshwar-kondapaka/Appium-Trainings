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
import io.appium.java_client.remote.MobileCapabilityType;

public class TestChromeBrowser {

	
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException

	{
		System.out.println("Test Script started");
		
		AndroidDriver<WebElement> driver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		driver.findElement(By.cssSelector("input[class='gLFyf']")).sendKeys("IPL 2021 Live score");
		driver.findElement(By.cssSelector("input[class='gLFyf']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.quit();  
		System.out.println("Test Passed successfully");
		
		
		
	}
}
