package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutStepTwoPage {

    WebDriver driver;
    WebDriverWait wait;

    By titleText = By.xpath("//*[contains(@class,'title')]");
    By finishButton = By.id("finish");

    public CheckoutStepTwoPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getTitleText(){
        return driver.findElement(titleText).getText();
    }

    public void finishButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton));
        driver.findElement(finishButton).click();
    }
}
