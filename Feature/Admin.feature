Feature: Admin

  @smoke
  Scenario: Login with valid credentials
    Given User launch chrome browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    When User eneter email as "admin@yourstore.com" and Password as "admin"
    When User clicks on Login button
    Then Verify user title page is "Dashboard / nopCommerce administration"
    Then Close browser

  @sanity
  Scenario Outline: Login Data Driven
    Given User launch chrome browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    When User eneter email as "<email>" and Password as "<password>"
    When User clicks on Login button
    Then Verify user title page is "Dashboard / nopCommerce administration"
    Then Close browser

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
      | admin@yourstore.com | admin    |
