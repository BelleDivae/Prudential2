package stepDefinition;

import openweatherTest.TestBase;
import pageObjectLib.HomePage;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.ExcelUtility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefinition  extends TestBase{
	HomePage homepage= new HomePage();
	boolean blnResult=false;

	@Given("Open the browser")
	public void open_the_browser() {

		TestBase.initialization();
	}

	
	@When("User validates the page title")
	public void user_validates_the_page_title() {
		//Validates title
		
		if(driver.findElement(By.xpath("//a[@class='navbar-brand']//img[@class='img-responsive']")).isDisplayed())
		{
			blnResult=true;
			System.out.println("Title verification- "+blnResult);
		}
	}

	@Then("User validates all the labels")
	public void user_validates_all_the_labels() {
		blnResult= homepage.validateAllLabel();
		System.out.println("All important labels verified: "+blnResult);
	}

	@When("User enter \"(.*)\"")
	public void user_enter(String strCityName) {
		driver.findElement(By.xpath("//input[@placeholder='Your city name']")).sendKeys(strCityName);
		//Click on Search Button
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
	}



	@When("User enters invalid \"(.*)\"")
	public void user_enters_invalid(String strInvalidCityName) {
		//Enter Valid City Name
		driver.findElement(By.xpath("//input[@placeholder='Your city name']")).sendKeys(strInvalidCityName);
		
		//Click on Search Button
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		
	}
	
	@Then("User validates the city weather")
	public void user_validates_the_city_weather() {
	   
		blnResult=driver.findElement(By.xpath("//p[contains(text(),'temperature from')]")).isDisplayed();
	    System.out.println("Weather Data loaded successfully- "+blnResult);
	}

	@Then("User validates NOT FOUND")
	public void user_validates_NOT_FOUND() {
		blnResult=homepage.validateInvalidCity("Not found");
	    System.out.println("Entered CityName is invalid- "+blnResult);
	}
	
	
	@When("User chooses temperature format")
	public void user_chooses_temperature_format() {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.xpath("//span[@id='metric']")).click();
			
	}
	
	
	@Then("Validate Temperature shown is in the chosen format \"(.*)\"")
	public void validate_Temperature_shown_is_in_the_chosen_format(String strTempVal) {
	   blnResult=homepage.validateTemperatureToggle(strTempVal);
		System.out.println("Valdated Temperature toggle button Successfully- "+blnResult);
	}

	
	
}
