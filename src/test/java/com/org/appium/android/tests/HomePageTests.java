package com.org.appium.android.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.org.appium.android.pages.ContextPermPage;
import com.org.appium.android.pages.EulaPage;
import com.org.appium.android.pages.HomePage;
import com.org.appium.android.utils.AppiumTest;
import com.org.appium.android.utils.UserActionsUtil;


/**
 * The Class HomePageTests.
 */
public class HomePageTests extends AppiumTest {

  private static final Logger LOGGER = Logger.getLogger(HomePageTests.class);

  /** The Generic page. */
  private ContextPermPage contextPermPage = new ContextPermPage();
  private EulaPage eulaPage = new EulaPage();
  private HomePage homePage = new HomePage();


  @BeforeTest
  public void beforeTest() throws Exception {
    AppiumTest.setup("generic-4.10.1.359.apk");
  }

  // *********** Hamburger Menu tests *********** //

  /**
   * Validate Presence Of Hamburger Menu after user login
   * 
   * @throws InterruptedException
   */
  @Test(priority = 1)
  public void validatePresenceOfHamburgerMenu() throws InterruptedException {
    // Accept EULA, Enable Location Services, Search for properties, Select property
    eulaPage.waitForEulaPage();
    eulaPage.selectAgree();
    LOGGER.info("Selected Agree");
    contextPermPage.waitForContextPage();
    LOGGER.info("Context Page Shown");
    contextPermPage.selectAccept();
    LOGGER.info("Select Context Page");
    contextPermPage.selectAllow();
    LOGGER.info("See Home Page");
    Assert.assertTrue(
        UserActionsUtil.isMobileElementPresentUsingContentDescAndroid(HomePage.HAMBURGER_MENU_ID),
        "Hamburger menu is not found");
  }

  /**
   * Validate Home link in Hamburger Menu
   */
  @Test(priority = 2)
  public void validateHomeLinkInhamburgerMenu() {
    homePage.clickHamburgerMenuItem(HomePage.HOME);
    LOGGER.info("checking for page title");
    Assert.assertEquals(homePage.getPageTitle(), "PW Corporate");
    UserActionsUtil.back();
  }

  /**
   * Validate Weather link in Hamburger Menu
   */
  @Test(priority = 3)
  public void validateWeatherlinkInhamburgerMenu() {
    homePage.clickHamburgerMenuItem(HomePage.WEATHER);
    Assert.assertEquals(homePage.getPageTitle(), "Weather");
    UserActionsUtil.back();
  }

  /**
   * Validate Office Locations link in Hamburger Menu
   */
  @Test(priority = 4)
  public void validateOfficeLocationsInhamburgerMenu() {
    homePage.clickHamburgerMenuItem(HomePage.OFFICE_LOCATIONS);
    Assert.assertEquals(homePage.getPageTitle(), "Office Locations");
    UserActionsUtil.back();
  }

  /**
   * Validate Office Map link in Hamburger Menu
   */
  @Test(priority = 5)
  public void validateOfficeMapLinkInhamburgerMenu() {
    homePage.clickHamburgerMenuItem(HomePage.OFFICE_MAP);
    Assert.assertEquals(homePage.getPageTitle(), "Buildings");
    UserActionsUtil.back();
  }

  /**
   * Validate Leadership link in Hamburger Menu
   */
  @Test(priority = 6)
  public void validateLeadershipLinkInhamburgerMenu() {
    homePage.clickHamburgerMenuItem(HomePage.LEADERSHIP);
    Assert.assertEquals(homePage.getPageTitle(), "Leadership");
    UserActionsUtil.back();
  }

  /**
   * Validate Departments link in Hamburger Menu
   */
  @Test(priority = 7)
  public void validateDepartmentsLinkInhamburgerMenu() {
    homePage.clickHamburgerMenuItem(HomePage.DEPARTMENTS);
    Assert.assertEquals(homePage.getPageTitle(), "Departments");
    UserActionsUtil.back();
  }

