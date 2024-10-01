
package com.threeylos.core.util.common;

import static org.testng.Assert.assertEquals;
import org.hamcrest.Matchers;

import io.restassured.response.Response;

/**
 * @author AbhinitKumar
 *
 */
public final class ApiAssertUtil {

	private ApiAssertUtil() {
	}

	/**
	 * Asserts that response are equal toexpectedStatusCode . If they are not, an
	 * AssertionError is thrown.
	 *
	 * @param actualStatusCode   the actual value
	 * @param expectedStatusCode the expected value
	 */
	public static void isStatusCode(Response response, int expectedStatusCode) {
		if (response == null) {
			throw new NullPointerException("Response must be not null");
		}
		assertEquals(response.getStatusCode(), expectedStatusCode);
	}

	public static void is(String key, Response response, Object expected) {
		if (response == null || key == null) {
			throw new NullPointerException("Response or key must be not null");
		}
		response.then().body(key, Matchers.is(expected));
	}

	public static void not(String key, Response response, Object notExpected) {
		if (response == null || key == null) {
			throw new NullPointerException("Response or key must be not null");
		}
		response.then().body(key, Matchers.not(notExpected));
	}
}
