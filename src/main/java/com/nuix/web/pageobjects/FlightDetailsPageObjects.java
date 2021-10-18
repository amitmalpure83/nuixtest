package com.nuix.web.pageobjects;

import org.openqa.selenium.By;

public class FlightDetailsPageObjects 
{
	public static String departureFlightLabelXpathStr = "//h2[text() = '#TAG#']";
	public static String returnFlightLabelXpathStr = "//h2[text() = '#TAG#']";
	public static String departureFlightDateLabelXPathStr = "//h2[text() = '#TAG#']/..//div[@data-test-id = 'flight-operated']";
	public static String returnFlightDateLabelXPathStr = "//h2[text() = '#TAG#']/..//div[@data-test-id = 'flight-operated']";
	
	public static By checkoutButton = By.xpath("//button[text() = 'Check out']");
	
	public static By getDepartureFlightLabel(String dateStr)
	{
		departureFlightLabelXpathStr = departureFlightLabelXpathStr.replaceAll("#TAG#", dateStr);
		By departureFlightLabel = By.xpath(departureFlightLabelXpathStr);
		return departureFlightLabel;
	}
	
	public static By getReturnFlightLabel(String dateStr)
	{
		returnFlightLabelXpathStr = returnFlightLabelXpathStr.replaceAll("#TAG#", dateStr);
		By returnFlightLabel = By.xpath(returnFlightLabelXpathStr);
		return returnFlightLabel;
	}
	
	public static By getReturnFlightDateLabel(String dateStr)
	{
		returnFlightDateLabelXPathStr = returnFlightDateLabelXPathStr.replaceAll("#TAG#", dateStr);
		By returnFlightDateLabel = By.xpath(returnFlightDateLabelXPathStr);
		return returnFlightDateLabel;
	}
	
	public static By getDepartureFlightDateLabel(String dateStr)
	{
		departureFlightDateLabelXPathStr = departureFlightDateLabelXPathStr.replaceAll("#TAG#", dateStr);
		By departureFlightDateLabel = By.xpath(departureFlightDateLabelXPathStr);
		return departureFlightDateLabel;
	}
	
}
