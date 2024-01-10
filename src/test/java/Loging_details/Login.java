package Loging_details;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class Login {


    static ChromeOptions options = new ChromeOptions();
    public static WebDriver driver = new ChromeDriver(options);

    @BeforeTest
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
    @Test
    public static void loging() throws IOException, InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("email")).sendKeys("web@zuse.lk");
        driver.findElement(By.id("password")).sendKeys("Kalupusa321@");

        WebElement rememberMeCheckbox = driver.findElement(By.xpath("//span[normalize-space()='Remember me']"));
        if (!rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        }

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}
