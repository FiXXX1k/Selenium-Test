package ConfingsAndHelpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import service.Attachment;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class WebDriverSetup2 {

    /**
     * Единственный экземпляр драйвера, реализует паттерн синглетон
     */
    private static RemoteWebDriver remoteWebDriver;

    /**
     * Получение уже созданного экземпляра вебдрайвера.
     * Если нужно обратиться к драйверу, используем этот метод (TestBase.getDriverInstance)
     */
    public static RemoteWebDriver getDriverInstance() {
        return remoteWebDriver;
    }

    /**
     * Драйвер для локального запуска
     *
     * @return экземпляр настроенного драйвера
     */
    public static RemoteWebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> chromePrefs = new HashMap<>();

        // сохранение скачанных файлов в target/downloads, может пригодиться для проверки скачанных файлов
        chromePrefs.put("download.default_directory", "target");
        chromePrefs.put("download.prompt_for_download", false);

        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        options.setExperimentalOption("prefs", chromePrefs);
        return new ChromeDriver(options);
    }

    @BeforeSuite
    protected static void setUpDriver() {
        remoteWebDriver = getChromeDriver();
        getDriverInstance().get("https://demoqa.com/checkbox");
        Attachment.getAllureEnvironment();
//        remoteWebDriver.manage().window().maximize();
        JavaScriptT.initJS();
        WaitT.initWait(Duration.ofSeconds(5), Duration.ofMillis(100));
    }
}

