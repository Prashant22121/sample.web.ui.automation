Feature: Ebay Login flow for existing customer

Scenario Outline:Verify Login for the user
  Given I am ebay user
  When I launch ebay website
  And  I login with "<Username>", "<Password>"
  Then I see welcome page

  Examples:
  | Username|Password|
  |prashantkmr2212@gmail.com|Shivbaba@1991|