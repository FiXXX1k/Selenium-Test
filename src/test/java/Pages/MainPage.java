package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;
import service.ErrorTestListener;

@Listeners(ErrorTestListener.class)
public class MainPage extends BasePage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */

    @CacheLookup
    @FindBy(xpath = "//div[text() = 'Elements']")
    public WebElement elements;
    @FindBy(xpath = "//li[@id = 'item-3']")
    public WebElement WebTablesButton;
    @FindBy(xpath = "//*[@class = 'text' and text() = 'Login']")
    public WebElement loginButSelection;
    @FindBy(xpath = "//div[contains(text (), 'Book Store Application')]")
    public WebElement bookStore;
    @FindBy(xpath = "//*[@class = 'text' and text() = 'Book Store']")
    public WebElement bookStoreButton;
    @FindBy(xpath = "//div[text() = 'Interactions']")
    public WebElement interactionsBtn;
    @FindBy(xpath = "//*[@class = 'text' and text() = 'Droppable']")
    public WebElement droppable;


    /**
     * метод для осуществления нажатия кнопки открытия элементов находящихся в разделе "Elements"
     */
    public void clickElementsBtn() {
        elements.click();
    }

    /**
     * метод для осуществления нажатия кнопки перехода на страницу "Web Tables"
     */
    public void clickWebTablesBtn() {
        WebTablesButton.click();
    }

    /**
     * метод для осуществления нажатия кнопки открытия элементов находящихся в разделе "Book Store Application"
     */
    public void clickBookStoreApplication() {
        bookStore.click();
    }

    /**
     * метод для осуществления нажатия кнопки перехода на страницу "Login"
     */
    public void clickLoginBtn() {
        loginButSelection.click();
    }

    /**
     * метод для осуществления нажатия кнопки перехода на страницу "Book Store"
     */
    public void clickBookStoreBtn() {
        bookStoreButton.click();
    }

    public void clickInteractionsBtn() {
        interactionsBtn.click();
    }

    public void clickDroppableBtn() {
        droppable.click();
    }
}
