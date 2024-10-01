package com.threeylos.core.api.config;

import io.restassured.authentication.OAuthSignature;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;

/**
 * Specify an authentication scheme to use when sending a request.
 *
 * @author AbhinitKumar
 */

@Log4j2
public final class ApiAuthContext {
	/**
	 * Allows you to specify how the request will look like.
	 */
	private final RequestSpecification requestSpecification;

	/**
	 * You can use the builder to construct a request specification.
	 */
	private final RequestSpecBuilder requestSpecBuilder;

	/**
	 * Construct and set the current requestSpecification and requestSpecBuilder.
	 */
	public ApiAuthContext(RequestSpecification requestSpecification, RequestSpecBuilder requestSpecBuilder) {
		this.requestSpecification = requestSpecification;
		this.requestSpecBuilder = requestSpecBuilder;
	}

	/**
	 * Add a header to be sent with auth details the request e.g:
	 *
	 * @param authHeaderName The header name
	 * @param type           +' ' @param token The header value
	 */
	public void headerAuth(String authHeaderName, String type, String token) {
		requestSpecBuilder.addHeader(authHeaderName, type + " " + token);
	}

	/**
	 * Use http basic authentication.
	 *
	 * @param userName The user name.
	 * @param password The password.
	 */
	public void basicAuth(String userName, String password) {
		requestSpecification.auth()
		        .basic(userName, password);
	}

	/**
	 * Returns the preemptive authentication view. This means that the
	 * authentication details are sent in the request header regardless if the
	 * server has challenged for authentication or not.
	 */
	public void preemptiveAuth(String userName, String password) {
		requestSpecification.auth()
		        .preemptive()
		        .basic(userName, password);
	}

	/**
	 * Use http digest authentication.
	 *
	 * @param userName The user name.
	 * @param password The password.
	 */
	public void digestAuth(String userName, String password) {
		requestSpecification.auth()
		        .digest(userName, password);
	}

	/**
	 * Excerpt from the HttpBuilder docs:<br>
	 * OAuth sign the request. Note that this currently does not wait for a
	 * WWW-Authenticate challenge before sending the the OAuth header. All requests
	 * to all domains will be signed for this instance. This assumes you've already
	 * generated an accessToken and secretToken for the site you're targeting. For
	 * more information on how to achieve this, see the <a href=
	 * '<a href="https://github.com/fernandezpablo85/scribe-java/wiki/Getting-Started">...</a>'>Scribe
	 * documentation</a>.
	 * </p>
	 *
	 * @param consumerKey
	 * @param consumerSecret
	 * @param accessToken
	 * @param secretToken
	 */
	public void oAuth1(String consumerKey, String consumerSecret, String accessToken, String secretToken) {
		requestSpecification.auth()
		        .oauth(consumerKey, consumerSecret, accessToken, secretToken);
	}

	/**
	 * Excerpt from the HttpBuilder docs:<br>
	 * OAuth sign the request. Note that this currently does not wait for a
	 * WWW-Authenticate challenge before sending the the OAuth header. All requests
	 * to all domains will be signed for this instance. This assumes you've already
	 * generated an accessToken and secretToken for the site you're targeting. For
	 * more information on how to achieve this, see the <a href=
	 * '<a href="https://github.com/fernandezpablo85/scribe-java/wiki/Getting-Started">...</a>'>Scribe
	 * documentation</a>.
	 * </p>
	 *
	 * @param consumerKey
	 * @param consumerSecret
	 * @param accessToken
	 * @param secretToken
	 * @param signature
	 */

	public void oAuth1(String consumerKey, String consumerSecret, String accessToken, String secretToken,
	        OAuthSignature signature) {
		requestSpecification.auth()
		        .oauth(consumerKey, consumerSecret, accessToken, secretToken, signature);
	}

	/**
	 * OAuth2 sign the request. Note that this currently does not wait for a
	 * WWW-Authenticate challenge before sending the the OAuth header (so currently
	 * it's the same as preemptive oauth2 authentication. The reason why it's
	 * located here is to be backward compatible). This assumes you've already
	 * generated an accessToken for the site you're targeting. The access token will
	 * be put in a header.
	 *
	 * @param accessToken The access token
	 */
	public void oAuth2(String accessToken) {
		requestSpecification.auth()
		        .oauth2(accessToken);
	}

	/**
	 * OAuth2 sign the request. Note that this currently does not wait for a
	 * WWW-Authenticate challenge before sending the the OAuth header. This assumes
	 * you've already generated an accessToken for the site you're targeting.
	 *
	 * @param accessToken The access token
	 * @param signature   The signature (note that if using
	 *                    {@link OAuthSignature#QUERY_STRING} then
	 *                    <code>Scribe</code> must be added to the classpath)
	 */
	public void oAuth2(String accessToken, OAuthSignature signature) {
		requestSpecification.auth()
		        .oauth2(accessToken);
	}
}
