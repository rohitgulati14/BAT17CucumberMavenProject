package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Feature/AddNewCustomer.feature",
		glue = "stepdefinitions",
		dryRun = false,
		monochrome = true,
		publish = true,
		tags = ""

)
public class TestRunner {

}
