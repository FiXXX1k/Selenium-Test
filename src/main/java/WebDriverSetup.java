import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class WebDriverSetup {
    static RemoteWebDriver driver;
    public static WebDriverWait wait;

    public static void initWait() {
        wait = new WebDriverWait(getDriverInstance(), Duration.ofSeconds(5), Duration.ofMillis(100));

    }



    public static RemoteWebDriver getDriverInstance(){
        return driver;
    }

    @BeforeClass
    public static void setupDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*","ignore-certificate-errors");


        WebDriverSetup.driver = new ChromeDriver(options);
        initWait();


    }


}
