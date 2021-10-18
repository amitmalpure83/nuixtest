package stepdef;

import com.nuix.base.BaseTest;
import com.nuix.utils.WebDriverUtil;
import com.nuix.web.pageactions.HomePageActions;
import com.nuix.web.pageactions.SignInPageActions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test extends BaseTest
{
	@Given("^user is  on homepage$")
	public void user_is_on_homepage() throws Throwable
	{
		WebDriverUtil.launch(webDriver);
		
	}

	@When("^user navigates to Login Page$")
	public void user_navigates_to_Login_Page() throws Throwable 
	{
		HomePageActions HomePageActions = new HomePageActions();
		System.out.println("init...");
		HomePageActions.clickSignInButton();
		HomePageActions.clickPopupSignInButton();
		System.out.println("end of init...");
	}

	@When("^user enters \"(.*)\" and \"(.*)$")
	public void user_enters_username_and_Password(String userName,String password) throws Throwable 
	{
		try 
		{
			SignInPageActions signInPageActions = new SignInPageActions();
			signInPageActions.typeUserName(userName);
			signInPageActions.typePsw(password);
			signInPageActions.clickLoginButton();


		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Then("^correct \"(.*)\" is displayed$")
	public void correct_error_message_is_displayed(String errorMessage) throws Throwable 
	{
		SignInPageActions signInPageActions = new SignInPageActions();
		signInPageActions.varifyErrorMessage(errorMessage);
	}
}
