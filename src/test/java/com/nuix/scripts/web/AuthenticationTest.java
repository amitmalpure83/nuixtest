package com.nuix.scripts.web;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nuix.base.BaseTest;
import com.nuix.utils.NuixDataProvider;
import com.nuix.utils.StringUtils;
import com.nuix.utils.WebDriverUtil;
import com.nuix.web.pageactions.HomePageActions;
import com.nuix.web.pageactions.SignInPageActions;

public class AuthenticationTest extends BaseTest
{
	@BeforeClass
	public void init(ITestContext context)
	{
		WebDriverUtil.launch(webDriver);
		
		HomePageActions HomePageActions = new HomePageActions();
		System.out.println("init...");
		HomePageActions.clickSignInButton();
		HomePageActions.clickPopupSignInButton();
		System.out.println("end of init...");

	}
	
	@Test (dataProvider = "data-provider", dataProviderClass = NuixDataProvider.class, priority=1)
	public void invalidCredentialsTest(ITestContext context, Object[] data)
	{
		Map<String, String> dataMap = StringUtils.getData(data);

		String userName = dataMap.get("userName");	
		String password = dataMap.get("password");	
		String errorMessage = dataMap.get("errorMessage");	

		try 
		{
			SignInPageActions signInPageActions = new SignInPageActions();
			signInPageActions.typeUserName(userName);
			signInPageActions.typePsw(password);
			signInPageActions.clickLoginButton();

			signInPageActions.varifyErrorMessage(errorMessage);

		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
	@Test (dataProvider = "data-provider", dataProviderClass = NuixDataProvider.class, priority=2)
	public void incorrectCredentialsTest(ITestContext context, Object[] data)
	{
		Map<String, String> dataMap = StringUtils.getData(data);

		String userName = dataMap.get("userName");	
		String password = dataMap.get("password");	
		String errorMessage = dataMap.get("errorMessage");	

		try 
		{
			SignInPageActions signInPageActions = new SignInPageActions();
			signInPageActions.typeUserName(userName);
			signInPageActions.typePsw(password);
			signInPageActions.clickLoginButton();

			signInPageActions.varifyErrorMessageForIncorrectCredentials(errorMessage);

		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
