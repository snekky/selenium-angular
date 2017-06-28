package ua.pp.krotov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    private WebDriver driver;
    @BeforeClass // Runs this method before the first test method in the current class is invoked
    public void setUp() {
        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();
    }

    @Test // Marking this method as part of the test
    public void gotoSeleniumLocalhost() {
        // Go to the Localhost
        driver.get("http://localhost:8081");
        // Waiting for loading page (10 seconds)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Find the text input element by its id and type "test"
        driver.findElement(By.id("login")).sendKeys("test");
        // Find the text input element by its id and type "test"
        driver.findElement(By.id("password")).sendKeys("test");
        // Click Enter button
        driver.findElement(By.id("tologin")).click();
        // Get text from header of the page
        String header = driver.findElement(By.id("headertext")).getText();
        // Verify that header equals "Home Page"
        Assert.assertEquals(header, "Home Page");
        // Click Logout button
        driver.findElement(By.id("logout")).click();
    }

    @Test // Marking this method as part of the test
    public void gotoSeleniumLocalhostFailure() {
        // Go to the Localhost
        driver.get("http://localhost:8081");
        // Waiting for loading page (10 seconds)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Find the text input element by its id and type "test1"
        driver.findElement(By.id("login")).sendKeys("test1");
        // Find the text input element by its id and type "test1"
        driver.findElement(By.id("password")).sendKeys("test1");
        // Click Enter button
        driver.findElement(By.id("tologin")).click();
        // Get text from header of the page
        String header = driver.findElement(By.id("headertext")).getText();
        // Verify that header equals "Home Page"
        Assert.assertEquals(header, "Best Page");
    }

    @AfterClass // Runs this method after all the test methods in the current class have been run
    public void tearDown() {
        // Close all browser windows and safely end the session
        driver.quit();
    }

}