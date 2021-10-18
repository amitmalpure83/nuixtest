package com.nuix.web.pageactions;

import com.nuix.utils.WebDriverUtil;
import com.nuix.web.pageobjects.FlightSearchPageObjects;
import com.nuix.web.pageobjects.HotelSearchPageObjects;

public class HotelSearchPageActions 
{
	public void waitForPageToLoad() 
	{
		WebDriverUtil.waitForPageToLoad(HotelSearchPageObjects.destinationTextBoxToClick);
	}
	
	public void waitForSearchPageToLoad() 
	{
		WebDriverUtil.waitForPageToLoad(HotelSearchPageObjects.selectHotel);
	}

	public void enterDestinationCity(String destinationCity) throws InterruptedException 
	{
		WebDriverUtil.click(HotelSearchPageObjects.destinationTextBoxToClick);
		WebDriverUtil.enterText(HotelSearchPageObjects.destinationTextBoxToType, destinationCity);
		WebDriverUtil.selectFromList(HotelSearchPageObjects.destinationTextBoxToSelect, destinationCity, 0);	
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

	public String selectHotel() 
	{
		return WebDriverUtil.selectFromListAndGetValue(HotelSearchPageObjects.selectHotel, HotelSearchPageObjects.selectHotelName, 2);
	}

	public void selectTravelers(String noOfAdultsStr, String noOfChildrenStr, String childAge1Str, String childAge2Str) 
	{
		int noOfAdults = Integer.parseInt(noOfAdultsStr);
		int noOfChildren = Integer.parseInt(noOfChildrenStr);
		
		WebDriverUtil.click(HotelSearchPageObjects.travelersTextBoxToClick);
		
		String actualNOfAdultsStr = WebDriverUtil.getAttributeValue(HotelSearchPageObjects.noOfadultsTextBox);
		int actualNOfAdults = Integer.parseInt(actualNOfAdultsStr);

		while(noOfAdults != actualNOfAdults)
		{
			if(noOfAdults > actualNOfAdults)
			{
				WebDriverUtil.click(HotelSearchPageObjects.noOfadultsIncreaseButton);
				actualNOfAdults++;
			}
			else if(noOfAdults < actualNOfAdults)
			{
				WebDriverUtil.click(HotelSearchPageObjects.noOfadultsDecreaseButton);
				actualNOfAdults--;
			}
		}
		
		String actualNOfChildStr = WebDriverUtil.getAttributeValue(HotelSearchPageObjects.noOfChildTextBox);
		int actualNOfChild = Integer.parseInt(actualNOfChildStr);

		while(noOfChildren != actualNOfChild)
		{
			if(noOfChildren > actualNOfChild)
			{
				WebDriverUtil.click(HotelSearchPageObjects.noOfChildIncreaseButton);
				actualNOfChild++;
			}
			else if(noOfChildren < actualNOfChild)
			{
				WebDriverUtil.click(HotelSearchPageObjects.noOfChildDecreaseButton);
				actualNOfChild--;
			}
		}
		
		WebDriverUtil.selectDropDown(HotelSearchPageObjects.childAge1Select, childAge1Str);
		WebDriverUtil.selectDropDown(HotelSearchPageObjects.childAge2Select, childAge2Str);
		
		WebDriverUtil.click(HotelSearchPageObjects.travelersDoneButton);
	}
}
