package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    //class attribute untuk masing-masing element
    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By titleError = By.xpath("//*[contains(@class,'error-message-container')]");
    By errorButton = By.xpath("//button[@class='error-button']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(30));
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void inputUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
    }

    public void inputPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public void loginButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
    }

    public String getTitleError(){
        return driver.findElement(titleError).getText();
    }

    public void errorButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorButton));
        driver.findElement(errorButton).click();
    }
}
