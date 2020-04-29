package com.org.appium.android.utils;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * The Class Helpers.
 */
@SuppressWarnings("rawtypes")
public class UserActionsUtil {

  /** The Constant LOGGER. */
  private static final Logger LOGGER = Logger.getLogger(UserActionsUtil.class);

  /** The driver. */
  public static AndroidDriver driver;

  /** The server address. */
  public static URL serverAddress;

  /** The driver wait. */
  private static WebDriverWait driverWait;

  /**
   * Initialize the webdriver. Must be called before using any helper methods.
   *
   * @param webDriver the web driver
   * @param driverServerAddress the driver server address
   */
  public static void init(AndroidDriver webDriver, URL driverServerAddress) {
    driver = webDriver;
    serverAddress = driverServerAddress;
    int timeoutInSeconds = 60;
    // must wait at least 60 seconds for cloud devices
    driverWait = new WebDriverWait(webDriver, timeoutInSeconds);
  }

  /**
   * Set implicit wait in seconds.
   *
   * @param seconds the new wait
   */
  public static void setWait(int seconds) {
    driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
  }

  /**
   * Return an element by locator.
   *
   * @param locator the locator
   * @return the web element
   */
  public static WebElement element(By locator) {
    return driver.findElement(locator);
  }

  /**
   * Return a list of elements by locator.
   *
   * @param locator the locator
   * @return the list
   */
  @SuppressWarnings("unchecked")
  public static List<WebElement> elements(By locator) {
    return driver.findElements(locator);
  }

  /**
   * Press the back button.
   */
  public static void back() {
    driver.navigate().back();
  }

  /**
   * Return a list of elements by tag name.
   *
   * @param tagName the tag name
   * @return the list
   */
  public static List<WebElement> tags(String tagName) {
    return elements(for_tags(tagName));
  }

  /**
   * Return a tag name locator.
   *
   * @param tagName the tag name
   * @return the by
   */
  public static By for_tags(String tagName) {
    return By.className(tagName);
  }

  /**
   * Return a static text element by xpath index.
   *
   * @param xpathIndex the xpath index
   * @return the web element
   */
  public static WebElement s_text(int xpathIndex) {
    return element(for_text(xpathIndex));
  }

  /**
   * Return a static text locator by xpath index.
   *
   * @param xpathIndex the xpath index
   * @return the by
   */
  public static By for_text(int xpathIndex) {
    return By.xpath("//android.widget.TextView[" + xpathIndex + "]");
  }

  /**
   * Return a static text element that contains text.
   *
   * @param text the text
   * @return the web element
   */
  public static WebElement text(String text) {
    return element(for_text(text));
  }

  /**
   * Return a static text locator that contains text.
   *
   * @param text the text
   * @return the by
   */
  public static By for_text(String text) {
    return By.xpath("//android.widget.TextView[contains(@text, '" + text + "')]");
  }

  /**
   * Return a static text element by exact text.
   *
   * @param text the text
   * @return the web element
   */
  public static WebElement text_exact(String text) {
    return element(for_text_exact(text));
  }

  /**
   * Return a static text locator by exact text.
   *
   * @param text the text
   * @return the by
   */
  public static By for_text_exact(String text) {
    return By.xpath("//android.widget.TextView[@text='" + text + "']");
  }

  /**
   * For find.
   *
   * @param value the value
   * @return the by
   */
  public static By for_find(String value) {
    return By.xpath("//*[@content-desc=\"" + value + "\" or @resource-id=\"" + value
        + "\" or @text=\"" + value + "\"] | //*[contains(translate(@content-desc,\"" + value
        + "\",\"" + value + "\"), \"" + value + "\") or contains(translate(@text,\"" + value
        + "\",\"" + value + "\"), \"" + value + "\") or @resource-id=\"" + value + "\"]");
  }

  /**
   * Find.
   *
   * @param value the value
   * @return the web element
   */
  public static WebElement find(String value) {
    return element(for_find(value));
  }

  /**
   * Wait 30 seconds for locator to find an element.
   *
   * @param locator the locator
   * @return the web element
   */
  public static WebElement wait(By locator) {
    return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }


  /**
   * Click.
   *
   * @param locator the locator
   */
  public static void click(By locator) {
    wait(locator).click();
  }


  /**
   * Wait 60 seconds for locator to find all elements.
   *
   * @param locator the locator
   * @return the list
   */
  public static List<WebElement> waitAll(By locator) {
    return driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
  }


