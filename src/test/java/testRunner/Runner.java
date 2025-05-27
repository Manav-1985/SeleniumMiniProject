package testRunner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
	    features = "src/test/java/features",       
	    glue = {"stepdefinitions"},           
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports/cucumber.html",
	        "json:target/cucumber-reports/Cucumber.json",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    },
	    monochrome = true,
	    dryRun = false
	)

public class Runner extends AbstractTestNGCucumberTests{


}
