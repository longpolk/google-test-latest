Feature: Jupviec_01
  Scenario: Test Jupviec 01
    Given I login VinID app with phone number 0115272727 and OTP 123456 and PIN 112233
    Then Verify I am on Homepage of VinID
    When I click on Tiện Ích shortcut
    Then Verify I am on Tiện Ích page
    And I click on Giúp việc link