  /**
   * Wait 60 seconds for locator to not find a visible element.
   *
   * @param locator the locator
   * @return true, if successful
   */
  public static boolean waitInvisible(By locator) {
    return driverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
  }


  /**
   * Checks if is displayed.
   *
   * @param displayedText the displayed text
   * @return true, if is displayed
   */
  public static boolean isDislayed(String displayedText) {
    return driver.findElement(By.xpath("//android.widget.TextView[@text='" + displayedText + "']"))
        .isDisplayed();
  }

  /**
   * Checks presence of mobile element using text.
   * 
   * @param text
   * @return
   */
  public static boolean isMobileElementPresentUsingTextAndroid(String text) {
    LOGGER.debug("Trying to find element with text - " + text);
    boolean isPresent =
        (driver.findElements(By.xpath("new UiSelector().text(\"" + text + "\")")).size() >= 1);
    LOGGER.debug("is WebElement present: " + isPresent);
    return isPresent;

  }

  /**
   * Checks presence of mobile element using id.
   * 
   * @param id
   * @return
   */
  public static boolean isMobileElementPresentUsingIdAndroid(String id) {
    LOGGER.debug("Trying to find element with ID - " + id);
    boolean isPresent =
        (driver.findElements(By.xpath("new UiSelector().resourceId(\"" + id + "\")")).size() >= 1);
    LOGGER.debug("is webElement present: " + isPresent);
    return isPresent;
  }

  /**
   * Checks presence of mobile element using contentDesc.
   * 
   * @param contentDesc
   * @return
   */

  public static boolean isMobileElementPresentUsingContentDescAndroid(String contentDesc) {
    LOGGER.debug("Trying to locate element using content-desc - " + contentDesc);
    boolean isPresent = (driver
        .findElements(
            MobileBy.AndroidUIAutomator("new UiSelector().description(\"" + contentDesc + "\")"))
        .size() >= 1);
    LOGGER.debug("is webElement present: " + contentDesc);
    return isPresent;
  }


