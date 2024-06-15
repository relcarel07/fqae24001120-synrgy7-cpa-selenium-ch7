package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    By titleText = By.xpath("//*[contains(@class,'title')]");
    By productSort = By.xpath("//select[@class='product_sort_container']");
    By hightolowSort = By.xpath("//option[@value='hilo']");
    By shopCart = By.id("shopping_cart_container");
    By backpackAddCart = By.id("add-to-cart-sauce-labs-backpack");
    By tshirtAddCart = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By highfirstPriceItem = By.id("item_5_title_link");
    By highsecondPriceItem = By.id("item_4_title_link");
    By itemSuccesLogin = By.id("item_4_title_link");

    public ProductPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(30));
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getTitleText(){
        return driver.findElement(titleText).getText();
    }

    public String getItemSucessLogin(){
        return driver.findElement(itemSuccesLogin).getText();
    }

    public void productSort(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productSort));
        driver.findElement(productSort).click();
    }

    public void hightolowSort(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hightolowSort));
        driver.findElement(hightolowSort).click();
    }

    public String gethighPriceItem(){
        return driver.findElement(highfirstPriceItem).getText();
    }

    public String getlowPriceItem(){
        return driver.findElement(highsecondPriceItem).getText();
    }

    public void shopCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(shopCart));
        driver.findElement(shopCart).click();
    }

    public void backpackAddCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(backpackAddCart));
        driver.findElement(backpackAddCart).click();
    }

    public void tshirtAddCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tshirtAddCart));
        driver.findElement(tshirtAddCart).click();
    }
}
