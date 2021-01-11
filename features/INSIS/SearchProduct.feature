Feature: User is able to search for products on amazon.com

  @TestGrp @searchProduct
  Scenario Outline: user is able to search for products
    Given User is on "https://www.amazon.co.uk"
    When user enters the "<product_name>" in searchbox and click search
    Then user gets search results

    Examples:
    |product_name|
    |thanos      |
    |Lenovo      |


    @TestGrp @searchProductInADepartment
   Scenario Outline: user is able to select a store and find a product
     Given User is on "https://www.amazon.co.uk"
     And select the department
           |Department|
           |Toys & Games|
     When user enters the "<product_name>" in searchbox and click search
     Then user gets search results
     And  user sorts the item by "Price: Low to High"
     And  filter results for free UK delivery

     Examples:
       |product_name|
       |thanos      |