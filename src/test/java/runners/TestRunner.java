package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
//--strict or @CucumberOptions(strict = true)

@CucumberOptions (
        features = "src/test/resources/features"
        , glue = {"com.automatedtest.hudl.infrastructure.driver",
        "com.automatedtest.hudl.stepDef"}
        , tags = {"@LoginTest"},
        plugin = {"pretty",
                "html:target/cucumber/cucumber-html-report",
                "json:target/cucumber/cucumber-json-report.json"
        },
        monochrome = true)
@RunWith(Cucumber.class)
public class TestRunner {
}