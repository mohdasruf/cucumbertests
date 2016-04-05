package cucumbertest;


import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature",glue="stepDefinition",tags={"@PositiveScenario"}
		)
//@Category({ PositiveTests.class })
public class TestsRunner_Positive {

}