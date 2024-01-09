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

public class Trip_Vehicles {

    public static ChromeOptions options = new ChromeOptions();
    public static WebDriver driver = new ChromeDriver(options);

    @BeforeTest
    void Setup() {

        options.addArguments("--remort-allow-origins");
        System.setProperty("web driver.chrome.driver", System.getProperty("user.dir") + "src/test/resources/chromedriver.exe");

        driver.get("https://next.magiya.lk/app/login"); ////////////////// change any ULR///////////////////
    }

    @Test(priority = 1)
    void loging(){

        driver.findElement(By.id("email")).sendKeys("web@zuse.lk");
        driver.findElement(By.id("password")).sendKeys("Kalupusa321@");

        WebElement rememberMeCheckbox = driver.findElement(By.xpath("//span[normalize-space()='Remember me']"));
        if (!rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        }

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
    }
    @Test(priority = 2)
    void shift() throws InterruptedException {
        // Waiting (using explicit waits instead of Thread.sleep is recommended)
        // Replace these Thread.sleep() with explicit waits where possible
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.xpath("(//*[name()='path'][@stroke-linecap='round'])[7]")).click();

        //create Create Fleet Brand button
        Thread.sleep(1000);
        WebElement Stations = driver.findElement(By.xpath("//*[@id=\"collapsible-resource-manager-desktop\"]/div/div[2]/div/div[2]/div/div/div[2]/a"));
        Stations.click();

        Thread.sleep(1000);
        WebElement create_Brand = driver.findElement(By.xpath("//*[@id=\"nova\"]/div[2]/div[2]/div[1]/div[1]/div[2]/div/a"));
        create_Brand.click();
    }
    @Test(priority = 1)
    void data() throws InterruptedException, IOException {

        String filePath = "src/test/java/Input_user_data/Trip_user_data/vehicles"; // Replace with the path to your userdata.txt file

        // Read data from the file and store it in a list

        // Read data from the file and store it in a list
        List<String> userData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while (( line = reader.readLine() ) != null) {
            userData.add(line);
        }
        reader.close();

        //Type
        final WebElement Trip_Vehicle = driver.findElement(By.xpath("/html//div[@id='nova']/div[2]//form[@class='space-y-8']/div[@class='space-y-4']/div/div/div[1]"));
        Trip_Vehicle.click();

        WebElement Trip_Vehicle_input = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        Trip_Vehicle_input.sendKeys(userData.get(0));
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//div[@class='text-sm font-semibold leading-normal text-white dark:text-gray-900'])[1]")).click();

        //Station
        final WebElement Trip_Vehicle_Station = driver.findElement(By.xpath("/html//div[@id='nova']//form[@class='space-y-8']/div[@class='space-y-4']/div/div/div[2]"));
        Trip_Vehicle_Station.click();

        WebElement Trip_Vehicle_Station_input = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        Trip_Vehicle_Station_input.sendKeys(userData.get(1));
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//div[@class='text-sm font-semibold leading-normal text-white dark:text-gray-900'])[1]")).click();

        WebElement Registered_Number = driver.findElement(By.id("register_no-create-trip-vehicle-text-field"));
        Registered_Number.sendKeys(userData.get(2));

        WebElement Engine_Number = driver.findElement(By.id("engine_no-create-trip-vehicle-text-field"));
        Engine_Number.sendKeys(userData.get(3));

        WebElement Chasis_Number = driver.findElement(By.id("chasis_no-create-trip-vehicle-text-field"));
        Chasis_Number.sendKeys(userData.get(4));

        WebElement Model_Number = driver.findElement(By.id("model_no-create-trip-vehicle-text-field"));
        Model_Number.sendKeys(userData.get(5));

        //WebElement Add_Seat_Layout = driver.findElement(By.id("name-default-text-field"));
        //Add_Seat_Layout.click();
    }
    @Test(priority = 1)
    void submit() {
        WebElement fleetField_submit = driver.findElement(By.xpath("//button[@type='submit']"));
        fleetField_submit.click();
    }
    @Test(priority = 1)
    void Quite()

        {
            driver.quit();
        }


    }