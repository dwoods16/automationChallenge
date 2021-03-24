Feature: As an api user I should be able to access GET and DELETE endpoints

Scenario: Get ip address of user should succeed
  Given url apiBaseURL
  And path 'ip'
  When method get
  Then status 200
  And match response == { "origin": "#string" }

Scenario: Delete request data should succeed
  * json payload = { "Data": "Delete Me" }

  Given url apiBaseURL
  And path 'anything'
  And request payload
  When method delete
  Then status 200
  And match response.json == payload
