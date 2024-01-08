package Trip_Management;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Trips {

    public static ChromeOptions options = new ChromeOptions();
    public static WebDriver driver = new ChromeDriver(options);

    @BeforeTest
    void Setup() {

        options.addArguments("--remort-allow-origins");
        System.setProperty("web driver.chrome.driver", System.getProperty("user.dir") + "src/test/resources/chromedriver.exe");

        driver.get("https://next.magiya.lk/app/login"); ////////////////// change any ULR///////////////////
    }

    @Test
    void teststeps() throws IOException, InterruptedException {

        driver.findElement(By.id("email")).sendKeys("web@zuse.lk");
        driver.findElement(By.id("password")).sendKeys("Kalupusa321@");

        WebElement rememberMeCheckbox = driver.findElement(By.xpath("//span[normalize-space()='Remember me']"));
        if (!rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        }

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        // Waiting (using explicit waits instead of Thread.sleep is recommended)
        // Replace these Thread.sleep() with explicit waits where possible
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //driver.findElement(By.xpath("(//*[name()='path'][@stroke-linecap='round'])[7]")).click();

        //create Create Fleet Brand button
        Thread.sleep(1000);
        WebElement Stations = driver.findElement(By.xpath("//*[@id=\"collapsible-resource-manager-desktop\"]/div/div[2]/div/div[2]/div/div/div[1]/a"));
        Stations.click();

        Thread.sleep(1000);
        WebElement create_Brand = driver.findElement(By.xpath("//*[@id=\"nova\"]/div[2]/div[2]/div[1]/div[1]/div[2]/div/a"));
        create_Brand.click();

        String filePath = "src/test/java/Input_user_data/Trip_user_data/trips"; // Replace with the path to your userdata.txt file

        // Read data from the file and store it in a list

        // Read data from the file and store it in a list
        List<String> userData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            userData.add(line);
        }
        reader.close();

        final WebElement Operator = driver.findElement(By.xpath("/html//div[@id='nova']/div[2]//form[@class='space-y-8']/div[@class='space-y-4']/div/div/div[1]"));
        Operator.click();

        WebElement Operator_input = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        Operator_input.sendKeys(userData.get(0));

        driver.findElement(By.xpath("(//div[@class='text-sm font-semibold leading-normal text-white dark:text-gray-900'])[1]")).click();

        //Route
        //final WebElement Route = driver.findElement(By.xpath("/html//div[@id='nova']//form[@class='space-y-8']/div[@class='space-y-4']/div/div/div[2]"));
        //Route.click();

        //WebElement Route_input = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        //Route_input.sendKeys(userData.get(1));

        //driver.findElement(By.xpath("(//div[@class='text-sm font-semibold leading-normal text-white dark:text-gray-900'])[1]")).click();

        WebElement start = driver.findElement(By.id("start_time-create-trip-text-field"));
        start.sendKeys(userData.get(2));

        //submit

        WebElement fleetField_submit = driver.findElement(By.xpath("//button[@type='submit']"));
        fleetField_submit.click();

        {
            driver.quit();
        }


    }
}