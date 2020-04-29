package com.org.appium.android.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;

public class DeviceUtils {

  /** The Constant LOGGER. */
  private static final Logger LOGGER = Logger.getLogger(DeviceUtils.class);

  /**
   * Gets the device name.
   *
   * @return the device name
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  public static String getDeviceName() throws IOException, InterruptedException {
    String deviceName = "";

    // get adb path based on environment
    String adbPath = "";
    if (AppiumTest.runOnLocalDevice) {
      adbPath = PropertyManager.APP_PROPERTIES.getProperty("local-adb-path");
    } else {
      adbPath = PropertyManager.APP_PROPERTIES.getProperty("aws-adb-path");
    }

    // construct adb shell command
    String[] adbCommand = {adbPath, "shell", "getprop", "ro.product.model"};
    LOGGER.debug("adb command:" + Arrays.toString(adbCommand));

    Process process = Runtime.getRuntime().exec(adbCommand);
    BufferedReader stdin = new BufferedReader(new InputStreamReader(process.getInputStream()));
    BufferedReader errin = new BufferedReader(new InputStreamReader(process.getErrorStream()));
    process.waitFor();

    String line;
    // read device name
    while ((line = stdin.readLine()) != null) {
      deviceName += line;
    }

    // read error, if any
    String error = "";
    while ((line = errin.readLine()) != null) {
      error += line;
    }

    LOGGER.debug("device name: " + deviceName);
    LOGGER.debug("error (if any): " + error);

    return deviceName;

  }


  /**
   * Gets the device capabilities.
   *
   * @return the device capabilities
   */
  public static Capabilities getDeviceCapabilities() {
    Capabilities deviceCapabilities = UserActionsUtil.driver.getCapabilities();
    LOGGER.debug("device capabilities: " + deviceCapabilities);
    return deviceCapabilities;
  }


  /**
   * Gets the device capability.
   *
   * @param capabilityName the capability name
   * @return the device capability
   */
  public static String getDeviceCapability(String capabilityName) {
    Capabilities deviceCapabilities = UserActionsUtil.driver.getCapabilities();
    String capability = (String) deviceCapabilities.getCapability(capabilityName);
    LOGGER.debug("device capabilities: " + capability);
    return capability;
  }

}
