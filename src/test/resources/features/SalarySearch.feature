@test
Feature: Salaries Filter
  Scenario Outline: User can filter salaries
    Given a user selects the role "<roleName>"
    And a user selects the country "<countryName>"
    When a user clicks the search button
    Then the selected data "<countryName>" and "<roleName>" appear in the page
    Examples:
    | roleName           | countryName |
    | Accountant         | Brazil      |
    | Mobile QA Engineer | Canada      |
    | Software Engineer  | Japan       |