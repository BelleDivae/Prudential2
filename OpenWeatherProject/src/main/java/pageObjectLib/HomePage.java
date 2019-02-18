package pageObjectLib;

import org.apache.poi.ss.formula.eval.BlankEval;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import openweatherTest.TestBase;



public class HomePage extends TestBase {


	public HomePage()
	{

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Your city name']")
	private WebElement citysearchfield;



	public void citysearch(String strCityName) {
		citysearchfield.sendKeys(strCityName);
	}


	public void highLighterMethod(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: none; border: 2px solid red;');", element);
	}

	public boolean validateAllLabel()
	{ boolean blnResult= false;
	try {
		boolean blnWeather,blnMaps,blnGuide,blnApi,blnPrice,blnPartners,blnStations,blnWidgets,blnBlog,blnSupportCentre;
		boolean blnEnvelope,blnWeatherBar,blnSignIn,blnSignUp,blnCelsius,blnFahren;

		WebElement eleWeather=driver.findElement(By.xpath("//a[@class='nav__link bg-hover-color'][contains(text(),'Weather')]"));
		WebElement eleMaps=driver.findElement(By.xpath("//a[@class='nav__link dropdown-toggle bg-hover-color']"));
		WebElement eleGuide=driver.findElement(By.xpath("//a[contains(text(),'Guide')]"));
		WebElement eleApi=driver.findElement(By.xpath("//a[@class='nav__link bg-hover-color'][contains(text(),'API')]"));
		WebElement elePrice=driver.findElement(By.xpath("//a[@class='nav__link bg-hover-color'][contains(text(),'Price')]"));
		WebElement elePartners=driver.findElement(By.xpath("//a[contains(text(),'Partners')]"));
		WebElement eleStations=driver.findElement(By.xpath("//a[contains(text(),'Stations')]"));
		WebElement eleWidgets=driver.findElement(By.xpath("//a[contains(text(),'Widgets')]"));
		WebElement eleBlog=driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
		WebElement eleSupportCentre=driver.findElement(By.xpath("//span[@class='hidden-xs']"));
		WebElement eleEnvelope=driver.findElement(By.xpath("//i[@class='fa fa-envelope']"));
		WebElement eleWeatherBar= driver.findElement(By.xpath("//a[@id='nav-search']"));
		WebElement eleSignIn= driver.findElement(By.xpath("//a[@class='pull-right'][contains(text(),'Sign In')]"));
		WebElement eleSignUp= driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
		WebElement eleCelsius= driver.findElement(By.xpath("//span[@id='metric']"));
		WebElement eleFahren= driver.findElement(By.xpath("//span[@id='imperial']"));

		highLighterMethod(driver,eleWeather);

		blnWeather=eleWeather.isDisplayed();
		blnMaps=eleMaps.isDisplayed();
		blnGuide=eleGuide.isDisplayed();
		blnApi=eleApi.isDisplayed();
		blnPrice=elePrice.isDisplayed();
		blnPartners=elePartners.isDisplayed();
		blnStations=eleStations.isDisplayed();
		blnWidgets=eleWidgets.isDisplayed();
		blnBlog=eleBlog.isDisplayed();
		blnSupportCentre=eleSupportCentre.isDisplayed();
		blnEnvelope=eleEnvelope.isDisplayed();
		blnWeatherBar= eleWeatherBar.isDisplayed();
		blnSignIn= eleSignIn.isDisplayed();
		blnSignUp= eleSignUp.isDisplayed();
		blnCelsius= eleCelsius.isDisplayed();
		blnFahren= eleFahren.isDisplayed();

		if(blnWeather && blnMaps && blnGuide && blnApi && 
				blnPrice && blnPartners && blnStations && blnWidgets && 
				blnBlog && blnSupportCentre && blnEnvelope && blnWeatherBar &&
				blnSignIn && blnSignUp && blnCelsius && blnFahren)
			blnResult=true;
		System.out.println("All the important Labels are varified successfully");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return blnResult;
	}


	public boolean validateInvalidCity(String strNotFound) {
		boolean blnResult= false;
		try {
			String strNotFoundError=driver.findElement(By.xpath("//div[@class='alert alert-warning']")).getText();
			if(strNotFoundError.contains(strNotFound))
				 blnResult=true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  blnResult;
	}
	
	
	public boolean validateTemperatureToggle(String... strTemperatureFormat) {
		boolean blnResult=false;
		try{
			for(String strTempVal:strTemperatureFormat){
				switch(strTempVal.toUpperCase()){	
				case "C":
					//Validating for Degree Celsius
					String strTempC=driver.findElement(By.xpath("//h3[@class='weather-widget__temperature']")).getText();
					if(strTempC.contains(strTempVal))
						blnResult=true;
					break;
				case "F":
					driver.findElement(By.xpath("//span[@id='imperial']")).click();
					String strTempF=driver.findElement(By.xpath("//h3[@class='weather-widget__temperature']")).getText();
					if(strTempF.contains(strTempVal))
						blnResult=true;
					break;
				}
				blnResult=true;
			
		}}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  blnResult;
	}
	
}