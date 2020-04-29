
package com.org.appium.android.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.org.appium.android.utils.UserActionsUtil;

public class EulaPage extends UserActionsUtil {

  /** The Constant LOGGER. */
  private static final Logger LOGGER = Logger.getLogger(HomePage.class);

  /** Eula Screen id's */
  private static final String EULA_PAGE =
      "com.org.appframework.sample.generic:id/eulaApplicationImageView";

  /** Eula Screen id's */
  private static final String EULA_AGREE_BUTTON =
      "com.org.appframework.sample.generic:id/acceptEulaButton";

  /**
   * Select Agree button on the EULA page.
   */
  public void selectAgree() {
    LOGGER.debug("Select Agree button");
    wait(By.id(EULA_PAGE));
    click(By.id(EULA_AGREE_BUTTON));


  }

  /**
   * Wait for Eula to show
   */
  public void waitForEulaPage() {
    LOGGER.debug("Wait for Eula to appear Agree button");
    wait(By.id(EULA_PAGE));
  }

}
