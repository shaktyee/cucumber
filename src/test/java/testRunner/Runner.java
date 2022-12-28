package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "./Features/LoginTags.feature",
		glue = "testDef",
		monochrome = true,
//		dryRun = true,
		plugin = {"pretty","html:test-output"},
		tags = {"@ibm_regression"}
		
		)

public class Runner {

}
