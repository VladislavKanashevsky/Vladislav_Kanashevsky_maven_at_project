package project.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"pretty", "summary"},
        glue = {"homework.at_project.steps"},
        features = "src/test/resources/features/project.feature"
//        tags = {"@booking","@w3schools"}
)

public class CucumberRunner {

}