  /**
   * Validate Directory link in Hamburger Menu
   */
  @Test(priority = 8)
  public void validateDirectoryLinkInhamburgerMenu() {
    homePage.clickHamburgerMenuItem(HomePage.DIRECTORY);
    Assert.assertEquals(homePage.getPageTitle(), "Directory");
    UserActionsUtil.back();
  }

  /**
   * Validate Eula link in Hamburger Menu
   */
  @Test(priority = 9)
  public void validateManagementLinkInhamburgerMenu() {
    homePage.clickHamburgerMenuItem(HomePage.EULA);
    Assert.assertEquals(homePage.getPageTitle(), "EULA");
    UserActionsUtil.back();
  }

  /**
   * Validate Message Center link in Hamburger Menu
   */
  @Test(priority = 10)
  public void validateMessagesLinkInhamburgerMenu() {
    homePage.clickHamburgerMenuItem(HomePage.MESSAGES);
    Assert.assertEquals(homePage.getPageTitle(), "Message Center");
    UserActionsUtil.back();
  }

  /*
   * Validate Events link in Hamburger Menu
   */
  @Test(priority = 11)
  public void validateEventsLinkInhamburgerMenu() {
    homePage.clickHamburgerMenuItem(HomePage.EVENTS);
    Assert.assertEquals(homePage.getPageTitle(), "Events");
    UserActionsUtil.back();
  }

  /**
   * Validate About link in Hamburger Menu
   */
  @Test(priority = 12)
  public void validateAboutLinkInhamburgerMenu() {
    homePage.clickHamburgerMenuItem(HomePage.ABOUT);
    Assert.assertEquals(homePage.getPageTitle(), "About");
    UserActionsUtil.back();
  }

  /**
   * Validate Parking link in Hamburger Menu
   */
  @Test(priority = 13)
  public void validateUnlockLinkInhamburgerMenu() {
    homePage.clickHamburgerMenuItem(HomePage.PARKING);
    Assert.assertEquals(homePage.getPageTitle(), "Parking");
    UserActionsUtil.back();
  }

  /**
   * Validate Settings link in Hamburger Menu
   */
  @Test(priority = 14)
  public void validateSettingsLinkInhamburgerMenu() {
    homePage.clickHamburgerMenuItem(HomePage.SETTINGS);
    Assert.assertEquals(homePage.getPageTitle(), "Settings");
    UserActionsUtil.back();
  }

  // *********** HOME PAGE LINKS *********** //

  /**
   * Validate Office Map button in Home Page
   */
  @Test(priority = 15)
  public void validateOfficeMapLnkInHomeMenu() {
    homePage.clickHomeButtonItem(HomePage.OFFICE_MAP_HOME);
    Assert.assertEquals(homePage.getPageTitle(), "Buildings");
    UserActionsUtil.back();
  }

  /**
   * Validate Leadership button in Home Page
   */
  @Test(priority = 16)
  public void validateLeadershipLinkInHomeMenu() {
    homePage.clickHomeButtonItem(HomePage.DIRECTORY_HOME);
    Assert.assertEquals(homePage.getPageTitle(), "Directory Home");
    UserActionsUtil.back();
  }

  /**
   * Validate Events button in Home Page
   */
  @Test(priority = 17)
  public void validateEventsLinkInHomeMenu() {
    homePage.clickHomeButtonItem(HomePage.EVENTS_HOME);
    Assert.assertEquals(homePage.getPageTitle(), "Events");
    UserActionsUtil.back();
  }

  /**
   * Validate Office Locations button in Home Page
   */
  @Test(priority = 18)
  public void validateOfficeLocationsLinkInHomeMenu() {
    homePage.clickHomeButtonItem(HomePage.OFFICE_LOCATIONS_HOME);
    Assert.assertEquals(homePage.getPageTitle(), "Office Locations Home");
    UserActionsUtil.back();
  }
}
