package com.threeylos.core.util.api;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import lombok.extern.log4j.Log4j2;
import io.cucumber.plugin.event.Result;
import io.cucumber.plugin.event.Status;
import io.cucumber.plugin.event.TestCase;
import io.cucumber.plugin.event.TestCaseFinished;


/**
 * @author AbhinitKumar
 */
@Log4j2
public class ApiTestListener implements ConcurrentEventListener {
    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseFinished.class, this::handleTestCaseFinished);
    }

    private void handleTestCaseFinished(TestCaseFinished event) {
        TestCase testCase = event.getTestCase();
        Result result = event.getResult();
        Status status = result.getStatus();
        Throwable error = result.getError();
        String scenarioName = testCase.getName();

        if (error != null) {
           /* System.out.println("-------------------------------------------------------------------------------- \n" +
                    "| Scenario ran with error.                                                 | \n" +
                    "| Scenario name:                         " + scenarioName + "                | \n" +
                    "| Scenario status:                       " + status.name() + "                                |\n" +
                    "|                      \uD83D\uDE21 \uD83D\uDC4E \uD83D\uDC4E \uD83D\uDE21                                               |\n" +
                    "--------------------------------------------------------------------------------");
            System.out.println();*/

            System.out.println("Scenario name: '" + scenarioName + "' ran with error\n" + "\uD83D\uDE21 \uD83D\uDC4E \uD83D\uDC4E \uD83D\uDE21 \n");
        } else {
            /*System.out.println("-------------------------------------------------------------------------------- \n" +
                    "| Scenario ran successfully.                                                   | \n" +
                    "| Scenario name:                         " + scenarioName + "                | \n" +
                    "| Scenario status:                       " + status.name() + "                                |\n" +
                    "|                      ❤\uFE0F \uD83D\uDC4D \uD83D\uDC4D ❤\uFE0F                                            |\n" +
                    "--------------------------------------------------------------------------------");*/
            System.out.println("Scenario name: '" + scenarioName + "' ran successfully\n" + " ❤\uFE0F \uD83D\uDC4D \uD83D\uDC4D ❤\uFE0F \n");
        }

    }
}
