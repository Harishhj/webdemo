package com.utilities;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;

public class LoggerClass extends Log {
	
	public static Logger Log = Logger.getLogger(Logger.class.getName());
	
	public static void startTestCase(String sTestCasename)
	{
		Log.info("*************************************************************************");
		Log.info("*************************************************************************");
		Log.info("$$$$$$$$$$$$$$$$$$$$$$" +sTestCasename+ "********************************");
		Log.info("*************************************************************************");
		Log.info("*************************************************************************");
	}
	public static void endTestCase(String sTestCasename )
	{
		Log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXX"  + "-END-" + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		Log.info("X");
		Log.info("X");
		Log.info("X");
		Log.info("X");
	}
	
	public static void info(String message)
	{
		//logger.log(Status.INFO,message);
		Log.info(message);
	}

}














//Manju Code which was fixed earlier as on 4 Apr 2022


//package com.utilities;
//
//import com.aventstack.extentreports.ExtentTest;
//
//public class LoggerClass {
//	
//	 
//}