  /**
   * Swipe down.
   */
  public static void swipeDown() {
    Dimension size = driver.manage().window().getSize();
    LOGGER.debug("window size: " + size);

    int starty = (int) (size.height * 0.80);
    int endy = (int) (size.height * 0.20);
    int startx = size.width / 2;

    LOGGER.debug("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

    driver.swipe(startx, starty, startx, endy, 5000);
  }


  /**
   * Swipe.
   */
  public static void swipe(int startx, int starty, int endx, int endy) {
    Dimension size = driver.manage().window().getSize();
    LOGGER.debug("window size: " + size);
    driver.swipe(startx, starty, endx, endy, 2000);
  }


  /**
   * Gets the window size.
   *
   * @return the window size
   */
  public static Dimension getWindowSize() {
    return driver.manage().window().getSize();
  }


  /**
   * Scroll to element.
   *
   * @param text the text
   * @return true, if successful
   */
  public static boolean scrollToElement(String text) {
    boolean isFound = false;
    int pageNumber = 0;
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    // TODO: remove the infinite loop possibility
    while (!isFound && pageNumber <= 3) {
      try {
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, '" + text + "')]"));
        LOGGER.info("displayed text: " + driver
            .findElement(By.xpath("//android.widget.TextView[contains(@text, '" + text + "')]"))
            .getText());
        isFound = true;
        LOGGER.info("element found on page no. " + pageNumber);
      } catch (NoSuchElementException | ElementNotVisibleException e) {
        swipeDown();
      }
      pageNumber++;
    }
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    return isFound;
  }


  /**
   * Scroll to element. Last 2 elements of a page might not get selected. NEED TO FIX
   *
   * @param by the by
   * @param name the name
   * @return true, if successful
   * @throws InterruptedException the interrupted exception
   */
  public static boolean scrollToElement(By by, String name) throws InterruptedException {
    boolean isFound = false;
    int pageNumber = 0;
    List<WebElement> pages;
    WebElement lastElement = null;

    // wait for the elements to be available
    wait(by);
    pages = elements(by);

    // loop till element is found for last element is reached
    while (!isFound) {
      // capture the last element to identify end of page

      LOGGER.debug("list size:" + pages.size());
      lastElement = pages.get(pages.size() - 1);

      // loop through the list to identify required element
      for (WebElement page : pages) {
        LOGGER.debug("element text: " + page.getText());
        if (name.trim().equals(page.getText().trim())) {
          LOGGER.debug("element found on page number " + pageNumber);
          isFound = true;
          break;
        }
      }
      // if element is not found, then scroll to next page
      if (!isFound) {
        swipeDown();
        pageNumber++;
        Thread.sleep(1000);
        pages = elements(by);
      }

      LOGGER.debug("last element text: " + lastElement.getText());
      LOGGER.debug("new last element text: " + pages.get(pages.size() - 1).getText());

      // check if end of page is reached
      if (lastElement.equals(pages.get(pages.size() - 1))) {
        break;
      }
    }
    LOGGER.debug("is element found: " + isFound);
    return isFound;
  }


  /**
   * Find element.
   *
   * @param by the by
   * @param name the name
   * @return the web element
   * @throws InterruptedException the interrupted exception
   */
  public static WebElement findElement(By by, String name) throws InterruptedException {
    WebElement webElement = null;
    boolean isFound = false;
    int pageNumber = 0;
    List<WebElement> pages;
    WebElement lastElement = null;

    // wait for the elements to be available
    wait(by);
    pages = elements(by);

    // loop till element is found for last element is reached
    while (!isFound) {
      // capture the last element to identify end of page

      LOGGER.debug("list size:" + pages.size());
      lastElement = pages.get(pages.size() - 1);

      // loop through the list to identify required element
      for (int loopItr = 0; loopItr < pages.size(); loopItr++) {
        LOGGER.debug("element text: " + pages.get(loopItr).getText());
        if (name.trim().equals(pages.get(loopItr).getText().trim())) {
          LOGGER.debug("element found on page number " + pageNumber);
          webElement = pages.get(loopItr);
          isFound = true;
        }
      }

      // if element is not found, then scroll to next page
      if (!isFound) {
        swipeDown();
        pageNumber++;
        Thread.sleep(1000);
        pages = elements(by);
      }

      LOGGER.debug("last element text: " + lastElement.getText());
      LOGGER.debug("new last element text: " + pages.get(pages.size() - 1).getText());

      // check if end of page is reached
      if (lastElement.equals(pages.get(pages.size() - 1))) {
        break;
      }
    }
    LOGGER.debug("is element found: " + isFound);
    return webElement;
  }


  /**
   * Click.
   *
   * @param webElement the web element
   */
  public static void click(WebElement webElement) {
    webElement.isEnabled();
    webElement.click();
  }


  /**
   * Select page. Ensure that the resourceID of the complete list of elements is passed
   *
   * @param resourceID the resource ID
   * @param text the text
   * @return the mobile element
   */
  public static MobileElement selectPage(String resourceID, String text) {
    MobileElement mobileElement = (MobileElement) driver.findElement(
        MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()" + ".resourceId(\""
            + resourceID + "\")).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));"));
    return mobileElement;
  }


  /**
   * Horizontal swipe.
   *
   * @param by the by
   */
  public static void horizontalSwipe(By by) {
    Dimension windowDimension = UserActionsUtil.getWindowSize();
    int startx = (int) (windowDimension.width * 0.9);
    int endx = (int) (windowDimension.width * 0.1);
    int starty = (int) wait(by).getLocation().getY();
    UserActionsUtil.swipe(startx, starty, endx, starty);
  }

  // **** SCROLL FUNCTIONS *****//

  public static MobileElement scrollAndroid(String resourceID, String text) {
    LOGGER.info("Trying to scroll to android element with text - " + text);
    // make sure u give the resource ID of the complete list of elements here as parameter

    MobileElement el = (MobileElement) driver.findElement(
        MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()" + ".resourceId(\""
            + resourceID + "\")).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));"));
    return el;
  }

  public static MobileElement scrollAndroidUsingindex(String resourceID, int index) {
    LOGGER.info("Trying to scroll to android element with index - " + index);

    // make sure u give the resouce ID of the complete list of elements here as parameter

    MobileElement el = (MobileElement) driver.findElement(
        MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()" + ".resourceId(\""
            + resourceID + "\")).scrollIntoView(" + "new UiSelector().index(\"" + index + "\"));"));
    return el;
  }

  public static MobileElement androidScrollToText(String text) {
    LOGGER.info("Trying to scroll to element with text  - " + text);

    MobileElement el = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
        "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
    return el;
  }

  public static MobileElement androidScrollToContentDesc(String contentDesc) {
    LOGGER.info("Trying to scroll to element with content desc - " + contentDesc);
    MobileElement el = (MobileElement) driver.findElement(MobileBy
        .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(description(\""
            + contentDesc + "\"));"));
    return el;
  }

  public static MobileElement androidScrollToID(String id) {
    LOGGER.info("Trying to scroll to android element with ID - " + id);

    MobileElement el = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
        "new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"" + id + "\"));"));
    return el;
  }

}
