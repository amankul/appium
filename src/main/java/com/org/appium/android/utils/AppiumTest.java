package com.org.appium.android.utils;

import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.applitools.eyes.BatchInfo;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * The Class AppiumTest.
 */
public class AppiumTest {

  /** The Constant LOGGER. */
  private static final Logger LOGGER = Logger.getLogger(AppiumTest.class);

  private static final String APPIUM_VERSION =
      PropertyManager.APP_PROPERTIES.getProperty("appium-version");

  protected static final String PLATFORM_NAME =
      PropertyManager.APP_PROPERTIES.getProperty("platform-name");

  private static final String DEVICE_NAME =
      PropertyManager.APP_PROPERTIES.getProperty("device-name");

  protected static final String PLATFORM_VERSION =
      PropertyManager.APP_PROPERTIES.getProperty("platform-version");

  /**
   * The Constant batch. enables the results from a run to be stored in a single entry in applitools
   */
  public static final BatchInfo BATCH;

  /** check if the tests need to run on a local device. */
  public static final boolean runOnLocalDevice =
      Boolean.valueOf(PropertyManager.APP_PROPERTIES.getProperty("local-device"));

  static {
    /**
     * Disable annoying cookie warnings. WARNING: Invalid cookie header
     */
    LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log",
        "org.apache.commons.logging.impl.NoOpLog");
    String platform;
    if (runOnLocalDevice) {
      platform = "physical-device";
    } else {
      platform = "aws";
    }
    String BATCH_INFO_NAME = platform + "-" + LocalDateTime.now();
    BATCH = new BatchInfo(BATCH_INFO_NAME);
    // BATCH.setId(BATCH_INFO_NAME);

  }


  /**
   * Generic setup method. Call this method in each of the test classes
   *
   * @param appName the new up
   * @throws Exception the exception
   */
  public static void setup(String appName) throws Exception {
    LOGGER.info("before test started");
    URL serverAddress;
    if (runOnLocalDevice) {
      // local device
      String userDir = System.getProperty("user.dir");
      String appPath = Paths.get(userDir, appName).toAbsolutePath().toString();
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, APPIUM_VERSION);
      capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
      capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
      capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
      capabilities.setCapability(MobileCapabilityType.APP, appPath);
      serverAddress = new URL("http://0.0.0.0:4723/wd/hub");

      UserActionsUtil.driver = new AndroidDriver<MobileElement>(serverAddress, capabilities);
      UserActionsUtil.init(UserActionsUtil.driver, serverAddress);
    } else {
      // cloud device
      serverAddress = new URL("http://127.0.0.1:4723/wd/hub");
      UserActionsUtil.driver =
          new AndroidDriver<MobileElement>(serverAddress, new DesiredCapabilities());
    }

    UserActionsUtil.driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
    UserActionsUtil.init(UserActionsUtil.driver, serverAddress);
    LOGGER.debug("android driver initialized");
  }


  /**
   * Tear down. Runs after each test
   *
   * @throws Exception the exception
   */
  @AfterTest
  public void tearDownTest() throws Exception {
    LOGGER.info("after test");
    if (UserActionsUtil.driver != null) {
      UserActionsUtil.driver.quit();
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see com.org.appium.android.utils.AppiumTest#tearDown()
   */
  // @AfterMethod
  // public void tearDownMethod() throws Exception {
  // UserActionsUtil.driver.resetApp();
  // LOGGER.debug("app reset after each test");
  // }


  /**
   * After class.
   */
  @AfterClass
  public void afterClass() {
    UserActionsUtil.driver.quit();
    LOGGER.debug("driver quit executed");
  }

}
