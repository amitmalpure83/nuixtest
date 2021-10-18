package com.nuix.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nuix.constants.AppConstants;

public class WebDriverUtil 
{
	private static WebDriver webDriver = null;
	private static WebDriverWait wait = null;

	public static WebDriver launch(WebDriver webDriver)
	{
		WebDriverUtil.webDriver = webDriver;
		webDriver.get(AppConstants.APP_URL);
		webDriver.manage().window().maximize();

		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(webDriver, 120);

		return webDriver;
	}

	public static void waitForPageToLoad(By element) 
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
	}

	public static void clickIfVisible(By element) 
	{
		if(isElementVisible(element))
		{
			webDriver.findElement(element).click();;
		}
	}

	public static void clickIfExists(By element) 
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));

		if(isElementPresent(element))
		{
			webDriver.findElement(element).click();
		}
	}

	public static void click(By element) 
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		webDriver.findElement(element).click();
	}

	public static void enterText(By element, String text, boolean isClear, boolean isCntlA) 
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));

		if(isClear)
		{
			webDriver.findElement(element).clear();
		}

		if(isCntlA)
		{
			webDriver.findElement(element).sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
		}
		else
		{
			webDriver.findElement(element).sendKeys(text);
		}
	}

	public static void enterText(By element, String text) 
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		webDriver.findElement(element).sendKeys(text);
	}

	public static void selectDropDown(By element, String option)
	{
		Select dropDown = new Select(webDriver.findElement(element));
		dropDown.selectByVisibleText(option);
	}

	public static void selectMultiLvlDropDown(By element, String option)
	{
		Select dropDown1 = new Select(webDriver.findElement(element));
		List<WebElement> optionsList = dropDown1.getOptions();

		for(WebElement optionElement : optionsList)
		{
			if(option.equals(optionElement.getText()))
			{
				optionElement.click();
				break;
			}
		}
	}

	public static String getLabel(By element) 
	{
		try {
			return webDriver.findElement(element).getText();
		} catch (NoSuchElementException e) {
			return "NoSuchElementException";
		}
	}
	
	public static String getAttributeValue(By element) 
	{
		String attributeName = "value";
		
		try {
			return webDriver.findElement(element).getAttribute(attributeName);
		} catch (NoSuchElementException e) {
			return "NoSuchElementException";
		}
	}

	public static boolean isElementPresent(By element) 
	{
		List<WebElement> elementList = webDriver.findElements(element);

		if(elementList.size() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean isElementVisible(By element)
	{
		return webDriver.findElement(element).isDisplayed();
	}

	public static void clickALink(By element, int attempts)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		
		try
		{
		List<WebElement> elementList = webDriver.findElements(element);

		for(WebElement element1 : elementList)
		{
			if(element1.isDisplayed())
			{
				element1.click();
				break;
			}
		}
		} catch (StaleElementReferenceException e) 
		{
			attempts++;

			if(attempts <= 2) 
			{
				clickALink(element, attempts);
			}
			else
			{
				e.printStackTrace();
			}
		}
	}

	public static void selectFromList(By element, String text, int attempts)
	{
		try 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));

			List<WebElement> elementList = webDriver.findElements(element);

			for(WebElement element1 : elementList)
			{
				if(element1.isDisplayed())
				{
					if(element1.getText().contains(text))
					{
						//retryingFindClick(element1);
						element1.click();
						break;
					}
				}
			}
		} catch (StaleElementReferenceException e) 
		{
			attempts++;

			if(attempts <= 2) 
			{
				selectFromList(element, text, attempts);
			}
			else
			{
				e.printStackTrace();
			}
		}
	}

	public static void selectFromList(By element, int attempts)
	{
		try 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));

			List<WebElement> elementList = webDriver.findElements(element);

			for(WebElement element1 : elementList)
			{
				if(element1.isDisplayed())
				{
					//retryingFindClick(element1);
					element1.click();
					break;
				}
			}
		} catch (StaleElementReferenceException e) 
		{
			attempts++;

			if(attempts <= 2) 
			{
				selectFromList(element, attempts);
			}
			else
			{
				e.printStackTrace();
			}
		}
	}
	
	public static String selectFromListAndGetValue(By element, By element2, int attempts)
	{
		String selectedHotelName = "";
		try 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));

			List<WebElement> elementList = webDriver.findElements(element);

			for(WebElement element1 : elementList)
			{
				if(element1.isDisplayed())
				{
					//retryingFindClick(element1);
					selectedHotelName = element1.findElement(element2).getText();
					element1.click();
					break;
				}
			}
		} catch (StaleElementReferenceException e) 
		{
			attempts++;

			if(attempts <= 2) 
			{
				selectFromList(element, attempts);
			}
			else
			{
				e.printStackTrace();
			}
		}
		
		return selectedHotelName;
	}

	public static boolean retryingFindClick(WebElement element1) 
	{
		boolean result = false;
		int attempts = 0;

		while(attempts < 2) 
		{
			try 
			{
				element1.click();
				result = true;
				break;
			} catch(StaleElementReferenceException e) {       }
			attempts++;
		}
		return result;
	}

	public static void switchPages() 
	{
		String oldTab = webDriver.getWindowHandle();

		ArrayList<String> newTabList = new ArrayList<String>(webDriver.getWindowHandles());
		newTabList.remove(oldTab);
		webDriver.switchTo().window(newTabList.get(0));

	}

	public static void makeAction() 
	{
		Actions action = new Actions(webDriver);
		action.sendKeys(Keys.ESCAPE);		
	}
}
