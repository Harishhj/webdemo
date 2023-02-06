package com.genericfunctions;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.model.Log;


public class FunctionLibrary{
	public static Dimension size;
	//private static final Logger logger = LoggerFactory.getLogger(FunctionLibrary.class);
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(FunctionLibrary.class);
	private static final long TimeOut = 0;
	
	public static void killProcess() throws Exception
	{
		try {
			Runtime.getRuntime().exec("TASKKILL /F /IM IEDriverServer.exe");
			Thread.sleep(200);
			Runtime.getRuntime().exec("TASKKILL /F /IM chromedriver.exe");
			Thread.sleep(200);
			Runtime.getRuntime().exec("TASKKILL /F /IM Safari.exe");
			Thread.sleep(200);
			//Log.info("All Opened Browser Instance closed Successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static String getClassName(Object obj)
	{
		String TestCaseName = obj.getClass().getSimpleName();
		return TestCaseName;
	}
	
	public void minimizeAllWindows() throws InterruptedException  
	{
		try {
			Runtime.getRuntime().exec("cmd.exe /C start "+System.getProperty("user.dir")+"\\resources\\MinimizeAllWindows.exe");
			Thread.sleep(200);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void maximizebrowserwindow()
	{
		BrowserFunctions.driver.manage().window().maximize();
		
	}

	public static void getUrl(String URL)
	{
		try {
			BrowserFunctions.driver.get(URL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public static void clickButton(String objName)
	{
		try {
			BrowserFunctions.driver.findElement(By.xpath(LoadPropertyfile.pro_obj.getProperty(objName))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void inputText(String objName, String testData)
	{
		try {
			BrowserFunctions.driver.findElement(By.xpath(LoadPropertyfile.pro_obj.getProperty(objName))).sendKeys(testData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void quitdriver()
	{
		BrowserFunctions.driver.quit();
	}
	public static void scrollFRomToptoBottom()throws Exception
	{
		for (int second= 0;; second++)
		{
			if(second>=60)
			{
				break;
			}
			((JavascriptExecutor)BrowserFunctions.driver).executeScript("window.scrollBy(0,400","");
		}
	}
	public void switchToNewTabAndClearBrowserData() throws InterruptedException
	{
		String parentWin = BrowserFunctions.driver.getWindowHandle();
		JavascriptExecutor executor = (JavascriptExecutor) BrowserFunctions.driver;
		(executor).executeScript("window.open('','_blank');");
		Set<String> allWindowHandles = BrowserFunctions.driver.getWindowHandles();
		for (String currentWindowHandle:allWindowHandles)
		{
			if(!currentWindowHandle.equals(parentWin))
			{
				BrowserFunctions.driver.switchTo().window(currentWindowHandle);
				BrowserFunctions.driver.get("chrome://settings/clearBrowserData");
				Thread.sleep(1000);
				ClearBrowserDataConfirm().click();
				Thread.sleep(1000);
				BrowserFunctions.driver.close();
				break;
			}
		}
		
		BrowserFunctions.driver.switchTo().window(parentWin);
	}
	
	public WebElement ClearBrowserDataConfirm()
	{
		return BrowserFunctions.driver.findElement(By.cssSelector(("* /deep/ #clearBrowserDataConfirm")));
	}
	public void implicitwait(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public static String getAttribute(String objName,String AttributeName)
	{
		
	String ValidateAttributeName =BrowserFunctions.driver.findElement(By.xpath(LoadPropertyfile.pro_obj.getProperty(objName))).getAttribute(AttributeName);
		return ValidateAttributeName;
	
	}
}
