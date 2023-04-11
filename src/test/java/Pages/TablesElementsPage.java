package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;
import service.ErrorTestListener;

@Listeners(ErrorTestListener.class)
public class TablesElementsPage  extends BasePage{


    @CacheLookup
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
    @FindBy(xpath = "//button[text() = 'Submit']")
    WebElement editionSubmitButton;
    @FindBy(xpath = "//*[@id = 'delete-record-2']")
    WebElement deleteButton;


    public void clickAddBtn () {addButton.click();}

    public void inputFirstName (String firstName) {
        firstNameLine.sendKeys(firstName);
    }

    public void inputLastName (String lastName) {
        lastNameLine.sendKeys(lastName);
    }

    public void inputEmail (String email) {
        emailLine.sendKeys(email);
    }

    public void inputAge (String age) {
        ageLine.sendKeys(age);
    }

    public void inputSalary (String salary) {
        salaryLine.sendKeys(salary);
    }

    public void inputDepartment (String department) {
        departmentLine.sendKeys(department);
    }

    public void clickSubmitBtn () {submitButton.click();}

    public void clickEditingBtn () {editingButton.click();}

    public void clearFirstName () {firstNameLine2.clear();}

    public void inputNewFirstName (String newFirstName) {
        firstNameLine2.sendKeys(newFirstName);
    }

    public void clickEditingSubmitBtn () {editionSubmitButton.click();}

    public void clickDeleteBtn () {deleteButton.click();}

}
