Feature: Login validation for Hudl

  Background:
    Given I navigate to hudl Home page
    And I click on Login Button
    And I should see login Page

  #Password provided in the note section of email
  @LoginTest @positive
  Scenario Outline: Enter valid credentials and successful login
    When I enter "<email>" with "<password>" on login page
    And I click on Login Button on login page
    Then I should be on the users home page

    Examples:
      | email                  | password |
      | abhinayyar83@gmail.com | ******** |

  @LoginTest @negative
  Scenario Outline: Enter invalid credentials and login failure
    When I enter "<email>" with "<password>" on login page
    And I click on Login Button on login page
    Then I should see login error

    Examples:
      | email            | password |
      | nayyar@gmail.com | hudl     |
      |                  | 123      |
      | abhi             |          |