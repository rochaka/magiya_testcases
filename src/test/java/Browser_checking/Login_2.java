package Browser_checking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class Login_2 {

    static FirefoxOptions options = new FirefoxOptions();
    public static WebDriver driver;

    @BeforeTest
    public void Setup() throws InterruptedException {
        String geckoDriverPath = System.getProperty("user.dir") + "src/test/resources/geckodriver.exe";
        options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get("https://next.magiya.lk/app/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public static void loging() throws IOException, InterruptedException {
        Thread.sleep(2000);
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
