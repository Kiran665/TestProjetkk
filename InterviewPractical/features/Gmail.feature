Feature: Gmail Login

  Background: 
    Given Launch Chrome browser and navigate to Gmail login URL

  Scenario Outline: Successful Gmail login with valid credentials and capture screenshot
    When User enters valid email as "<username>"
    And User click on Next
    Then User enter valid password as "<password>"
    And User click on Next for login
    Then login should be successful alongwith it's verification message and page Title should be "Gmail"
    When User click on Compose and maximize window
    Then User enters  recipient email id as "<recipient>" email id and write subject and message body
    And User click on send
    And User click on Sent items for confirmation and capture it's sccreenshot
    And User click on Sign out
    And close the browser

    Examples: 
      | username               | password    | recipient           |
      | kirantest556@gmail.com | Krutika@123 | kk1889908@gmail.com |

  Scenario Outline: Gmail login failed with invalid credentials and capture screenshot
    When User enters correct email as "<username1>"
    And User click on Next Button to procced further
    Then User enter incorrect password as "<password1>"
    And User click on Next Button
    Then login failed alongwith it's error message and capture screenshot
    And close the browser after user enters invalid password

    Examples: 
      | username1           | password1 |
      | kk1889908@gmail.com | Test@123  |
