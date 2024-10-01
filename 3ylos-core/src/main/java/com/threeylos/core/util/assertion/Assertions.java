package com.threeylos.core.util.assertion;

import lombok.extern.log4j.Log4j2;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.testng.asserts.Assertion;

/**
 * @author AbhinitKumar
 *
 */

@Log4j2
public abstract class Assertions extends Assertion {

    public static <T> void assertThat(T actual, Matcher<? super T> matcher) {
        MatcherAssert.assertThat(actual, matcher);
    }

    public static <T> void assertThat(String reason, T actual, Matcher<? super T> matcher) {
        MatcherAssert.assertThat(reason, actual, matcher);
    }

    public static void assertThat(String reason, boolean assertion) {
        MatcherAssert.assertThat(reason, assertion);
    }


}
