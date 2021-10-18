package com.nuix.web.pageobjects;

import org.openqa.selenium.By;

public class HotelSearchPageObjects 
{
	public static By destinationTextBoxToClick = By.xpath("//button[@aria-label='Going to']");
	public static By destinationTextBoxToType = By.xpath("//input[@placeholder = 'Where are you going?']");
	public static By destinationTextBoxToSelect = By.xpath("//ul[@data-stid= 'location-field-destination-results']/li");
	
	public static By departureDateBox = By.id("d1-btn");
	public static By returningDateBox = By.id("d2-btn");
	
	public static By travelersTextBoxToClick = By.xpath("//button[contains(@aria-label, 'traveler')]");
	public static By noOfadultsTextBox = By.xpath("//input[@type = 'text' and @id = 'adult-input-0']");
	public static By noOfadultsDecreaseButton = By.xpath("//input[@type = 'text' and @id = 'adult-input-0']/preceding-sibling::button");
	public static By noOfadultsIncreaseButton = By.xpath("//input[@type = 'text' and @id = 'adult-input-0']/following-sibling::button");
	public static By noOfChildTextBox = By.xpath("//input[@type = 'text' and @id = 'child-input-0']");
	public static By noOfChildDecreaseButton = By.xpath("//input[@type = 'text' and @id = 'child-input-0']/preceding-sibling::button");
	public static By noOfChildIncreaseButton = By.xpath("//input[@type = 'text' and @id = 'child-input-0']/following-sibling::button");
	public static By childAge1Select = By.id("child-age-input-0-0");
	public static By childAge2Select = By.id("child-age-input-0-1");
	public static By travelersDoneButton = By.xpath("//button[text() = 'Done']");

	public static By searchButton = By.xpath("//button[text() = 'Search']");
	
	public static By selectHotel = By.xpath("//li[@data-stid = 'property-listing']");
	public static By selectHotelName = By.xpath("//li[@data-stid = 'property-listing']//h3");
	public static By continueButton = By.xpath("//button[text() = 'Select']");
	
	/*
	 * public static By getDepartureDateButton(String dateStr) {
	 * departureDateButtonXpathStr =
	 * departureDateButtonXpathStr.replaceAll("#DATE#", dateStr); By
	 * departureDateButton = By.xpath(departureDateButtonXpathStr); return
	 * departureDateButton; }
	 * 
	 * public static By getReturnDateButton(String dateStr) {
	 * returnDateButtonXpathStr = returnDateButtonXpathStr.replaceAll("#DATE#",
	 * dateStr); By departureDateButton = By.xpath(returnDateButtonXpathStr); return
	 * departureDateButton; }
	 */
}
