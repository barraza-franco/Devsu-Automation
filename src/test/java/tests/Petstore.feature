@petstore
Feature: Petstore with Karate

  Background: 
    * url 'https://petstore.swagger.io/v2'

  Scenario: Add pet to store
    Given path 'pet'
    And request
      """
      {
      	"id": 3002,
      	"name": "limon",
      	"status": "available"
      }
      """
    When method post
    Then status 200
    And match response.name == 'limon'
    And match response.status == 'available'

  Scenario: Consult pet by ID
    Given path 'pet'
    And path '3002'
    When method get
    Then status 200
    And match response.name == 'limon'

  Scenario: Update pet to sold
    Given path 'pet'
    And request
      """
      {
      	"id": 3002,
      	"name": "limon",
      	"status": "sold"
      }
      """
    When method put
    Then status 200
    And match response.name == 'limon'
    And match response.status == 'sold'

  Scenario: Find pet by status
    Given path 'pet/findByStatus'
    And param status = 'sold'
    When method get
    Then status 200
    And match each response[*].status == 'sold'
    And match response[*].name contains 'limon'

  Scenario: Delete pet created
    Given path 'pet'
    And path '3002'
    When method delete
    Then status 200
