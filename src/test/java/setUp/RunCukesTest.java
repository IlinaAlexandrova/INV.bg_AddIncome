package setUp;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber/report.json","html:target/cucumber", "junit:target/cucumber/cucumber.xml"},
        features = "src/test/java/features/Cashbox.feature",
        glue = {"src/test/java/setUp/MyStepdefs.java"},
        tags = {"@test", "~@ignore"},
        monochrome = true)

public class RunCukesTest extends AbstractTestNGCucumberTests {
}