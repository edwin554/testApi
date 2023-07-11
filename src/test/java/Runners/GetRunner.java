package Runners;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/Get.feature",
        glue = "StepDefinitions",
        monochrome = true,
        plugin = {"pretty",
        "junit:target/cucumber-reports/cucumber.xml",
        "html:target/cucumber-reports/report-html"},
        tags = "Apis"
)

public class GetRunner {
}
