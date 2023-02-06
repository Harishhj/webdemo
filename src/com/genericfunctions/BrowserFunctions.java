package com.genericfunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFunctions {

	//public static String USERDIR = LoadPropertyfile.loadconfigProperties().getPath();
	public static String USERDIR = LoadPropertyfile.loadconfigProperties().getPath();
	public static WebDriver driver;
	static FunctionLibrary f1_obj;
	
	public static void openBrowser(String BrowserType)
	{
		f1_obj = new FunctionLibrary();
		switch(BrowserType)
		{
		case "CHROME":
			try {
				System.setProperty(CommonEnumConstants.CHROMEDIRVER.getValue(),USERDIR+CommonEnumConstants.CHROMEEXEPATH.getValue());
				driver = new ChromeDriver();
				f1_obj.implicitwait(driver);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "FIREFOX":
			try {
				System.setProperty(CommonEnumConstants.FIREFOXDRIVER.getValue(),USERDIR+CommonEnumConstants.FIREFOXEXEPATH.getValue());
				driver = new FirefoxDriver();
				f1_obj.implicitwait(driver);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
	
	
	
}
