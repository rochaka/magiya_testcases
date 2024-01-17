package Function_tests.Fleet_Management;

import Function_tests.Loging_details.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Fleet_Counter {


    @Test ( priority = 1 )
    void executeLoginTest() throws IOException, InterruptedException {
        Login loginTest = new Login();
        loginTest.Setup();
        loginTest.loging();
    }
    @Test(priority = 2)
    void Button() throws InterruptedException {
        // Waiting (using explicit waits instead of Thread.sleep is recommended)
        // Replace these Thread.sleep() with explicit waits where possible
        Login.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        Thread.sleep(1000);
        WebElement Transist = Login.driver.findElement(By.xpath("(//*[name()='path'][@stroke-linecap='round'])[7]"));
        Transist.click();

        //create Create Fleet Brand button
        Thread.sleep(1000);
        WebElement Stations = Login.driver.findElement(By.xpath("//*[@id=\"collapsible-resource-manager-desktop\"]/div/div[2]/div/div[1]/div/div/div[5]/a"));
        Stations.click();

        Thread.sleep(1000);
        WebElement create_Brand = Login.driver.findElement(By.xpath("//*[@id=\"nova\"]/div[2]/div[2]/div[1]/div[1]/div[2]/div/a"));
        create_Brand.click();

    }
    @Test(priority = 3)
    void Create() throws InterruptedException, IOException {
        String filePath = "src/test/java/Input_user_data/Fleet_user_data/ Fleet Counters"; // Replace with the path to your userdata.txt file

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
        Login.driver.findElement(By.id("name-create-fleet-counter-text-field")).sendKeys(userData.get(0));

        //oparator
        final WebElement Counter_Operator = Login.driver.findElement(By.xpath("/html//div[@id='nova']/div[2]/div[2]//form[@class='space-y-8']/div[@class='space-y-4']/div/div/div[2]"));
        Counter_Operator.click();

        WebElement Counter_Operator_input = Login.driver.findElement(By.xpath("//input[@placeholder='Search']"));
        Counter_Operator_input.sendKeys(userData.get(1));


        Login.driver.findElement(By.xpath("(//div[@class='text-sm font-semibold leading-normal text-white dark:text-gray-900'])[1]")).click();


        //Fleet Station
        final WebElement Counter_city = Login.driver.findElement(By.xpath("/html//div[@id='nova']/div[2]/div[2]//form[@class='space-y-8']/div[@class='space-y-4']/div/div/div[3]"));
        Counter_city.click();

        WebElement Counter_city_input = Login.driver.findElement(By.xpath("//input[@placeholder='Search']"));
        Counter_city_input.sendKeys(userData.get(2));
        Thread.sleep(3000);

        Login.driver.findElement(By.xpath("/html/body/div[7]/div/div[2]")).click();

        //Latitude
        Login.driver.findElement(By.id("latitude-create-fleet-counter-text-field")).sendKeys(userData.get(3));

        //Longitude
        Login.driver.findElement(By.id("longitude-create-fleet-counter-text-field")).sendKeys(userData.get(4));

        //Elevation
        Login.driver.findElement(By.id("elevation-create-fleet-counter-text-field")).sendKeys(userData.get(5));


    }
    @Test(priority = 4)
    void Submit(){
        WebElement fleetField_submit = Login.driver.findElement(By.xpath("//button[@type='submit']"));
        fleetField_submit.click();
    }
    //submit
    @Test(priority = 5)
    void quite(){
        {
            Login.driver.quit();
        }
    }



    }

