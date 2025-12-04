package com.example.demo;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite   // This marks the class as a JUnit Platform test suite.
@SelectClasspathResource("features")
//This tells JUnit+Cucumber to Look in the classpath folder named features for .feature files.

//Uses GLUE to connect Gherkin text → Java methods
//GLUE (Step definition package) This Tells Cucumber The step definition Java classes are inside this package.
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.example.demo.stepdefs")

//This tells Cucumber which plugins to enable
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:build/reports/cucumber-report.html, json:build/reports/cucumber.json")


//Plugin	                                                          Meaning
//pretty	                                                  Pretty-print console logs
//html:build/reports/cucumber-report.html	                 Export beautiful HTML report
//json:build/reports/cucumber.json	                      Export machine-readable JSON report



//This class tells JUnit where to find .feature tests, where to find step-definitions, how to run them, and where to generate reports.
public class CucumberTestRunner {
}

//CucumberTestRunner is a JUnit 5 test suite that tells JUnit:
//
//        “Run all Cucumber feature files using the Cucumber engine.”
//
//This class is the entry point for executing your Cucumber tests when you run: ./gradlew test
