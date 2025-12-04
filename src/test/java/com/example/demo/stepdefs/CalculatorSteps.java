package com.example.demo.stepdefs;

import com.example.demo.service.CalculatorService;
import io.cucumber.java.en.*;
import io.cucumber.spring.CucumberContextConfiguration;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//Cucumber Step Definition class that tells Cucumber:

//“When a scenario in the .feature file has a step like
//Given I have a calculator or When I add 5 and 7,
//run this Java method.”

//It connects plain English statements (Gherkin) to real Java code.

@CucumberContextConfiguration // Tells Cucumber to Use Spring Boot’s context for dependency injection.
@SpringBootTest  // tells Spring-Boot to Load the full application context for the test.
public class CalculatorSteps {

    private static final Logger log = LoggerFactory.getLogger(CalculatorSteps.class);

    @Autowired
    private CalculatorService calculator;

    private int result;


    //This ensures the environment is properly setup.
    @Given("I have a calculator")
    public void i_have_a_calculator() {
        log.info("Initializing calculator...");
        Assertions.assertThat(calculator).isNotNull();
    }
    //  Logs that initialization started
    //
    //  Confirms Spring injected calculator
    //
    //  If calculator is null, the test will fail immediately

    @When("I add {int} and {int}")
    public void i_add_numbers(int a, int b) {
        log.info("Adding {} and {}", a, b);
        result = calculator.add(a, b);
    }
    // Accepts the two numbers from the .feature file and add and store it in result

    @Then("the result should be {int}")
    public void the_result_should_be(int expected) {
        log.info("Checking expected result: {}", expected);
        Assertions.assertThat(result).isEqualTo(expected);
        log.info("Test passed successfully!");
    }
    //  Retrieves expected value from the feature file
    //
    //  Compares it with the actual result
    //
    //  Logs success if the assertion passes
    //
    //  This is the verification step.
}


//Summary:



//CalculatorSteps class:

//Loads Spring Boot context
//Wires CalculatorService
//Connects each English sentence in the .feature file to Java code
//Runs the calculator logic
//Verifies the results
//Logs everything for readability
//It bridges Gherkin (plain English tests) with real Java Spring logic.
