package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {
                "src/test/resources/feature/AddToCart.feature"
        },
        glue = "steps",
        strict = true
        //        tags = ""

)
public class AddToCartTestSuite {
}
