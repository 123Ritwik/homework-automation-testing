package com.threeylos.core.config;

import java.util.Properties;

import lombok.extern.log4j.Log4j2;

import com.threeylos.core.util.common.FileUtil;

/**
 * 
 * This class loaded all the configuration
 * 
 * @author AbhinitKumar
 *
 */
@Log4j2
public final class ApplicationProperties {

	/**
	 * Configuration property file name.
	 */
	private static final String TEST_CONFIG = "application.properties";

	/**
	 * Configuration property data
	 */
	private static final Properties PROP;

	private ApplicationProperties() {
	}

	static {
		PROP = FileUtil.getProperties(TEST_CONFIG);

	}

	public static Properties getProperties() {
		return PROP;
	}

	public static String getValue(final String key) {
		log.debug("Get property value by key:{} and value: {}", key,PROP.getProperty(key));
		return PROP.getProperty(key);
	}

}
