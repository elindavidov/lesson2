Feature: Successful searching

  @test
  Scenario Outline: Successful search in progress website and found a result
    Given browser "<browser>"
    And website loaded this address: "https://progressbg.net"
    When I execute a search for "automation"
    Then I should expect there is a result
    And I should verify contact title
    And I should verify AboutUs
    And click on Partners
    And Verify Seeburger URL "http://www.seeburger.com/"

    Examples:
      | browser |
      | chrome  |
      | firefox |