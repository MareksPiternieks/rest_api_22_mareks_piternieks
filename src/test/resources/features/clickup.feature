Feature: This feature tests ClickUp API

  Scenario: Create folder in ClickUp space
    Given Create new folder with name "My Folder Name", save it`s data and verify it`s name
    Then Create new list
    And Verify list name is correct and it is added in correct folder
    Then Create new task in list
    And Verify task name is correct
    Then Remove task from list
    And Fetch the List and verify that the Task can't be found there


