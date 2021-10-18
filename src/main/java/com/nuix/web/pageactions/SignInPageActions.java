package com.nuix.web.pageactions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.nuix.utils.WebDriverUtil;
import com.nuix.web.pageobjects.HomePageObjects;
import com.nuix.web.pageobjects.SignInPageObjects;

public class SignInPageActions 
{
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

	public void varifyErrorMessage(String errorMessage) 
	{
		String actualErrorMessage = WebDriverUtil.getLabel(SignInPageObjects.getUserEmailidErrorLabel(errorMessage));
    	assertEquals(errorMessage, actualErrorMessage, "Expected error message : " + errorMessage + " Actual message : " + actualErrorMessage );
	}

	public void varifyErrorMessageForIncorrectCredentials(String errorMessage) 
	{
		String actualErrorMessage = WebDriverUtil.getLabel(SignInPageObjects.incorrectCredentialsErrorLabel);
		assertTrue(actualErrorMessage.contains(errorMessage), "Expected error message : " + errorMessage + " Actual message : " + actualErrorMessage );
	}

	
	
}
