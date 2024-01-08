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

public class schedules {

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

        driver.findElement(By.id("driver")).sendKeys("web@zuse.lk");
        driver.findElement(By.id("password")).sendKeys("Kalupusa321@");

        WebElement rememberMeCheckbox = driver.findElement(By.xpath("//span[normalize-space()='Remember me']"));
        if (!rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        }

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        // Waiting (using explicit waits instead of Thread.sleep is recommended)
        // Replace these Thread.sleep() with explicit waits where possible
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("(//*[name()='path'][@stroke-linecap='round'])[7]")).click();

        //create Create Fleet Brand button
        Thread.sleep(2000);
        WebElement Stations = driver.findElement(By.xpath("//*[@id=\"collapsible-resource-manager-desktop\"]/div/div[2]/div/div[2]/div/div/div[5]/a"));
        Stations.click();

        Thread.sleep(3000);
        WebElement create_Brand = driver.findElement(By.xpath("//*[@id=\"nova\"]/div[2]/div[2]/div[1]/div[1]/div[2]/div/a"));
        create_Brand.click();

        String filePath = "src/test/java/Input_user_data/Trip_user_data/Schedules"; // Replace with the path to your userdata.txt file

        // Read data from the file and store it in a list

        // Read data from the file and store it in a list
        List<String> userData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            userData.add(line);
        }
        reader.close();

        //date
        Thread.sleep(1000);
        driver.findElement(By.id("date-create-trip-schedule-date-field")).sendKeys(userData.get(0));

        //trip
        //driver.findElement(By.xpath("/html//div[@id='nova']/div[2]//form[@class='space-y-8']/div[@class='space-y-4']/div/div/div[2]")).click();

        //driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(userData.get(1));

        //driver.findElement(By.xpath("(//div[@class='text-sm font-semibold leading-normal text-white dark:text-gray-900'])[1]")).click();


        //Vehicle
        driver.findElement(By.xpath("/html//div[@id='nova']/div[2]//form[@class='space-y-8']/div[@class='space-y-4']/div/div/div[3]")).click();

        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(userData.get(2));

        driver.findElement(By.xpath("(//div[@class='text-sm font-semibold leading-normal text-white dark:text-gray-900'])[1]")).click();

        //Driver
        final WebElement Schedule_Driver = driver.findElement(By.xpath("/html//div[@id='nova']/div[2]//form[@class='space-y-8']/div[@class='space-y-4']/div/div/div[4]"));
        Schedule_Driver.click();

        WebElement Schedule_Driver_input = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        Schedule_Driver_input.sendKeys(userData.get(3));

        driver.findElement(By.xpath("(//div[@class='text-sm font-semibold leading-normal text-white dark:text-gray-900'])[1]")).click();

        //Assistant
        final WebElement Schedule_Assistant = driver.findElement(By.xpath("/html//div[@id='nova']/div[2]//form[@class='space-y-8']/div[@class='space-y-4']/div/div/div[5]"));
        Schedule_Assistant.click();

        WebElement Schedule_Assistant_input = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        Schedule_Assistant_input.sendKeys(userData.get(4));

        driver.findElement(By.xpath("(//div[@class='text-sm font-semibold leading-normal text-white dark:text-gray-900'])[1]")).click();


        //WebElement Add_Seat_Layout = driver.findElement(By.id("name-default-text-field"));
        //Add_Seat_Layout.click();

        //submit

        WebElement fleetField_submit = driver.findElement(By.xpath("//button[@type='submit']"));
        fleetField_submit.click();

        {
            driver.quit();
        }


    }
}