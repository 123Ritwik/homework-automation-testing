package com.threeylos.core.api.config;


import com.threeylos.core.config.ApplicationProperties;

/**
 * @author AbhinitKumar
 */
public class TokenConfig {

	private static final String TOKEN = "token";

	public String getToken() {
		return System.getenv(TOKEN) == null ? ApplicationProperties.getValue(TOKEN) : System.getenv(TOKEN);
	}

}
