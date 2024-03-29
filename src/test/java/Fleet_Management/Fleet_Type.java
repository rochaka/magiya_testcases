package Fleet_Management;

import Loging_details.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static Loging_details.Login.driver;

public class Fleet_Type {


    @Test ( priority = 1 )
    void executeLoginTest() throws IOException, InterruptedException {
        Login loginTest = new Login();
        loginTest.Setup();
        loginTest.loging();
    }
    @Test(priority = 2)
    void shift() throws InterruptedException {
        // Waiting (using explicit waits instead of Thread.sleep is recommended)
        // Replace these Thread.sleep() with explicit waits where possible
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        Thread.sleep(1000);
        WebElement Transist = driver.findElement(By.xpath("(//*[name()='path'][@stroke-linecap='round'])[7]"));
        Transist.click();

        //create Create Fleet Brand button
        Thread.sleep(1000);
        WebElement Stations = driver.findElement(By.xpath("//*[@id=\"collapsible-resource-manager-desktop\"]/div/div[2]/div/div[1]/div/div/div[3]/a"));
        Stations.click();

        Thread.sleep(1000);
        WebElement create_Brand = driver.findElement(By.xpath("//*[@id=\"nova\"]/div[2]/div[2]/div[1]/div[1]/div[2]/div/a"));
        create_Brand.click();
    }
    @Test(priority = 3)
    void Data() throws IOException, InterruptedException {String filePath = "src/test/java/Input_user_data/Fleet_user_data/Fleet Types"; // Replace with the path to your userdata.txt file

        // Read data from the file and store it in a list

        // Read data from the file and store it in a list
        List<String> userData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            userData.add(line);
        }
        reader.close();

        Thread.sleep(3000); // Sleep for 3 seconds
        driver.findElement(By.xpath("//*[@id=\"nova\"]/div[2]/div[2]/div[1]/form/div[1]/div/div/div[1]")).click();

        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(userData.get(0));

        driver.findElement(By.xpath("(//div[@class='text-sm font-semibold leading-normal text-white dark:text-gray-900'])[1]")).click();


        //Model
        driver.findElement(By.id("model-create-fleet-type-text-field")).sendKeys(userData.get(1));

        //year
        //driver.findElement(By.id("year-create-fleet-type-text-field")).sendKeys(userData.get(2));

        //Seating Area Term
        driver.findElement(By.id("seating_area_term")).click();
        Thread.sleep(1000);
    }

    @Test ( priority = 4 )
    void submit() throws InterruptedException {
        //submit
        Thread.sleep(3000);
        WebElement fleetField_submit = driver.findElement(By.xpath("//button[@type='submit']"));
        fleetField_submit.click();

    }

    @Test ( priority = 5 )
    void exit(){
            driver.quit();
        }


    }
