package com.testscripts;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.genericfunctions.BrowserFunctions;
import com.genericfunctions.FunctionLibrary;
import com.genericfunctions.LoadPropertyfile;
import com.objectrepository.Objects;
import com.utilities.ExcelReader;
import com.utilities.ExtentReport;
import com.utilities.Log;
import com.utilities.LoggerClass;
import com.utilities.TakeScreenshot;

public class LoginToKapivaSite extends ExtentReport{

	FunctionLibrary f1_obj;
	BrowserFunctions bFunc_obj;
	LoginToKapivaSite kapiva_obj;
	
	@Test
	public void kapivaHomePage() throws Exception
	{
		kapiva_obj = new LoginToKapivaSite();
		String TestCaseName = FunctionLibrary.getClassName(kapiva_obj);
		logger = extent.createTest(TestCaseName);
		logger.assignAuthor("Shilpa HK");
		logger.assignCategory("SmokeTestReport-----QA Environment");
		f1_obj = new FunctionLibrary();
		bFunc_obj = new BrowserFunctions();
		FunctionLibrary.killProcess();
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Kapiva_Test_001");
		LoggerClass.startTestCase("Kapiva_Test_001");
		BrowserFunctions.openBrowser(LoadPropertyfile.loadconfigProperties().getBrowserName());
		Log.info("Browser instance is Opened:  "+LoadPropertyfile.loadconfigProperties().getBrowserName());
		//LoggerClass.info("Browser instance is Opened"+LoadPropertyfile.loadconfigProperties().getBrowserName());
		FunctionLibrary.maximizebrowserwindow();
		Log.info("Browser instance is Maximized>>>>>>>>>>>");
		//LoggerClass.info("Browser instance is Maximized>>>>>>>>>>>");
		FunctionLibrary.getUrl(LoadPropertyfile.loadconfigProperties().getUrl());
		TakeScreenshot.getScreenshot(BrowserFunctions.driver);
		Log.info("Navigating to Application URL:  "+LoadPropertyfile.loadconfigProperties().getUrl());
		//LoggerClass.info("Navigating to Application URL"+LoadPropertyfile.loadconfigProperties().getUrl());
		Objects.getOR();
		FunctionLibrary.clickButton("LoginBtn");
		FunctionLibrary.inputText("Email", ExcelReader.getData().get("EmailAddress"));
		TakeScreenshot.getScreenshot(BrowserFunctions.driver);
		Log.info("Email Address Entered is :  "+ExcelReader.getData().get("EmailAddress"));
		FunctionLibrary.inputText("PWD", ExcelReader.getData().get("Password"));
		TakeScreenshot.getScreenshot(BrowserFunctions.driver);
		FunctionLibrary.clickButton("SignInBtn");
		TakeScreenshot.getScreenshot(BrowserFunctions.driver);
		Log.endTestCase("Kapiva_Test_001");
    	LoggerClass.endTestCase("Kapiva_Test_001");
		
	}
	@AfterTest
	public void quitDriver()
	{
		BrowserFunctions.driver.close();
	}

}

















