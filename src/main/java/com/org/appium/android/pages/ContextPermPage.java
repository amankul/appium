package com.org.appium.android.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.org.appium.android.utils.UserActionsUtil;

public class ContextPermPage extends UserActionsUtil {

  /** The Constant LOGGER. */
  private static final Logger LOGGER = Logger.getLogger(HomePage.class);

  /** Contextual Screen id's. */
  private static final String NOT_NOW_BUTTON = "android:id/button2";

  /** Contextual Screen id's. */
  private static final String ACCEPT_BUTTON = "android:id/button1";

  /** Contextual Screen id's. */
  private static final String CONTEXTPAGE =
      "com.org.appframework.sample.generic:id/appframe__internal__notice_image";

  /** OS Location prompt Allow */
  private static final String ALLOW_BUTTON =
      "com.android.packageinstaller:id/permission_allow_button";

  /** OS Location prompt Deny */
  private static final String DENY_BUTTON =
      "com.android.packageinstaller:id/permission_deny_button";

  /**
   * Select Not Now button.
   */
  public void selectNotNow() {
    click(By.id(NOT_NOW_BUTTON));
    LOGGER.debug("not now selected");
  }

  /**
   * Select Accept button.
   */
  public void selectAccept() {
    click(By.id(ACCEPT_BUTTON));
    LOGGER.debug("accept selected");
  }

  /**
   * Wait for Contextual Permissions Page
   */
  public void waitForContextPage() {
    wait(By.id(CONTEXTPAGE));
    LOGGER.debug("Contextextual Permissions Prompt is shown");
  }

  /**
   * Select Allow on the OS location prompt
   */
  public void selectAllow() {
    click(By.id(ALLOW_BUTTON));
    LOGGER.debug("Allow OS location prompt");
  }

  /**
   * Select Allow on the OS location prompt
   */
  public void selectDeny() {
    click(By.id(DENY_BUTTON));
    LOGGER.debug("Allow OS location prompt");
  }

}
