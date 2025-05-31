Feature: Appointment Management

  Background:
    Given user has navigated to EMR application
    When user enter valid username , password and email
    And user cliks on login button
    Then user is successfully logged in

  @appointment
  Scenario: Schedule a new appointment
    #Given I am on the dashboard page
    When I click on Appointments
    And I click on Schedule a New Appointment
    And I select a doctor and date
    And I enter the reason of this visit
    And I click save
    Then I should be able to see the appointment form
