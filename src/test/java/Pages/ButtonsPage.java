package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage{
    @CacheLookup
    @FindBy(xpath = "//button[text() = 'Double Click Me']")
    public WebElement doubleClickMeBtn;
    @FindBy(xpath = "//button[text() = 'Right Click Me']")
    public WebElement rightClickMeBtn;
    @FindBy(xpath = "//button[text() = 'Click Me']")
    public WebElement clickMeBtn;

}
