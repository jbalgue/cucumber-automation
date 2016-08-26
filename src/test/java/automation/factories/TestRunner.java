package automation.factories;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "features/" }, glue = { "automation.stepDefinitions.regressionTest", "automation.stepDefinitions.smokeTest" }, 
monochrome = true

// create a tags
// Test Group 1
// tags = ['@google', '~@login']
)

public class TestRunner {}
