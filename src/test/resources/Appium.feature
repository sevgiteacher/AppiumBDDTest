Feature: Testing apks dynamically independent from activity and package
  Scenario: user create a new account
    Given user is on app
    When user click "Contacts"
    And user click "Create_new_contact"
    And user types "Deneme2" to "First_Name" area
    And user types "Test2" to "Last_Name" area
    And user types "07136283602" to "Phone" area
    And user click "Save"
#    Then new account is saved

  Scenario: user should swipe with TouchAction class
    Given user is on app
    And user click "Views"
    And user scroll to "Tabs"
    And user click "Tabs"
    And user click "Scrollable"
    And user scroll "TAB_5" to "TAB_1"
    And user click "TAB_8"

