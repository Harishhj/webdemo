package com.utilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.genericfunctions.BrowserFunctions;
import com.utilities.Reporting;



public class ExtentReport 
{
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	//public static ExtentTest Log;
	
	@BeforeSuite
	public void StartTest()
	{
		htmlReporter = new ExtentHtmlReporter(Reporting.reportPath());
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName","A2MML11952");
		extent.setSystemInfo("Environment","Staging Env");
		extent.setSystemInfo("UserName","Shilpa");
	
		htmlReporter.config().setDocumentTitle("ExecutionReport");
		htmlReporter.config().setDocumentTitle("Test_Scripts_Results");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			logger.fail(MarkupHelper.createLabel(result.getName() + "- Test Case Failed", ExtentColor.RED));
			String screenShotPath = Reporting.Capture(driver);
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "- Test Case Failed due to below issue", ExtentColor.RED));
			logger.fail(result.getThrowable());
			logger.fail("Snapshot below: "+logger.addScreenCaptureFromPath(screenShotPath));
			logger.fail(result.getThrowable());
		}
		else if (result.getStatus() == ITestResult.SKIP)
		{
			logger.skip(MarkupHelper.createLabel(result.getName() + "- Test Case Skipped", ExtentColor.YELLOW));
			logger.skip(result.getThrowable());
		}
		else if (result.getStatus() == ITestResult.SUCCESS)
		{
			logger.pass(MarkupHelper.createLabel(result.getName() + "- Test Case Passed", ExtentColor.GREEN));
			//logger.pass(result.getThrowable());
		}
	}
	
	@AfterSuite
	public void endReport()
	{
		extent.flush();
	}
	
}
