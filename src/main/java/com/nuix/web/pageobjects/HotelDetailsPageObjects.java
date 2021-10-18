package com.nuix.web.pageobjects;

import org.openqa.selenium.By;

public class HotelDetailsPageObjects 
{
	public static String hotelNameLabelXpathStr = "//h1[text() = '#TAG#']";
	
	public static By checkoutButton = By.xpath("//button[text() = 'Reserve']");
	
	public static By getHotelNameLabel(String hotelName)
	{
		hotelNameLabelXpathStr = hotelNameLabelXpathStr.replaceAll("#TAG#", hotelName);
		By hotelNameLabel = By.xpath(hotelNameLabelXpathStr);
		return hotelNameLabel;
	}
	
	
}
