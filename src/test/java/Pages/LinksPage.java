package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LinksPage extends BasePage{
    @CacheLookup
    @FindBy(xpath = "//a[text() = 'Home']")
    public WebElement homeLink;
    @FindBy(xpath = "//a[@id = 'dynamicLink']")
    public WebElement dynamicLink;
    @FindBy(xpath = "//a[text() = 'Created']")
    public WebElement createdLink;
    @FindBy(xpath = "//a[text() = 'No Content']")
    public WebElement noContentLink;
    @FindBy(xpath = "//a[text() = 'Moved']")
    public WebElement movedLink;
    @FindBy(xpath = "//a[text() = 'Bad Request']")
    public WebElement badRequestLink;
    @FindBy(xpath = "//a[text() = 'Unauthorized']")
    public WebElement unauthorizedLink;
    @FindBy(xpath = "//a[text() = 'Forbidden']")
    public WebElement forbiddenLink;
    @FindBy(xpath = "//a[text() = 'Not Found']")
    public WebElement notFoundLink;

    public void clickHomeLink(){
        homeLink.click();
    }

    public void clickDynamicLink(){
        dynamicLink.click();
    }

    public void clickCreatedLink(){
        createdLink.click();
    }

    public void clickNoContentLink(){
        noContentLink.click();
    }

    public void clickMoveLink(){
        movedLink.click();
    }

    public void clickBadRequestLink(){
        badRequestLink.click();
    }

    public void clickUnauthorizedLink(){
        unauthorizedLink.click();
    }

    public void clickForbiddenLink(){
        forbiddenLink.click();
    }

    public void clickNotFoundLink(){
        notFoundLink.click();
    }
}
