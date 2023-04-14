package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;
import service.ErrorTestListener;

@Listeners(ErrorTestListener.class)
public class DragAndDropPage extends BasePage {

    @CacheLookup
    @FindBy(xpath = "//div[text() = 'Drag me']")
    public WebElement dragElement;
    @FindBy(xpath = "//div[@id = 'droppable']")
    public  WebElement dropBox;








}







