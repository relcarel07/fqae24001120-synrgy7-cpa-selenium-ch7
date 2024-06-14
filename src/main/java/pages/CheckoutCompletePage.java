package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutCompletePage {

    WebDriver driver;
    WebDriverWait wait;

    By titleText = By.xpath("//*[contains(@class,'title')]");
    By completeText = By.xpath("//*[contains(@class,'complete-header')]");
    By ponyexpreesImg = By.xpath("//img[@class='pony_express']");

    public CheckoutCompletePage(WebDriver driver){
        this.driver = driver;
        //this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getTitleText(){
        return driver.findElement(titleText).getText();
    }

    public String getCompleteText(){
        return  driver.findElement(completeText).getText();
    }

    public void ponyexpressImgisDisplayed(){
        driver.findElement(ponyexpreesImg).isDisplayed();
    }
}
