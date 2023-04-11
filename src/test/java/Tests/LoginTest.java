package Tests;

import ConfingsAndHelpers.Assertions;
import ConfingsAndHelpers.JavaScriptT;
import ConfingsAndHelpers.WebDriverSetup2;
import Pages.LogInAccountPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import service.ErrorTestListener;

@Listeners(ErrorTestListener.class)
public class LoginTest extends WebDriverSetup2 {

    @Test(priority = 1)
    public void notAutorization() throws InterruptedException {
        LogInAccountPage logInAccountPage = new LogInAccountPage();
        MainPage mainPage = new MainPage();
        mainPage.clickElementsBtn();
        Thread.sleep(2000);
        JavaScriptT.scrollBy(0, 450);
        Thread.sleep(2000);
        mainPage.clickBookStoreApplication();
        Thread.sleep(2000);
        JavaScriptT.scrollBy(0, 450);
        Thread.sleep(2000);
        mainPage.clickLoginBtn();
        logInAccountPage.inputLogin("Timmy");
        logInAccountPage.inputPassword("CR8Tv@kGH3iiBvE");
        logInAccountPage.clickLoginBtn();
        Thread.sleep(1000);
        WebElement error =
                WebDriverSetup2.getDriverInstance().
                        findElement(By.xpath("//*[text() = 'Invalid username or password!']"));
        Assertions.checkText(error, "Invalid username or password!");
    }

    @Test(priority = 2)
    public void autrization() throws InterruptedException {
        LogInAccountPage logInAccountPage = new LogInAccountPage();
        logInAccountPage.clearLogin();
        logInAccountPage.inputLogin("Timophone");
        logInAccountPage.clearPassword();
        logInAccountPage.inputPassword("CR8Tv@kGH3iiBvE");
        logInAccountPage.clickLoginBtn();
        Thread.sleep(1000);
        WebElement element3 =
                WebDriverSetup2.getDriverInstance().findElement(By.xpath("//div[@class = 'main-header']"));
        Assert.assertTrue(Assertions.isDisplayed(element3));
    }

}



