package utility;

import hooks.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WebAction {
    private static Select select;
    private static Actions actions;
    private static WebDriverWait wait;
    private static Alert alert;

    public static String getTitle() {
        return Hooks.driver.getTitle();
    }

    public static void sendText(String page, String key, String text, boolean clear) {

        WebElement element = Hooks.driver.findElement(
                ObjectRepository.getLocator(page, key));

        if (clear) {
            element.clear();
        }

        element.sendKeys(text);
    }

    public static void click(String page, String key) {
        Hooks.driver.findElement(
                ObjectRepository.getLocator(page, key)
        ).click();
    }

    public static String getText(String page, String key) {
        return Hooks.driver.findElement(
                ObjectRepository.getLocator(page, key)).getText();
    }

    public static boolean isDisplayed(String page, String key) {
        return Hooks.driver.findElement(
                ObjectRepository.getLocator(page, key)).isDisplayed();
    }

    public static boolean isEnabled(String page, String key) {
        return Hooks.driver.findElement(
                ObjectRepository.getLocator(page, key)).isEnabled();
    }

    public static boolean isSelected(String page, String key) {
        return Hooks.driver.findElement(
                ObjectRepository.getLocator(page, key)).isSelected();
    }

    public static void submit(String page, String key) {
        Hooks.driver.findElement(
                ObjectRepository.getLocator(page, key)).submit();
    }

    public static void selectByVisibleText(String page, String key, String text) {
        WebElement element = Hooks.driver.findElement(
                ObjectRepository.getLocator(page, key));
        select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void selectByValue(String page, String key, String value) {
        WebElement element = Hooks.driver.findElement(
                ObjectRepository.getLocator(page, key));
        select = new Select(element);
        select.selectByValue(value);
    }

    public static void selectByIndex(String page, String key, int index) {
        WebElement element = Hooks.driver.findElement(
                ObjectRepository.getLocator(page, key));
        select = new Select(element);
        select.selectByIndex(index);
    }

    public static void mouseHover(String page, String key) {
        WebElement element = Hooks.driver.findElement(
                ObjectRepository.getLocator(page, key));
        actions = new Actions(Hooks.driver);
        actions.moveToElement(element).perform();
    }

    public static void rightClick(String page, String key) {
        WebElement element = Hooks.driver.findElement(
                ObjectRepository.getLocator(page, key));
        actions = new Actions(Hooks.driver);
        actions.contextClick(element).perform();
    }

    public static void doubleClick(String page, String key) {
        WebElement element = Hooks.driver.findElement(
                ObjectRepository.getLocator(page, key));
        actions = new Actions(Hooks.driver);
        actions.doubleClick(element).perform();
    }

    public static void waitForVisibility(String page, String key, int seconds) {
        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                ObjectRepository.getLocator(page, key)));
    }

    public static void waitForClickable(String page, String key, int seconds) {
        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(
                ObjectRepository.getLocator(page, key)));
    }

    public static void navigateTo(String url) {
        Hooks.driver.navigate().to(url);
    }

    public static void refresh() {
        Hooks.driver.navigate().refresh();
    }

    public static void goBack() {
        Hooks.driver.navigate().back();
    }

    public static void goForward() {
        Hooks.driver.navigate().forward();
    }

    // ---------------- WINDOW HANDLING ----------------

    public static String getCurrentWindowHandle() {
        return Hooks.driver.getWindowHandle();
    }

    public static Set<String> getAllWindowHandles() {
        return Hooks.driver.getWindowHandles();
    }

    public static void switchToWindow(String windowHandle) {
        Hooks.driver.switchTo().window(windowHandle);
    }

    // ---------------- ALERT HANDLING ----------------

    public static void acceptAlert() {
        alert = Hooks.driver.switchTo().alert();
        alert.accept();
    }

    public static void dismissAlert() {
        alert = Hooks.driver.switchTo().alert();
        alert.dismiss();
    }

    public static String getAlertText() {
        alert = Hooks.driver.switchTo().alert();
        return alert.getText();
    }

    public static void sendTextToAlert(String text) {
        alert = Hooks.driver.switchTo().alert();
        alert.sendKeys(text);
    }

    // ---------------- JAVASCRIPT EXECUTION ----------------

    public static void clickUsingJS(String page, String key) {
        WebElement element = Hooks.driver.findElement(
                ObjectRepository.getLocator(page, key));
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void scrollIntoView(String page, String key) {
        WebElement element = Hooks.driver.findElement(
                ObjectRepository.getLocator(page, key));
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollByPixels(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    // ---------------- SCREENSHOT ----------------

    public static void takeScreenshot(String filePath) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) Hooks.driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(filePath+"/screenshot"+".png");
        FileUtils.copyFile(src, dest);
    }

    // ---------------- EXCEL UTILITIES ----------------

    public static String readExcelCell(String filePath, String sheetName, int rowNum, int cellNum)
            throws IOException {

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(cellNum);

        String value = cell.toString();

        workbook.close();
        fis.close();

        return value;
    }

    public static void writeExcelCell(String filePath, String sheetName,
                                      int rowNum, int cellNum, String data)
            throws IOException {

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
    }
}
