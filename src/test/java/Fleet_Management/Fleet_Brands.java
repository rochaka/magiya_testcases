package Fleet_Management;

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
public class Fleet_Brands {

    public static ChromeOptions options =new ChromeOptions();
    public static WebDriver driver = new ChromeDriver(options);

    @BeforeTest
    void Setup(){

        options.addArguments("--remort-allow-origins");
        System.setProperty("web driver.chrome.driver",System.getProperty("user.dir") +"src/test/resources/chromedriver.exe");

        driver.get("https://next.magiya.lk/app/login"); ////////////////// change any ULR///////////////////
    }

    @Test

    void teststeps() throws IOException {

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

        WebElement Transist = driver.findElement(By.xpath("(//*[name()='path'][@stroke-linecap='round'])[7]"));
        Transist.click();

        //create Create Fleet Brand button
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement Brand = driver.findElement(By.xpath("//*[@id=\"collapsible-resource-manager-desktop\"]/div/div[2]/div/div[1]/div/div/div[1]/a"));
        Brand.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement create_Brand = driver.findElement(By.xpath("(//span[@class='hidden md:inline-block'])[1]"));
        create_Brand.click();

        String filePath = "src/test/java/Input_user_data/Fleet_user_data/Fleet Brands"; // Replace with the path to your userdata.txt file

        // Read data from the file and store it in a list

        // Read data from the file and store it in a list
        List<String> userData = new ArrayList<>();
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            userData.add(line);
        }
        reader.close();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Create Fleet Brand
        driver.findElement(By.id("name-create-fleet-brand-text-field")).sendKeys(userData.get(0));

        //submit

        WebElement fleetField_submit = driver.findElement(By.xpath("//button[@type='submit']"));
        fleetField_submit.click();

        {
            driver.quit();
        }


    }
}