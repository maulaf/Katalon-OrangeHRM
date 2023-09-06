Feature: Employee Management

Scenario: Add employee

Given user login as admin
When navigate to menu PIM
And user click add button
And user fill add form
And user click save button
Then data employee should be successfully saved
