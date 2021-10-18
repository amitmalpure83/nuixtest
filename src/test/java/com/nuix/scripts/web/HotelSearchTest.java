package com.nuix.scripts.web;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.nuix.base.BaseTest;
import com.nuix.utils.NuixDataProvider;
import com.nuix.utils.StringUtils;
import com.nuix.utils.WebDriverUtil;
import com.nuix.web.pageactions.HomePageActions;
import com.nuix.web.pageactions.HotelDetailsPageActions;
import com.nuix.web.pageactions.HotelSearchPageActions;

public class HotelSearchTest extends BaseTest
{
	@Test (dataProvider = "data-provider", dataProviderClass = NuixDataProvider.class, priority=4)
	public void flightSearchTest(ITestContext context, Object[] data)
	{
		Map<String, String> dataMap = StringUtils.getData(data);

		String destinationCity = dataMap.get("DestinationCity");	
		String departingDate = dataMap.get("DepartingDate");	
		String returnDate = dataMap.get("ReturnDate");	
		String noOfAdults = dataMap.get("noOfAdults");	
		String noOfChildren = dataMap.get("noOfChildren");	
		String childAge1 = dataMap.get("childAge1");	
		String childAge2 = dataMap.get("childAge2");	
		
		try 
		{
			WebDriverUtil.launch(webDriver);
			
			HomePageActions HomePageActions = new HomePageActions();
			System.out.println("before selectMoreTravel");
			HomePageActions.selectMoreTravel();
			HomePageActions.selectHotelSearch();

			HotelSearchPageActions hotelSearchPageActions = new HotelSearchPageActions();
			hotelSearchPageActions.waitForPageToLoad();
			hotelSearchPageActions.enterDestinationCity(destinationCity);
			hotelSearchPageActions.selectDepartingDate(departingDate);
			hotelSearchPageActions.selectReturnDate(returnDate);
			hotelSearchPageActions.clickDone();
			hotelSearchPageActions.selectTravelers(noOfAdults, noOfChildren, childAge1, childAge2);
			hotelSearchPageActions.clickSearch();

			hotelSearchPageActions.waitForSearchPageToLoad();
			String selectedHotelName = hotelSearchPageActions.selectHotel();
			
			HotelDetailsPageActions hotelDetailsPageActions = new HotelDetailsPageActions();
			hotelDetailsPageActions.switchtoHotelDetailsPage();
			hotelDetailsPageActions.waitForPageToLoad(selectedHotelName);
			hotelDetailsPageActions.varifyHotelDetails(selectedHotelName);
			
			Thread.sleep(5000);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
