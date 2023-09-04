/*
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Set;

public class SeleniumExample {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tihor\\Downloads\\chromedriver_win32\\chromedriver.exe");
        // Enable cookies
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        //options.addCookie(new Cookie("name", "value")); // Replace "name" and "value" with your desired cookie details
        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver(options);


        // Launch Chrome browser
        driver.get("https://stackoverflow.com/");
        System.out.println("Opened the browser");
        // Add cookies
        Cookie cookie = new Cookie("cookie monster", "0.1"); // Replace "name" and "value" with your desired cookie details
        driver.manage().addCookie(cookie);
        // Wait for the page content to load
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        System.out.println("Page content loaded");


        // Print the cookies
        Set<Cookie> allCookies = driver.manage().getCookies();
        System.out.println("Cookies:");
        for (Cookie c : allCookies) {
            System.out.println(c.getName() + "=" + c.getValue());
        }

        // Perform actions on the webpage
        //List<WebElement> elements = driver.findElements(By.xpath("//*[contains(translate(text(), 'COOKIE', 'cookie'), 'cookie')]"));
        List<WebElement> elements = driver.findElements(By.xpath("//button[contains(translate(text(), 'ACCEPT', 'accept'), 'accept') or contains(translate(text(), 'REJECT', 'reject'), 'reject') or contains(translate(text(), 'Necessary', 'necessary'), 'reject')]"));

        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

        // Add delay before closing the browser
        Thread.sleep(5000); // 5 seconds delay

        // Close the browser
        driver.quit();
    }
}
*/


import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

public class seleniumtest {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tihor\\Downloads\\chromedriver_win32\\chromedriver.exe");

        // Specify the path to the unpacked extension directory
        String extensionPath = "C:\\Users\\tihor\\Downloads\\internal_capstone\\NUS_MComp_CapStone\\extension";



        // Enable cookies
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        // Identify the specific extension file within the directory
        File extensionFile = new File(extensionPath+ File.separator + "extension-file.crx");
        // Add the extension to ChromeOptions
        options.addExtensions(extensionFile);

        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver(options);

        // Launch Chrome browser
        driver.get("https://stackoverflow.com/");
        System.out.println("Opened the browser");

        // Set the folder path containing JavaScript files
        String folderPath = "C:\\Users\\tihor\\Downloads\\internal_capstone\\NUS_MComp_CapStone\\extension";



        // Wait for the page content to load
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        System.out.println("Page content loaded");





        // Perform actions on the webpage
        List<WebElement> elements = driver.findElements(By.xpath("//button[contains(translate(text(), 'ACCEPT', 'accept'), 'accept') or contains(translate(text(), 'REJECT', 'reject'), 'reject') or contains(translate(text(), 'Necessary', 'necessary'), 'reject')]"));

        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

        // Add delay before closing the browser
        Thread.sleep(5000); // 5 seconds delay

        // Close the browser
        driver.quit();
    }
}

