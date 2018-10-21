Feature: ChooseCar

  Scenario: Successfully choosing a car
    Given user is on Home page
    When user click on a car 
    Then he will be navigated to the car details page
    And car details will be displayed