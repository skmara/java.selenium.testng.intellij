Feature: Home
  @Fail
  Scenario: User Should able to launch the application- possitive
    Given The user Launch the url "https://myoperator.com/careers"
    Then I Verify The Expected title is "Join India's best SAAS company to work for | MyOperator"

  Scenario: User Should able to launch the application- Possitive
    Given The user Launch the url "https://myoperator.com/"
    Then I Verify The Expected title is "India’s 1st Call + WhatsApp Business Communication Platform"

  Scenario: User Should not able to launch the application- Negeative
    Given The user Launch the url "https://myoperator.com/"
    Then I Verify The Expected title is not "Join India's best SAAS company to work for | MyOperator"

  Scenario: User Should not able to launch the application- Negative
    Given The user Launch the url "https://myoperator.com/careers"
    Then I Verify The Expected title is not "India’s 1st Call + WhatsApp Business Communication Platform"

  Scenario: Verify User can able see 404 for invalid url
    Given The user Launch the url "http://localhost:63342/Automation/target/cucumber-reports.html?_ijt=iqaji2j2kcqqlog1rcs2kngfhc&_ij_reload=RELOAD_ON_SAVE#686a9745-9292-4d75-961c-1ec2ab74cfc2"
    Then I verify "404 Not Found" error

  @Career
  Scenario: User Should able to View the open positions Click the OpenPosition- possitive
    Given The user Launch the url "https://myoperator.com/careers"
    When User Click on open position
    Then I Verify The button is Clicked
  @Career
  Scenario: User can able to see the catogory of oppertunities- Possitive
    Given The user Launch the url "https://myoperator.com/careers"
    When User Click on open position
    Then I Verify The catogories or present "Operations,Customer support,Marketing,Sales,Technical,HR,Finance"

  @Career @Apply
  Scenario: Verify User can able see the error message Fill Application - Negative
    Given The user Launch the url "https://myoperator.com/careers"
    When User Click on open position
    And I click on the "Technical" Catagory
    Then I Verify user moved to new tab with the title of "Jobs @ MyOperator"
    When I Click on "View Current Openings"
    And I Click on Remote Jobs
    And I Click on "Product Designer"
    And I Click on apply now button
    When I click on submit button
    Then I verify the Error message for "First Name,Last Name,Email,Mobile,Age,Gender,City,Province,Country,Resume"





