package runner;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/advancedSearch.feature", "src/main/resources/smoke.feature"},
        glue = "stepdefinitions"
)
public class RunnerTests {

}
