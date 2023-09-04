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

public class seleniumtest1 {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tihor\\Downloads\\chromedriver_win32\\chromedriver.exe");

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

       /* //test-1
        driver.get("chrome-extension://ddajkjpjkaiallekcmgjnflckjipejea/options.html");
        Thread.sleep(2000);
        //end-test-1

        // Switch to the extension's window or frame
        //driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

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
        Thread.sleep(5000);*/

        // Launch Chrome browser
        driver.get("https://stackoverflow.com/");
        System.out.println("Opened the browser");

        // Wait for the page content to load
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

        System.out.println("Page content loaded");


        // Find all elements on the webpage
        List<WebElement> allElementsBefore = driver.findElements(By.cssSelector("*"));

        // Calculate the total number of elements before
        int totalElementsBefore = allElementsBefore.size();
        System.out.println("Total number of elements before on the webpage: " + totalElementsBefore);

        // Check if the extension is properly installed
        try {
            // Find an element that is unique to the extension's presence (e.g., a button with a unique ID)
            WebElement extensionButton = driver.findElement(By.id("ddajkjpjkaiallekcmgjnflckjipejea"));
            System.out.println("Extension is properly installed.");
        } catch (NoSuchElementException e) {
            System.out.println("Extension is not installed or not working correctly.");
        }

        // Perform actions on the webpage
        List<WebElement> elements = driver.findElements(By.xpath("//button[contains(translate(text(), 'ACCEPT', 'accept'), 'accept') or contains(translate(text(), 'REJECT', 'reject'), 'reject') or contains(translate(text(), 'Necessary', 'necessary'), 'necessary')]"));

        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

        // Find all elements with class names containing keywords
        List<WebElement> bannersAndAlerts = driver.findElements(By.cssSelector("[class*='popup'], [class*='banner'], [class*='alert']"));

        // Print the count of banners and alerts before the delay
        System.out.println("Total number of non-disappearing banners and alerts before: " + bannersAndAlerts.size());

        //test
        Thread.sleep(20000); // 20 seconds delay

        // Find all elements again after the delay
        List<WebElement> allElementsAfter = driver.findElements(By.cssSelector("*"));

        // Calculate the total number of elements after
        int totalElementsAfter = allElementsAfter.size();
        System.out.println("Total number of elements after on the webpage: " + totalElementsAfter);

        // Find elements with class names containing keywords again after the delay
        List<WebElement> bannersAndAlertsAfter = driver.findElements(By.cssSelector("[class*='popup'], [class*='banner'], [class*='alert']"));

        // Filter out the elements that are still present after the delay
        bannersAndAlertsAfter.removeIf(element -> allElementsAfter.contains(element));

        // Print the count of hidden or closed banners and alerts after the delay
        System.out.println("Total number of hidden or closed banners and alerts after: " + bannersAndAlertsAfter.size());

        // Add delay before closing the browser
        Thread.sleep(20000); // 20 seconds delay

        // Close the browser
        driver.quit();
    }
}
