package openweatherTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	public static WebDriver driver;
	public static Properties properties;
	public static WebDriverWait wait;
	public static int TimeFrame=30;
	public static int impicitwait= 50;
	
	public static final String testDataExcelFileName= "Userinput.xlsx";
	// static String propertyFilePath=
	// "/Users/shsharma/workspace/mars/clientgoals/"+"src/main/java/Utilities/config.properties";

	public TestBase() {

	}

	public static void useaction(WebElement we){
		
		Actions action= new Actions(driver);
		action.moveToElement(we).click().build().perform();
				
	}
	
public static void sendkeys(WebElement we, String text){
		
		Actions action= new Actions(driver);
		action.moveToElement(we).click();
		action.sendKeys(text);
		action.build().perform();
				
	}
	
	public static void selectdropdown(WebElement we, int index, String text)
	{
		Select s= new Select(we);
		if(we.isDisplayed())
		{
		s.selectByIndex(index);
	}
		else
		{
			s.selectByVisibleText(text);
		}
	}
	
	
	public static boolean waitForElementVisible(WebElement we){
		 
		try{
			wait = new WebDriverWait(driver,TimeFrame);
			 wait.until(ExpectedConditions.visibilityOf(we));
			 return true;
		}catch(Exception e){
			return false;
		}
		
		
	}
	
	public static void click(WebElement we){
		if(waitForElementVisible(we)){
			we.click();
		}else{
			
			
		}
	}
	
	
	public static void readProperty() {
		try {
			if (properties == null) {
				properties = new Properties();
				FileInputStream reader = new FileInputStream(
					"C:\\javaworkspace\\OpenWeatherProject\\src\\main\\java\\Utilities\\config.properties");
						
				
				properties.load(reader);
			}
		}
		 catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization()

	{

		String browsername = properties.getProperty("browser");

		if (browsername.equals("Chrome"))

			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
	//	driver.manage().window().maximize();
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// }
	}
	
	
	
	
	//public static void endSession(){
	//	driver.quit();
//	}

}
