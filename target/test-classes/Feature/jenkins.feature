Feature: Verifying Login

  Scenario Outline: Verifying login with valid credentials
    Given User is on the registration form
    When User login "<userName>","<Email>","<Password>","<Confirm Pass>"
    Then User should verify success message after login "Thank you for registering!"

    Examples: 
      | userName | Email                | Password  | Confirm Pass |
      | Dhana    | ksureka924@gmail.com | Asdf1234@ | Asdf1234@    |
