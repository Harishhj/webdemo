package com.utilities;

import com.aventstack.extentreports.Status;

public class Log extends ExtentReport{

	public static void startTestCase(String sTestCaseName)
	{
//		logger.log(Status.INFO,"************");
//		logger.log(Status.INFO, "************");
		logger.log(Status.INFO, "************");
		logger.log(Status.INFO, "************"+sTestCaseName+"************");
		logger.log(Status.INFO, "************");
//		logger.log(Status.INFO, "************");
	}
	
	public static void endTestCase(String sTestCaseName)
	{
		logger.log(Status.INFO, "************"+"END"+"*************");
		logger.log(Status.INFO, "**********");
		logger.log(Status.INFO, "**********");
	}
	
	public static void info(String message)
	{
		logger.log(Status.INFO,message);
	}
	
	public static void error(String message)
	{
		Log.error(message);
		
	}
}






