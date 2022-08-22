#Author: SemaDemir

Feature: LoginPage Landing
 

  @smoke
  Scenario: Navigating and landing loginpage
   ##Given I navigated to SIS login page
    And I validated that the logo is visible
    Then I validated that the SIS Login text is visible
    And I validated that username box is visible
    And I validated that pasword box is visible
    Then I validated that academic year box is visible
    And I validated that login button is visible
    And I validated that forgot password link is visible

  
