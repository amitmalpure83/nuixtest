package com.nuix.base;

import java.io.File;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	protected static WebDriver webDriver;

	@BeforeClass
	public static void prepareWebDriver() 
	{
		WebDriverManager.chromedriver().setup();
		createWebDriver();
	}

	public static void prepareFirefoxWebDriver() 
	{
		System.setProperty("webdriver.gecko.driver", "./resources/geckodriver.exe");

		//WebDriverManager.firefoxdriver().setup();

		FirefoxOptions options = new FirefoxOptions();
		File pathToFirefoxBinary = new File("C:\\Users\\200848\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToFirefoxBinary);
		options.setBinary(ffBinary);

		System.setProperty("webdriver.firefox.bin", "C:\\Users\\200848\\AppData\\Local\\Mozilla Firefox\\firefox.exe");

		webDriver = new FirefoxDriver(options);
	}

	@BeforeTest
	public void setUp() 
	{

	}

	@AfterClass
	public static void afterEachBaseSeleniumTest() 
	{
		if (webDriver != null) 
		{
			webDriver.quit();
		}
	}


	protected static void createWebDriver() 
	{
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		options.addArguments("--window-size=1920,1200");
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);

		webDriver = new ChromeDriver(options);
	}
}