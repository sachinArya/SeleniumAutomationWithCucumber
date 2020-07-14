Feature: User is able to search for products on amazon.com

  @searchProduct
  Scenario Outline: user is able to search for products
    Given User is on "https://www.amazon.co.uk"
    When user enters the "<product_name>" in searchbox and click search
    Then user gets search results

    Examples:
    |product_name|
    |thanos      |
    #|Lenovo      |