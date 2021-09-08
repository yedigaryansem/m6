Feature: As a user i want to login to mail.ru

  @smoke
  Scenario: After log in in right section should be displayed username
    Given the user opens mail.ru website
    When  the user login to mail.ru
    Then page with "username" displayed