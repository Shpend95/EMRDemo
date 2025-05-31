Feature: Login related scenarios

  @smoke
  Scenario:Valid patient login
    Given user has navigated to EMR application
    When user enter valid username , password and email
    And user selects his language choice
    And user cliks on login button
    Then user is successfully logged in