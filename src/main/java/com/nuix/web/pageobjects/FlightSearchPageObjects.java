package com.nuix.web.pageobjects;

import org.openqa.selenium.By;

public class FlightSearchPageObjects 
{
	public static By departureTextBoxToClick = By.xpath("//button[@aria-label='Leaving from']");
	public static By departureTextBoxToType = By.xpath("//input[@placeholder = 'Where are you leaving from?']");
	public static By departureTextBoxToSelect = By.xpath("//ul[@data-stid= 'location-field-leg1-origin-results']/li");
	
	public static By destinationTextBoxToClick = By.xpath("//button[@aria-label='Going to']");
	public static By destinationTextBoxToType = By.xpath("//input[@placeholder = 'Where are you going to?']");
	public static By destinationTextBoxToSelect = By.xpath("//ul[@data-stid= 'location-field-leg1-destination-results']/li");
	
	public static By departureDateBox = By.id("d1-btn");
	public static By returningDateBox = By.id("d2-btn");
	public static By searchButton = By.xpath("//button[text() = 'Search']");
	
	public static String departureDateButtonXpathStr = "//button[contains(@aria-label, '#DATE#')]";
	public static String returnDateButtonXpathStr = "//button[contains(@aria-label, '#DATE#')]";
	public static By selectDateButton = By.xpath("//button[@data-stid = 'apply-date-picker']");
	
	public static By chooseDepartingFlightLabel = By.xpath("//span[text() = 'Choose departing flight']");
	public static By selectFlight = By.xpath("//li[@data-test-id = 'offer-listing']");
	public static By continueButton = By.xpath("//button[text() = 'Select']");
	
	
	public static By getDepartureDateButton(String dateStr)
	{
		departureDateButtonXpathStr = departureDateButtonXpathStr.replaceAll("#DATE#", dateStr);
		By departureDateButton = By.xpath(departureDateButtonXpathStr);
		return departureDateButton;
	}

	public static By getReturnDateButton(String dateStr) 
	{
		returnDateButtonXpathStr = returnDateButtonXpathStr.replaceAll("#DATE#", dateStr);
		By departureDateButton = By.xpath(returnDateButtonXpathStr);
		return departureDateButton;
	}
}
