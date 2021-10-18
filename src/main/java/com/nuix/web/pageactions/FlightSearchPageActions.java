package com.nuix.web.pageactions;

import com.nuix.utils.WebDriverUtil;
import com.nuix.web.pageobjects.FlightSearchPageObjects;

public class FlightSearchPageActions 
{
	public void waitForPageToLoad() 
	{
		WebDriverUtil.waitForPageToLoad(FlightSearchPageObjects.departureTextBoxToClick);
	}
	
	public void waitForSearchPageToLoad() 
	{
		WebDriverUtil.waitForPageToLoad(FlightSearchPageObjects.selectFlight);
	}

	public void enterDepartureCity(String departureCity) throws InterruptedException 
	{
		WebDriverUtil.click(FlightSearchPageObjects.departureTextBoxToClick);
		WebDriverUtil.enterText(FlightSearchPageObjects.departureTextBoxToType, departureCity);
		WebDriverUtil.selectFromList(FlightSearchPageObjects.departureTextBoxToSelect, departureCity, 0);

	}

	public void enterDestinationCity(String destinationCity) throws InterruptedException 
	{
		WebDriverUtil.click(FlightSearchPageObjects.destinationTextBoxToClick);
		WebDriverUtil.enterText(FlightSearchPageObjects.destinationTextBoxToType, destinationCity);
		WebDriverUtil.selectFromList(FlightSearchPageObjects.destinationTextBoxToSelect, destinationCity, 0);	
	}

	public void selectDepartingDate(String dateStr) 
	{
		WebDriverUtil.click(FlightSearchPageObjects.departureDateBox);
		WebDriverUtil.click(FlightSearchPageObjects.getDepartureDateButton(dateStr));
	}

	public void selectReturnDate(String dateStr) 
	{
		WebDriverUtil.click(FlightSearchPageObjects.getReturnDateButton(dateStr));
	}

	public void clickDone() 
	{
		WebDriverUtil.click(FlightSearchPageObjects.selectDateButton);
	}

	public void clickSearch() 
	{
		WebDriverUtil.click(FlightSearchPageObjects.searchButton);
	}

	public void selectDepartingFlight() 
	{
		WebDriverUtil.selectFromList(FlightSearchPageObjects.selectFlight, 2);
		WebDriverUtil.click(FlightSearchPageObjects.continueButton);

	}

	public void selectReturningFlight() 
	{
		WebDriverUtil.selectFromList(FlightSearchPageObjects.selectFlight, 2);
		WebDriverUtil.click(FlightSearchPageObjects.continueButton);		
	}
}
