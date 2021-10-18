package com.nuix.web.pageobjects;

import org.openqa.selenium.By;

public class SignInPageObjects 
{
	public static By emailIdTextBox = By.xpath("//input[@type = 'email']");
	public static By pswTextBox = By.xpath("//input[@type = 'password']");
	public static By loginButton = By.xpath("//button[@type = 'submit']");

	public static String userEmailidErrorLabelXpathStr = "//p[text()='#ERR_MSG1#']";
	public static By userPasswordErrorLabel = By.id("userPasswordError1");
	public static By incorrectCredentialsErrorLabel = By.xpath("//h5[@class = 'alert-message']");

	public static By getUserEmailidErrorLabel(String errorMessage)
	{
		String errorLabelXpathStr = userEmailidErrorLabelXpathStr;
		
		errorLabelXpathStr = errorLabelXpathStr.replaceAll("#ERR_MSG1#", errorMessage);
		By userEmailidErrorLabel = By.xpath(errorLabelXpathStr);
		return userEmailidErrorLabel;
	}
}
