package Browser_checking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class browse_the {
    static ChromeOptions options = new ChromeOptions();
    public static WebDriver driver = new ChromeDriver(options);

    public void Setup() throws InterruptedException {
        String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://next.magiya.lk/app/login");
        // Add an implicit wait to handle synchronization issues
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
}
