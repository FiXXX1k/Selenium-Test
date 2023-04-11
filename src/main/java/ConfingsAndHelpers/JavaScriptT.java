package ConfingsAndHelpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static ConfingsAndHelpers.WebDriverSetup2.getDriverInstance;

public class JavaScriptT {

    protected static JavascriptExecutor js;

    /** Инициализация исполнителя Js скриптов */
    public static void initJS() {
        js = getDriverInstance();
    }

    @Step("Клик по невидимому элементу JS")
    public static void clickInvisibleElementJS(String locator) {
        String script = "arguments[0].click();";
        ((JavascriptExecutor)getDriverInstance()).executeScript(script, getDriverInstance().findElement(By.xpath(locator)));
    }

    @Step("Скролл страницы на заданное расстояние в пикселях по X и по Y JS")
    public static void scrollBy(int x, int y) {
        String script = "window.scrollBy(" + x + "," + y + ")";
        ((JavascriptExecutor)getDriverInstance()).executeScript(script);
    }

    @Step("Установка невидимости веб элемента JS")
    public static void displayNone(String locator) {
        String script = "arguments[0].style.display='none';";
        ((JavascriptExecutor)getDriverInstance()).executeScript(script, By.xpath(locator));
    }

    @Step("Получение текста веб элемента JS")
    public static String getTextJS(String locator) {
        String script = "return document.documentElement.innerText";
        return ((JavascriptExecutor)getDriverInstance()).executeScript(script, getDriverInstance().findElement(By.xpath(locator))).toString();
    }
}
