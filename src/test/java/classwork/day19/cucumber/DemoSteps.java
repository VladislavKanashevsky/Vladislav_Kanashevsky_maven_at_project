package classwork.day19.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DemoSteps {

    @Given("I open demoG7 site")
    public void iOpenDemoGSite() {
        System.out.println("I opened the site");
    }

    @When("I fill {string} in the form")
    public void iFillInTheForm(String text) {
        System.out.printf("The I printed '%s' string", text);
    }

    @Then("I need to see something")
    public void iNeedToSeeSomething() {
        System.out.println("I finished");
        Assert.assertTrue(true);
    }
}
