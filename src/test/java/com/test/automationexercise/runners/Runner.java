package com.test.automationexercise.runners;


import io.cucumber.core.options.CucumberOptionsAnnotationParser;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/test/automationexercise/stepdefinitions",
        dryRun = false,
        tags = "@regression",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt",
        "json:target/cucumber-reports/cucumber.json"}
)
public class Runner {
}
