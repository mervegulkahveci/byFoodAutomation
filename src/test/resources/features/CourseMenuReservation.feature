@test2
Feature: Course Menu Reservation
 Background: Navigate to Course Menu
   Given go to "CourseMenuRestaurant" page
   And scroll down the page
   And click on "Find Menu Options" button

  Scenario: TC001-User Completes Checkout as a Guest at Course Menu Restaurant
    Then confirm course menu section is displayed
    When click on "Select" button
    And add 2 adults
    And select a date
    And select hour
    And click on "Request Reservation" button
    Then verify landing on checkout page
    And enter "GuestEmail" in the "Email" field
    And enter "FullName" in the "Fullname (Name Surname)" field
    When enter "Country" in the "Country" field
    And click on "Country" from opened menu
    And enter "CountryCode" in the "Country code" field
    And click on "CountryCode" from opened menu
    And enter "PhoneNumber" in the "Phone number" field
    And scroll down the page
    And enter card number information
    And select the checkboxes
    And click on "Request Reservation" button
    Then verify reservation is completed successfully
    And click on "My Reservations" button
    Then verify that the reservation is displayed on user dashboard



