package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutStepOnePage {
    WebDriver driver;
    WebDriverWait wait;

    By titleText = By.xpath("//*[contains(@class,'title')]");
    By firstnameField = By.id("first-name");
    By lastnameField = By.id("last-name");
    By zipField = By.id("postal-code");
    By continueButton = By.id("continue");

    public CheckoutStepOnePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getTitleText(){
        return driver.findElement(titleText).getText();
    }

    public void inputFirtname(String firstname){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstnameField));
        driver.findElement(firstnameField).sendKeys(firstname);
    }

    public void inputLastname(String lastname){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastnameField));
        driver.findElement(lastnameField).sendKeys(lastname);
    }

    public void inputZip(String zip){
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipField));
        driver.findElement(zipField).sendKeys(zip);
    }

    public void continueButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
        driver.findElement(continueButton).click();
    }
}
