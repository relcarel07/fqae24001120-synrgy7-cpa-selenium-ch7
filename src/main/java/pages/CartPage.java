package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    By titleText = By.xpath("//*[contains(@class,'title')]");
    By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getTitleText(){
        return driver.findElement(titleText).getText();
    }

    public void checkoutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton));
        driver.findElement(checkoutButton).click();
    }
}
