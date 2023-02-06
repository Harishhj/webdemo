package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reporting 
{

	static Date date = new Date();
	String timestamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm").format(date);
	String currentdate = new SimpleDateFormat("dd_MM_yyyy").format(date);
	static String fulltimestamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(date);
	String minstamp = new SimpleDateFormat("hh_mm").format(date);
	
	public WebDriver driver;
	
	public Reporting(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public static String rptpath;
	public static String ReportPath;
	public static String Path;
	public static String SSPath;
	
	
	public static String reportPath()
	{
		createReportFolder();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss a");
		Path = "./Reports/"+"Execution_Report_"+sdf.format(date)+".html";
		return Path;
	}
	
	public static void createReportFolder()
	{
		rptpath = "./Reports/";
		File files = new File(rptpath);
		if(!files.exists()) {
			if(files.mkdirs()) {
				
			}else {
				
			}
		}
	}
	
	public static String Capture(WebDriver driver) throws IOException
	{
		String dateName = new SimpleDateFormat("yyyyMMhhmmss").format(date);
		String destination = System.getProperty("user.dir")+"/FailedTestScreenshots/"+dateName+".png";
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File Source = ts.getScreenshotAs(OutputType.FILE);
			File finalDestination = new File(destination);
			FileUtils.copyFile(Source, finalDestination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
	}
}









//Manju Code which was fixed earlier as on 4 Apr 2022

//package com.utilities;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.WebDriver;
//
//public class Reporting 
//{
//
//	static Date date = new Date();
//	String timestamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm").format(date);
//	String currentdate = new SimpleDateFormat("dd_MM_yyyy").format(date);
//	static String fulltimestamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(date);
//	String minstamp = new SimpleDateFormat("hh_mm").format(date);
//	
//	public WebDriver driver;
//	
//	public Reporting(WebDriver driver) 
//	{
//		this.driver = driver;
//	}
//	
//	public static String rptpath;
//	public static String ReportPath;
//	public static String Path;
//	public static String SSPath;
//	
//	
//	public static String reportPath()
//	{
//		createReportFolder();
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss a");
//		Path = "./reports/"+"Execution_Report_"+sdf.format(date)+".html";
//		return Path;
//	}
//	
//	public static void createReportFolder()
//	{
//		rptpath = "./Reports/";
//		File files = new File(rptpath);
//		if(!files.exists()) {
//			if(files.mkdirs()) {
//				
//			}else {
//				
//			}
//		}
//	}
//	public static String Capture(WebDriver driver) throws IOException
//	{
//		String dateName = new SimpleDateFormat("yyyyMMhhmmss").format(date);
//		String destination = System.getProperty("user.dir")+"/FailedTestScreenshots/"+dateName+".png";
//		try {
//			TakeScreenshot ts = (TakeScreenshot) driver;
//			File Source = ts.getScreenshotAs(OutputType.FILE);
//			File finalDestination = new File(destination);
//			FileUtils.copyFile(Source, finalDestination);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return destination;
//	}
//}
