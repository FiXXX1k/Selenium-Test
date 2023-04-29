package Tests;

import ConfingsAndHelpers.Assertions;
import ConfingsAndHelpers.JavaScriptT;
import ConfingsAndHelpers.WaitT;
import ConfingsAndHelpers.WebDriverSetup2;
import Pages.LinksPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class LinksTest extends WebDriverSetup2 {

    @Test(priority = 1)
    public void homeLinkClickTest(){
        MainPage mainPage = new MainPage();
        LinksPage linksPage = new LinksPage();
        mainPage.buttonLinks.click();
        linksPage.clickHomeLink();
        WaitT.littleWait(2000);
        WebElement homePageBanner =
                WebDriverSetup2.getDriverInstance().findElement(By.xpath("//*[@href = 'https://demoqa.com']"));
        Assert.assertTrue(Assertions.isDisplayed(homePageBanner));
        getDriverInstance().getWindowHandle();
        String mainWindow = getDriverInstance().getWindowHandle();
        getDriverInstance().switchTo().window(mainWindow);
        Set<String> s1 = getDriverInstance().getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String childWindow = i1.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                getDriverInstance().switchTo().window(childWindow);
                getDriverInstance().close();
            }
        }
        getDriverInstance().switchTo().window(mainWindow);
    }

    @Test(priority = 2)
    public void dynamicLinkTest(){
        LinksPage linksPage = new LinksPage();
        linksPage.clickDynamicLink();
        WaitT.littleWait(2000);
        WebElement homePageBanner =
                WebDriverSetup2.getDriverInstance().findElement(By.xpath("//*[@href = 'https://demoqa.com']"));
        Assert.assertTrue(Assertions.isDisplayed(homePageBanner));
        getDriverInstance().getWindowHandle();
        String mainWindow = getDriverInstance().getWindowHandle();
        getDriverInstance().switchTo().window(mainWindow);
        Set<String> s1 = getDriverInstance().getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String childWindow = i1.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                getDriverInstance().switchTo().window(childWindow);
                getDriverInstance().close();
            }
        }
        getDriverInstance().switchTo().window(mainWindow);
    }


    @Test(priority = 3)
    public void createdLinkTest(){
        LinksPage linksPage = new LinksPage();
        linksPage.clickCreatedLink();
        WaitT.littleWait(1000);
        WebElement error1 =
                WebDriverSetup2.getDriverInstance().
                        findElement(By.xpath("//p[@id = 'linkResponse']"));
        Assertions.checkText(error1, "Link has responded with staus 201 and status text Created");

    }

    @Test(priority = 4)
    public void noContentLinkTest(){
        LinksPage linksPage = new LinksPage();
        linksPage.clickNoContentLink();
        WaitT.littleWait(1000);
        WebElement error2 =
                WebDriverSetup2.getDriverInstance().
                        findElement(By.xpath("//p[@id = 'linkResponse']"));
        Assertions.checkText(error2, "Link has responded with staus 204 and status text No Content");
    }

    @Test(priority = 5)
    public void movedLinkTest(){
        LinksPage linksPage = new LinksPage();
        linksPage.clickMoveLink();
        WaitT.littleWait(1000);
        WebElement error3 =
                WebDriverSetup2.getDriverInstance().
                        findElement(By.xpath("//p[@id = 'linkResponse']"));
        Assertions.checkText(error3, "Link has responded with staus 301 and status text Moved Permanently");
    }

    @Test(priority = 6)
    public void badRequestLinkTest(){
        LinksPage linksPage = new LinksPage();
        linksPage.clickBadRequestLink();
        WaitT.littleWait(1000);
        WebElement error4 =
                WebDriverSetup2.getDriverInstance().
                        findElement(By.xpath("//p[@id = 'linkResponse']"));
        Assertions.checkText(error4, "Link has responded with staus 400 and status text Bad Request");
    }

    @Test(priority = 7)
    public void unauthorizedLinkTest(){
        LinksPage linksPage = new LinksPage();
        linksPage.clickUnauthorizedLink();
        WaitT.littleWait(1000);
        WebElement error5 =
                WebDriverSetup2.getDriverInstance().
                        findElement(By.xpath("//p[@id = 'linkResponse']"));
        Assertions.checkText(error5, "Link has responded with staus 401 and status text Unauthorized");
    }

    @Test(priority = 8)
    public void forbiddenLinkTest(){
        LinksPage linksPage = new LinksPage();
        linksPage.clickForbiddenLink();
        WaitT.littleWait(1000);
        WebElement error6 =
                WebDriverSetup2.getDriverInstance().
                        findElement(By.xpath("//p[@id = 'linkResponse']"));
        Assertions.checkText(error6, "Link has responded with staus 403 and status text Forbidden");
    }

    @Test(priority = 9)
    public void notFoundLinkTest(){
        LinksPage linksPage = new LinksPage();
        JavaScriptT.scrollBy(0, 250);
        linksPage.clickNotFoundLink();
        WaitT.littleWait(1000);
        WebElement error7 =
                WebDriverSetup2.getDriverInstance().
                        findElement(By.xpath("//p[@id = 'linkResponse']"));
        Assertions.checkText(error7, "Link has responded with staus 404 and status text Not Found");
    }
}
