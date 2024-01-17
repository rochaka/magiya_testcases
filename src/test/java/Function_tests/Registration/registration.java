package Function_tests.Registration;

import Function_tests.Loging_details.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class registration {

    @Test ( priority = 1 )
    void executeLoginTest() throws IOException, InterruptedException {
        Login loginTest = new Login();
        loginTest.Setup();
        Login.loging();
    }

    @Test(priority = 2)
    void Shift(){
        // Waiting (using explicit waits instead of Thread.sleep is recommended)
        // Replace these Thread.sleep() with explicit waits where possible
        WebDriver.Timeouts timeouts = Login.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Navigation
        WebElement system = Login.driver.findElement(By.xpath("(//*[name()='svg'][@role='presentation'])[3]"));
        system.click();

        Login.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement admin = Login.driver.findElement(By.xpath("(//a[@class='group flex px-4 my-1 py-2 hover:text-primary-500 hover:bg-gray-200 dark:hover:bg-gray-800 rounded w-full cursor-pointer items-center active:outline-none active:ring focus:outline-none focus:ring focus:ring-primary-200 dark:focus:ring-gray-600 text-gray-500'])[1]"));
        admin.click();

        Login.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement createUser = Login.driver.findElement(By.xpath("(//a[@class='shrink-0 h-9 px-4 focus:outline-none ring-primary-200 dark:ring-gray-600 focus:ring text-white dark:text-gray-800 inline-flex items-center font-bold shadow rounded focus:outline-none ring-primary-200 dark:ring-gray-600 focus:ring bg-primary-500 hover:bg-primary-400 active:bg-primary-600 text-white dark:text-gray-800 inline-flex items-center font-bold px-4 h-9 text-sm shrink-0 h-9 px-4 focus:outline-none ring-primary-200 dark:ring-gray-600 focus:ring text-white dark:text-gray-800 inline-flex items-center font-bold'])[1]"));
        createUser.click();
    }
    @Test(priority = 3)
    void User() throws IOException {
        Login.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        /////////////////////////////////////

        // Read data from the file and store it in a list

        String filePath = "src/test/java/Input_user_data/Registration_data"; // Replace with the path to your userdata.txt file

        // Read data from the file and store it in a list

        // Read data from the file and store it in a list
        List<String> userData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            userData.add(line);
        }
        reader.close();

        // Use data from the list to input into respective fields
        Login.driver.findElement(By.id("name-create-user-text-field")).sendKeys(userData.get(0));
        Login.driver.findElement(By.id("email-create-user-text-field")).sendKeys(userData.get(1));
        Login.driver.findElement(By.id("password-create-user-password-field")).sendKeys(userData.get(2));

        Login.driver.findElement(By.id("gender")).sendKeys(userData.get(3));
        final WebElement cities_search_input_dropdown = Login.driver.findElement(By.cssSelector(".relative.flex.items-center.form-control.form-input-bordered.form-select.pr-6"));
        cities_search_input_dropdown.click();
        Login.driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(userData.get(4));
        Login.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        Login.driver.findElement(By.xpath("(//div[@class='text-sm font-semibold leading-normal text-white dark:text-gray-900'])[1]")).click();
        Login.driver.findElement(By.id("mobile-create-user-text-field")).sendKeys(userData.get(5));
    }
    @Test(priority = 4)
    void Submit(){
        Login.driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Test(priority = 5)
    void compire() {
        WebElement errorMessage = Login.driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/form/div[1]/div/div/div[2]/div[2]/p")); // Replace with actual error message element locator

        try {
            errorMessage = Login.driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/form/div[1]/div/div/div[2]/div[2]/p"));
            if (errorMessage.isDisplayed()) {
                System.out.println("The Email has already been taken..");
                Assert.fail("The Email has already been taken..");
            } else {
                System.out.println("Account creation succeeded as expected.");
                // Continue with test execution or simply log the success message
            }
        } catch (NoSuchElementException e) {
            System.out.println("The User Was Created!");
            // No need for explicit passing as TestNG will consider the test passed
            // if it reaches this point without encountering any failures
        }
    }
    @Test(priority = 6)
    void quit() {
            Login.driver.quit();
        }


    }



