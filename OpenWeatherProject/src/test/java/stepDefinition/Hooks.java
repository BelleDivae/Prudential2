package stepDefinition;



import openweatherTest.TestBase;

import cucumber.api.java.Before;

public class Hooks {
	
	@Before
	public void beforeScenario(){
		
		TestBase.readProperty();
		
		
	}

}
