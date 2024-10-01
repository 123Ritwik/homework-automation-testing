package com.threeylos.test.homework;

import com.threeylos.core.runner.BaseRunner;

import io.cucumber.testng.CucumberOptions;

/**
 *
 */
@CucumberOptions(features = "classpath:/features/api/homework/homeworkApi.feature",
        glue = "com.threeylos.test.homework.api.homework",
        tags = "@api"
)
public class TestRunner extends BaseRunner {

}
