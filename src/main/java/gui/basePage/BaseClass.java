package gui.basePage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseClass {
    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        BaseClass.driver = driver;
    }

    private static WebDriver driver = null;

    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        setDriver(driver);
        driver.manage().window().maximize();
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }

    public void clickOnWebElement(WebElement element) {
        element.click();
    }

    public void clickUsingJavaScriptExecutor(WebElement element) {
        JavascriptExecutor javascriptExcecutor = (JavascriptExecutor) driver;
        javascriptExcecutor.executeScript("arguments[0].click();", element);
    }

    public void switchToBrowser(String browserTitle) {
        Set<String> windows = driver.getWindowHandles();
       Iterator<String> windowsIterator = windows.iterator();
       while(windowsIterator.hasNext()){
           String parentOrChildWindow = windowsIterator.next();
           String title = driver.switchTo().window(parentOrChildWindow).getTitle();
           if(title.contains(browserTitle)){
               break;
           }
       }
    }

    public void type(WebElement element, String value) {
        element.sendKeys(value);
    }

    public String getElementValue(WebElement element) {
        return element.getText();
    }

    public void implicitWait(Integer seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void clear(WebElement element){
        element.clear();
    }

    public void scrollInToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public Boolean regularExpressionPatternVerification(String regularExpression, String stringValue){
        Pattern pattern = Pattern.compile(regularExpression);//. represents single character
        Matcher matcher = pattern.matcher(stringValue);
        return matcher.matches();
    }
}
