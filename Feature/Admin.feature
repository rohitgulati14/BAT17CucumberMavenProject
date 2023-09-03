Feature:Admin

Scenario: Login with valid credentials
Given User launch chrome browser
When User open url "https://admin-demo.nopcommerce.com/login"
When User eneter email as "admin@yourstore.com" and Password as "admin"
When User clicks on Login button
Then Verify user title page is "Dashboard / nopcommerce administration"
Then Close browser