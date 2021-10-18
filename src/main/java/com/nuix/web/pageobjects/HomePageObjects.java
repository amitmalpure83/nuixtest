package com.nuix.web.pageobjects;

import org.openqa.selenium.By;

public class HomePageObjects 
{
	  public static By signInButton = By.xpath("//div[text() = 'Sign in']");
	  public static By popupSignInButton = By.xpath("//a[text() = 'Sign in']");
	  public static By emailIdTextBox = By.id("signin-loginid");
	  public static By pswTextBox = By.id("signin-password");
	  public static By loginButton = By.id("submitButton");
	  
	  public static By moreTravelSelection = By.xpath("//div[text() = 'More travel']");
	  public static By moreTravelFlightSelection = By.xpath("//a[contains(@href,'/Flights')]/div[text() = 'Flights']");
	  public static By moreTravelHotelSelection = By.xpath("//a[contains(@href,'/Hotels')]/div[text() = 'Stays']");
	  
}
