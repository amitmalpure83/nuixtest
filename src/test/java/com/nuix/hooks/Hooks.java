package com.nuix.hooks;

import com.nuix.base.BaseTest;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks 
{
	@Before
    public void beforeScenario()
	{
		WebDriverManager.chromedriver().setup();
		BaseTest.prepareWebDriver();
    }	
	
	@After
    public void afterScenario()
	{
		BaseTest.afterEachBaseSeleniumTest();
    }
}
