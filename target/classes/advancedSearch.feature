Feature: Advanced Search
  As a user
  I want to test advanced search
  So that I can be sure that advanced search works correctly

  Scenario Outline: Find product via Advanced Search
    Given User opens '<homePage>' page
    And User checks 'Advanced search' link visibility
    And User opens advanced search page
    When User makes advanced search by keyword '<keyword>'
    And User selects search including title and description
    And User selects 'Price' checkbox
    And User enters '<minimumPriceRange>' minimum price
    And User enters '<maximumPriceRange>' maximum price
    And User selects 'Buy it now' buying format
    And User selects 'New' condition
    And User selects 'Sale items' to show in results
    And User selects 'Free international shipping' option
    And User selects 'From preferred location' option
    And User selects 'Only show items from:' checkbox
    And User selects 'Sellers with eBay stores' option
    And User clicks 'Search' button
    Then User checks search query in search result '<expectedResult>'

    Examples:
      | homePage              | keyword        | minimumPriceRange       | maximumPriceRange| expectedResult |
      | https://www.ebay.com/ |apple iphone    |200                      |1000              |apple iphone    |

  Scenario Outline: Clear options in Advanced Search
    Given User opens '<homePage>' page
    And User checks 'Advanced search' link visibility
    And User opens advanced search page
    When User makes advanced search by keyword '<keyword>'
    And User selects search including title and description
    And User selects 'Price' checkbox
    And User enters '<minimumPriceRange>' minimum price
    And User enters '<maximumPriceRange>' maximum price
    And User selects 'Buy it now' buying format
    And User selects 'New' condition
    And User selects 'Sale items' to show in results
    And User selects 'Free international shipping' option
    And User selects 'From preferred location' option
    And User selects 'Only show items from:' checkbox
    And User selects 'Sellers with eBay stores' option
    And User clicks 'Clear options' button
    Then User checks if search input field is empty

    Examples:
      | homePage              | keyword        | minimumPriceRange       | maximumPriceRange|
      | https://www.ebay.com/ |apple iphone    |200                      |1000              |

  Scenario Outline: Find product by item number
    Given User opens '<homePage>' page
    And User checks 'Advanced search' link visibility
    And User opens advanced search page
    And User opens search by item number
    When User makes search by item number '<itemNumber>'
    Then User checks search item number in search result '<expectedResult>'
    Examples:
      | homePage              |itemNumber  | expectedResult|
      | https://www.ebay.com/ |273187533934| 273187533934  |
