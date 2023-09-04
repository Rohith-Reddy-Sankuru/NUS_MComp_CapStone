import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class OptionSelection {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tihor\\Downloads\\chromedriver-win64\\\\chromedriver-win64\\chromedriver.exe");


        // Specify the path to the unpacked extension directory
        String extensionPath = "C:\\Users\\tihor\\Downloads\\internal_capstone\\NUS_MComp_CapStone\\extension";

        // Enable cookies
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        // Add the extension to ChromeOptions as an unpacked extension
        options.addArguments("--load-extension=" + extensionPath);

        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver(options);


        //Access the unique id of cookie by viewing in the chrome browser
        driver.get("chrome-extension://ddajkjpjkaiallekcmgjnflckjipejea/options.html");
        Thread.sleep(2000);


        // Find and select the "Accept all" checkbox
        WebElement acceptAllCheckbox = driver.findElement(By.id("accept"));
        acceptAllCheckbox.click();

        //Find "necessary"
        WebElement acceptNecessaryCheckbox = driver.findElement(By.id("necessary"));
        acceptNecessaryCheckbox.click();

        //Find "Reject all"
        WebElement rejectCheckbox = driver.findElement(By.id("reject"));
        rejectCheckbox.click();

        //Find "Custom"
        WebElement customCheckbox = driver.findElement(By.id("custom"));
        customCheckbox.click();

        //Now if we click custom you should select the necessary option
        //performance
        WebElement performanceCheckbox = driver.findElement(By.id("performance"));
        performanceCheckbox.click();

        //functional
        WebElement functionalCheckbox = driver.findElement(By.id("functional"));
        functionalCheckbox.click();

        //targeting
        WebElement targetingCheckbox = driver.findElement(By.id("targeting"));
        targetingCheckbox.click();


        WebElement saveButton = driver.findElement(By.id("saveButton"));
        saveButton.click();
        Thread.sleep(5000);

        // Launch Chrome browser
        driver.get("https://stackoverflow.com/");
        System.out.println("Opened the browser");

        // Wait for the page content to load
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

        System.out.println("Page content loaded");


        // Add delay before closing the browser
        Thread.sleep(20000); // 20 seconds delay

        // Close the browser
        driver.quit();
    }
}
