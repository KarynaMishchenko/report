Feature: Google Cloud functionality

  As a regular user
  I want to be able to use Google Cloud

  Scenario: Search on Google Cloud
    Given I am on the Google Cloud home page
    When I search for "Google Cloud Platform Pricing Calculator"
    Then I should see the pricing calculator result

  Scenario: Fill the form
    Given I am on the Google Cloud home page
    When I search for "Google Cloud Platform Pricing Calculator"
    And I select the pricing calculator result
    And I enter "4" as the number of instances
    And I select the series "n1"
    And I choose machine type "n1-standard-8 (vCPUs: 8, RAM: 30GB)"
    And I add a GPU with type "NVIDIA Tesla V100"
    And I select the number of GPUs
    And I choose local SSD size "2x375 GB"
    And I add the configuration to the estimate
    And I send the estimate by email
    And I enter email value in Email field
    And I click on Send Email button
    Then I see that prices are up to date
