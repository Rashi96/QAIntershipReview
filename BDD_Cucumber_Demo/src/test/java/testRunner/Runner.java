package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/features/login.feature"},
        dryRun = !true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true,
        glue = "steps",
        plugin = {"html:CucumberReports"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
