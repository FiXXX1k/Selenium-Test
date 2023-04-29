package Tests;

import ConfingsAndHelpers.Assertions;
import ConfingsAndHelpers.WebDriverSetup2;
import Pages.ButtonsPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends WebDriverSetup2 {


    @Test(priority = 1)
    public void doubleClickTest() {
        MainPage mainPage = new MainPage();
        ButtonsPage buttonsPage = new ButtonsPage();
        Actions actions = new Actions(getDriverInstance());
        mainPage.buttonsButton.click();
        actions
                .click(buttonsPage.doubleClickMeBtn)
                .perform();
        Assertions.elementNotAttachedToPage(By.xpath("//*[text() = 'You have done a double click']"));
        actions
                .doubleClick(buttonsPage.doubleClickMeBtn)
                .perform();
        WebElement noticeAboutDoubleClickAction =
                WebDriverSetup2.getDriverInstance().findElement(By.xpath("//*[text() = 'You have done a double click']"));
        Assert.assertTrue(Assertions.isDisplayed(noticeAboutDoubleClickAction));
    }

    @Test(priority = 2)
    public void rightClickTest() {
        ButtonsPage buttonsPage = new ButtonsPage();
        Actions actions = new Actions(getDriverInstance());
        actions
                .click(buttonsPage.rightClickMeBtn)
                .perform();
        Assertions.elementNotAttachedToPage(By.xpath("//*[text() = 'You have done a right click']"));
        actions
                .doubleClick(buttonsPage.rightClickMeBtn)
                .perform();
        Assertions.elementNotAttachedToPage(By.xpath("//*[text() = 'You have done a right click']"));
        actions
                .contextClick(buttonsPage.rightClickMeBtn)
                .perform();
        WebElement noticeAboutRightClickAction =
                WebDriverSetup2.getDriverInstance().findElement(By.xpath("//*[text() = 'You have done a right click']"));
        Assert.assertTrue(Assertions.isDisplayed(noticeAboutRightClickAction));
    }

    @Test(priority = 3)
    public void clickLeftTest(){
        ButtonsPage buttonsPage = new ButtonsPage();
        Actions actions = new Actions(getDriverInstance());
        actions
                .contextClick(buttonsPage.clickMeBtn)
                .perform();
        Assertions.elementNotAttachedToPage(By.xpath("//*[text() = 'You have done a dynamic click']"));
        buttonsPage.clickMeBtn.click();
        actions
                .click(buttonsPage.clickMeBtn)
                .perform();
        WebElement noticeAboutLeftClickAction =
                WebDriverSetup2.getDriverInstance().findElement(By.xpath("//*[text() = 'You have done a dynamic click']"));
        Assert.assertTrue(Assertions.isDisplayed(noticeAboutLeftClickAction));
    }
}
