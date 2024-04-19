#Author:SemaDemir

Feature: Add New Student

Scenario: Adding a new student at Student page

Given I navigated the Student page
Then I clicked add new student button
And I validated that a student data form opened
Then I submit all data of the student 
When I validated all boxes filled out
Then clicked submit button 
Then I validated a new student is added
