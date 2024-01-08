import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class template {

    public static ChromeOptions options = new ChromeOptions();
    public static WebDriver driver = new ChromeDriver(options);

    @BeforeTest
    void Setup() {

        options.addArguments("--remort-allow-origins");
        System.setProperty("web driver.chrome.driver", System.getProperty("user.dir") + "src/test/resources/chromedriver.exe");

        driver.get("https://next.magiya.lk/app/login"); ////////////////// change any ULR///////////////////
    }

    @Test
    void teststeps() {

        driver.findElement(By.id("email")).sendKeys("web@zuse.lk");
        driver.findElement(By.id("password")).sendKeys("Kalupusa321@");

        WebElement rememberMeCheckbox = driver.findElement(By.xpath("//span[normalize-space()='Remember me']"));
        if (!rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        }

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();


        {
            driver.quit();
        }


    }


}
