package com.salesforce.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Salesforce.feature"}, 
					glue = {"com.salesforce.steps"})

public class SalesforceRunnerTest extends AbstractTestNGCucumberTests{
	
}
