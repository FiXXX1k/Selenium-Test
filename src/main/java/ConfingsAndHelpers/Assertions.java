package ConfingsAndHelpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.assertj.core.api.Assertions.assertThat;


public class Assertions {

    public static void checkText(WebElement element, String value) {
        String errorMessage = element.getText();
        assertThat(errorMessage).isEqualTo(value);
    }

    public static void checkAttributeValue(WebElement element, String value, String attribute) {
        String attributeValue = element.getAttribute(attribute);
        assertThat(attributeValue).isEqualTo(value);
    }

    public static boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Метод возвращает true если срабатывает исключение что элементЫ НЕ НАЙДЕНЫ,
     * таким образом мы проверяем, что элементы не отображаются
     * иметь приватный доступ т.к. только возвращает true/false и должен использоваться в методе ассерта
     */
    private static boolean isElementNotVisibleOnPage(By locator) {
        try {
            visibilityOfAllElementLocated(locator);
            return false;
        } catch (TimeoutException e) {
            return true;
        }
    }

    public static void elementNotAttachedToPage(By element) {
        boolean elementPresentOnPage = isElementNotVisibleOnPage(element);
        assertThat(elementPresentOnPage).as("Элемент с таким локатором не найден").isTrue();
    }

    public static void visibilityOfAllElementLocated(By webElement) {
        WaitT.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(webElement));
    }
}





