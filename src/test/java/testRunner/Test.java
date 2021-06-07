package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//Features/Customers.feature",
		glue="stepDefinitions",
		dryRun=false,               //if true ->it will check whether every features contains step definitions or not before actual execution
		plugin= {"pretty","html:target/cucumber-report.html"},
		tags = "@AllTest" 
		)

public class Test {
	

}
