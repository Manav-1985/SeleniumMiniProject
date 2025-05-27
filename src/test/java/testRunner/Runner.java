package testRunner;

import io.cucumber.testng.CucumberOptions; 

import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features = "src/test/resources/features", // ✅ Correct path
	    glue = {"stepDefinition"},              
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports/cucumber.html",
	        "json:target/cucumber-reports/Cucumber.json",
//	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    },
	    monochrome = true,
	    dryRun = false
	)

public class Runner extends AbstractTestNGCucumberTests{


}
