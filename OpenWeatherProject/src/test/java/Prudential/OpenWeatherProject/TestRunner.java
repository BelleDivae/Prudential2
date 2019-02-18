package Prudential.OpenWeatherProject;




import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"C:/javaworkspace/OpenWeatherProject/src/test/java/feature/SanityTest.feature"},
				 glue = {"stepDefinition"},
				// plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
				 monochrome=true,
				 dryRun=false
				//dryRun=true
		//true=checks the mapping of step definition and deosnt run		 
		)

public class TestRunner {




/* @AfterClass
 public static void writeExtentReport() {
	Reporter.loadXMLConfig(new File("C:\\Users\\shsharma\\workspace\\mars\\clientgoals\\src\\main\\java\\Utilities\\extent-config.xml"));
	*/
//	src/main/java/Utilities/extent-config.xml
//	C:\\Users\\shsharma\\workspace\\mars\\clientgoals\\src\\main\\java\\Utilities\\extent-config.xml
 }
