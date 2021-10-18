Feature: Login Feature
  Verify if a invalid user is not able to Login in to the site

Scenario Outline: Login as a invalid user
    Given user is  on homepage
    When user navigates to Login Page
    And user enters "<username>" and "<password>"
    Then correct "<error message>" is displayed
    
Examples:
    | username   		| password 	|	error message							|
    | amit123 			| amit123 	|	Please provide a valid email address.	|
    | amit123@gmail.com	| amit123 	|	Please enter your password.				|
    |					|			|	Please enter your email address.		|
    