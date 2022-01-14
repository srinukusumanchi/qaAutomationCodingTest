Feature: Testing Lapcorp application

  Scenario: verify job post applied successfully
    Given open the browser
    Given navigate to the url "https://www.labcorp.com/"
    When click on careers link
    And search for a position "QA Test Automation Developer"
    And enter "" into city,state or zip
    And click on submit button
    And browse to the position
    And verify job location label
    And verify job id label
    And capture job details
    Then click on apply now
    Then verify job title
    Then verify posting id
    Then verify job location
    Then click on return to job search
