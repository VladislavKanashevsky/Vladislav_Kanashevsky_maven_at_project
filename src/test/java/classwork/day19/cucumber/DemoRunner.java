package classwork.day19.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        glue = {"day19.cucumber"},
        features = {"src/test/resources/features/first.feature"
                , "src/test/resources/features/second.feature"},
        tags = "@QA"
)
public class DemoRunner {

}
