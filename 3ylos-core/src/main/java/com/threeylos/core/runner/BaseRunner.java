package com.threeylos.core.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

/**
 * All runner class must be extended this class.
 *
 * @author AbhinitKumar
 */
@CucumberOptions(
        //features = "target/test-classes",
        plugin = {"json:target/cucumber/cucumber-report.json",
				"html:target/cucumber/cucumber-reports.html",
				"com.threeylos.core.util.api.ApiTestListener"

		},
        monochrome = true,
        snippets = SnippetType.CAMELCASE
        //publish = true
        //dryRun = true
)
public abstract class BaseRunner extends AbstractTestNGCucumberTests {

}
