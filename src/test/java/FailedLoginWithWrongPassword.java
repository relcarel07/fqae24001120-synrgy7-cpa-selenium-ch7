import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class FailedLoginWithWrongPassword {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void failedLogin(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret");
        loginPage.loginButton();
        loginPage.errorButton();

        //validation url
        Assert.assertEquals(loginPage.getCurrentUrl(),"https://www.saucedemo.com/");
        System.out.println("Current URL: " + driver.getCurrentUrl());

        //validation message error
        //Assert.assertEquals(loginPage.getTitleError(),"Epic sadface: Username and password do not match any user in this service");
        //System.out.println("Error Message: " + driver.findElement(By.xpath("//*[contains(@class,'error-message-container')]")).getText());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
