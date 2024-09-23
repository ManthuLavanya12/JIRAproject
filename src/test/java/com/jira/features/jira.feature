Feature: Create Jira issue with multiple files
  
  Scenario: Create a Jira issue and attach files
    Given set base path and base uri
    And set authentication
    When send post request to create issue with attachments
    Then should receive a status code of 201
    And the issue should be created with the specified attachments
    

  
