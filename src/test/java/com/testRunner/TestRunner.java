package com.testRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.report.*;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(glue = "com.step",features = "src/test/resources/Feature",dryRun=false,plugin= {"json:target/jenkins.json"})
public class TestRunner {
	@AfterClass
	public static void afterExecution() {
		Reporting.generateJVMReport(System.getProperty("user.dir") + "/target/jenkins.json");
	}

}
