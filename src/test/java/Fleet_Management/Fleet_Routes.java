package Fleet_Management;

import Loging_details.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Loging_details.Login.driver;

public class Fleet_Routes {


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
        Thread.sleep(3000);
        WebElement Transist = driver.findElement(By.xpath("(//*[name()='path'][@stroke-linecap='round'])[7]"));
        Transist.click();

        //create Create Fleet Brand button
        Thread.sleep(3000);
        WebElement Stations = driver.findElement(By.xpath("//*[@id=\"collapsible-resource-manager-desktop\"]/div/div[2]/div/div[1]/div/div/div[6]/a"));
        Stations.click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/a")).click();
    }
    @Test(priority = 3)
    void Data() throws InterruptedException, IOException {
        String filePath = "src/test/java/Input_user_data/Fleet_user_data/Fleet Routes"; // Replace with the path to your userdata.txt file

        // Read data from the file and store it in a list

        // Read data from the file and store it in a list
        List<String> userData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            userData.add(line);
        }
        reader.close();

        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/form/div[1]/div/div/div[1]")).click();

        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(userData.get(0));
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[6]/div/div")).click();

        //////////////ADD Stoppage////////////////
        driver.findElement(By.xpath("//*[@id=\"nova\"]/div[2]/div[2]/div[1]/form/div[1]/div/div/div[2]/div[2]/div[2]/button")).click();

        ////////Choose An Option 1///////
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/form/div[1]/div/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div[2]/div/select")).click();

        driver.findElement(By.id("cy5W6KdNvYmbEnmM__stoppage")).sendKeys(userData.get(1));
    }
    @Test(priority = 4)
    void submit(){
        WebElement fleetField_submit = driver.findElement(By.xpath("//button[@type='submit']"));
        fleetField_submit.click();
    }
    @Test(priority = 5)
    void Quite() {

        driver.quit();

    }

    }
