package com.nuix.scripts.web;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.nuix.base.BaseTest;
import com.nuix.utils.NuixDataProvider;
import com.nuix.utils.StringUtils;
import com.nuix.utils.WebDriverUtil;
import com.nuix.web.pageactions.FlightDetailsPageActions;
import com.nuix.web.pageactions.FlightSearchPageActions;
import com.nuix.web.pageactions.HomePageActions;

public class FlightSearchTest extends BaseTest
{
	@Test (dataProvider = "data-provider", dataProviderClass = NuixDataProvider.class, priority=3)
	public void flightSearchTest(ITestContext context, Object[] data)
	{
		Map<String, String> dataMap = StringUtils.getData(data);

		String departureCity = dataMap.get("DepartureCity");	
		String destinationCity = dataMap.get("DestinationCity");	
		String departingDate = dataMap.get("DepartingDate");	
		String returnDate = dataMap.get("ReturnDate");	
		String departureFlightName = dataMap.get("DepartureFlightName");	
		String departureFlightDate = dataMap.get("DepartureFlightDate");	
		String returnFlightName = dataMap.get("ReturnFlightName");	
		String returnFlightDate = dataMap.get("ReturnFlightDate");	

		try 
		{
			WebDriverUtil.launch(webDriver);
			
			HomePageActions HomePageActions = new HomePageActions();
			System.out.println("before selectMoreTravel");
			
			HomePageActions.selectMoreTravel();
			HomePageActions.selectFlightSearch();

			FlightSearchPageActions flightSearchPageActions = new FlightSearchPageActions();
			flightSearchPageActions.waitForPageToLoad();
			flightSearchPageActions.enterDepartureCity(departureCity);
			flightSearchPageActions.enterDestinationCity(destinationCity);
			flightSearchPageActions.selectDepartingDate(departingDate);
			flightSearchPageActions.selectReturnDate(returnDate);
			flightSearchPageActions.clickDone();
			flightSearchPageActions.clickSearch();
			flightSearchPageActions.waitForSearchPageToLoad();
			flightSearchPageActions.selectDepartingFlight();
			flightSearchPageActions.selectReturningFlight();

			FlightDetailsPageActions flightDetailsPageActions = new FlightDetailsPageActions();
			flightDetailsPageActions.switchtoFlightDetailsPage();
			flightDetailsPageActions.waitForPageToLoad(departureFlightName);
			flightDetailsPageActions.varifyDepartureFlightDetails(departureFlightName, departureFlightDate);
			flightDetailsPageActions.varifyReturnFlightDetails(returnFlightName, returnFlightDate);
			flightDetailsPageActions.clickCheckOut();
			
			Thread.sleep(5000);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
