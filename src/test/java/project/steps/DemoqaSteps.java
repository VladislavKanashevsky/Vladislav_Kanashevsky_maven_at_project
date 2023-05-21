package project.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import project.driver.Driver;
import project.objects.SelectMenuItems;
import project.pages.page_demoqa.SelectMenuDemoqa;

import org.apache.log4j.Logger;

public class DemoqaSteps {

    SelectMenuDemoqa selectMenuDemoqa = new SelectMenuDemoqa();

    SelectMenuItems selectMenuItems = new SelectMenuItems();

    public static final Logger LOGGER = Logger.getLogger(DemoqaSteps.class.getName());

    @Before(value = "@demoQA")
    public void beforeTests() {
        LOGGER.info("The demoqa cucumber Before method is started");
        Driver.getWebDriver();
        LOGGER.info("The demoqa cucumber Before method is finished");
    }

    @After(value = "@demoQA")
    public void afterTests() {
        LOGGER.info("The demoqa cucumber After method is started");
        Driver.closeDriver();
        LOGGER.info("The demoqa cucumber After method is finished");
    }

    @Given("I open \"demoQA.com\"")
    public void openDemoQA() {
        selectMenuDemoqa.getUrlToSelectMenuDemoqa();
        LOGGER.debug("Step 'I open \"demoQA.com\"' is executed");
    }

    @When("I click on the Select Value Dropdown")
    public void clickSelectValueDropdown() {
        selectMenuDemoqa.clickSelectValueDropdown();
        LOGGER.debug("Step 'I click on the Select Value Dropdown' is executed");
    }

    @When("I select Group1 Option1")
    public void selectGroup1Option1OfSelectValue() {
        selectMenuItems.selectGroupOption();
        LOGGER.debug("Step 'I select Group Option' is executed");
    }

    @When("I click on the Select One Dropdown")
    public void clickSelectOneDropdown() {
        selectMenuDemoqa.clickSelectOneDropdown();
        LOGGER.debug("Step 'I click on the Select One Dropdown' is executed");
    }

    @When("I select Dr")
    public void selectDrOfSelectOne() {
        selectMenuItems.selectDr();
        LOGGER.debug("Step 'I select Dr' is executed");
    }

    @When("I select Blue Of Old Style Select Menu")
    public void selectBlueOfOldStyleSelectMenu() {
        selectMenuItems.selectOfOldStyle();
        LOGGER.debug("Step 'I select Blue Of Old Style Select Menu' is executed");
    }

    @When("I click on the Multi Select Dropdown")
    public void clickMultiSelectDropdown() {
        selectMenuDemoqa.clickMultiSelectDropdown();
        LOGGER.debug("Step 'I click on the Multi Select Dropdown' is executed");
    }

    @When("I select Green")
    public void selectGreenOfMultiSelectDropdown() {
        selectMenuItems.selectOfMulti();
        LOGGER.debug("Step 'I select Green' is executed");
    }

    @When("I select Audi in the Standard Multi Select")
    public void selectAudiOfStandardMultiSelect() {
        selectMenuItems.selectAudiOfStandardMulti();
        LOGGER.debug("Step 'I select Audi in the Standard Multi Select' is executed");
    }

    @Then("I check that all fields are selected")
    public void checkAllFields() {
        LOGGER.debug("Step 'I check that all fields are selected' is executed");
    }
}
