package com.org.appium.android.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import com.org.appium.android.utils.UserActionsUtil;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class HomePage extends UserActionsUtil {

  // The Constant LOGGER
  private static final Logger LOGGER = Logger.getLogger(HomePage.class);

  // Button id's for left menu items and Home buttons
  public static final String HAMBURGER_MENU_ID = "Open Navigation drawer";
  public static final String HOME = "1: [Home]";
  public static final String WEATHER = "1: [Weather]";
  public static final String OFFICE_LOCATIONS = "73: [Office Locations]";
  public static final String OFFICE_LOCATIONS_HOME = "73: [Office Locations Home]";
  public static final String OFFICE_MAP = "84: [Office Map]";
  public static final String OFFICE_MAP_HOME = "84: [Nativemaps]";
  public static final String LEADERSHIP = "36: [Leadership]";
  public static final String DEPARTMENTS = "36: [Departments]";
  public static final String DIRECTORY = "36: [Directory]";
  public static final String DIRECTORY_HOME = "36: [Directory Home]";
  public static final String EULA = "98: [EULA]";
  public static final String MESSAGES = "17: [Messages]";
  public static final String EVENTS = "30: [Events]";
  public static final String EVENTS_HOME = "30: [Events Home]";
  public static final String ABOUT = "1: [About]";
  public static final String PARKING = "32: [Parking]";
  public static final String SETTINGS = "70: [Settings]";


  // RETURNS THE PAGE TITLE
  public String getPageTitle() {
    String pageTitle = driver.findElementByClassName("android.widget.TextView").getText();
    LOGGER.info("Found Page Title - " + pageTitle);
    return pageTitle;
  }

  // TAP BACK KEY
  public void clickBackArrow() {
    UserActionsUtil.back();
  }

  // HAMBURGER MENU
  public void clickHamburgerMenu() {
    LOGGER.info("Click on hamburger menu");
    click(By.id(HAMBURGER_MENU_ID));
  }

  // SELECTS HAMBURGER MENU ITEM
  public void clickHamburgerMenuItem(String itemName) {
    waitForHamMenu();
    clickHamburgerMenu();
    UserActionsUtil.androidScrollToContentDesc(itemName).click();
    LOGGER.info(itemName + " Selected");
  }

  // SELECTS HOME BUTTON ITEM
  public void clickHomeButtonItem(String itemName) {
    UserActionsUtil.androidScrollToContentDesc(itemName).click();
  }

  // WAITS FOR THE HAMBRUGER MENU TO APPEAR
  public void waitForHamMenu() {
    wait(By.id(HAMBURGER_MENU_ID));
    LOGGER.info("Hamburger menu found");
  }
}
