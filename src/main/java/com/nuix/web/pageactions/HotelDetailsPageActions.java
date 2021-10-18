package com.nuix.web.pageactions;

import static org.testng.Assert.assertEquals;

import com.nuix.utils.WebDriverUtil;
import com.nuix.web.pageobjects.FlightDetailsPageObjects;
import com.nuix.web.pageobjects.HotelDetailsPageObjects;

public class HotelDetailsPageActions 
{
	public void waitForPageToLoad(String hotelName) 
	{
		WebDriverUtil.waitForPageToLoad(HotelDetailsPageObjects.getHotelNameLabel(hotelName));
	}

	public void varifyHotelDetails(String hotelName) 
	{
		String actualHotelName = WebDriverUtil.getLabel(HotelDetailsPageObjects.getHotelNameLabel(hotelName));

		assertEquals(actualHotelName, hotelName, "Hotel Details doesn't match! Expected Value : " + hotelName + " Actual Value : " + actualHotelName );
	}

	public void clickCheckOut() 
	{
		WebDriverUtil.click(FlightDetailsPageObjects.checkoutButton);
	}

	public void switchtoHotelDetailsPage() 
	{
		WebDriverUtil.switchPages();
	}
}
