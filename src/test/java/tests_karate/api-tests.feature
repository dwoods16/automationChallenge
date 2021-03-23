@api
Feature: As an api user I should be able to access GET and DELETE endpoints

Scenario: Get ip address of user should succeed
  Given url api.baseURL
  And path 'ip'
  When method get
  Then status 200
  And match response == { "origin": "#string" }

Scenario: Delete request data should succeed
  * json payload = { "Data": "Delete Me" }

  Given url api.baseURL
  And path 'anything'
  And request payload
  When method delete
  Then status 200
  And match response == read('expected-api-delete-response.json')
  And match response.json == payload
