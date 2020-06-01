Feature: Testing apks dynamically independent from activity and package
  Scenario: user create a new account
    Given user is on phone app
    When user click "Contacts"
    And user click "Create_new_contact"
    And user types "Deneme" to "First_Name" area
    And user types "Test" to "Last_Name" area
    And user types "07136283608" to "Phone" area
    And user click "Save"
#    Then new account is saved


  