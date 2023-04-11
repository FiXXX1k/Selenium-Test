package Tests;

import ConfingsAndHelpers.Assertions;
import ConfingsAndHelpers.WebDriverSetup2;
import Pages.MainPage;
import Pages.TablesElementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TablesElementsTest extends WebDriverSetup2 {


    @Test (priority = 1)
    public void additingTableTest (){
        TablesElementsPage tablesElementsPage = new TablesElementsPage();
        MainPage mainPage = new MainPage();
        mainPage.clickElementsBtn();
        mainPage.clickWebTablesBtn();
        tablesElementsPage.clickAddBtn();
        tablesElementsPage.inputFirstName("Mike");
        tablesElementsPage.inputLastName("Smith");
        tablesElementsPage.inputEmail("MikySmithy999@mail.ru");
        tablesElementsPage.inputAge("26");
        tablesElementsPage.inputSalary("10000");
        tablesElementsPage.inputDepartment("Legal");
        tablesElementsPage.clickSubmitBtn();
        WebElement element =
                WebDriverSetup2.getDriverInstance().findElement(By.xpath("//div[text() = 'Mike']"));
        Assert.assertTrue(Assertions.isDisplayed(element));
    }

    @Test(priority = 2)
    public void editingTest() {
        TablesElementsPage tablesElementsPage = new TablesElementsPage();
        tablesElementsPage.clickEditingBtn();
        tablesElementsPage.clearFirstName();
        tablesElementsPage.inputNewFirstName("John");
        tablesElementsPage.clickEditingSubmitBtn();
        WebElement element2 =
                WebDriverSetup2.getDriverInstance().findElement(By.xpath("//div[text() = 'John']"));
        Assert.assertTrue(Assertions.isDisplayed(element2));
    }

    @Test(priority = 3)
    public void deleteBtnCheck(){
        TablesElementsPage tablesElementsPage = new TablesElementsPage();
        tablesElementsPage.clickDeleteBtn();
        Assertions.elementNotAttachedToPage(By.xpath("//div[text() = 'Alden']"));
    }
}
