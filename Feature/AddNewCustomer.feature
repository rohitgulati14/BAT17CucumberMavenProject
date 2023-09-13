Feature: Customer

  Scenario Outline: Login Data Driven
    Given User launch chrome browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    When User eneter email as "<email>" and Password as "<password>"
    When User clicks on Login button
    Then Verify user title page is "Dashboard / nopCommerce administration"
    When user click on customers menu
    And user click on customers menu item
    And user click on new add button
    Then user can view add new custoer page
    When user enter customer info as "<newEmail>" and "<newPass>" and "<fname>" and "<lname>" and "<gender>" and "<comName>" and "<adminComment>"
    And user click on save button
    Then user can view confirmation msg "The new customer has been added successfully"
    Then Close browser

    Examples: 
      | email               | password | newEmail          | newPass | fname | lname  | gender | comName | adminComment |
      | admin@yourstore.com | admin    | rohit@yopmail.com |    1234 | rohit | gulati | male   | ABC     | test1        |
      #| admin@yourstore.com | admin    | joy@yopmail.com   |    2345 | joy   | arora  | female | xyz     | test2        |
      #| admin@yourstore.com | admin    | rahul@yopmail.com |    3432 | rahul | jha    | female | pqr     | test3        |
