package runners.product;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/uiFailedTests.txt",
        glue = "stepdefinitions/productsteps",
        dryRun = false,
        tags = "@productOutline",
        plugin={"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)
public class ProductReRun {

}
