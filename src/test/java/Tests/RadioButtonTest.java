package Tests;

import ConfingsAndHelpers.Assertions;
import ConfingsAndHelpers.WaitT;
import ConfingsAndHelpers.WebDriverSetup2;
import Pages.MainPage;
import Pages.RadioButtonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import service.ErrorTestListener;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Listeners(ErrorTestListener.class)
public class RadioButtonTest extends WebDriverSetup2 {

    @Test(priority = 1)
    public void yesButtonClickableTest(){
        MainPage mainPage = new MainPage();
        RadioButtonPage radioButtonPage = new RadioButtonPage();
        mainPage.clickRadioBtn();
        WaitT.littleWait(1000);
        radioButtonPage.clickYesBtn();
        WebElement verification1 =
                WebDriverSetup2.getDriverInstance().
                        findElement(By.xpath("//span[contains(text(), 'Yes')]"));
        Assertions.checkText(verification1, "Yes");
    }

    @Test(priority = 2)
    public void impressiveButtonTest(){
        RadioButtonPage radioButtonPage = new RadioButtonPage();
        radioButtonPage.clickImpressiveBtn();
        WebElement verification2 =
                WebDriverSetup2.getDriverInstance().
                        findElement(By.xpath("//span[contains(text(), 'Impressive')]"));
        Assertions.checkText(verification2, "Impressive");
    }

    @Test(priority = 3)
    public void noButtonNotClickableTest(){
        RadioButtonPage radioButtonPage = new RadioButtonPage();
        assertThat(radioButtonPage.noButton.getCssValue("cursor"))
                .as("Полученное значение атрибута: не соответствует ожидаемому: " + "not-allowed")
                .isEqualTo("not-allowed");


    }
}
