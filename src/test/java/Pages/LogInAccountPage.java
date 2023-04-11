package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LogInAccountPage extends BasePage{

    @CacheLookup
    @FindBy(xpath = "//input[@id = 'userName']")
    WebElement userName;
    @FindBy(xpath = "//input[@id = 'password']")
    WebElement passwordLine;
    @FindBy(xpath = "//button[@id = 'login']")
    WebElement loginButton;

    public void inputLogin(String login){
        userName.sendKeys(login);
    }

    public void inputPassword(String password){
        passwordLine.sendKeys(password);
    }

    public void clickLoginBtn(){loginButton.click();
    }
     public void clearLogin(){userName.clear();}

    public void clearPassword(){passwordLine.clear();}
}


