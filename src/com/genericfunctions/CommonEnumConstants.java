package com.genericfunctions;


	public enum CommonEnumConstants
	{
		CHROMEEXEPATH("/drivers/chromedriver.exe"),
		FIREFOXEXEPATH("/drivers/"),
		IEDEXEPATH("/driver/"),
		GECKOEXEPATH("/drivers/geckodriver.exe"),
		SAFARIEXEPATH("/driver/"),
		OPERAEXEPATH("/driver/"),
		OBJECTREPOSITORYPATH("/Config/OR.properties"),
		EXCELFILEPATH("/TestData/Excel.xlsx"),
		SCREENSHOTPATH("/Screenshots/"),
		ATTACHSCREENSHOTS("/Screenshots/"),
		USERDIRECTORY("user.dir"),
		CONFIGFILEPATH("/Config/config.properties"),
		CHROMEDIRVER("webdriver.chrome.driver"),
		IEDRIVER("webdriver.ie.driver"),
		FIREFOXDRIVER("webdriver.gecko.driver");
		
		//private final String value;
		private final String value;
		private CommonEnumConstants(String val)
		{
			value = val;
		}
		public String getValue()
		{
			return value;
		}
	}


