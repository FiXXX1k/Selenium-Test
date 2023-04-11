package service;

import ConfingsAndHelpers.WebDriverSetup2;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

import static service.AllureEnvironmentWriter.allureEnvironmentWriter;

public class Attachment {
    /**
     * прикрепляет текстовое сообщение в отчет
     */
    @io.qameta.allure.Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    /**
     * прикрепляет скриншот в отчет
     */
    @io.qameta.allure.Attachment(value = "{attachName}", type = "image/png")
    public static byte[] attachScreenshot(String attachName) {
        return ((TakesScreenshot) WebDriverSetup2.getDriverInstance()).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * прикрепляет исходный код страницы в отчет
     */
    @io.qameta.allure.Attachment(value = "Page source", type = "text/html")
    public static byte[] attachPageSource() {
        return WebDriverSetup2.getDriverInstance().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    /**
     * прикрепляет окружение в отчет
     */
    public static void getAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", WebDriverSetup2.getDriverInstance().getCapabilities().getBrowserName().toUpperCase())
                        .put("Version", WebDriverSetup2.getDriverInstance().getCapabilities().getBrowserVersion())
                        .build());
    }
}
