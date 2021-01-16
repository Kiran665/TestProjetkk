package testRunnerForGmail;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= "features", glue="stepDefinationForGmail", 
dryRun=false, monochrome=true, 
stepNotifications=true, plugin= {"pretty", "html:target/HtmlReports", "json:target/cucumber.json"}
)

public class TestRunnerForGmail {

}
