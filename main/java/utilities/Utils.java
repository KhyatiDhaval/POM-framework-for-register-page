package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {


     static WebDriver driver;


    public Utils(WebDriver driver) {

        this.driver = driver;
    }

    public static WebElement getElement(String locator){
        WebElement element = driver.findElement(By.id(locator));
        return element;

    }
    public static void doSendKeys(By locator, String value){
        getElement(String.valueOf(locator)).sendKeys(value);

    }
    public static void doClick(By locator){

        getElement(String.valueOf(locator)).click();
    }
    public static boolean verifyContinueButton(By locator){

        return getElement(String.valueOf(locator)).isDisplayed();
    }
    public static WebElement waitForElementToBeVisible(String locator, int timeout){

        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));

    }
    public static void selectValueFromDropDown(WebElement element, String value){
       Select select;
        select = new Select(element);
        select.selectByVisibleText(value);
    }

    public static void waitForElementToBeVisible(By messageVerificationForRegistration) {
    }
}
