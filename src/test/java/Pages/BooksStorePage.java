package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;
import service.ErrorTestListener;

import static org.openqa.selenium.Keys.ENTER;

@Listeners(ErrorTestListener.class)
public class BooksStorePage extends BasePage {

    @CacheLookup
    @FindBy(xpath = "//input[@id = 'searchBox']")
    WebElement bookSearch;
    @FindBy(xpath = "//a[@href = '/books?book=9781449325862']")
    WebElement bookLink;

    public void inputBookSearchName(String bookName){
        bookSearch.sendKeys(bookName + ENTER);
    }

    public void clickBookLink() {bookLink.click();}
}

