Feature: Smoke

  As a Guest User
  I want to know that I can use main website functionality without registration

  Scenario Outline: Search for item in different category than recommended one
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User changes search category to '<category>'
    When User makes search by keyword '<keyword>'
    Then User checks message of found amount of items in the selected category
    Examples:
      | homePage              |keyword         |category  |
      | https://www.ebay.com/ |adidas yeezy 500| Antiques |


  Scenario Outline: Search cannot be saved by guest user
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User tries to save search
    Then User checks if Sign In page is open
    Examples:
      | homePage              |keyword         |
      | https://www.ebay.com/ |adidas yeezy 500|


    Scenario Outline: Product Item can be added to the cart
      Given User opens '<productPage>' product page
      When User adds product to cart
      Then User checks if Cart Page is open
      And List summary is visible
      Examples:
        | productPage                         |
        |https://www.ebay.com/itm/133975645651|


    Scenario Outline: Product Item can be removed from the cart
      Given User opens '<productPage>' product page
      And User adds product to cart
      When User removes product item from cart
      Then Message alert is shown
      Examples:
        | productPage                          |
        | https://www.ebay.com/itm/133975645651|


    Scenario Outline: Product Item cannot be saved for later by guest user
      Given User opens '<productPage>' product page
      And User adds product to cart
      When User saves product item for later
      Then User checks if Sign In page is open
      Examples:
        | productPage                          |
        | https://www.ebay.com/itm/133975645651|

    Scenario Outline: Product item cannot be added to Watchlist by guest user
        Given User opens '<productPage>' product page
        When User adds product to watchlist
        Then User checks if Sign In page is open
        Examples:
          | productPage                          |
          | https://www.ebay.com/itm/133975645651|

    Scenario Outline: User can checkout as a guest
      Given User opens '<productPage>' product page
      When User clicks Buy it Now button
      And User selects Checkout as a guest
      Then User checks if Checkout page is open
    Examples:
      | productPage                          |
      | https://www.ebay.com/itm/133975645651|