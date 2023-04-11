package Pages;

import ConfingsAndHelpers.WebDriverSetup2;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends WebDriverSetup2 {
    BasePage() {
        PageFactory.initElements(WebDriverSetup2.getDriverInstance(), this);
    }
}
