package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RadioButtonPage extends BasePage {
    @CacheLookup
    @FindBy(xpath = "//*[text() = 'Yes']")
    public WebElement yesButton;
    @FindBy(xpath = "//*[text() = 'Impressive']")
    public WebElement impressiveButton;
    @FindBy(xpath = "//*[text() = 'No']")
    public WebElement noButton;

    public void clickYesBtn(){
        yesButton.click();
    }

    public void clickImpressiveBtn(){
        impressiveButton.click();
    }



}
