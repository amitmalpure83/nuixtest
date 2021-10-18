package com.nuix.web.pageactions;

import com.nuix.utils.WebDriverUtil;
import com.nuix.web.pageobjects.HomePageObjects;

public class HomePageActions 
{
	public void clickSignInButton()
	{
		if(!WebDriverUtil.isElementPresent(HomePageObjects.popupSignInButton))
		{
			WebDriverUtil.clickIfExists(HomePageObjects.signInButton);
		}
	}
	
	public void clickPopupSignInButton()
	{
		WebDriverUtil.waitForPageToLoad(HomePageObjects.popupSignInButton);
		WebDriverUtil.clickIfExists(HomePageObjects.popupSignInButton);
	}
	
	public void checkForPopupButton() 
	{
		WebDriverUtil.isElementPresent(HomePageObjects.popupSignInButton);
	}
	
	public void typeUserName(String userName)
	{
		WebDriverUtil.waitForPageToLoad(HomePageObjects.emailIdTextBox);
		WebDriverUtil.enterText(HomePageObjects.emailIdTextBox, userName, true, true);
	}
	
	public void typePsw(String password)
	{
		WebDriverUtil.enterText(HomePageObjects.pswTextBox, password, true, true);
	}
	
	public void clickLoginButton()
	{
		WebDriverUtil.clickIfExists(HomePageObjects.loginButton);
	}

	public void selectFlightSearch() 
	{
		WebDriverUtil.clickALink(HomePageObjects.moreTravelFlightSelection, 2);		
	}
	
	public void selectHotelSearch() 
	{
		WebDriverUtil.clickALink(HomePageObjects.moreTravelHotelSelection, 2);		
	}
	
	public void selectMoreTravel() 
	{
		
		WebDriverUtil.makeAction();
		WebDriverUtil.clickALink(HomePageObjects.moreTravelSelection, 2);		
	}

}
