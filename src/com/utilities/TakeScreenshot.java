package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class TakeScreenshot 
{
	public static String screenshotPath = System.getProperty("user.dir")+"/Screenshots/";
	public static void getScreenshot(WebDriver driver) throws IOException
	{
		DateFormat dateWithTime = new SimpleDateFormat("dd-MM-yyyy h-m-s");
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String time = dateFormat.format(date);
		File path = new File(screenshotPath+File.separator+time);
		path.mkdir();
		File srcFiler  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFiler  = new File (path+File.separator+dateWithTime.format(date)+".png");
		FileUtils.copyFile(srcFiler,destFiler);
		
	}
}

























//Manju Code which was fixed earlier as on 4 Apr 2022
//package com.utilities;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.WebDriver;
//
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.AndroidDriver;
//
//public class TakeScreenshot 
//{
//
//	public static String screenshotPath = System.getProperty("user.dir")+"/Screenshot/";
//	public static File getScreenshot(OutputType<File> file) throws IOException
//	{
//		DateFormat dateWithTime = new SimpleDateFormat("dd-MM-yyyy h-m-s");
//		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//		Date date = new Date();
//		String time = dateFormat.format(date);
//		File path = new File(screenshotPath+File.separator+time);
//		path.mkdir();
//		@SuppressWarnings("static-access")
//		File srcFiler  = ((TakeScreenshot)file).getScreenshot(OutputType.FILE);
//		File destFiler  = new File (path+File.separator+dateWithTime.format(date)+".png");
//		FileUtils.copyFile(srcFiler,destFiler);
//		return destFiler;
//				
//	}
//	public File getScreenshotAs(OutputType<File> file) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//}
