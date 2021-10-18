package com.nuix.web.pageactions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.nuix.utils.WebDriverUtil;
import com.nuix.web.pageobjects.FlightDetailsPageObjects;

public class FlightDetailsPageActions 
{
	public void waitForPageToLoad(String expectedDepartureFlightLabel) 
	{
		WebDriverUtil.waitForPageToLoad(FlightDetailsPageObjects.getDepartureFlightLabel(expectedDepartureFlightLabel));
	}
	
	public void varifyDepartureFlightDetails(String expectedDepartureFlightLabel, String expectedDepartureFlightDateLabel) 
	{
		String departureFlightLabel = WebDriverUtil.getLabel(FlightDetailsPageObjects.getDepartureFlightLabel(expectedDepartureFlightLabel));
		String departureFlightDateLabel = WebDriverUtil.getLabel(FlightDetailsPageObjects.getDepartureFlightDateLabel(expectedDepartureFlightLabel));
		
    	assertEquals(departureFlightLabel, expectedDepartureFlightLabel, "Departure FlightDetails doesn't match! Expected Value : " + expectedDepartureFlightLabel + " Actual Value : " + departureFlightLabel );
    	assertTrue(departureFlightDateLabel.contains(expectedDepartureFlightDateLabel), "Departure FlightDetails doesn't match! Expected Value : " + expectedDepartureFlightDateLabel + " Actual Value : " + departureFlightDateLabel );
	}
	
	public void varifyReturnFlightDetails(String expectedReturnFlightLabel, String expectedReturnFlightDateLabel) 
	{
		String returnFlightLabel = WebDriverUtil.getLabel(FlightDetailsPageObjects.getReturnFlightLabel(expectedReturnFlightLabel));
		String returnFlightDateLabel = WebDriverUtil.getLabel(FlightDetailsPageObjects.getReturnFlightDateLabel(expectedReturnFlightLabel));
		
    	assertEquals(returnFlightLabel, expectedReturnFlightLabel, "Return FlightDetails doesn't match! Expected Value : " + expectedReturnFlightLabel + " Actual Value : " + returnFlightLabel );
    	assertTrue(returnFlightDateLabel.contains(expectedReturnFlightDateLabel), "Return FlightDetails doesn't match! Expected Value : " + expectedReturnFlightDateLabel + " Actual Value : " + returnFlightDateLabel );
	}
	
	public void clickCheckOut() 
	{
		WebDriverUtil.click(FlightDetailsPageObjects.checkoutButton);
	}

	public void switchtoFlightDetailsPage() 
	{
		WebDriverUtil.switchPages();
	}
}
