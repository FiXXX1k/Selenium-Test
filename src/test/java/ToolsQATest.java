import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;



import static org.openqa.selenium.Keys.*;

public class ToolsQATest extends WebDriverSetup {

    @CacheLookup
    @FindBy(xpath = "//li[@id = 'item-3']")
    WebElement WebTablesButton;
    @FindBy(xpath = "//button[@class = 'btn btn-primary']")
    WebElement addButton;
    @FindBy(xpath = "//input[@placeholder = 'First Name']")
    WebElement firstNameLine;
    @FindBy(xpath = "//input[@id = 'lastName']")
    WebElement lastNameLine;
    @FindBy(xpath = "//input[@id = 'userEmail']")
    WebElement emailLine;
    @FindBy(xpath = "//input[@placeholder = 'Age']")
    WebElement ageLine;
    @FindBy(xpath = "//input[@id = 'salary']")
    WebElement salaryLine;
    @FindBy(xpath = "//input[@id = 'department']")
    WebElement departmentLine;
    @FindBy(xpath = "//button[@id = 'submit']")
    WebElement submitButton;
    @FindBy(xpath = "//span[@id = 'edit-record-1']")
    WebElement editingButton;
    @FindBy(xpath = "//input[@class = ' mr-sm-2 form-control']")
     WebElement firstNameLine2;
    @FindBy(xpath = "//button[@class = 'btn btn-primary']")
     WebElement editionSubmitButton;
    @FindBy(xpath = "//button[@class = 'close']")
    WebElement closeButton;
    @FindBy(xpath = "//span[@id = 'delete-record-2']")
    WebElement deleteButton;
    @FindBy(xpath = "//input[@id = 'userName']")
    WebElement userName;
    @FindBy(xpath = "//input[@id = 'password']")
    WebElement password;
    @FindBy(xpath = "//button[@id = 'login']")
     WebElement loginButton;
    @FindBy(xpath = "//*[@class = 'text' and text() = 'Login']")
    WebElement loginButSelection;
    @FindBy(xpath = "//div[text() = 'Book Store Application']")
    WebElement bookStore;
    @FindBy(xpath = "//div[text() = 'Elements']")
     WebElement elements;
    @FindBy(xpath = "//*[@class = 'text' and text() = 'Book Store']")
      WebElement bookStoreButton;
    @FindBy (xpath = "//input[@id = 'searchBox']")
    WebElement bookSearch;
    @FindBy(xpath = "//a[@href = '/books?book=9781449325862']")
     WebElement bookLink;

    ToolsQATest mainPage;

    @Test(priority = 1)
    public void initPage() {
        WebDriverSetup.getDriverInstance().get("https://demoqa.com/checkbox");
        mainPage = PageFactory.initElements(WebDriverSetup.getDriverInstance(), ToolsQATest.class);

    }

    @Test(priority = 2)
    public void WebTablesElementsTest()  {
        mainPage.WebTablesButton.click();
        mainPage.addButton.click();
        mainPage.firstNameLine.click();
        mainPage.firstNameLine.sendKeys("Mike" + ENTER);
        mainPage.lastNameLine.click();
        mainPage.lastNameLine.sendKeys("Smith" + ENTER);
        mainPage.emailLine.click();
        mainPage.emailLine.sendKeys("MikySmithy999@mail.ru" + ENTER);
        mainPage.ageLine.click();
        mainPage.ageLine.sendKeys("26" + ENTER);
        mainPage.salaryLine.click();
        mainPage.salaryLine.sendKeys("10000" + ENTER);
        mainPage.departmentLine.click();
        mainPage.departmentLine.sendKeys("Legal");
        mainPage.submitButton.click();
        WebElement element =
                WebDriverSetup.getDriverInstance().findElement(By.xpath("//div[text() = 'Mike']"));
        Assert.assertTrue(Assertions.isDisplayed(element));
        mainPage.editingButton.click();
        mainPage.firstNameLine2.click();
        mainPage.firstNameLine2.clear();
        mainPage.firstNameLine2.sendKeys("John" + ENTER);
        mainPage.editionSubmitButton.click();
        mainPage.closeButton.click();
        WebElement element2 =
                WebDriverSetup.getDriverInstance().findElement(By.xpath("//div[text() = 'John']"));
        Assert.assertTrue(Assertions.isDisplayed(element2));
        mainPage.deleteButton.click();
         Assertions.elementNotAttachedToPage(By.xpath("//div[text() = 'Alden']"));




    }

    @Test (priority = 3)
    public void notAutorizationTest() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) getDriverInstance();
        jse.executeScript("window.scrollBy(0,250)");
        mainPage.elements.click();
        Thread.sleep(1000);
        mainPage.bookStore.click();
        Thread.sleep(1000);
        mainPage.loginButSelection.click();
        mainPage.userName.click();
        mainPage.userName.sendKeys("Timmy");
        mainPage.password.click();
        mainPage.password.sendKeys("CR8Tv@kGH3iiBvE");
        mainPage.loginButton.click();
        Thread.sleep(1000);
        WebElement error =
                WebDriverSetup.getDriverInstance().
                        findElement(By.xpath("//*[text() = 'Invalid username or password!']"));
        Assertions.checkText(error, "Invalid username or password!");

    }

    @Test (priority = 4)
    public void autorizationTest() throws InterruptedException {
        mainPage.userName.clear();
        mainPage.userName.sendKeys("Timophone");
        mainPage.password.clear();
        mainPage.password.click();
        mainPage.password.sendKeys("CR8Tv@kGH3iiBvE");
        mainPage.loginButton.click();
        Thread.sleep(1000);
        WebElement element3 =
                WebDriverSetup.getDriverInstance().findElement(By.xpath("//div[@class = 'main-header']"));
        Assert.assertTrue(Assertions.isDisplayed(element3));

    }

    @Test (priority = 5)
    public void testBookStore() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) getDriverInstance();
        jse.executeScript("window.scrollBy(0,250)");
        mainPage.bookStoreButton.click();
        Thread.sleep(1000);
        WebElement element4 =
                WebDriverSetup.getDriverInstance().findElement(By.xpath("//div[text() = 'Book Store']"));
        Assert.assertTrue(Assertions.isDisplayed(element4));
        mainPage.bookSearch.click();
        mainPage.bookSearch.sendKeys("Git Pocket Guide" + ENTER);
        Assertions.elementNotAttachedToPage(By.xpath("//a[@href='/books?book=9781449331818']"));
        mainPage.bookLink.click();
        WebElement element5 =
                WebDriverSetup.getDriverInstance().findElement(By.xpath("//*[text() = 'Git Pocket Guide']"));
        Assert.assertTrue(Assertions.isDisplayed(element5));

    }

}










