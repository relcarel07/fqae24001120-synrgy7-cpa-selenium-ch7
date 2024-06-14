import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class Checkout {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void checkOut(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.loginButton();
        productPage.tshirtAddCart();
        productPage.backpackAddCart();
        productPage.shopCart();
        cartPage.checkoutButton();
        checkoutStepOnePage.inputFirtname("Carel");
        checkoutStepOnePage.inputLastname("Putra");
        checkoutStepOnePage.inputZip("64116");
        checkoutStepOnePage.continueButton();
        checkoutStepTwoPage.finishButton();


        //validation url
        Assert.assertEquals(checkoutCompletePage.getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");
        System.out.println("Current URL: " + driver.getCurrentUrl());

        //validation complete text
        Assert.assertEquals(checkoutCompletePage.getCompleteText(),"Thank you for your order!");
        System.out.println("Complete Text: " + driver.findElement(By.xpath("//*[contains(@class,'complete-header')]")).getText());

        //validation pony express
        checkoutCompletePage.ponyexpressImgisDisplayed();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
