package Tests;

import ConfingsAndHelpers.JavaScriptT;
import ConfingsAndHelpers.WaitT;
import ConfingsAndHelpers.WebDriverSetup2;
import Pages.DragAndDropPage;
import Pages.MainPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import service.ErrorTestListener;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Listeners(ErrorTestListener.class)
public class DragAndDropTest extends WebDriverSetup2 {

    @Test(priority = 1)
    public void DragAndDropTest()  {
        MainPage mainPage = new MainPage();
        DragAndDropPage dragAndDropPage = new DragAndDropPage();
        Actions actions = new Actions(getDriverInstance());

        mainPage.clickElementsBtn();
        WaitT.littleWait(2000);
        mainPage.clickInteractionsBtn();
        JavaScriptT.scrollBy(0, 450);
        WaitT.littleWait(2000);
        JavaScriptT.scrollBy(0, 450);
        WaitT.littleWait(2000);
        mainPage.clickDroppableBtn();
        WaitT.littleWait(2000);
        actions
                .clickAndHold(dragAndDropPage.dragElement)
                .moveToElement(dragAndDropPage.dropBox)
                .release(dragAndDropPage.dragElement)
                .perform();
        WaitT.littleWait(2000);

        assertThat(dragAndDropPage.dropBox.getCssValue("background-color"))
                .as("Полученное значение атрибута: не соответствует ожидаемому: " + "rgba(70, 130, 180, 1)")
                .isEqualTo("rgba(70, 130, 180, 1)");
    }
}
