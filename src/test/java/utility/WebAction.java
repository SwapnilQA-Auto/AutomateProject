package utility;

import hooks.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WebAction {
    private static Select select;
    private static Actions actions;
    private static WebDriverWait wait;
    private static Alert alert;
    private static final Logger logger = LogManager.getLogger(WebAction.class);

    /**
     * Returns the current page title. Use to fetch the title of the loaded web page.
     */
    public static String getTitle() {
        logger.info("Getting page title");
        try {
            return Hooks.driver.getTitle();
        } catch (Exception e) {
            logger.error("Failed to get page title", e);
            throw e;
        }
    }

    /**
     * Sends text to a web element. Use to input text into fields; can optionally clear existing content.
     */
    public static void sendText(String page, String key, String text, boolean clear) {
        logger.info("Sending text to element | Page: " + page + " | Key: " + key + " | Text: " + text);
        try {
            WebElement element = Hooks.driver.findElement(
                    ObjectRepository.getLocator(page, key));

            if (clear) {
                element.clear();
            }

            element.sendKeys(text);
        } catch (Exception e) {
            logger.error("Failed to send text | Page: " + page + " | Key: " + key, e);
            throw e;
        }
    }

    /**
     * Clicks on the specified web element. Use to perform a standard click action.
     */
    public static void click(String page, String key) {
        logger.info("Clicking on element | Page: " + page + " | Key: " + key);
        try {
            Hooks.driver.findElement(
                    ObjectRepository.getLocator(page, key)
            ).click();
        } catch (Exception e) {
            logger.error("Failed to click element | Page: " + page + " | Key: " + key, e);
            throw e;
        }
    }

    /**
     * Retrieves visible text from the specified web element. Use to get element's displayed content.
     */
    public static String getText(String page, String key) {
        logger.info("Getting text from element | Page: " + page + " | Key: " + key);
        try {
            return Hooks.driver.findElement(
                    ObjectRepository.getLocator(page, key)).getText();
        } catch (Exception e) {
            logger.error("Failed to get text | Page: " + page + " | Key: " + key, e);
            throw e;
        }
    }

    /**
     * Checks if the specified element is displayed. Use to verify element visibility.
     */
    public static boolean isDisplayed(String page, String key) {
        logger.info("Checking if element is displayed | Page: " + page + " | Key: " + key);
        try {
            return Hooks.driver.findElement(
                    ObjectRepository.getLocator(page, key)).isDisplayed();
        } catch (Exception e) {
            logger.error("Failed to check isDisplayed | Page: " + page + " | Key: " + key, e);
            throw e;
        }
    }

    /**
     * Checks if the specified element is enabled. Use to verify if an element can be interacted with.
     */
    public static boolean isEnabled(String page, String key) {
        logger.info("Checking if element is enabled | Page: " + page + " | Key: " + key);
        try {
            return Hooks.driver.findElement(
                    ObjectRepository.getLocator(page, key)).isEnabled();
        } catch (Exception e) {
            logger.error("Failed to check isEnabled | Page: " + page + " | Key: " + key, e);
            throw e;
        }
    }

    /**
     * Checks if the specified element is selected. Use for checkboxes, radio buttons, etc.
     */
    public static boolean isSelected(String page, String key) {
        logger.info("Checking if element is selected | Page: " + page + " | Key: " + key);
        try {
            return Hooks.driver.findElement(
                    ObjectRepository.getLocator(page, key)).isSelected();
        } catch (Exception e) {
            logger.error("Failed to check isSelected | Page: " + page + " | Key: " + key, e);
            throw e;
        }
    }

    /**
     * Submits the specified element. Use for submitting forms or input elements.
     */
    public static void submit(String page, String key) {
        logger.info("Submitting element | Page: " + page + " | Key: " + key);
        try {
            Hooks.driver.findElement(
                    ObjectRepository.getLocator(page, key)).submit();
        } catch (Exception e) {
            logger.error("Failed to submit element | Page: " + page + " | Key: " + key, e);
            throw e;
        }
    }

    /**
     * Selects an option in a dropdown by visible text. Use for dropdown selection by text.
     */
    public static void selectByVisibleText(String page, String key, String text) {
        logger.info("Selecting by visible text | Page: " + page + " | Key: " + key + " | Text: " + text);
        try {
            WebElement element = Hooks.driver.findElement(
                    ObjectRepository.getLocator(page, key));
            select = new Select(element);
            select.selectByVisibleText(text);
        } catch (Exception e) {
            logger.error("Failed selectByVisibleText | Page: " + page + " | Key: " + key, e);
            throw e;
        }
    }

    /**
     * Selects an option in a dropdown by value attribute. Use for dropdown selection by value.
     */
    public static void selectByValue(String page, String key, String value) {
        logger.info("Selecting by value | Page: " + page + " | Key: " + key + " | Value: " + value);
        try {
            WebElement element = Hooks.driver.findElement(
                    ObjectRepository.getLocator(page, key));
            select = new Select(element);
            select.selectByValue(value);
        } catch (Exception e) {
            logger.error("Failed selectByValue | Page: " + page + " | Key: " + key, e);
            throw e;
        }
    }

    /**
     * Selects an option in a dropdown by index. Use for dropdown selection by option index.
     */
    public static void selectByIndex(String page, String key, int index) {
        logger.info("Selecting by index | Page: " + page + " | Key: " + key + " | Index: " + index);
        try {
            WebElement element = Hooks.driver.findElement(
                    ObjectRepository.getLocator(page, key));
            select = new Select(element);
            select.selectByIndex(index);
        } catch (Exception e) {
            logger.error("Failed selectByIndex | Page: " + page + " | Key: " + key, e);
            throw e;
        }
    }

    /**
     * Performs mouse hover over the specified element. Use for hover actions (e.g., to reveal menus).
     */
    public static void mouseHover(String page, String key) {
        logger.info("Mouse hover on element | Page: " + page + " | Key: " + key);
        try {
            WebElement element = Hooks.driver.findElement(
                    ObjectRepository.getLocator(page, key));
            actions = new Actions(Hooks.driver);
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            logger.error("Failed mouseHover | Page: " + page + " | Key: " + key, e);
            throw e;
        }
    }

    /**
     * Performs a right-click (context click) on the specified element. Use for context menu actions.
     */
    public static void rightClick(String page, String key) {
        logger.info("Right click on element | Page: " + page + " | Key: " + key);
        try {
            WebElement element = Hooks.driver.findElement(
                    ObjectRepository.getLocator(page, key));
            actions = new Actions(Hooks.driver);
            actions.contextClick(element).perform();
        } catch (Exception e) {
            logger.error("Failed rightClick | Page: " + page + " | Key: " + key, e);
            throw e;
        }
    }

    /**
     * Performs a double-click on the specified element. Use for triggering double-click events.
     */
    public static void doubleClick(String page, String key) {
        logger.info("Double click on element | Page: " + page + " | Key: " + key);
        try {
            WebElement element = Hooks.driver.findElement(
                    ObjectRepository.getLocator(page, key));
            actions = new Actions(Hooks.driver);
            actions.doubleClick(element).perform();
        } catch (Exception e) {
            logger.error("Failed doubleClick | Page: " + page + " | Key: " + key, e);
            throw e;
        }
    }

    /**
     * Waits until the specified element is visible. Use for explicit waits before interacting with elements.
     */
    public static void waitForVisibility(String page, String key, int seconds) {
        logger.info("Waiting for visibility | Page: " + page + " | Key: " + key + " | Seconds: " + seconds);
        try {
            wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    ObjectRepository.getLocator(page, key)));
        } catch (Exception e) {
            logger.error("Failed waitForVisibility | Page: " + page + " | Key: " + key, e);
            throw e;
        }
    }

    /**
     * Waits until the specified element is clickable. Use for explicit waits before clicking elements.
     */
    public static void waitForClickable(String page, String key, int seconds) {
        logger.info("Waiting for element to be clickable | Page: " + page + " | Key: " + key + " | Seconds: " + seconds);
        try {
            wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.elementToBeClickable(
                    ObjectRepository.getLocator(page, key)));
        } catch (Exception e) {
            logger.error("Failed waitForClickable | Page: " + page + " | Key: " + key, e);
            throw e;
        }
    }

    // ---------------- WAIT UTILITIES ----------------

    /**
     * Sets the implicit wait timeout for locating elements. Use to define default wait time for all element searches.
     */
    public static void setImplicitWait(int seconds) {
        logger.info("Setting implicit wait: " + seconds + " seconds");
        try {
            Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        } catch (Exception e) {
            logger.error("Failed to set implicit wait", e);
            throw e;
        }
    }

    /**
     * Sets the page load timeout. Use to specify how long to wait for a page to load.
     */
    public static void setPageLoadTimeout(int seconds) {
        logger.info("Setting page load timeout: " + seconds + " seconds");
        try {
            Hooks.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
        } catch (Exception e) {
            logger.error("Failed to set page load timeout", e);
            throw e;
        }
    }

    /**
     * Sets the script timeout. Use to specify maximum execution time for asynchronous scripts.
     */
    public static void setScriptTimeout(int seconds) {
        logger.info("Setting script timeout: " + seconds + " seconds");
        try {
            Hooks.driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(seconds));
        } catch (Exception e) {
            logger.error("Failed to set script timeout", e);
            throw e;
        }
    }

    /**
     * Waits for an element using fluent wait. Use for custom polling and timeout strategies.
     */
    public static WebElement fluentWait(String page, String key, int timeoutSeconds, int pollingSeconds) {
        logger.info("Fluent wait for element | Page: " + page + " | Key: " + key + " | Timeout: " + timeoutSeconds + "s | Polling: " + pollingSeconds + "s");
        try {
            Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<>(Hooks.driver)
                    .withTimeout(Duration.ofSeconds(timeoutSeconds))
                    .pollingEvery(Duration.ofSeconds(pollingSeconds))
                    .ignoring(org.openqa.selenium.NoSuchElementException.class)
                    .ignoring(org.openqa.selenium.ElementNotInteractableException.class)
                    .ignoring(org.openqa.selenium.StaleElementReferenceException.class);

            return wait.until(driver -> driver.findElement(ObjectRepository.getLocator(page, key)));
        } catch (Exception e) {
            logger.error("Failed fluentWait | Page: " + page + " | Key: " + key, e);
            throw e;
        }
    }

    /**
     * Navigates the browser to the specified URL. Use to load a new page.
     */
    public static void navigateTo(String url) {
        logger.info("Navigating to URL: " + url);
        try {
            Hooks.driver.navigate().to(url);
        } catch (Exception e) {
            logger.error("Failed to navigate to URL: " + url, e);
            throw e;
        }
    }

    /**
     * Refreshes the current browser page. Use to reload the current page.
     */
    public static void refresh() {
        logger.info("Refreshing browser");
        try {
            Hooks.driver.navigate().refresh();
        } catch (Exception e) {
            logger.error("Failed to refresh browser", e);
            throw e;
        }
    }

    /**
     * Navigates back in the browser history. Use to go to the previous page.
     */
    public static void goBack() {
        logger.info("Navigating back");
        try {
            Hooks.driver.navigate().back();
        } catch (Exception e) {
            logger.error("Failed to navigate back", e);
            throw e;
        }
    }

    /**
     * Navigates forward in the browser history. Use to go to the next page.
     */
    public static void goForward() {
        logger.info("Navigating forward");
        try {
            Hooks.driver.navigate().forward();
        } catch (Exception e) {
            logger.error("Failed to navigate forward", e);
            throw e;
        }
    }

    // ---------------- WINDOW HANDLING ----------------

    /**
     * Returns the handle of the current browser window. Use for window management.
     */
    public static String getCurrentWindowHandle() {
        logger.info("Getting current window handle");
        try {
            return Hooks.driver.getWindowHandle();
        } catch (Exception e) {
            logger.error("Failed getCurrentWindowHandle", e);
            throw e;
        }
    }

    /**
     * Returns handles for all open browser windows. Use to iterate or switch between windows.
     */
    public static Set<String> getAllWindowHandles() {
        logger.info("Getting all window handles");
        try {
            return Hooks.driver.getWindowHandles();
        } catch (Exception e) {
            logger.error("Failed getAllWindowHandles", e);
            throw e;
        }
    }

    /**
     * Switches browser context to the specified window handle. Use to operate in a different window/tab.
     */
    public static void switchToWindow(String windowHandle) {
        logger.info("Switching to window | Handle: " + windowHandle);
        try {
            Hooks.driver.switchTo().window(windowHandle);
        } catch (Exception e) {
            logger.error("Failed switchToWindow | Handle: " + windowHandle, e);
            throw e;
        }
    }

    // ---------------- ALERT HANDLING ----------------

    /**
     * Accepts the currently displayed alert. Use to confirm JavaScript alerts/popups.
     */
    public static void acceptAlert() {
        logger.info("Accepting alert");
        try {
            alert = Hooks.driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            logger.error("Failed acceptAlert", e);
            throw e;
        }
    }

    /**
     * Dismisses the currently displayed alert. Use to cancel/close JavaScript alerts/popups.
     */
    public static void dismissAlert() {
        logger.info("Dismissing alert");
        try {
            alert = Hooks.driver.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
            logger.error("Failed dismissAlert", e);
            throw e;
        }
    }

    /**
     * Gets the text from the currently displayed alert. Use to read alert messages.
     */
    public static String getAlertText() {
        logger.info("Getting alert text");
        try {
            alert = Hooks.driver.switchTo().alert();
            return alert.getText();
        } catch (Exception e) {
            logger.error("Failed getAlertText", e);
            throw e;
        }
    }

    /**
     * Sends text input to the currently displayed alert. Use for prompt dialogs requiring input.
     */
    public static void sendTextToAlert(String text) {
        logger.info("Sending text to alert | Text: " + text);
        try {
            alert = Hooks.driver.switchTo().alert();
            alert.sendKeys(text);
        } catch (Exception e) {
            logger.error("Failed sendTextToAlert", e);
            throw e;
        }
    }

    // ---------------- JAVASCRIPT EXECUTION ----------------

    /**
     * Clicks an element using JavaScript. Use for elements not interactable by standard click.
     */
    public static void clickUsingJS(String page, String key) {
        logger.info("Clicking using JavaScript | Page: " + page + " | Key: " + key);
        try {
            WebElement element = Hooks.driver.findElement(
                    ObjectRepository.getLocator(page, key));
            JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            logger.error("Failed clickUsingJS | Page: " + page + " | Key: " + key, e);
            throw e;
        }
    }

    /**
     * Scrolls the specified element into view using JavaScript. Use to bring off-screen elements into view.
     */
    public static void scrollIntoView(String page, String key) {
        logger.info("Scrolling element into view | Page: " + page + " | Key: " + key);
        try {
            WebElement element = Hooks.driver.findElement(
                    ObjectRepository.getLocator(page, key));
            JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            logger.error("Failed scrollIntoView | Page: " + page + " | Key: " + key, e);
            throw e;
        }
    }

    /**
     * Scrolls the page by the specified number of pixels. Use for custom scrolling actions.
     */
    public static void scrollByPixels(int x, int y) {
        logger.info("Scrolling by pixels | X: " + x + " | Y: " + y);
        try {
            JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
            js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
        } catch (Exception e) {
            logger.error("Failed scrollByPixels", e);
            throw e;
        }
    }
    /**
     * Scrolls the page to the bottom. Use to reach the end of a page for lazy-loaded content.
     */
    public static void scrollToBottom() {
        logger.info("Scrolling to the bottom of the page");
        try {
            JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        } catch (Exception e) {
            logger.error("Failed scrollToBottom", e);
            throw e;
        }
    }

    // ---------------- SCREENSHOT ----------------

    /**
     * Takes a screenshot of the current browser window and saves it to the specified path.
     * Use for capturing the current state of the UI.
     */
    public static void takeScreenshot(String filePath) throws IOException {
        logger.info("Taking screenshot at path: " + filePath);
        try {
            TakesScreenshot ts = (TakesScreenshot) Hooks.driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File(filePath+"/screenshot"+".png");
            FileUtils.copyFile(src, dest);
        } catch (Exception e) {
            logger.error("Failed takeScreenshot", e);
            throw e;
        }
    }

    // ---------------- EXCEL UTILITIES ----------------

    /**
     * Reads the value of a cell from an Excel file. Use to fetch test data or configurations.
     */
    public static String readExcelCell(String filePath, String sheetName, int rowNum, int cellNum)
            throws IOException {
        logger.info("Reading Excel | File: " + filePath + " | Sheet: " + sheetName + " | Row: " + rowNum + " | Cell: " + cellNum);
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(cellNum);

            String value = cell.toString();

            workbook.close();
            fis.close();

            return value;
        } catch (Exception e) {
            logger.error("Failed readExcelCell", e);
            throw e;
        }
    }

    /**
     * Writes data to a cell in an Excel file. Use to store output or update test data.
     */
    public static void writeExcelCell(String filePath, String sheetName,
                                      int rowNum, int cellNum, String data)
            throws IOException {
        logger.info("Writing Excel | File: " + filePath + " | Sheet: " + sheetName + " | Row: " + rowNum + " | Cell: " + cellNum + " | Data: " + data);
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            Row row = sheet.getRow(rowNum);
            if (row == null) {
                row = sheet.createRow(rowNum);
            }

            Cell cell = row.getCell(cellNum);
            if (cell == null) {
                cell = row.createCell(cellNum);
            }

            cell.setCellValue(data);

            fis.close();

            FileOutputStream fos = new FileOutputStream(filePath);
            workbook.write(fos);

            workbook.close();
            fos.close();
        } catch (Exception e) {
            logger.error("Failed writeExcelCell", e);
            throw e;
        }
    }
}
