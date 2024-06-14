import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class SortingbyHighToLowPrice {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void sortingProduct(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.loginButton();
        productPage.productSort();
        productPage.hightolowSort();


        //validation url
        Assert.assertEquals(productPage.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        System.out.println("Current URL: " + driver.getCurrentUrl());

        //validation high price
        Assert.assertEquals(productPage.gethighPriceItem(),"Sauce Labs Fleece Jacket");
        System.out.println("Item High Price: " + driver.findElement(By.id("item_5_title_link")).getText());

        //validation low price
        Assert.assertEquals(productPage.getlowPriceItem(),"Sauce Labs Onesie");
        System.out.println("Item Low Price: " + driver.findElement(By.id("item_2_title_link")).getText());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
