package runners.product;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/com.products",
        glue = "stepdefinitions/productsteps",
        dryRun = false,
        tags = "@productOutline"
)
public class ProductRunner {

}
