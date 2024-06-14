import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class SuccesfullyLogin {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void succesfullyLogin(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.loginButton();

        //validation url
        Assert.assertEquals(productPage.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        System.out.println("Current URL: " + driver.getCurrentUrl());

        //validation title
        Assert.assertEquals(productPage.getTitleText(),"Products");
        System.out.println("Current Page: " + driver.findElement(By.xpath("//*[contains(@class,'title')]")).getText());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
