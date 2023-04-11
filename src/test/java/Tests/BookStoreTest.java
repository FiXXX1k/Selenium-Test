package Tests;

import ConfingsAndHelpers.Assertions;
import ConfingsAndHelpers.JavaScriptT;
import ConfingsAndHelpers.WebDriverSetup2;
import Pages.BooksStorePage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BookStoreTest extends WebDriverSetup2 {

    @Test(priority = 1)
    public void bookSearchTest() throws InterruptedException {
        MainPage mainPage = new MainPage();
        BooksStorePage booksStorePage = new BooksStorePage();
        mainPage.clickElementsBtn();
        Thread.sleep(2000);
        JavaScriptT.scrollBy(0, 450);
        Thread.sleep(2000);
        mainPage.clickBookStoreApplication();
        Thread.sleep(2000);
        JavaScriptT.scrollBy(0, 250);
        mainPage.clickBookStoreBtn();
        Thread.sleep(1000);
        WebElement element4 =
                WebDriverSetup2.getDriverInstance().findElement(By.xpath("//div[text() = 'Book Store']"));
        Assert.assertTrue(Assertions.isDisplayed(element4));
        Thread.sleep(2000);

        booksStorePage.inputBookSearchName("Git Pocket Guide");
        Assertions.elementNotAttachedToPage(By.xpath("//a[@href='/books?book=9781449331818']"));
    }

    @Test(priority = 2)
    public void bookLinkEnter() {
        BooksStorePage booksStorePage = new BooksStorePage();
        booksStorePage.clickBookLink();
        WebElement element5 =
                WebDriverSetup2.getDriverInstance().findElement(By.xpath("//*[text() = 'Git Pocket Guide']"));
        Assert.assertTrue(Assertions.isDisplayed(element5));
    }
}
