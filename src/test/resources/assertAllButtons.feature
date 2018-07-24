Feature: Assert all buttons

  Scenario Outline: Successful find all buttons from Homepage
    Given browser "<browser>"
    When website loaded this address: "https://progressbg.net"
    Then I should verify all buttons
    And verify contacts title

    Examples:
      | browser |
      | chrome  |
      | firefox |