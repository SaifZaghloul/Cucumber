
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Feature", glue = { "test.java.TCs" }, plugin =

{ "pretty", "json:target/cucumber.json" })

public class testRun {

}