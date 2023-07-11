package Runners;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/Put.feature",
        glue = "StepDefinitions",
        monochrome = true,
        plugin = "pretty",
        tags = "Apis"
)
public class PutRunner {
}
