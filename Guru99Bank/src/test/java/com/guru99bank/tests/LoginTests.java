package com.guru99bank.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests {
	// Initialization of variables
	static WebDriver driver;

	// Browser selection
	// 1 - Firefox
	// 2 - Chrome
	int Browser = 2;

	@BeforeClass
	public void setup() {
		if (Browser == 1) {
			System.setProperty(Repository.ffPropertyKey, Repository.ffGeckoDriverPath);
			driver = new FirefoxDriver();
		} else if (Browser == 2) {
			System.setProperty(Repository.chromePropertyKey, Repository.chromeGeckoDriverPath);
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
	}

	@Test
	public void pageLoad() {
		driver.get(Repository.bankURL);
		driver.manage().timeouts().implicitlyWait(Repository.WaitTime,TimeUnit.SECONDS);
		// Assertion on the title of the page
		Assert.assertEquals(driver.getTitle(), Repository.homePageTitle);
	}

	@Test(dependsOnMethods = "pageLoad")
	public void Login() {
		driver.findElement(By.xpath(Repository.uid)).sendKeys(Repository.userId);
		driver.findElement(By.xpath(Repository.pid)).sendKeys(Repository.password);
		driver.findElement(By.xpath(Repository.logButton)).click();

		// Explicit Wait conditions
		// WebDriverWait wait = new WebDriverWait(driver, 5);
		// WebElement mgrIdText =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mgrId)));
		// String mgrLkt = mgrIdText.getText();

		String mgrLkt = driver.findElement(By.xpath(Repository.mgrId)).getText();
		String ManagerId = mgrLkt.substring(12, mgrLkt.length());

		// Assertions on the page
		Assert.assertEquals(driver.findElement(By.cssSelector(Repository.check1))
				.getText(), Repository.expectedHeadline);
		Assert.assertEquals(driver.getTitle(), Repository.expectedTitle);
		Assert.assertEquals(ManagerId, Repository.userId);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
