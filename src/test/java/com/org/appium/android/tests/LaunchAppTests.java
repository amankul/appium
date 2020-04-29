package com.org.appium.android.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.org.appium.android.pages.ContextPermPage;
import com.org.appium.android.pages.EulaPage;
import com.org.appium.android.utils.AppiumTest;
import com.org.appium.android.utils.UserActionsUtil;



/**
 * The Class PhunGenericTest.
 */
public class LaunchAppTests extends AppiumTest {

  private static final Logger LOGGER = Logger.getLogger(LaunchAppTests.class);

  /** The Generic page. */
  private ContextPermPage contextPermPage = new ContextPermPage();
  private EulaPage eulaPage = new EulaPage();


  @BeforeTest
  public void beforeTest() throws Exception {
    AppiumTest.setup("PhunGeneric-4.10.1.359.apk");
  }


  /**
   * Declines Eula and Permissions screen
   * 
   * @throws InterruptedException
   */
  @Test(priority = 1)
  public void testNotNowButtonPress() throws InterruptedException {
    Thread.sleep(4000);
    // eulaPage.waitForEulaPage();
    eulaPage.selectAgree();
    // contextPermPage.waitForContextPage();
    contextPermPage.selectNotNow();
    Assert.assertTrue(UserActionsUtil.isMobileElementPresentUsingTextAndroid("DELETE"),
        "Delete button is not observed after swiping message to the left");
  }

  /**
   * Accepts Eula and Permissions screen
   * 
   * @throws InterruptedException
   */
  @Test(priority = 2)
  public void testAgreeButtonPress() throws InterruptedException {
    Thread.sleep(4000);
    // eulaPage.waitForEulaPage();
    eulaPage.selectAgree();
    // contextPermPage.waitForContextPage();
    contextPermPage.selectAccept();
    Assert.assertTrue(UserActionsUtil.isMobileElementPresentUsingTextAndroid("DELETE"),
        "Delete button is not observed after swiping message to the left");
  }


}
