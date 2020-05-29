Feature: Create account testing
  Scenario: user create a new account
    Given user is on phone app
    When user tap "Contacts"
    And user tap "Create_new_contact"
    And user types "Deneme" to "First_Name" area
    And user types "Test" to "Last_Name" area
#    And user types "07136283608" to "Phone" area
#    And user tap "Save"
#    Then new account is saved
