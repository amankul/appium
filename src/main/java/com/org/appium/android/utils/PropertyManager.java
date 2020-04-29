package com.org.appium.android.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.testng.log4testng.Logger;

/**
 * The Class PropertyManager.
 */
public class PropertyManager {

  /** The Constant LOGGER. */
  private static final Logger LOGGER = Logger.getLogger(PropertyManager.class);

  /** The Constant APP_PROPERTIES. */
  public static final Properties APP_PROPERTIES;

  /** The Constant APP_PROPERTIES_NAME. */
  private final static String APP_PROPERTIES_NAME = "config.properties";

  static {
    APP_PROPERTIES = loadPropertyFile(APP_PROPERTIES_NAME);
  }

  /**
   * Load property file.
   *
   * @param filename the filename
   * @return the properties
   */
  public static Properties loadPropertyFile(String filename) {
    Properties properties = new Properties();
    InputStream is = PropertyManager.class.getClassLoader().getResourceAsStream(filename);
    try {
      properties.load(is);
      is.close();
    } catch (IOException e) {
      properties = null;
      LOGGER.error("exception is reading file: " + filename, e);
    }
    return properties;
  }

}
