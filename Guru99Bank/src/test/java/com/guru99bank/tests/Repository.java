package com.guru99bank.tests;

public class Repository {
	// Property keys and browser driver paths
	public static final String ffPropertyKey = "webdriver.gecko.driver";
	public static final String ffGeckoDriverPath = "C:\\Vijay\\Automation\\GeckoDrivers\\Firefox\\geckodriver.exe";
	public static final String chromePropertyKey = "webdriver.chrome.driver";
	public static final String chromeGeckoDriverPath = "C:\\Vijay\\Automation\\GeckoDrivers\\chrome\\chromedriver.exe";

	// General Setting
	public static final int WaitTime = 10;
	
	// login page details
	public static final String bankURL = "http://www.demo.guru99.com/V4/";
	public static final String userId = "mngr51699";
	public static final String password = "mAhUqAj";
	public static final String homePageTitle = "Guru99 Bank Home Page";

	// Login Page : page objects
	// ------------- Page Objects ----------------//
	// ------- xPath ---------------//
	public static final String uid = "//input[@name='uid']";
	public static final String pid = "//input[@name='password']";
	public static final String logButton = "//input[@name='btnLogin']";

	// Home Page Details
	public static final String expectedTitle = "Guru99 Bank Manager HomePage";
	public static final String expectedHeadline = "Guru99 Bank";

	// Home Page : page objects
	// ------------- Page Objects ----------------//
	// ------- xPath ---------------//
	public static final String mgrId = "//tr[@class='heading3']/td";

	// -------- CSS Selector -----------//
	public static final String check1 = ".barone";
}
