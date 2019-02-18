Feature: Navigate to OpenWeather and validate the label

  #Scenario Outline: Navigate to Openweather and verify labels
   # Given Open the browser
   # When User validates the page title
   # Then User validates all the labels

  #Scenario Outline: Navigate to Openweather and verify weather of city
   # Given Open the browser
   # When User enter "<cityname>"
   #Then User validates the city weather
    
  #Scenario Outline: Navigate to Openweather and verify labels
  # Given Open the browser
  # When User enters invalid "<invalidcityname>"
  # Then User validates NOT FOUND
  
  #This is additional Scenario from QA perspective   
   Scenario Outline: Navigate to Openweather and verify Temperature Toggle Button
   Given Open the browser
   When User chooses temperature format 
   Then Validate Temperature shown is in the chosen format "<temperature>"
   
      
    Examples:
    |cityname| |invalidcityname|  |temperature|
    |Mumbai|	 |ABC|    					|F|
    															
    
    
