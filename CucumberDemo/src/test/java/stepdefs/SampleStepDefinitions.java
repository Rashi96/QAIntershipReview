package stepdefs;
import io.cucumber.java.en.*;
import io.cucumber.junit.CucumberOptions;

import static org.junit.Assert.assertEquals;

public class SampleStepDefinitions {

    private int num1;
    private int num2;
    private int result;

    @Given("I have two numbers {int} and {int}")
    public void iHaveTwoNumbers(int number1, int number2) {
        num1 = number1;
        num2 = number2;
    }

    @When("I add them")
    public void iAddThem() {
        result = num1 + num2;
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int expectedResult) {
        assertEquals(expectedResult, result);
    }
}






